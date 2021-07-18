package com.shibeta.unit4.HotelManagement.module;

import com.shibeta.unit4.HotelManagement.view.InformationMessage;

import java.util.Arrays;

public class User {
    private static String[] userNames = {};
    private static String[] userPasswords = {};

    public static String[] getUserNames() {
        return userNames;
    }

    public static String[] getUserPasswords() {
        return userPasswords;
    }

    /**
     * 查询房间信息
     */
    public static void showApartmentInfo() {}

    /**
     * 查询服务
     */
    public static void showService() {}

    public static String[][] setUserInformation(RoomList room) {
        if (room != null) {
            StringBuilder userName = new StringBuilder();
            StringBuilder userPasswd = new StringBuilder();
            if (!(room.getUsername().equals(InformationMessage.unsettle()))) {
                userName.append(room.getUsername());
                userName.append(" ");
                userPasswd.append(room.getUserIdentify());
                userPasswd.append(" ");
            }

            if (room.nextRoom != null) {
                String[][] userInformation = setUserInformation(room.nextRoom);
                if (userInformation.length > 0) {
                    if (!(Arrays.toString(userInformation[0]).equals("[\"\"]") || userInformation[0] == null)) {
                        for (String name : userInformation[0]) {
                            userName.append(name);
                        }
                        for (String passwd : userInformation[1]) {
                            userPasswd.append(passwd);
                        }
                    }
                    userNames = userName.toString().split(" ");
                    userPasswords = userPasswd.toString().split(" ");
                    return new String[][]{userNames, userPasswords};
                }
            }
            if (!(userName.toString().equals(""))) {
                userNames = userName.toString().split(" ");
                userPasswords = userPasswd.toString().split(" ");
                return new String[][]{userNames, userPasswords};
            }
        }
        return new String[][]{};
    }
}
