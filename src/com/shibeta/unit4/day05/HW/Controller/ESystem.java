package com.shibeta.unit4.day05.HW.Controller;


import com.shibeta.unit4.day05.HW.Model.Express;
import com.shibeta.unit4.day05.HW.Model.ExpressMap;
import com.shibeta.unit4.day05.HW.Model.UserIO;
import com.shibeta.unit4.day05.HW.View.ExceptionMessage;
import com.shibeta.unit4.day05.HW.View.InformationMessage;
import com.shibeta.unit4.day05.HW.View.Menu;

import java.io.*;
import java.util.Scanner;

public class ESystem {
    /**
     * 新建快递管理对象
     */
    private static String path = "src/com/shibeta/unit4/day05/HW/info/express.bin";
    private static final ExpressMap eM = readFromFile(path);
    public static void main(String[] args) {
        mainMenu: while(true) {
            // 欢迎菜单
            Menu.welcomeMenu();
            switch (UserIO.userSelect()) {
                // 用户菜单
                case 1 -> userMenu();
                // 管理员菜单
                case 2 -> adminMenu();
                case 3 -> {break mainMenu;}
                default -> System.out.println(ExceptionMessage.wrongSelect());
            }
        }
    }

    /**
     * 用户菜单
     */
    public static void userMenu() {
        userMenu: while(true) {
            Menu.userMenu();
            switch(UserIO.userSelect()) {
                // 取件
                case 1 -> {
                    // 取件页面
                    Menu.getExpress();
                    try {
                        // 取件码
                        int pickUp = Integer.parseInt(UserIO.userInput());
                        // 由取件码取出快递
                        Object e = eM.getByCode(pickUp);
                        if (e != null) {
                            System.out.println(InformationMessage.getExpressSucceed());
                            System.out.println(e);
                            break userMenu;
                        }
                        System.out.println(InformationMessage.getExpressFailed());
                    }
                    catch(NumberFormatException n) {
                        System.out.println(ExceptionMessage.wrongInput());
                    }
                }
                // 退出
                case 2 -> {
                    break userMenu;
                }
                default ->  System.out.println(ExceptionMessage.wrongSelect());
            }
        }

    }

    /**
     * 管理员页面
     */
    public static void adminMenu() {
        adminMenu: while(true) {
            // 管理员目录
            Menu.adminMenu();
            switch (UserIO.userSelect()) {
                // 录入快递
                case 1 -> saveExpress();
                // 修改快递
                case 2 -> resetExpress();
                // 删除快递
                case 3 -> removeExpress();
                // 显示快递
                case 4 -> showExpress();
                // 退出
                case 5 -> {
                    break adminMenu;
                }
                default -> System.out.println(ExceptionMessage.wrongSelect());
            }
        }
    }

    /**
     * 录入快递
     */
    public static void saveExpress() {
        // 输入快递单号
        Menu.addExpress();
        System.out.println(InformationMessage.inputENum());
        String eNum = UserIO.userInput();
        // 输入快递公司
        System.out.println(InformationMessage.inputCompany());
        String eCompany = UserIO.userInput();

        // 新建快递，录入信息
        Express e = new Express();
        int pickupCode = eM.setPickupCode(e);
        if (!eM.setENum(e, eNum)) {
            System.out.println(InformationMessage.alreadyHasENum());
        } else {
            eM.setECompany(e, eCompany);
            eM.setLocation(e);
            // 录入快递
            if (eM.add(pickupCode, e)) {
                System.out.println(InformationMessage.addExpressSucceed());
            } else {
                System.out.println(InformationMessage.addExpressFailed());
            }
        }
        saveInFile(path);

    }

    /**
     * 修改快递
     */
    public static void resetExpress() {
        // 修改快递菜单
        Menu.resetExpress();
        // 提示输入旧、新快递单号及新快递公司
        System.out.println(InformationMessage.inputENum());
        String ENum = UserIO.userInput();
        System.out.println(InformationMessage.inputNewENum());
        String newENum = UserIO.userInput();
        System.out.println(InformationMessage.inputNewCompany());
        String newCompany = UserIO.userInput();
        // 调用修改方法
        int status = eM.reset(ENum, newENum, newCompany);
        switch (status) {
            case 0 -> System.out.println(InformationMessage.resetExpressSucceed());
            case 1 -> System.out.println(InformationMessage.resetExpressENumExist());
            case 2 -> System.out.println(InformationMessage.resetExpressFailed());
        }
        saveInFile(path);

    }

    /**
     * 删除快递
     */
    public static void removeExpress() {
        System.out.println(InformationMessage.inputENum());
        // 通过快递单号删除快递
        String ENum = UserIO.userInput();
        if (eM.remove(ENum)) {
            System.out.println(InformationMessage.removeExpressSucceed());
        } else {
            System.out.println(InformationMessage.removeExpressFailed());
        }
        saveInFile(path);

    }

    /**
     * 查看所有快递
     */
    public static void showExpress() {
        eM.showExpress();
    }

    public static void changePath() {
        System.out.print("请输入新的保存(读取)路径: ");
        path = new Scanner(System.in).nextLine();
    }

    /**
     * 存储入本地文件
     * @param path 存储路径
     */
    public static void saveInFile(String path) {
        File express = new File(path);

        // 若路径不存在，则分隔出文件名，判断父文件夹路径是否存在
        if (!express.exists()) {
            char[] pathC = path.toCharArray();
            int fileBeginIndex = path.lastIndexOf('/') + 1;
            String directoryPath = new String(pathC, 0, fileBeginIndex - 1);

            File directory = new File(directoryPath);
            // 若目录路径不存在，尝试创建路径
            if (!directory.isDirectory()) {
                if (!directory.mkdirs()) {
                    System.out.println(InformationMessage.directoryCreateFailed());
                    return;
                }
                System.out.println(InformationMessage.directoryCreateSucceed());
            }

        }

        // 创建文件，序列化写入到文件中
        try(ObjectOutputStream ojo = new ObjectOutputStream(new FileOutputStream(path))) {
            ojo.writeObject(eM);
            ojo.flush();
            System.out.println(InformationMessage.expressSaveSucceed());
        } catch (IOException e) {
            System.out.println(InformationMessage.expressSaveFailed());
            e.printStackTrace();
        }
    }

    /**
     * 读取快递信息文件
     * @param path 快递存放路径
     * @return 快递类
     */
    private static ExpressMap readFromFile(String path) {
        // 若路径文件不存在，则返回新的空快递信息
        if (!(new File(path).exists())) {
            return new ExpressMap();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            Object express = ois.readObject();
            // 若读取到的快递文件非正确的快递信息类，则返回新的空快递信息
            if (express instanceof ExpressMap) {
                System.out.println(InformationMessage.expressLoadSucceed());
                return (ExpressMap) express;
            }
        } catch (IOException e) {
            System.out.println(InformationMessage.expressLoadFailed());
            e.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println(InformationMessage.expressLoadFormatError());
            c.printStackTrace();
        }
        return new ExpressMap();

    }
}
