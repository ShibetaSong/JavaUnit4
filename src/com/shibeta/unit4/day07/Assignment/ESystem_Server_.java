//package com.shibeta.unit4.day07.Assignment;
//
//import java.io.*;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.Scanner;
//
//public class ESystem_Server_ {
//    public static void main(String[] args) throws IOException, InterruptedException {
//        ServerSocket server = new ServerSocket(55555);
//        System.out.println("服务器已启动");
//        ConnectServer cs = new ConnectServer(server);
//        Thread t = new Thread(cs);
//
//        t.start();
//
//        while (true) {
//            System.out.println("输入end来停止线程");
//
//            if (new Scanner(System.in).nextLine().equals("end")) {
//                t.interrupt();
//                System.out.println("服务器已关闭");
//                break;
//            }
//        }
//    }
//
//    static class ConnectServer implements Runnable {
//        ServerSocket server;
//        private Socket socket;
//
//        ConnectServer(ServerSocket server) {
//            this.server = server;
//        }
//
//        @Override
//        public void run() {
//            Thread waitConnect = new Thread(() -> {
//                while (true) {
//                    try {
//                        this.socket = waitConnect(server);
//                        // 监听是否在线
//                        Thread look = new Thread(() -> lookConnection(socket));
//                        look.setDaemon(true);
//                        look.start();
//
//                        Login user = new Login(socket);
//                        user.login();
////                        user.closeConnection();
//                        System.out.println(this.socket);
//                    } catch (IOException | InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//            waitConnect.setDaemon(true);
//            waitConnect.start();
//        }
//    }
//
//    public static Socket waitConnect(ServerSocket server) throws IOException, InterruptedException {
//        try {
//            Socket s = server.accept();
//            System.out.println("一个客户端连接了: " + s.getRemoteSocketAddress());
////            while (true) {
////                try {
////                    Thread.sleep(1000);
////                    s.sendUrgentData(0xFF);
////                    System.out.println("当前处于连接状态");
////                }
////                catch (Exception e) {
////                    System.out.println(s.getRemoteSocketAddress() + "断开了连接");
////                    break;
////                }
////            }
//
//            return s;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return new Socket();
//        }
//    }
//
//    /**
//     * 监听是否保持连接
//     *
//     * @param s 客户端
//     */
//    public static void lookConnection(Socket s) {
//        while (true) {
//            try {
//                Thread.sleep(1000);
//                s.sendUrgentData(0xFF);
//            } catch (Exception e) {
//                System.out.println(s.getRemoteSocketAddress() + "断开了连接");
//                break;
//            }
//        }
//    }
//
//    static class Login {
//        private final OutputStream os;
//        private final PrintStream ps;
//        private final BufferedReader br;
//
//        Login(Socket socket) throws IOException {
//            InputStream is = socket.getInputStream();
//            this.os = socket.getOutputStream();
//            this.br = new BufferedReader(new InputStreamReader(is));
//            this.ps = new PrintStream(os);
//            ps.println(socket.getRemoteSocketAddress() + ", 欢迎连接到服务器");
//        }
//
//        public int login() {
//            this.ps.println("请选择登录身份：");
//            this.ps.println("1. 用户");
//            this.ps.println("2. 管理员");
//            return 1;
//        }
//
//        public void closeConnection() {
//            ps.close();
//            try {
//                os.close();
//                br.close();
//                System.out.println("传输流已断开");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
