package com.shibeta.unit4.day04.类集概述与链表二叉树.LinkedList2.View;


/**
 * @author Shibeta
 */
public class Message {
    /**
     * @return 链表已创建
     */
    public static String linkedListCreated() {
        return "链表创建成功！";
    }

    /**
     * @return  所在位置数据不存在
     */
    public static String dataHasBeenRemoved() {
        return "【提醒】该数据已被删除！";
    }

    /**
     * @return 无该数据
     */
    public static String noSuchData() {
        return "【没有找到此数据！】";
    }

    /**
     * @return 链表数据删除成功
     */
    public static String dataRemoveSuccessfully() {
        return "数据删除成功！";
    }

    /**
     * @return 链表数据添加成功
     */
    public static String dataAppendSuccessfully() {
        return "数据添加成功！";
    }

    /**
     * @return 输入的索引位置有误
     */
    public static String wrongLocation() {
        return "【位置有误！】";
    }

    /**
     * @return 提示用户输入选择
     */
    public static String userSelect() {
        return "请输入选择：";
    }

    /**
     * @return 提示用户输入位置
     */
    public static String locationInput() {
        return "请输入位置：";
    }

    /**
     * @return 选择有误
     */
    public static String wrongSelection() {
        return "【选择有误！】";
    }

    /**
     * @return 数据类型有误
     */
    public static String wrongDataType() {
        return "【数据类型有误！】";
    }

    /**
     * @return 提示用户输入数据(多个)
     */
    public static String multipleDataInput() {
        return "请输入数据(以单个空格分隔)：";
    }

    /**
     * @return 提示用户输入数据(单个)
     */
    public static String dataInput() {
        return "请输入数据：";
    }

    /**
     * @return 程序结束
     */
    public static String programTerminated() {
        return "程序结束";
    }

    /**
     * @return 未知异常
     */
    public static String unknownError() {
        return "【未知异常】";
    }

    /**
     * @param eCode 异常代码
     * @return 异常代码
     */
    public static String errorCode(String eCode) {
        return "代码："+eCode;
    }


}
