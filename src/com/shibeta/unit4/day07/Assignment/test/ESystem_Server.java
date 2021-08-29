package com.shibeta.unit4.day07.Assignment.test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ESystem_Server {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket server = new ServerSocket(50000);
        System.out.println("服务器已启动");

        System.out.println("输入://end 以关闭服务器");
        do {
            NewConnection nc = new NewConnection(new CreateConnection(server));
            Thread t = new Thread(nc);
            t.setDaemon(true);
            t.start();
        } while (!input.nextLine().equals("://end"));

    }

    static class NewConnection implements Runnable{
        CreateConnection cc;

        NewConnection(CreateConnection cc) {
            this.cc = cc;
        }

        @Override
        public void run() {
            try {
                cc.getConnection();
                Thread looking = new Thread(() -> {
                    while (!cc.dead) {
                        try {
                            cc.lookingConnection();
                        } catch (InterruptedException | IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                Thread lookingMessage = new Thread(() -> {
                    while (!cc.dead) {
                        try {
                            cc.lookingMessage();
                        } catch (IOException e) {
                            cc.dead = true;
                            e.printStackTrace();
                        }
                    }
                });
                looking.setDaemon(true);
                lookingMessage.setDaemon(true);

                looking.start();
                lookingMessage.start();

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 等待、创建连接
     */
    static class CreateConnection{
        ServerSocket server;
        Socket client;
        // 打印流
        PrintStream ps;
        // 字符读取流
        BufferedReader br;

        boolean hasClient;
        boolean dead;
        boolean flag;

        CreateConnection(ServerSocket server) {
            this.server = server;
            this.hasClient = false;
            this.dead = false;
            this.flag = false;
        }

        /**
         * 检查是否死亡线程
         */
        public void verifyIsDead() {
            if (dead) {
                System.out.println("线程已死亡");
                Thread.currentThread().interrupt();
            }
        }

        /**
         * 创建连接
         */
        public void getConnection() throws IOException, InterruptedException{
            verifyIsDead();
            if (hasClient) {
                return;
            }
            client = server.accept();
            hasClient = true;
            br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            ps = new PrintStream(client.getOutputStream());

            System.out.println("一个客户端已连接：" + client.getRemoteSocketAddress());
        }

        /**
         * 监听连接
         */
        public synchronized void lookingConnection() throws InterruptedException, IOException {
            verifyIsDead();
            if (flag = true) {
                return;
            }
            if (client == null) {
                this.notifyAll();
                getConnection();
                System.out.println("客户端未连接");
            }
            try {
                client.sendUrgentData(0xFF);
                System.out.println("仍在连接中");
                this.flag = true;
                this.notifyAll();
                this.wait();
                Thread.sleep(500);
            } catch (IOException e) {
                this.dead = true;
                System.out.println("线程应死亡");
                this.wait();
            }
        }

        /**
         * 监听信息
         */
        public synchronized void lookingMessage() throws IOException {
            verifyIsDead();
            if (!flag) {
                return;
            }
            if (!dead) {
                System.out.println(br.readLine());
                flag = false;
            }

        }

        /**
         * 发送信息
         */
        public synchronized void sendMessage() {
            verifyIsDead();
            while (!dead) {
                System.out.println("[" + client.getRemoteSocketAddress() + "] 输入要发送的信息：");
                ps.println(input.nextLine());
            }
        }
    }
}
