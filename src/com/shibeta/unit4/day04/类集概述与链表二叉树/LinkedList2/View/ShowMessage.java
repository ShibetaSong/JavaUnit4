package com.shibeta.unit4.day04.类集概述与链表二叉树.LinkedList2.View;


/**
 * @author Shibeta
 */
public class ShowMessage {
    /**
     * 链表创建成功提示语
     */
    public static void linkedListCreated() {
        System.out.println(Message.linkedListCreated());
    }

    /**
     * 数据添加成功提示语
     */
    public static void dataAppendSuccessfully() {
        System.out.println(Message.dataAppendSuccessfully());
    }

    /**
     * 数据删除成功提示语
     */
    public static void dataRemoveSuccessfully() {
        System.out.println(Message.dataRemoveSuccessfully());
    }

    /**
     * 输入选择提示语
     */
    public static void userSelect() {
        System.out.print(Message.userSelect());
    }

    /**
     * 选择有误提示语
     */
    public static void wrongSelection() {
        System.out.println(Message.wrongSelection());
    }

    /**
     * 输入多个数据提示语
     */
    public static void multipleDataInput() {
        System.out.println(Message.multipleDataInput());
    }

    /**
     * 输入单个数据提示语
     */
    public static void dataInput() {
        System.out.println(Message.dataInput());
    }

    /**
     * 数据类型有误提示语
     */
    public static void wrongDataType() {
        System.out.println(Message.wrongDataType());
    }

    /**
     * 没有匹配的数据项提示语
     */
    public static void noSuchData() {
        System.out.println(Message.noSuchData());
    }

    /**
     * 程序结束提示语
     */
    public static void programTerminated() {
        System.out.println(Message.programTerminated());
    }

    /**
     * 位置输入提示语
     */
    public static void locationInput() {
        System.out.println(Message.locationInput());
    }

    /**
     * 位置有误提示语
     */
    public static void wrongLocation() {
        System.out.println(Message.wrongLocation());
    }

    /**
     * 未知异常提示语
     * @param eCode 代号
     */
    public static void unknownError(String eCode) {
        System.out.println(Message.unknownError()+Message.errorCode(eCode));
    }
}
