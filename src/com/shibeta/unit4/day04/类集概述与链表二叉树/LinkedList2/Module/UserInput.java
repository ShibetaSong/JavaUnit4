package com.shibeta.unit4.day04.类集概述与链表二叉树.LinkedList2.Module;


import com.shibeta.unit4.day04.类集概述与链表二叉树.LinkedList2.View.Message;
import com.shibeta.unit4.day04.类集概述与链表二叉树.LinkedList2.View.ShowMessage;
import com.shibeta.unit4.day04.类集概述与链表二叉树.LinkedList2.View.UserMenu;

import java.util.Scanner;

/**
 * @author Shibeta
 */
public class UserInput {
    static Scanner input = new Scanner(System.in);

    /**
     * 用户选择
     * @param x 选择下限
     * @param y 选择上限
     * @return 选择编号，若选择有误则返回-1
     */
    public static int menuSelect(int x, int y) {
        ShowMessage.userSelect();
        int select;

        try {
            select =  Integer.parseInt(input.nextLine());
        } catch (Exception e) {
            return -1;
        }

        if (select <= y && select >= x) {
            return select;
        }
        return -1;
    }

    public static int locationInput(List list) {
        ShowMessage.locationInput();
        int location;

        try {
            location = Integer.parseInt(input.nextLine());
        } catch (Exception e) {
            return -1;
        }

        if (location < 0 || location > list.getNum()) {
            return -1;
        }
        return location;
    }
    /**
     * 接受并转换数据
     * @param choice integer，要存储的数据类型 1-整型， 2-字符串， 3-浮点型
     * @return 转换后的数据
     */
    public static Object dataInput(int choice) {
        return dataInput(choice, false);
    }

    public static Object dataInput(int dataType, boolean isAdd) {
        String data;
        Object processedData;
        int saveType = 1;
        switch (dataType) {
            // 整型数据
            case 1 -> {
                if (isAdd) {
                    UserMenu.saveTypeMenu();
                    saveType = menuSelect(1, 3);
                }

                if (saveType == -1) {
                    ShowMessage.wrongSelection();
                    return false;

                } else if (saveType == 3) {
                    return false;
                } else {
                    // 单个数据操作
                    if (saveType == 1) {
                        ShowMessage.dataInput();
                        data = input.nextLine();
                        processedData = List.processData(data, 1, false);
                        if (!(processedData instanceof Integer)) {
                            ShowMessage.wrongDataType();
                            return false;
                        }
                        return processedData;
                    }

                    // 多个数据操作
                    ShowMessage.multipleDataInput();
                    data = input.nextLine();
                    processedData = List.processData(data, 1, true);
                    if (!(processedData instanceof int[])) {
                        ShowMessage.wrongDataType();
                        return false;
                    }
                    return processedData;
                }
            }

            // 字符串型
            case 2 -> {
                if (isAdd) {
                    UserMenu.saveTypeMenu();
                    saveType = menuSelect(1, 3);
                }

                if (saveType == -1) {
                    ShowMessage.wrongSelection();
                    return false;

                } else if (saveType == 3) {
                    return false;
                } else {
                    // 单个数据操作
                    if (saveType == 1) {
                        ShowMessage.dataInput();
                        data = input.nextLine();
                        return List.processData(data, 2, false);
                    }

                    // 多个数据操作
                    ShowMessage.multipleDataInput();
                    data = input.nextLine();
                    processedData = List.processData(data, 2, true);
                }
            }


            // 浮点型
            case 3 -> {
                if (isAdd) {
                    UserMenu.saveTypeMenu();
                    saveType = menuSelect(1, 3);
                }

                if (saveType == -1) {
                    ShowMessage.wrongSelection();
                    return false;
                } else if (saveType == 3) {
                    return false;
                } else {
                    // 单个数据操作
                    if (saveType == 1) {
                        ShowMessage.dataInput();
                        data = input.nextLine();
                        processedData = List.processData(data, 3, false);
                        if (!(processedData instanceof Float)) {
                            return false;
                        }
                        return processedData;
                    }

                    // 多个数据操作
                    ShowMessage.multipleDataInput();
                    data = input.nextLine();
                    processedData = List.processData(data, 3, true);
                    if (!(processedData instanceof float[])) {
                        ShowMessage.wrongDataType();
                        return false;
                    }
                }

            }
            default -> {
                return Message.wrongDataType();
            }
        }

        return processedData;
    }



}
