package com.shibeta.unit4.HotelManagement.module;

import com.shibeta.unit4.HotelManagement.view.ExceptionMessage;

import java.util.Scanner;

public class UserInput {
    static final Scanner input = new Scanner(System.in);

    /**
     * 要求用户进行选择。
     * @return 若用户输入的是正整数，则返回该数字；否则返回-1。
     */
    public static int userSelect() {
        String userSelect = input.nextLine();
        int select;
        try {
            select = Integer.parseInt(userSelect);
            if (select < 0) {
                throw new NumberFormatException(ExceptionMessage.wrongFormat());
            }
        } catch (NumberFormatException e) {
            select = -1;
        }
        return select;
    }

    /**
     * 要求用户输入姓名
     * @return 用户姓名
     */
    public static String usernameInput() {
        return input.nextLine();
    }

    /**
     * 要求用户输入密码
     * @return 用户密码
     */
    public static String passwordInput() {
        return input.nextLine();
    }
}
