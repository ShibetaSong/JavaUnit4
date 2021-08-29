//package com.shibeta.unit4.day07.Assignment;
//
//import java.io.*;
//import java.net.Socket;
//import java.util.Scanner;
//import java.util.TreeMap;
//
//public class ESystem_Client {
//    static final Scanner input = new Scanner(System.in);
//
//    public static void main(String[] args) throws IOException, InterruptedException {
//        Socket socket = new Socket("127.0.0.1", 55555);
//        socket.setOOBInline(true);
//
////        // 监听消息
////        Thread listen = new Thread(() -> {
////            try {
////                listeningMessage(socket);
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
////        });
////        listen.setDaemon(true);
////
////        Thread send = new Thread(() -> {
////           try {
////               sendMessage(socket);
////           } catch (IOException e) {
////               e.printStackTrace();
////           }
////        });
////        listen.start();
//
//        try {
//            ToServer client = new ToServer(socket);
//            Thread listen = new Thread(() -> {
//                try {
//                    client.listeningMessage();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            });
//
//            Thread send = new Thread(() -> {
//                try {
//                    client.sendMessage();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            });
//
//            listen.setDaemon(true);
//            send.setDaemon(true);
//            listen.start();
//            send.start();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        input.nextLine();
//    }
//
//    static class ToServer {
//        private final BufferedReader bf;
//        private final PrintStream ps;
//
//        ToServer(Socket client) throws IOException{
//            InputStream info = client.getInputStream();
//            this.bf = new BufferedReader(new InputStreamReader(info));
//            OutputStream os = client.getOutputStream();
//            this.ps = new PrintStream(os);
//        }
//
//        public void listeningMessage() throws IOException {
//            try {
//                while (true) {
//                    String message = this.bf.readLine();
//
//                    if (!message.equals("null")) {
//                        System.out.println(message);
//                        continue;
//                    }
//                    Thread.sleep(500);
//                }
//            }
//            catch (IOException | InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        public void sendMessage() throws IOException{
//            this.ps.println("发送至服务器端的消息");
//        }
//    }
//
//    /**
//     * 监听来自服务器的消息
//     * @param client 客户端
//     */
//    public static void listeningMessage(Socket client) throws IOException {
//        InputStream info = client.getInputStream();
//        BufferedReader bf = new BufferedReader(new InputStreamReader(info));
//        try {
//            while (true) {
//                String message = bf.readLine();
//
//                if (!message.equals("null")) {
//                    System.out.println(message);
//                    continue;
//                }
//                Thread.sleep(500);
//            }
//        }
//        catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 发送消息至服务器
//     * @param client 客户端
//     */
//    public static void sendMessage(Socket client) throws IOException{
//        OutputStream os = client.getOutputStream();
//        PrintStream ps = new PrintStream(os);
//        ps.println("发送至服务器端的消息");
//    }
//}
