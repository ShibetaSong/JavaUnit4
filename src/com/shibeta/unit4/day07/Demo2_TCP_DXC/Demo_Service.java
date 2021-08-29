package com.shibeta.unit4.day07.Demo2_TCP_DXC;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo_Service {
    // 服务器
    public static void main(String[] args) throws IOException {
        // 搭建服务器
        ServerSocket server = new ServerSocket(55565);
        System.out.println("服务器启动完毕");
        // 等待客户端的连接
        while (true) {
            Socket socket = server.accept();
            new Thread() {
                @Override
                public void run() {
                    try {
                        InputStream is = socket.getInputStream();
                        OutputStream os = socket.getOutputStream();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            System.out.println("一个客户端连接了");

        }
    }
}
