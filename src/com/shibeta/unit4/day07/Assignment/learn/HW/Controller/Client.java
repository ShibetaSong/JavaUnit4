package com.shibeta.unit4.day07.Assignment.learn.HW.Controller;

import com.shibeta.unit4.HotelManagement.module.User;
import com.shibeta.unit4.day07.Assignment.learn.HW.Model.Express;
import com.shibeta.unit4.day07.Assignment.learn.HW.Model.ExpressMap;
import com.shibeta.unit4.day07.Assignment.learn.HW.Model.UserIO;
import com.shibeta.unit4.day07.Assignment.learn.HW.View.InformationMessage;
import com.shibeta.unit4.day07.Assignment.learn.HW.View.Menu;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class
Client {
    private final int PORT = 10886;
    private Socket client;
//    private ESystem es = new ESystem();
//    private ExpressMap eM = ESystem.getEM();

    public static void main(String[] args) {
        Client c = new Client();
        try {
            c.start();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("连接服务器失败");
        }
    }

    public void start() throws ClassNotFoundException {
        OutputStream out;
        ObjectOutputStream objOut = null;
        InputStream in;
        ObjectInputStream objIn = null;

        try {
            client = new Socket("127.0.0.1", PORT);
            in = client.getInputStream();
            out = client.getOutputStream();
            objOut = new ObjectOutputStream(out);
            objIn = new ObjectInputStream(in);
            System.out.println("连接服务器成功！");

            clientMain: while (true) {
                Menu.welcomeMenu();
                try {
                    switch (UserIO.userSelect()) {
                        case 3 -> {
                            objOut.writeUTF("break");
                            objOut.flush();

                            break clientMain;
                        }
                        case 2 -> adminMenu(objOut, objIn);
                    }
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

            try {
                if (client!=null) {
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objIn != null) {
                    objIn.close();
                }
                if (objOut != null) {
                    objOut.close();
                }
                if (client!=null) {
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void findAll(ObjectOutputStream objOut, ObjectInputStream objIn) throws IOException, ClassNotFoundException {
        System.out.println("查看所有快递");
        objOut.writeUTF("findAll");
        objOut.flush();
        int count = objIn.readInt();
        if (count == 0) {
            System.out.println("快递柜中没有快递！");
            return;
        }

//        List<Express> expressList = (List<Express>) objIn.readObject();
        Object obj = objIn.readObject();
//        System.out.println(obj);
        List<Express> expressList = new ArrayList<Express>((List)obj);

//        System.out.println(expressList.toString());
        for (Express e: expressList) {
            System.out.println(e);
        }
//        for (int i=0; i<count; i++) {

//            if (obj instanceof TreeMap) {
//                for (Express e: ((TreeMap<Integer, Express>) obj).values()) {
//                    System.out.println(e);
//                    return;
//                }
//            }
//            if (obj instanceof String) {
//                System.out.println((String) obj);
//                return;
//            }
//            System.out.println(obj);
//        }
    }
    public void add(ObjectOutputStream objOut, ObjectInputStream objIn) throws IOException, ClassNotFoundException {
        System.out.println("录入快递");
        objOut.writeUTF("add");
        objOut.flush();

        // 新建快递，录入信息
        Express e = new Express();

        // 输入快递单号
        Menu.addExpress();
        System.out.println(InformationMessage.inputENum());
        String eNum = UserIO.userInput();
        e.setENum(eNum);

        // 输入快递公司
        System.out.println(InformationMessage.inputCompany());
        String eCompany = UserIO.userInput();
        e.setECompany(eCompany);

        // 录入快递
        objOut.writeObject(e);
        System.out.println(objIn.readUTF());

    }

    /**
     * 删除快递
     * @param objOut 输出流
     * @param objIn 输入流
     * @throws IOException I
     * @throws ClassNotFoundException C
     */
    public void delete(ObjectOutputStream objOut, ObjectInputStream objIn) throws IOException, ClassNotFoundException {
        System.out.println("删除快递");
        objOut.writeUTF("delete");
        objOut.flush();

        // 根据快递单号删除
        System.out.println(InformationMessage.inputENum());
        String ENum = UserIO.userInput();

        System.out.println("确认删除(y)? 请确认单号: "+ENum);
        if (!UserIO.userInput().equals("y")) {
            objOut.writeUTF("cancel");
            objOut.flush();
            return;
        }
        objOut.writeUTF(ENum);
        objOut.flush();

        // 获取删除结果
        System.out.println(objIn.readUTF());

    }
    public void reset(ObjectOutputStream objOut, ObjectInputStream objIn) throws IOException, ClassNotFoundException{
        System.out.println("修改快递");
        objOut.writeUTF("reset");
        objOut.flush();

        System.out.println(InformationMessage.inputENum());
        String ENum = UserIO.userInput();
        objOut.writeUTF(ENum);
        objOut.flush();

        Object res = objIn.readObject();
        if (!(res instanceof Boolean)) {
            System.out.println(res);
            return;
        }


        System.out.println(InformationMessage.inputNewENum());
        objOut.writeUTF(UserIO.userInput());
        objOut.flush();
        System.out.println(InformationMessage.inputNewCompany());
        objOut.writeUTF(UserIO.userInput());
        objOut.flush();

        System.out.println(objIn.readUTF());


//        // 提示输入旧、新快递单号及新快递公司
//        System.out.println(InformationMessage.inputENum());
//        String ENum = UserIO.userInput();
//        objOut.writeUTF(ENum);
//        objOut.flush();
//
//        Object res = objIn.readObject();
//        if (!(res instanceof Express)) {
//            System.out.println(res);
//            return;
//        }
//        System.out.println("获取到快递"+res);
//        System.out.println("设置快递信息中...");
//        // 设置快递信息并发送至服务器
//        Express e = (Express) res;
//
//        e = new Express(e.getENum(), e.getPickupCode(), e.getECompany(), e.getLocation()[0], e.getLocation()[1]);
//
//        System.out.println(InformationMessage.inputNewENum());
//        e.setENum(UserIO.userInput());
//        System.out.println(InformationMessage.inputNewCompany());
//        e.setECompany(UserIO.userInput());
//
//        Express newE = new Express(e.getENum(), e.getPickupCode(), e.getECompany(), e.getLocation()[0], e.getLocation()[1]);
//        System.out.println("提交快递信息中..." + newE);
//        objOut.writeObject(newE);


//        // 获取服务器设置反馈
//        System.out.println(objIn.readUTF());

    }
    public void adminMenu(ObjectOutputStream objOut, ObjectInputStream objIn) throws IOException, ClassNotFoundException {
//        adminMain: while (true) {
//            objOut = new ObjectOutputStream(client.getOutputStream());
//            objIn = new ObjectInputStream(client.getInputStream());
            Menu.clientAdminMenu();
            switch (UserIO.userSelect()) {
                case 5 -> {
//                    break adminMain;
                    return;
                }
                case 4 -> delete(objOut, objIn);
                case 3 -> reset(objOut, objIn);
                case 2 -> findAll(objOut, objIn);
                case 1 -> add(objOut, objIn);
            }
//        }
    }
}
