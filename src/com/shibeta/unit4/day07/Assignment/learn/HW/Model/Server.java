package com.shibeta.unit4.day07.Assignment.learn.HW.Model;

import com.shibeta.unit4.day07.Assignment.learn.HW.Controller.ESystem;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {
    private final int PORT = 10886;
    private static final ExpressMap eMap = ESystem.getEM();
    private ServerSocket server;

    public static void main(String[] args) {
        while (true) {
            int func = menu();
            if (func == 1) {
                System.out.println("输入E以关闭服务器");
                Thread serverT = new Thread(() -> {
                    Server server = new Server();
                    server.start();
                });
                serverT.setDaemon(true);
                serverT.start();
                String ctrl = UserIO.userInput();
                if (ctrl.equals("E")) {
                    serverT.interrupt();
                    return;
                }
            } else if (func != 2) {
                System.out.println("输入有误! ");
                continue;
            }
            return;
        }
    }

    public static int menu() {
        int select;
        while (true) {
            System.out.println("=====快递管理服务器=====");
            System.out.println("1、启动服务器");
            System.out.println("2、退出");

            select = UserIO.userSelect();
            if (select == -1) {
                System.out.println("输入有误！");
                continue;
            }
            break;
        }
        return select;
    }

    public void start() {
        new Thread(() -> {
            try {
                server = new ServerSocket(PORT);
                System.out.println("服务器已经连接！ 端口为" + PORT);

                // 等待客户端连接
                while (true) {
                    Socket client = server.accept();
                    System.out.println("客户端" + client.hashCode() + "连接成功！");
                    // 为每个客户端开启一个线程处理请求
                    new Thread(() -> {
                        try {
                            // 接受客户端的请求 -- 读， 将结果响应给客户端 -- 写
                            handlerRequest(client);
                        } catch (Exception e) {
                            System.out.println("客户端" + client.hashCode() + "断开了连接");
                        }
                    }).start();
                }
            } catch (Exception e) {
                System.out.println("客户端断开了连接");
            }
        }).start();
    }

    /**
     * 处理客户端的请求
     *
     * @param client 客户端
     */
    private void handlerRequest(Socket client) {
        OutputStream out;
        ObjectOutputStream objOut = null;
        InputStream in;
        ObjectInputStream objIn = null;

        try {
            in = client.getInputStream();
            out = client.getOutputStream();
            objIn = new ObjectInputStream(in);
            objOut = new ObjectOutputStream(out);

            // 获取客户端发送的请求类型
            while (true) {
                String flag = objIn.readUTF();
                System.out.println("用户" + client.hashCode() + ", 请求：" + flag + "，线程" + Thread.currentThread().getName() + "启动");
                if (flag.equals("break")) {
                    System.out.println(client.hashCode() + "断开了连接");
                    break;
                }

                switch (flag) {
                    case "findAll" -> {
                        // 查找
                        TreeMap<Integer, Express> expressMap = eMap.getExpresses();
                        int size = expressMap != null ? expressMap.size() : 0;
                        objOut.writeInt(size);
                        objOut.flush();
                        if (size == 0) {
                            continue;
                        }
                        List<Express> list = new ArrayList<>(expressMap.values());
                        Collections.sort(list);
                        System.out.println(list);
                        objOut.writeObject(list);
//                        for (Express e : list) {
//                            System.out.println(e);
//                            objOut.writeObject(e);
//                        }
                    }
                    case "add" -> {

                        // 获取客户端发送的参数
                        Express e = (Express) objIn.readObject();
                        if (add(e, eMap)) {
                            objOut.writeUTF("快递添加成功!");
                            objOut.flush();
                            continue;
                        }
                        objOut.writeUTF("快递添加失败! 请检查快递单号是否重复");
                        objOut.flush();

//                        if (!eMap.setENum(e, e.getENum())) {
////                        System.out.println(InformationMessage.alreadyHasENum());
//                            objOut.writeUTF("快递添加失败，快递单号已存在！");
//                            objOut.flush();
//                            continue;
//                        }
//                        eMap.setECompany(e, e.getECompany());
//                        eMap.setLocation(e);
//
//                        Boolean res = eMap.add(eMap.setPickupCode(e), e);
//                        if (res) {
//                            objOut.writeUTF("添加成功\n"+e);
//                        } else {
//                            objOut.writeUTF("快递添加失败");
//                        }
//                        objOut.flush();
                    }
                    case "reset" -> {
                        System.out.println("reset");
                        String ENum = objIn.readUTF();
                        if (!eMap.checkIsENumExist(ENum)) {
                            objOut.writeObject("快递不存在");
                            continue;
                        }
                        Express oldE = eMap.findByENum(ENum);
//                        String oldECompany = oldE.getECompany();
                        int[] oldLocation = oldE.getLocation();
                        int oldPickCode = oldE.getPickupCode();

                        objOut.writeObject(true);

//                        Express e = (Express) objIn.readObject();
                        String newENum = objIn.readUTF();
                        String newECom = objIn.readUTF();

                        System.out.println(newENum + ", " + newECom);
                        if (delete(ENum, eMap)) {
                            Express newE = new Express(newENum, oldPickCode, newECom, oldLocation[0], oldLocation[1]);
                            if (add(newE, eMap)) {
                                objOut.writeUTF("修改成功\n" + eMap.findByENum(newENum));
                                System.out.println("修改成功");
                                objOut.flush();
                                continue;
                            }
                            add(oldE, eMap);
                            continue;
                        } else {
                            objOut.writeUTF("修改失败，快递单号冲突！");
                            objOut.flush();
                        }

                        System.out.println(eMap.getExpresses().values());

                    }
                    case "delete" -> {
                        System.out.println("delete");
                        String ENum = objIn.readUTF();

                        if (ENum.equals("cancel")) {
                            continue;
                        }

                        if (delete(ENum, eMap)) {
                            objOut.writeUTF("删除成功");
                            objOut.flush();
                            continue;
                        }

                        objOut.writeUTF("删除失败, 快递不存在!");
                        objOut.flush();
                    }
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            try {
                assert objOut != null;
                objOut.writeUTF(e.getMessage());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (!client.isClosed()) {
                    if (objIn != null) {
                        objIn.close();
                    }
                    if (objOut != null) {
                        objOut.close();
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 添加快递
     * @param e 要添加的快递
     * @param eMap 快递管理
     * @return boolean
     * @throws IOException I
     */
    public boolean add(Express e, ExpressMap eMap) throws IOException{
        if (!eMap.setENum(e, e.getENum())) {
            return false;
        }
        eMap.setECompany(e, e.getECompany());
        eMap.setLocation(e);
        return eMap.add(eMap.setPickupCode(e), e);
    }

    public boolean delete(String ENum, ExpressMap eMap) {
        return eMap.remove(ENum);
    }
}
