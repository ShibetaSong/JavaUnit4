package com.shibeta.unit4.day07.Assignment.learn.ExpressManagement.HW.Controller;

import com.shibeta.unit4.day07.Assignment.learn.HW.Model.Express;
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
            welcomeMenu(objOut, objIn);

            try {
                if (client!=null) {
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            System.out.println("连接服务器失败");
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
        System.out.println("=====查看所有快递=====");
        objOut.writeUTF("findAll");
        objOut.flush();
        int count = objIn.readInt();
        if (count == 0) {
            System.out.println("快递柜中没有快递！");
            return;
        }

        Object obj = objIn.readObject();
        List<Express> expressList = new ArrayList<Express>((List)obj);

        for (Express e: expressList) {
            System.out.println(e);
        }
    }
    public void add(ObjectOutputStream objOut, ObjectInputStream objIn) throws IOException, ClassNotFoundException {
        System.out.println("=====录入快递=====");
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
        System.out.println("=====删除快递=====");
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

    /**
     * 修改快递
     * @param objOut 输出流
     * @param objIn 输入流
     * @throws IOException I
     * @throws ClassNotFoundException C
     */
    public void reset(ObjectOutputStream objOut, ObjectInputStream objIn) throws IOException, ClassNotFoundException{
        System.out.println("=====修改快递=====");
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
    }

    /**
     * 取出快递
     * @param objOut 输出流
     * @param objIn 输入流
     * @throws IOException I
     * @throws ClassNotFoundException C
     */
    public void getExpress(ObjectOutputStream objOut, ObjectInputStream objIn) throws IOException, ClassNotFoundException{
        System.out.println("=====取件=====");
        objOut.writeUTF("get");
        objOut.flush();

        System.out.println(InformationMessage.inputPickupCode());
        objOut.writeInt(UserIO.userInputInt());
        objOut.flush();

        Object obj = objIn.readObject();
        if (obj == null) {
            System.out.println("没有此快递，请检查取件码！");
            return;
        }
        System.out.println("=====取件成功！=====");
        System.out.println(obj);



    }

    public void adminMenu(ObjectOutputStream objOut, ObjectInputStream objIn) throws IOException, ClassNotFoundException {
        while (true) {
            Menu.clientAdminMenu();
            switch (UserIO.userSelect()) {
                case 5 -> {
                    return;
                }
                case 4 -> delete(objOut, objIn);
                case 3 -> reset(objOut, objIn);
                case 2 -> findAll(objOut, objIn);
                case 1 -> add(objOut, objIn);
                default -> {}
            }
        }
    }

    public void welcomeMenu(ObjectOutputStream objOut, ObjectInputStream objIn) throws IOException, ClassNotFoundException{
        Menu.welcomeMenu();
        try {
            switch (UserIO.userSelect()) {
                case 3 -> {
                    objOut.writeUTF("break");
                    objOut.flush();
                }
                case 2 -> {
                    if (verify(objOut, objIn, true)) {
                        adminMenu(objOut, objIn);
                    }
                    objIn.close();
                    objOut.close();
                    client.close();
                    start();
                }
                case 1 -> {
                    if (verify(objOut, objIn, false)) {
                        getExpress(objOut, objIn);
                    }
                    objIn.close();
                    objOut.close();
                    client.close();
                    start();
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean verify(ObjectOutputStream objOut, ObjectInputStream objIn, boolean isAdmin) throws IOException, ClassNotFoundException {
        objOut.writeUTF(isAdmin? "admin": "user");
        objOut.flush();

        System.out.println(isAdmin? "===管理员名称===": "===用户名===");
        objOut.writeUTF(UserIO.userInput());
        objOut.flush();

        if (!(boolean) objIn.readObject()) {
            System.out.println(isAdmin? "管理员不存在！": "用户不存在！");
            return false;
        }
        System.out.println("===密码===");
        objOut.writeUTF(UserIO.userInput());
        objOut.flush();

        if (!(boolean) objIn.readObject()) {
            System.out.println("密码错误！");
            return false;
        }
        return true;
    }
}
