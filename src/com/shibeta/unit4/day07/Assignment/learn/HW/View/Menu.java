package com.shibeta.unit4.day07.Assignment.learn.HW.View;

import com.shibeta.unit4.day05.HW.View.InformationMessage;

public class Menu {
    /**
     * 欢迎页面，选择管理员或普通用户
     */
    public static void welcomeMenu() {
        System.out.println("==========快递驿站==========");
        System.out.println("1. 用户");
        System.out.println("2. 管理员");
        System.out.println("3. 退出");
    }

    /**
     * 用户登陆目录
     */
    public static void userMenu() {
        System.out.println("==========用户登陆==========");
        System.out.println("1. 取件");
        System.out.println("2. 退出");

    }

    public static void adminMenu() {
        System.out.println("==========管理员登陆==========");
        System.out.println("1. 快递录入");
        System.out.println("2. 修改快递");
        System.out.println("3. 删除快递");
        System.out.println("4. 查看所有快递");
        System.out.println("5. 退出");
    }

    public static void getExpress() {
        System.out.println("==========取件==========");
        System.out.print(InformationMessage.inputPickupCode());
    }

    public static void addExpress() {
        System.out.println("==========快递录入==========");

    }

    public static void clientAdminMenu() {
        System.out.println("==========客户端==========");
        System.out.println("1. 快递录入");
        System.out.println("2. 查看所有快递");
        System.out.println("3. 修改快递");
        System.out.println("4. 删除快递");
        System.out.println("5. 退出");
    }

    public static void resetExpress() {
        System.out.println("==========快递修改==========");
    }
}
