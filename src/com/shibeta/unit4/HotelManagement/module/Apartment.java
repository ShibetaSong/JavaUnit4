package com.shibeta.unit4.HotelManagement.module;

import com.shibeta.unit4.HotelManagement.view.ExceptionMessage;

public class Apartment {
    static StringBuilder roomType = new StringBuilder("标准双床房 高级大床房 影视大床房 高级套房 ");
    static String[] roomTypes = roomType.toString().split(" ");

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
     * @return 返回全部房间类型
     */
    public static StringBuilder getRoomType() {
        roomType = new StringBuilder(roomType.toString().strip());

        return roomType;
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


}
