package com.shibeta.unit4.day07.Demo1_TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo1_TCP {
    /**
     * TCP协议的 CS程序
     * socket 套接字，通信端点
     * 客户端和服务器通过socket通信
     *
     * ServerSocket 搭建服务器
     * Socket   搭载客户端
     */

    // 客户端
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 55565);
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        System.out.println("来自服务端的消息：" + br.readLine());
        OutputStream os = socket.getOutputStream();
        PrintStream ps = new PrintStream(os);
        ps.println("服务器你好");


    }

}
