package com.shibeta.unit4.day07.Assignment.learn.ExpressManagement.HW.Controller;

import com.shibeta.unit4.day07.Assignment.learn.HW.Controller.ESystem;
import com.shibeta.unit4.day07.Assignment.learn.HW.Model.Express;
import com.shibeta.unit4.day07.Assignment.learn.HW.Model.ExpressMap;
import com.shibeta.unit4.day07.Assignment.learn.HW.Model.UserIO;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {
    private final int PORT = 10886;
    private static final ExpressMap eMap = ESystem.getEM();
    private ServerSocket server;
    private static final Map<String, String> users = new HashMap<>();
    private static final Map<String, String> admins = new HashMap<>();

    public static void main(String[] args) {
        users.put("user", "123");
        admins.put("admin", "abc");

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
            }
            if (func == 2) {
                return;
            }
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
                            ObjectOutputStream objOut = new ObjectOutputStream(client.getOutputStream());
                            ObjectInputStream objIn = new ObjectInputStream(client.getInputStream());

                            verify(objOut, objIn, client);
                            handlerRequest(objOut, objIn, client);

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
     * 验证用户名密码是否对应
     *
     * @param map   字典
     * @param key   键
     * @return 0 => 对应, 1 => 没有用户, 2 => 不对应
     */
    private boolean verifyUserOrAdmin(ObjectOutputStream objOut, ObjectInputStream objIn,
                                      Map<String, String> map, String key)
            throws IOException {

        // 验证用户名
        if (!map.containsKey(key) || map.get(key) == null) {
            objOut.writeObject(false);
            return false;
        }
        objOut.writeObject(true);

        // 验证密码
        if (!(map.get(key)).equals(objIn.readUTF())) {
            objOut.writeObject(false);
            return false;
        }
        objOut.writeObject(true);
        return true;
    }


    /**
     * 验证身份
     *
     * @param client 客户端
     */
    private void verify(ObjectOutputStream objOut, ObjectInputStream objIn, Socket client) throws IOException{
        // 获取用户验证请求
        while (true) {
            String ver = objIn.readUTF();

            if (ver.equals("user")) {
                if (verifyUserOrAdmin(objOut, objIn, users, objIn.readUTF())) {
                    return;
                }
            }
            if (ver.equals("admin")) {
                // 输入管理员名
                if (verifyUserOrAdmin(objOut, objIn, admins, objIn.readUTF())) {
                    return;
                }
            }
        }
    }

    /**
     * 处理客户端的请求
     *
     * @param client 客户端
     */
    private void handlerRequest(ObjectOutputStream objOut, ObjectInputStream objIn, Socket client) {
        try {
            // 获取客户端发送的请求类型
            while (true) {
                String flag = objIn.readUTF();
                System.out.println("客户端" + client.hashCode() + ", 请求：" + flag + ", 线程" + Thread.currentThread().getName() + "启动");
                if (flag.equals("break")) {
                    System.out.println("客户端" + client.hashCode() + "断开了连接");
                    return;
                }
                if (flag.equals("logoff")) {
                    System.out.println("客户端" +  client.hashCode() + "注销");
                    return;
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
                        objOut.writeObject(list);

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
                    }

                    case "reset" -> {
                        String ENum = objIn.readUTF();
                        if (!eMap.checkIsENumExist(ENum)) {
                            objOut.writeObject("快递不存在");
                            continue;
                        }
                        Express oldE = eMap.findByENum(ENum);
                        int[] oldLocation = oldE.getLocation();
                        int oldPickCode = oldE.getPickupCode();

                        objOut.writeObject(true);

                        String newENum = objIn.readUTF();
                        String newECom = objIn.readUTF();

                        if (delete(ENum, eMap)) {
                            Express newE = new Express(newENum, oldPickCode, newECom, oldLocation[0], oldLocation[1]);
                            if (add(newE, eMap)) {
                                objOut.writeUTF("修改成功\n" + eMap.findByENum(newENum));
                                objOut.flush();
                                continue;
                            }
                            add(oldE, eMap);
                            objOut.writeUTF("修改失败，快递单号冲突！");
                            objOut.flush();
                        } else {
                            objOut.writeUTF("修改失败，快递不存在！");
                            objOut.flush();
                        }
                    }

                    case "delete" -> {
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

                    case "get" -> {
                        int pickUpCode = objIn.readInt();
                        objOut.writeObject(eMap.getByCode(pickUpCode));
                    }
                }
            }

        } catch (IOException | ClassNotFoundException e) {
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
                System.out.println("客户端" + client.hashCode() + "断开了连接");

            }
        }
    }

    /**
     * 添加快递
     *
     * @param e    要添加的快递
     * @param eMap 快递管理
     * @return boolean
     * @throws IOException I
     */
    public boolean add(Express e, ExpressMap eMap) throws IOException {
        if (!eMap.setENum(e, e.getENum())) {
            return false;
        }
        eMap.setECompany(e, e.getECompany());
        if (e.getLocation()[0] == 0) {
            eMap.setLocation(e);
        }
        return e.getPickupCode() == 0? eMap.add(eMap.setPickupCode(e), e): eMap.add(e.getPickupCode(), e);
    }

    /**
     * 删除快递
     * @param ENum 单号
     * @param eMap 快递管理
     * @return boolean
     */
    public boolean delete(String ENum, ExpressMap eMap) {
        return eMap.remove(ENum);
    }
}
