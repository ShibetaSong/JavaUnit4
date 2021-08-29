package com.shibeta.unit4.day07.Demo1_TCP;

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
        Socket socket = server.accept();

        System.out.println("一个客户端连接了");

        OutputStream os = socket.getOutputStream();
        PrintStream ps = new PrintStream(os);
        ps.println("欢迎连接服务器");

        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        System.out.println("来自客户端的消息：" + br.readLine());
        System.out.println("服务器程序执行结束");

    }
}
