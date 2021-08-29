//package com.shibeta.unit4.day07.Assignment;
//
//import java.io.*;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class ESystem_Server {
//    public static void main(String[] args) throws IOException, InterruptedException {
//        ServerSocket server = new ServerSocket(50000);
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
////                        // 监听是否在线
////                        Thread look = new Thread(() -> lookConnection(socket));
////                        look.setDaemon(true);
////                        look.start();
//
//                        // 登录
//                        Login user = new Login(socket);
//                        int userOrAdmin = user.login();
//                        if (userOrAdmin == 1) {
//
//                        } else {
//
//                        }
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
//    /**
//     * 等待连接
//     * @param server 服务器端
//     * @return 客户端
//     */
//    public static Socket waitConnect(ServerSocket server) throws IOException, InterruptedException {
//        try {
//            Socket s = server.accept();
//            System.out.println("一个客户端连接了: " + s.getRemoteSocketAddress());
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
//
//                Thread.currentThread().interrupt();
//                break;
//            }
//        }
//    }
////    public static void lookConnection(Socket s) {
////        while (true) {
////            try {
////                Thread.sleep(1000);
////                s.sendUrgentData(0xFF);
////            } catch (Exception e) {
////                System.out.println(s.getRemoteSocketAddress() + "断开了连接");
////
////                Thread.currentThread().interrupt();
////                break;
////            }
////        }
////    }
//
//    /**
//     * 客户端登陆
//     */
//    static class Login {
//        private final OutputStream os;
//        private final PrintStream ps;
//        private final BufferedReader br;
//        private Socket socket;
//
//        Login(Socket socket) throws IOException {
//            InputStream is = socket.getInputStream();
//            this.socket = socket;
//            this.os = socket.getOutputStream();
//            this.br = new BufferedReader(new InputStreamReader(is));
//            this.ps = new PrintStream(os);
//            ps.println(socket.getRemoteSocketAddress() + ", 欢迎连接到服务器");
//        }
//
//        public int login() throws IOException {
//            ArrayList<Integer> selectLack = new ArrayList<>();
//            selectLack.add(1);
//            selectLack.add(2);
//
//            // 监听是否在线
//            Thread look = new Thread(() -> lookConnection(socket));
//            look.setDaemon(true);
//            look.start();
//
//            this.ps.println("请选择登录身份");
//            this.ps.println("1. 用户");
//            this.ps.println("2. 管理员");
//            this.ps.print("请输入选择: ");
//            while (true) {
//                if (!look.isAlive()) {
//                    Thread.currentThread().interrupt();
//                }
//                String user = this.br.readLine();
//                try {
//                    int userOrAdmin = Integer.parseInt(user);
//                    if (selectLack.contains(userOrAdmin)) {
//                        return userOrAdmin;
//                    }
//                    throw new Exception();
//                } catch (Exception e) {
//                    this.ps.print("\n输入有误，请重新输入: ");
//                }
//            }
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
