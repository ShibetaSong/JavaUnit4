package com.shibeta.unit4.HotelManagement.module;

import com.shibeta.unit4.HotelManagement.view.ExceptionMessage;

public class Apartment {
    static StringBuilder roomType = new StringBuilder("标准双床房 高级大床房 影视大床房 高级套房 ");
    static String[] roomTypes = roomType.toString().split(" ");
    static StringBuilder roomFacilitiesRepair = new StringBuilder();

    /**
     * 获取指定房间类型
     * @param type 指定房间类型
     * @return 返回指定房间类型，若无，返回无此类型房间提示
     */
    public static StringBuilder getRoomType(String type) {
        for(String eachRoomType : roomTypes) {
            if (eachRoomType.equals(type)) {
                return new StringBuilder(type);
            }
        }
        return new StringBuilder(ExceptionMessage.noSuchRoomType());
    }

    /**
     * 获取全部房间类型
     * @return StringBuilder,返回全部房间类型
     */
    public static StringBuilder getRoomType() {
        roomType = new StringBuilder(roomType.toString().strip());

        return roomType;
    }

    /**
     * 获取全部房间类型
     * @return 数组，返回全部房间类型
     */
    public static String[] getRoomTypes() {
        roomTypes = roomType.toString().strip().split(" ");
        return roomTypes;
    }
    /**
     * 添加新类型房间
     * @param newType 新类型房间
     * @return 添加后的全部房间类型
     */
    public static StringBuilder addRoomType(String newType) {
        if (!(getRoomType(newType).toString().equals(ExceptionMessage.noSuchRoomType()))) {
            return new StringBuilder(ExceptionMessage.roomTypeExist());
        }
        if (newType.equals("")) {
            return new StringBuilder(ExceptionMessage.wrongFormat());
        }

        roomType.append(" ");
        roomType.append(newType);
        roomTypes = roomType.toString().split(" ");

        return getRoomType();
    }

    /**
     * 删除指定房间类型
     * @param rmType 指定的房间类型
     * @return 删除后的全部房间类型
     */
    public static StringBuilder rmRoomType(String rmType) {
        for (int i = 0; i < roomTypes.length; i ++) {
            if (roomTypes[i].equals(rmType)) {
                if (i == roomTypes.length -1) {
                    int containLength = roomTypes[i].length();
                    roomType.replace(roomType.length()-containLength-1, roomType.length(), "");
                    roomTypes = null;
                    for(String type : roomType.toString().split(" ")) {
                        addRoomType(type);
                    }
                    roomType = new StringBuilder(roomType.toString().strip());
                    return roomType;
                }
                StringBuilder newRoomType = new StringBuilder();

                for (int j = 0; j < i; j ++) {
                    newRoomType.append(" ");
                    newRoomType.append(roomTypes[j]);

                }
                for (int k = i + 1; k < roomTypes.length; k ++) {
                    newRoomType.append(" ");
                    newRoomType.append(roomTypes[k]);
                }

                roomType = newRoomType;
                roomTypes = roomType.toString().strip().split(" ");

                return getRoomType();
            }
        }
        return new StringBuilder(ExceptionMessage.noSuchRoomType());
    }

    /**
     * 申请房间设备报修
     * @param detail 申请详情
     */
    public static void applyRoomFacilitiesRepair(String detail) {
        if (!(detail.equals(""))) {
            roomFacilitiesRepair.append(detail);
            roomFacilitiesRepair.append("/end;");
        }
    }

    /**
     * 查看房间设备报修信息
     * @return 全部报修信息
     */
    public static String[] getRoomFacilitiesRepair() {
        return roomFacilitiesRepair.toString().split("/end;");
    }
}
