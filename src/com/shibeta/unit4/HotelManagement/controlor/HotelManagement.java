package com.shibeta.unit4.HotelManagement.controlor;


import com.shibeta.unit4.HotelManagement.module.RoomList;
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
            RoomList room = new RoomList();

            // 欢迎页面
            int select = ManagementProgram.welcome();
            if (select == 4) {
                break;
            }
            select = inputVerify.userSelectExchange(select, 1, 3);
            String result = inputVerify.userSelectVerify(select);

            if (result.equals(ExceptionMessage.numberInputOutOfRange())) {
                ShowMessage.numberInputOutOfRange();
                continue;
            } else if (result.equals(ExceptionMessage.wrongFormat())) {
                ShowMessage.wrongFormat();
                continue;

            }
            if (result.equals(InformationMessage.selectSuccessfully())) {
                // 登陆页面
                Menu.login();

                // 处理登陆信息
                Object loginResult = ManagementProgram.login(select, room);
                String user = null;
                String loginIdentify = ExceptionMessage.unknownException("cHM_main_31_110_41");

                if (loginResult instanceof String[]) {
                    if (((String[]) loginResult).length > 2) {
                        user = ((String[]) loginResult)[2];
                    }
                    loginIdentify = ((String[])loginResult)[1];
                    loginResult = ((String[]) loginResult)[0];

                } else if (loginResult instanceof String) {
                    if (loginResult.equals(InformationMessage.adminLoginSuccessfully())) {
                        loginIdentify = InformationMessage.adminLogin();
                    }
                    if (loginResult.equals(InformationMessage.guestLoginSuccessfully())) {
                        loginIdentify = InformationMessage.guestLogin();
                    }
                }

                // 管理员登陆 密码错误
                if (loginResult.toString().equals(ExceptionMessage.wrongPassword())) {
                    ShowMessage.wrongPassword();
                    continue;
                }

                // 用户登陆 用户名密码错误
                if (loginResult.toString().equals(ExceptionMessage.wrongUserOrPasswd())) {
                    ShowMessage.wrongUserOrPasswd();
                    continue;
                }

                // 退出
                if (loginResult.equals(InformationMessage.backMenu())) {
                    break;
                }

                Menu.loginIdentify(loginIdentify);
                // 管理员登陆
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
                            default -> ShowMessage.wrongFormat();
                        }
                    }

                }

                // 用户登陆
                if (loginResult.equals(InformationMessage.userLoginSuccessfully())) {
                    // 用户功能模块循环
                    while (true) {
                        Menu.user(user);
                        ShowMessage.userSelect();
                        int userSelect = UserInput.userSelect();
                        if (userSelect == 3) {
                            break;
                        }
                    }
                }

                // 游客登陆
                if (loginResult.equals(InformationMessage.guestLoginSuccessfully())) {
                    while (true) {
                        Menu.user();
                        ShowMessage.userSelect();
                        int guestSelect = UserInput.userSelect();
                        if (guestSelect == 3) {
                            break;
                        }
                    }
                }
            } else {
                ShowMessage.unknownException("cHM_main_20_43___43");
            }
        }

    }
}
