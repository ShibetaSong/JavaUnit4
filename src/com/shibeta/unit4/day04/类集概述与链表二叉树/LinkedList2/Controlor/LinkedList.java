package com.shibeta.unit4.day04.类集概述与链表二叉树.LinkedList2.Controlor;

import com.shibeta.unit4.day04.类集概述与链表二叉树.LinkedList2.Module.List;
import com.shibeta.unit4.day04.类集概述与链表二叉树.LinkedList2.Module.UserInput;
import com.shibeta.unit4.day04.类集概述与链表二叉树.LinkedList2.View.ShowInfo;
import com.shibeta.unit4.day04.类集概述与链表二叉树.LinkedList2.View.ShowMessage;
import com.shibeta.unit4.day04.类集概述与链表二叉树.LinkedList2.View.UserMenu;

import java.util.Scanner;


public class LinkedList {
    static Scanner input = new Scanner(System.in);
    /**
     * 链表程序启动
     * @return - 链表实例对象
     */
    public static List start() {
        UserMenu.welcome();
        return new List();
    }

    public static void program(List list) {
        main : while (true) {
            UserMenu.menu();
            int choice = UserInput.menuSelect(1, 5);
            if (choice == -1) {
                ShowMessage.wrongSelection();
            } else {
                switch (choice) {
                    case 1 -> UserMenu.addMenu();
                    case 2 -> UserMenu.searchMenu();
                    case 3 -> UserMenu.removeMenu();
                    case 4 -> UserMenu.lookUpMenu();
                    case 5 -> {
                        ShowMessage.programTerminated();
                        break main;
                    }
                    default -> ShowMessage.wrongSelection();
                }
                if (choice == 4) {
                    System.out.println(list.getDetails());
                } else {
                    // 添加数据
                    if (choice == 1) {
                        while (true) {
                            int sMenuChoice = UserInput.menuSelect(1, 4);
                            if (sMenuChoice == -1) {
                                ShowMessage.wrongSelection();
                                UserMenu.addMenu();
                                continue;
                            } else if (sMenuChoice == 4){
                                break;
                            }

                            Object data;
                            data = UserInput.dataInput(sMenuChoice, true);
                            if (data instanceof float[] || data instanceof String[] || data instanceof int[]) {
                                list.saveInLinkedList(data);
                            } else {
                                if (!(data instanceof Boolean) || (boolean) data) {
                                    list.add(data);
                                } else {
                                    UserMenu.addMenu();
                                    continue;
                                }
                            }
                            break;
                        }

                    } else {
                        // 非添加数据

                        // 查找
                        if (choice == 2) {
                            search: while (true) {
                            int tMenuChoice = UserInput.menuSelect(1, 4);
                            switch (tMenuChoice) {
                                case 1 -> ShowInfo.searchByLocation(list);
                                case 2 -> {
                                    int location = UserInput.locationInput(list);
                                    if (location != -1) {
                                        ShowInfo.searchByLocation(list, location);
                                    }
                                }
                                case 3 -> {
                                    while (true) {
                                        UserMenu.selectDataType();
                                        int dataType = UserInput.menuSelect(1, 4);
                                        if (dataType == -1) {
                                            ShowMessage.wrongSelection();
                                            continue;
                                        } else if (dataType == 4) {
                                            break;
                                        }
                                        ShowMessage.dataInput();
                                        ShowInfo.searchByData(list, input.nextLine(), dataType);

                                    }

                                }
                                case 4 -> {
                                    break search;
                                }
                                case -1 -> ShowMessage.wrongSelection();
                            }
                                UserMenu.searchMenu();

                        }

                        }

                        // 删除数据
                        if (choice == 3) {
                            while (true) {
                                int deleteType = UserInput.menuSelect(1, 3);
                                if (deleteType == 3) {
                                    break;
                                } else if (deleteType == -1) {
                                    ShowMessage.wrongSelection();
                                    UserMenu.removeMenu();
                                    continue;
                                }

                                if (deleteType == 1) {
                                    // 根据索引删除
                                    int location = UserInput.locationInput(list);
                                    if (location == -1) {
                                        ShowMessage.wrongLocation();
                                    } else {
                                        int result = ShowInfo.deleteByLocation(list, location);
                                        if (result == 1) {
                                            ShowMessage.dataRemoveSuccessfully();
                                        } else if (result == 0) {
                                            ShowMessage.unknownError("VSI_deleteByLocation_45_54");
                                        } else {
                                            ShowMessage.wrongLocation();
                                        }
                                    }
                                    UserMenu.removeMenu();

                                } else {
                                    // 根据数据删除
                                    while (true) {
                                        UserMenu.selectDataType();
                                        int sMenuChoice = UserInput.menuSelect(1, 4);
                                        if (sMenuChoice == -1) {
                                            ShowMessage.wrongSelection();
                                            UserMenu.selectDataType();
                                            continue;
                                        } else if (sMenuChoice == 4) {
                                            break;
                                        }

                                        int result = ShowInfo.deleteByData(list, sMenuChoice);
                                        if (result == 1) {
                                            ShowMessage.dataRemoveSuccessfully();
                                            UserMenu.removeMenu();
                                            break;
                                        } else if (result == -1) {
                                            ShowMessage.noSuchData();
                                            UserMenu.removeMenu();
                                            break;
                                        } else if(result == -2) {
                                            ShowMessage.wrongDataType();
                                            UserMenu.removeMenu();
                                            break;
                                        } else {
                                            ShowMessage.unknownError("MLS_deleteByData_0159_0202");
                                            UserMenu.removeMenu();
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
