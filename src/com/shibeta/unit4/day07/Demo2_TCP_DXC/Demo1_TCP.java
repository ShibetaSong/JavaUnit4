package com.shibeta.unit4.day07.Demo2_TCP_DXC;

import java.io.*;
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



    }

}
