package com.shibeta.unit4.HotelManagement.controlor;

import com.shibeta.unit4.HotelManagement.module.Admin;
import com.shibeta.unit4.HotelManagement.module.RoomList;
import com.shibeta.unit4.HotelManagement.module.User;
import com.shibeta.unit4.HotelManagement.module.UserInput;
import com.shibeta.unit4.HotelManagement.view.ExceptionMessage;
import com.shibeta.unit4.HotelManagement.view.InformationMessage;
import com.shibeta.unit4.HotelManagement.view.Menu;
import com.shibeta.unit4.HotelManagement.view.ShowMessage;

public class ManagementProgram {
    public static int welcome() {
            Menu.welcome();
            ShowMessage.userSelect();
            return UserInput.userSelect();
        }

    /**
     * 登陆主进程
     * @param identity 登陆身份：1、用户; 2、管理员
     * @return 若以用户登陆，返回用户登陆组信息；若以管理员登陆，返回管理员登陆成功字样
     */
    public static Object login(int identity, RoomList room) {
        switch (identity) {
            case 1 -> {
                String loginResult = userLogin(room).toString();
                String[] loginResults = loginResult.split(" ");

                if (loginResults.length < 2) {
                    return loginResult;
                } else {
                    return loginResults;
                }
            }
            case 2 -> {
                ShowMessage.passwordInput();
                StringBuilder password = new StringBuilder(UserInput.passwordInput());
                if (!adminLogin(password)) {
                    return ExceptionMessage.wrongPassword();
                }
                return InformationMessage.adminLoginSuccessfully();
            }
            case 3 -> {
                Menu.loginIdentify(InformationMessage.guestLogin());
                return InformationMessage.guestLoginSuccessfully();
            }
            default -> {
                return ExceptionMessage.unknownException("cMP_login_32_36___36");
            }

        }
    }

    /**
     * 用户登陆核心进程
     * @return 若登陆正常，返回登陆成功、登陆身份，若是用户登陆则一并返回用户名。若登陆异常，则返回异常信息。
     */
    public static StringBuilder userLogin(RoomList room) {
        ShowMessage.usernameInput();
        StringBuilder user = new StringBuilder(UserInput.usernameInput());
        ShowMessage.passwordInput();
        String password = UserInput.passwordInput();

        if (user.toString().equals("") && password.equals("")) {
            return new StringBuilder(InformationMessage.guestLoginSuccessfully());
        }

        User.setUserInformation(room);

        for (int i = 0; i < User.getUserNames().length; i++) {
            if (user.toString().equals(User.getUserNames()[i])) {
                if (password.equals(User.getUserPasswords()[i])) {
                    StringBuilder loginResult = new StringBuilder(InformationMessage.userLoginSuccessfully());
                    loginResult.append(" ");
                    loginResult.append(InformationMessage.userLogin());
                    loginResult.append(" ");
                    loginResult.append(user);
                    return loginResult;
                }
            }
        }
        return new StringBuilder(ExceptionMessage.wrongUserOrPasswd());
    }

    public static boolean adminLogin(StringBuilder passwd) {
        Admin admin = new Admin();
        return passwd.toString().equals(admin.getAdminPasswd());
    }
}
