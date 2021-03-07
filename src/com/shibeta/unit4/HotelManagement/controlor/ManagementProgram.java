package com.shibeta.unit4.HotelManagement.controlor;

import com.shibeta.unit4.HotelManagement.module.Admin;
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

    public static String login(int identity) {
        switch (identity) {
            case 1 -> {
                ShowMessage.usernameInput();
                String user = UserInput.usernameInput();
                ShowMessage.passwordInput();
                String password = UserInput.passwordInput();
                if (!userLogin(user, password)) {
                    return ExceptionMessage.wrongUserOrPasswd();
                }
                return InformationMessage.userLoginSuccessfully();
            }
            case 2 -> {
                ShowMessage.passwordInput();
                StringBuilder password = new StringBuilder(UserInput.passwordInput());
                if (!adminLogin(password)) {
                    return ExceptionMessage.wrongPassword();
                }
                return InformationMessage.adminLoginSuccessfully();
            }
            default -> {
                return ExceptionMessage.unknownException("cMP_login_32_36___36");
            }
        }
    }

    public static boolean userLogin(String uname, String passwd) {
        for (int i = 0; i < User.userName.length; i++) {
            if (uname.equals(User.userName[i])) {
                return passwd.equals(User.userPasswd[i]);
            }
        }
        return false;

    }

    public static boolean adminLogin(StringBuilder passwd) {
        Admin admin = new Admin();
        return passwd.toString().equals(admin.getAdminPasswd());

    }
}
