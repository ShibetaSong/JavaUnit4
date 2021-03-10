package com.shibeta.unit4.HotelManagement.view;

public class ExceptionMessage {
    public static String numberOnly() {
        return "仅支持整数";
    }

    public static String wrongFormat() {
        return "格式有误";
    }


    public static String numberInputOutOfRange() {
        return "输入超出范围";
    }

    public static String unknownException(String location) {
        return "未知错误，错误代码【" + location + "】";
    }

    public static String wrongPassword() {
        return "密码输入有误";
    }

    public static String wrongUserOrPasswd() {
        return "用户名或密码输入错误";
    }

    public static String noSuchRoomType() {
        return "无该类型房间";
    }

    public static String roomTypeExist() {
        return "此类型房间已存在";
    }

    public static String roomTypeDidNotSet() {
        return "该房间类型未设置";
    }

    public static String noMatchRoom() {
        return "房间不存在";
    }

    public static String emptyRoom() {
        return "该房间无人入住";
    }

}
