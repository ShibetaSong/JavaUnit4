package com.shibeta.unit4.HotelManagement.view;

public class Menu {

    public static void welcome() {
        System.out.println("\n==========欢迎来到酒店管理系统 v1.0==========");
        System.out.println("\t请选择登陆类型");
        System.out.println("\t\t1、用户");
        System.out.println("\t\t2、管理员");
        System.out.println("\t\t3、退出");
    }

    public static void login() {
        System.out.println("\n==========登陆==========");
    }

    public static void admin() {
        System.out.println("\n==========管理员==========");
        System.out.println("\t1、办理入住");
        System.out.println("\t2、办理退房");
        System.out.println("\t3、修改信息");
        System.out.println("\t4、搜索信息");
        System.out.println("\t5、查看信息");
        System.out.println("\t6、退出");
    }

    public static void adminShowInfo() {
        System.out.println("\n==========查看信息==========");
        System.out.println("\t1、查看房间详情");
        System.out.println("\t2、查看已住房间");
        System.out.println("\t3、查看空房间");
        System.out.println("\t4、查看入住旅客");
        System.out.println("\t5、退出");

    }

    public static void adminCheckIn() {
        System.out.println("\n==========办理入住==========");
    }

    public static void adminCheckOut() {
        System.out.println("\n==========办理退房==========");
    }

    public static void adminChangeInfo() {
        System.out.println("\n==========修改信息==========");
    }

    public static void adminSearchInfo() {
        System.out.println("\n==========搜索信息==========");
    }

    public static void user() {
        user("游客");
    }

    public static void user(String username) {
        System.out.println("\n==========欢迎您, " + username + " 用户==========");
        System.out.println("\t1、查询房间信息");
        System.out.println("\t2、查询服务");
        System.out.println("\t3、退出");
    }

    public static void loginIdentify(String loginIdentify) {
        System.out.println("\n====================");
        System.out.println("当前身份：" + loginIdentify);
        System.out.println("====================");
    }

    public static void getRoomInformation(String roomIdentify,
                                          String roomType,
                                          String username,
                                          String userIdentify,
                                          String userSex,
                                          String userPhone,
                                          String roomFacilitiesRepairApply) {
        System.out.println("=========================");
        System.out.println("房间号：" + roomIdentify);
        System.out.println("房间类型：" + roomType);
        System.out.println("住户名：" + username);
        System.out.println("证件号：" + userIdentify);
        System.out.println("性别：" + userSex);
        System.out.println("手机号：" + userPhone);
        System.out.println("房间报修情况：" + roomFacilitiesRepairApply);
    }
}
