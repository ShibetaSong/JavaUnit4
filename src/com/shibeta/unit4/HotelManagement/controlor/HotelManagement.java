package com.shibeta.unit4.HotelManagement.controlor;


import com.shibeta.unit4.HotelManagement.module.UserInput;
import com.shibeta.unit4.HotelManagement.module.inputVerify;
import com.shibeta.unit4.HotelManagement.view.ExceptionMessage;
import com.shibeta.unit4.HotelManagement.view.InformationMessage;
import com.shibeta.unit4.HotelManagement.view.Menu;
import com.shibeta.unit4.HotelManagement.view.ShowMessage;

public class HotelManagement {
    public static void main(String[] args) {
        // 主程序循环
        while (true) {
            // 欢迎页面
            int select = ManagementProgram.welcome();
            if (select == 3) {
                break;
            }
            select = inputVerify.userSelectExchange(select, 1, 2);
            String result = inputVerify.userSelectVerify(select);

            if (result.equals(ExceptionMessage.numberInputOutOfRange())) {
                ShowMessage.numberInputOutOfRange();
                continue;
            } else if (result.equals(ExceptionMessage.wrongFormat())) {
                ShowMessage.wrongFormat();
                continue;

            // 进入选择
            }
            if (result.equals(InformationMessage.selectSuccessfully())) {
                // 登陆页面
                Menu.login();
                String loginResult = ManagementProgram.login(select);

                // 管理员登陆 密码错误
                if (loginResult.equals(ExceptionMessage.wrongPassword())) {
                    ShowMessage.wrongPassword();
                    continue;
                }

                // 用户登陆 用户名密码错误
                if (loginResult.equals(ExceptionMessage.wrongUserOrPasswd())) {
                    ShowMessage.wrongUserOrPasswd();
                    continue;
                }

                if (loginResult.equals(InformationMessage.backMenu())) {
                    break;
                }
                if (loginResult.equals(InformationMessage.adminLoginSuccessfully())) {
                    // 管理员功能模块循环
                    while (true) {
                        Menu.admin();
                        ShowMessage.userSelect();
                        int adminSelect = UserInput.userSelect();
                        if (adminSelect == 6) {
                            break;
                        }
                        adminSelect = inputVerify.userSelectExchange(adminSelect, 1, 6);
                        switch (adminSelect) {
                            case 1 -> {
                                Menu.adminCheckIn();
                            }
                            case 2 -> {
                                Menu.adminCheckOut();
                            }
                            case 3 -> {
                                Menu.adminChangeInfo();
                            }
                            case 4 -> {
                                Menu.adminSearchInfo();
                            }
                            case 5 -> {
                                Menu.adminShowInfo();
                            }
                        }
                    }

                }

                if (loginResult.equals(InformationMessage.userLoginSuccessfully())) {
                    // 用户功能模块循环
                    while (true) {
                        Menu.user();
                        ShowMessage.userSelect();
                        int userSelect = UserInput.userSelect();

                    }
                }

            } else {
                ShowMessage.unknownException("cHM_main_20_43___43");
            }
        }

    }
}
