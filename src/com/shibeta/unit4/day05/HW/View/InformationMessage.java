package com.shibeta.unit4.day05.HW.View;

public class InformationMessage {
    public static String userSelect() {
        return "请输入选择：";
    }

    public static String userInput() {
        return "请输入:";
    }

    public static String inputPickupCode() {
        return "【输入取件码】";
    }

    public static String inputCompany() {
        return "【输入快递公司】";
    }

    public static String inputENum() {
        return "【输入快递单号】";
    }

    public static String inputNewENum() {
        return "【输入新快递单号】";
    }

    public static String inputNewCompany() {
        return "【输入新快递公司】";
    }

    public static String alreadyHasENum() {
        return "快递单号重复！";
    }
    
    public static String getExpressSucceed() {
        return "取件成功！";
    }
    
    public static String getExpressFailed() {
        return "取件码错误或没有此快递！";
    }

    public static String addExpressSucceed() {
        return "快递录入成功！";
    }

    public static String addExpressFailed() {
        return "快递录入失败！快递柜已满或取件码重复！";
    }

    public static String removeExpressSucceed() {
        return "快递删除成功！";
    }

    public static String removeExpressFailed() {
        return "快递删除失败！";
    }

    public static String resetExpressSucceed() {
        return "快递修改成功！";
    }

    public static String resetExpressENumExist() {
        return "快递单号已存在！";
    }

    public static String resetExpressFailed() {
        return "没有此快递，快递修改失败！";
    }

    public static String expressLoadSucceed() {
        return "快递读取成功！";
    }

    public static String expressLoadFailed() {
        return "快递读取失败！";
    }

    public static String expressLoadFormatError() {
        return "快递格式错误！";
    }

    public static String expressSaveSucceed() {
        return "快递保存成功！";
    }

    public static String expressSaveFailed() {
        return "快递保存失败！";
    }

    public static String directoryCreateSucceed() {
        return "目录创建成功！";
    }

    public static String directoryCreateFailed() {
        return "目录创建失败！";
    }
}
