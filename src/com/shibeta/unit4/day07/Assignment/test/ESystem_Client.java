package com.shibeta.unit4.day07.Assignment.test;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;


public class ESystem_Client {
    static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException, InterruptedException {
        Thread startThread = new Thread(() -> {
            try {
                runClient();
                System.out.println("输入://end 以关闭客户端");
            } catch (SocketException e) {
                e.printStackTrace();
            }
        });
        startThread.setDaemon(true);
        startThread.start();

        // 当用户输入 ://end 时，关闭客户端
        while (true) {
            if (input.nextLine().equals("://end")) {
                Thread.currentThread().interrupt();
                break;
            }
        }


    }

    static void runClient() throws SocketException {
        Socket socket;

        try {
            socket = new Socket("127.0.0.1", 50000);
        } catch (IOException e) {
            System.out.println("无法连接至服务器");
            return;
        }
        socket.setOOBInline(true);

        try {
            ToServer client = new ToServer(socket);

            // 监听消息
            Thread listen = new Thread(() -> {
                try {
                    client.listeningMessage();
                } catch (IOException | InterruptedException e) {
                    System.out.println("与服务器的连接已断开");
                }
            });

            // 发送信息
            Thread send = new Thread(() -> {
                try {
                    client.sendMessage();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            listen.setDaemon(true);
            send.setDaemon(true);
            listen.start();
            send.start();

//            Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
//            while (true) {
//                if (input.nextLine().equals("://end")) {
//                    Thread.currentThread().interrupt();
//                    break;
//                }
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
     * 与服务器的交互操作
     */
    static class ToServer {
        private final BufferedReader bf;
        private final PrintStream ps;

        ToServer(Socket client) throws IOException {
            InputStream info = client.getInputStream();
            this.bf = new BufferedReader(new InputStreamReader(info));
            OutputStream os = client.getOutputStream();
            this.ps = new PrintStream(os);
        }

        /**
         * 监听来自服务器的消息
         */
        public void listeningMessage() throws IOException, InterruptedException {
            while (true) {
                String message = this.bf.readLine();

                if (!message.equals("null")) {
                    System.out.println(message);
                    continue;
                }
                Thread.sleep(500);
            }

        }

        public void sendMessage() throws IOException {
            this.ps.println("发送至服务器端的消息");
        }
    }
}
