package com.shibeta.unit4.HotelManagement.view;

import com.shibeta.unit4.day04.类集概述与链表二叉树.LinkedList2.View.Message;
import jdk.swing.interop.SwingInterOpUtils;

public class ShowMessage {
    /**
     * 提示用户输入
     */
    public static void userSelect() {
        System.out.print(InformationMessage.userSelect());
    }

    /**
     * 提示格式输入错误
     */
    public static void wrongFormat() {
        System.out.println(ExceptionMessage.wrongFormat());
    }

    /**
     * 提示数字输入超出范围
     */
    public static void numberInputOutOfRange() {
        System.out.println(ExceptionMessage.numberInputOutOfRange());
    }

    /**
     * 提示仅支持数字输入
     */
    public static void numberOnly() {
        System.out.println(ExceptionMessage.numberOnly());
    }

    /**
     * 提示未知错误
     * @param location 错误所在位置
     */
    public static void unknownException(String location) {
        System.out.println(ExceptionMessage.unknownException(location));
    }

    /**
     * 提示输入用户名
     */
    public static void usernameInput() {
        System.out.print(InformationMessage.usernameInput());
    }

    /**
     * 提示输入密码
     */
    public static void passwordInput() {
        System.out.print(InformationMessage.passwordInput());
    }

    /**
     * 提示密码输入错误
     */
    public static void wrongPassword() {
        System.out.println(ExceptionMessage.wrongPassword());
    }

    public static void enterGuestName() {
        System.out.println(InformationMessage.enterGuestName());
    }

    public static void enterGuestSex() {
        System.out.println(InformationMessage.enterGuestSex());
    }

    public static void enterGuestCode() {
        System.out.println(InformationMessage.enterGuestCode());
    }

    public static void enterGuestPhone() {
        System.out.println(InformationMessage.enterGuestPhone());
    }

    public static void wrongUserOrPasswd() {
        System.out.println(ExceptionMessage.wrongUserOrPasswd());
    }

}
