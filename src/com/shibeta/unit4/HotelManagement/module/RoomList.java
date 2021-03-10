package com.shibeta.unit4.HotelManagement.module;

import com.shibeta.unit4.HotelManagement.view.ExceptionMessage;
import com.shibeta.unit4.HotelManagement.view.InformationMessage;


public class RoomList {
    private final StringBuilder roomIdentify;
    private StringBuilder roomType;
    private static StringBuilder roomNum = new StringBuilder("100");
    private StringBuilder roomFacilitiesRepair;
    private boolean roomClear;

    private StringBuilder username = null;
    private StringBuilder userSex = null;
    private StringBuilder userIdentify = null;
    private StringBuilder userPhone = null;
    final int maxFloorNum = 24;
    final int floorMaxRoomNum = 24;

    private RoomList nextRoom;

    /**
     * 房间创建时，自动生成房间号
     */
    public RoomList() {
        StringBuilder temRoomNum = new StringBuilder(roomNum.toString());
        int eachFloorRoomNum = Integer.parseInt(temRoomNum.replace(0,temRoomNum.length()-2, "").toString());
        int floorNum = Integer.parseInt(roomNum.replace(roomNum.length()-2, roomNum.length(),"").toString());


        if (eachFloorRoomNum >= floorMaxRoomNum) {
            eachFloorRoomNum = 1;
            floorNum ++;
        } else {
            eachFloorRoomNum ++;
        }

        if (eachFloorRoomNum < 10) {
            roomNum = new StringBuilder(floorNum + "0" + eachFloorRoomNum);
            roomIdentify = new StringBuilder(roomNum.toString());
            return;
        }
        roomNum = new StringBuilder(Integer.toString(floorNum) + eachFloorRoomNum);
        roomIdentify = new StringBuilder(roomNum.toString());

    }

    public StringBuilder getRoomType() {
        return roomType;
    }

    /**
     * 获取指定房间的房间类型
     * @param roomIdentify 房间号
     * @return String 房间类型
     */
    public String getRoomType(String roomIdentify) {
        if (this.roomIdentify.toString().equals(roomIdentify)) {
            if (roomType == null) {
                return ExceptionMessage.roomTypeDidNotSet();
            }
            return roomType.toString();
        }
        return this.nextRoom.getRoomType(roomIdentify);
    }

    /**
     * 设置房间类型
     * @param roomType String 房间类型
     * @return String 设置是否成功
     */
    public String setRoomType(String roomType) {
        for (String type : Apartment.getRoomTypes()) {
            if (roomType.equals(type)) {
                this.roomType = new StringBuilder(roomType);
                return InformationMessage.roomTypeSetSuccessfully();
            }
        }
        return ExceptionMessage.noSuchRoomType();
    }

    public String setRoomType(String roomType, String roomIdentify) {
        String isRoomIdentifyCorrect;
        isRoomIdentifyCorrect = roomIdentifyVerify(roomIdentify);
        if (!(isRoomIdentifyCorrect.equals(InformationMessage.roomIdentifyCorrect()))) {
            return isRoomIdentifyCorrect;
        }
        if (this.roomIdentify.toString().equals(roomIdentify)) {
            for (String type : Apartment.getRoomTypes()) {
                if (roomType.equals(type)) {
                    this.roomType = new StringBuilder(roomType);
                    return InformationMessage.roomTypeSetSuccessfully();
                }
            }
            return ExceptionMessage.noSuchRoomType();

        }
        if (this.nextRoom == null) {
            this.nextRoom = new RoomList();
        }
        return this.nextRoom.setRoomType(roomType, roomIdentify);
    }

    public StringBuilder getRoomFacilitiesRepair() {
        return roomFacilitiesRepair;
    }

    public void setRoomFacilitiesRepair(StringBuilder roomFacilitiesRepair) {
        this.roomFacilitiesRepair = roomFacilitiesRepair;
    }

    public boolean isRoomClear() {
        return roomClear;
    }

    public void setRoomClear(boolean roomClear) {
        this.roomClear = roomClear;
    }

    public String getUsername() {
        if (this.username == null) {
            return ExceptionMessage.emptyRoom();
        }
        return username.toString();
    }

    public String getUsername(String roomIdentify) {
        String isRoomIdentifyCorrect;
        isRoomIdentifyCorrect = roomIdentifyVerify(roomIdentify);
        if (!(isRoomIdentifyCorrect.equals(InformationMessage.roomIdentifyCorrect()))) {
            return isRoomIdentifyCorrect;
        }

        if (this.roomIdentify.toString().equals(roomIdentify)) {
            return getUsername();
        }
        if (this.nextRoom == null) {
            return ExceptionMessage.noMatchRoom();
        }
        return this.nextRoom.getUsername(roomIdentify);
    }

    public String setUsername(String username) {
        this.username = new StringBuilder(username);
        return InformationMessage.usernameSetSuccessfully();
    }

    public String setUsername(String username, String roomIdentify) {
        String isRoomIdentifyCorrect;
        isRoomIdentifyCorrect = roomIdentifyVerify(roomIdentify);
        if (!(isRoomIdentifyCorrect.equals(InformationMessage.roomIdentifyCorrect()))) {
            return isRoomIdentifyCorrect;
        }

        if (this.roomIdentify.toString().equals(roomIdentify)) {
            this.setUsername(username);
            return InformationMessage.usernameSetSuccessfully();
        }
        if (this.nextRoom == null) {
            this.nextRoom = new RoomList();
        }
        return this.nextRoom.setUsername(username, roomIdentify);
    }

    public String getUserSex() {
        return userSex.toString();
    }

    public void setUserSex(StringBuilder userSex) {
        this.userSex = userSex;
    }

    public String getUserIdentify() {
        return userIdentify.toString();
    }

    public void setUserIdentify(StringBuilder userIdentify) {
        this.userIdentify = userIdentify;
    }

    public String getUserPhone() {
        return userPhone.toString();
    }

    public void setUserPhone(StringBuilder userPhone) {
        this.userPhone = userPhone;
    }

    public void enableNewRoom() {
        enableNewRoom(false);
    }

    public void enableNewRoom(boolean allowEmpty) {
        if (allowEmpty) {
            this.nextRoom = new RoomList();
            return;
        }
        if (this.username != null) {
            this.nextRoom = new RoomList();
        }
    }

    public void enableNewRoom(int roomIdentify) {

    }

    public void enableNewRoom(String username, String roomIdentify) {

    }

    public String roomIdentifyVerify(String roomIdentify) {
        if (roomIdentify.length() < 3 || roomIdentify.length() > 4) {
            return ExceptionMessage.noMatchRoom();
        }

        StringBuilder floorNum;
        StringBuilder eachFloorRoomNum = new StringBuilder(roomIdentify);

        floorNum = new StringBuilder(eachFloorRoomNum.replace(roomIdentify.length() - 2, roomIdentify.length(), ""));
        eachFloorRoomNum = new StringBuilder(roomIdentify).replace(0, roomIdentify.length() - 2, "");

        try {
            int temFloorNum = Integer.parseInt(floorNum.toString());
            int temFloorRoomNum = Integer.parseInt(eachFloorRoomNum.toString());
            if (temFloorRoomNum > this.floorMaxRoomNum || temFloorNum > this.maxFloorNum) {
                return ExceptionMessage.noMatchRoom();
            }
            return InformationMessage.roomIdentifyCorrect();
        } catch (NumberFormatException n) {
            return ExceptionMessage.wrongFormat();
        }
    }


}
