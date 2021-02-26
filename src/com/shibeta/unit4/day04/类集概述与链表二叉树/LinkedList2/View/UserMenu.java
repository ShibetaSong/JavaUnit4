package com.shibeta.unit4.day04.类集概述与链表二叉树.LinkedList2.View;

/**
 * @author Shibeta
 */
public class UserMenu {
    /**
     * 欢迎菜单
     */
    public static void welcome() {
        System.out.println("----------欢迎使用链表系统v1.0----------");
    }

    /**
     * 提示用户进行选择操作
     */
    public static void userSelect() {
        System.out.println("\t====================");
        System.out.println("\t  请选择需要进行的操作");
        System.out.println("\t====================");
    }

    /**
     * 提示选择数据类型
     */
    public static void dataType() {
        System.out.println("\t\t1.整型数据");
        System.out.println("\t\t2.字符串数据");
        System.out.println("\t\t3.浮点型数据");
        System.out.println("\t\t4.返回");
    }

    /**
     * 开始菜单
     */
    public static void menu() {
        userSelect();
        System.out.println("\t\t1.添加新数据");
        System.out.println("\t\t2.查找数据");
        System.out.println("\t\t3.删除数据");
        System.out.println("\t\t4.遍历数据");
        System.out.println("\t\t5.退出");
    }

    /**
     * 添加数据菜单
     */
    public static void addMenu() {
        System.out.println("----------添加新数据----------");
        userSelect();
        dataType();
    }

    /**
     * 查找数据菜单
     */
    public static void searchMenu() {
        System.out.println("----------查找数据----------");
        userSelect();
        searchType();
    }

    /**
     * 删除数据菜单
     */
    public static void removeMenu() {
        System.out.println("----------删除数据----------");
        userSelect();
        deleteType();
    }

    /**
     * 遍历数据菜单
     */
    public static void lookUpMenu() {
        System.out.println("----------遍历数据----------");
        System.out.println("链表数据如下：");
    }

    /**
     * 选择存储数据类型菜单
     */
    public static void saveTypeMenu() {
        System.out.println("----------存储数据----------");
        userSelect();
        System.out.println("\t\t1、存储单个数据");
        System.out.println("\t\t2、存储多个数据");
        System.out.println("\t\t3、返回");
    }

    /**
     * 选择查找类型菜单
     */
    public static void searchType() {
        System.out.println("\t1、查找首个数据");
        System.out.println("\t2、按照索引查找数据");
        System.out.println("\t3、按照数据查找索引");
        System.out.println("\t4、返回");
    }

    /**
     * 选择删除类型菜单
     */
    public static void deleteType() {
        System.out.println("\t1、根据索引删除");
        System.out.println("\t2、根据数据删除");
        System.out.println("\t3、返回");

    }

    /**
     * 选择数据类型菜单
     */
    public static void selectDataType() {
        System.out.println("----------选择数据类型----------");
        userSelect();
        dataType();
    }
}
