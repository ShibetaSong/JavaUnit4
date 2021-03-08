package com.shibeta.unit4.day04.类集概述与链表二叉树.LinkedList2.View;

import com.shibeta.unit4.day04.类集概述与链表二叉树.LinkedList2.Module.List;
import com.shibeta.unit4.day04.类集概述与链表二叉树.LinkedList2.Module.UserInput;

public class ShowInfo {
    /**
     * 由位置检索，输出链表第一个元素
     * @param list 链表实例
     */
    public static void searchByLocation(List list) {
        System.out.println(list.getByLocation());
    }

    /**
     * 由位置检索
     * @param list 链表实例
     * @param location 检索的位置
     */
    public static void searchByLocation(List list, int location) {
        Object data = list.getByLocation(location);
        System.out.println(data);
    }

    public static void searchByData(List list, Object data, int type) {
        data = List.processData(data.toString(), type);
        int location = list.getByData(data);
        if (location == -1) {
            ShowMessage.noSuchData();
        } else if (location == -2){
            ShowMessage.unknownError("MLS_GetByData_077_120");
        } else {
            System.out.println(location);
        }
    }

    public static int deleteByData(List list, int type) {
        Object data;
        data = UserInput.dataInput(type);
        String notice = list.deleteAndReloadByData(data);
        if (notice.equals(Message.dataRemoveSuccessfully())) {
            return 1;
        } else if (notice.equals(Message.noSuchData())) {
            return -1;
        } else if (notice.equals(Message.wrongDataType())){
            return -2;
        } else {
            return 0;
        }
    }

    public static int deleteByLocation(List list, int location) {
        String notice = list.deleteAndReloadByLocation(location);
        if (notice.equals(Message.wrongLocation())) {
            return -1;
        } else if (notice.equals(Message.dataRemoveSuccessfully())) {
            return 1;
        }
        return 0;
    }

}
