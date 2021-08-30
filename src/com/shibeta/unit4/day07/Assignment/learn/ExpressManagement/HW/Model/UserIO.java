package com.shibeta.unit4.day07.Assignment.learn.ExpressManagement.HW.Model;

import com.shibeta.unit4.day05.HW.View.ExceptionMessage;
import com.shibeta.unit4.day05.HW.View.InformationMessage;

import java.util.Scanner;


public class UserIO {
    static Scanner input = new Scanner(System.in);

    /**
     * 验证一个字符串是否由数字组成
     * @param info 传入要验证的字符串
     * @return boolean，若该字符串由数字组成，返回 true，否则返回 false.
     */
    public static Boolean verifyIsInfoDigit(String info) {
        try {
            int intInfo = Integer.parseInt(info);
            if(intInfo <= 0) {
                throw new NumberFormatException("Must higher than 0");
            }
            return true;
        }
        catch (NumberFormatException ex) {
            return false;
        }
    }

    /**
     * 用户选择功能
     * @return int, 用户选择的内容。若用户输入有误，则返回-1。
     */
    public static int userSelect() {
        System.out.print(InformationMessage.userSelect());
        String userSelect = input.nextLine();
        if (verifyIsInfoDigit(userSelect)) {
            return Integer.parseInt(userSelect);
        }
        return -1;
    }

    /**
     * 用户输入功能
     * @return String, 用户输入的内容。
     */
    public static String userInput() {
        do {
            System.out.print(InformationMessage.userInput());
            String userInputContain = input.nextLine();
            if (!userInputContain.equals("")) {
                return userInputContain;
            }
            System.out.println(ExceptionMessage.wrongInput());
//            System.out.println(InformationMessage.userInput());
        } while (true);
    }

    /**
     * 用户输入功能(大于0的整型)
     * @return int, 用户输入的内容
     */
    public static int userInputInt() {
        do {
            System.out.println(InformationMessage.userInput());
            String userInputContain = input.nextLine();
            if (verifyIsInfoDigit(userInputContain)) {
                return Integer.parseInt(userInputContain);
            }
            System.out.println(ExceptionMessage.wrongInput());
        } while (true);
    }

}
