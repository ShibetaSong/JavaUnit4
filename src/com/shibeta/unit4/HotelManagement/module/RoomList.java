package com.shibeta.unit4.HotelManagement.module;

import com.shibeta.unit4.HotelManagement.view.ExceptionMessage;
import com.shibeta.unit4.HotelManagement.view.InformationMessage;


public class RoomList {
    /**
     * 房间号，房间实例创建起便固定不再改变
     */
    private final StringBuilder roomIdentify;

    /**
     * 房间类型，必须是Apartment中存在的房间类型
     */
    private StringBuilder roomType;

    /**
     * 房间号，静态，其随着房间实例的增加而增加，代表着最大的房间号
     */
    private static StringBuilder roomNum = new StringBuilder("100");

    /**
     * 房间报修情况，默认为"无"
     */
    private StringBuilder roomFacilitiesRepair = new StringBuilder("无");

    /**
     * 住户姓名、性别、证件号等个人信息
     */
    private StringBuilder username;
    private StringBuilder userSex;
    private StringBuilder userIdentify;
    private StringBuilder userPhone;

    /**
     * 房间最大楼层数
     */
    final int maxFloorNum = 24;

    /**
     * 房间单楼层最大房间数
     */
    final int floorMaxRoomNum = 24;

    /**
     * 下一个房间对象，组成链表
     */
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
        if (this.nextRoom != null) {
            return this.nextRoom.getRoomType(roomIdentify);
        }
        return ExceptionMessage.noMatchRoom();
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

    /**
     * 设置指定房间的房间类型
     * @param roomType 房间类型
     * @param roomIdentify 房间号
     * @return 设置成功或失败原因
     */
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
            enableNewRoom();
        }
        return this.nextRoom.setRoomType(roomType, roomIdentify);
    }

    /**
     * 获取指定住户的房间号
     * @param userName 住户姓名
     * @return String 房间号
     */
    public String getRoomIdentify(String userName) {
        if (userName.strip().equals("")) {
            return ExceptionMessage.wrongName();
        }
        if (this.username != null) {
            if (this.username.toString().equals(userName)) {
                return this.roomIdentify.toString();
            }
        }

        if (this.nextRoom == null) {
            return ExceptionMessage.noRoom();
        }
        return this.nextRoom.getRoomIdentify(userName);


    }

    /**
     * 获取指定房间的房间报修情况
     * @param roomIdentify 房间号
     * @return String 房间报修信息
     */
    public String getRoomFacilitiesRepair(String roomIdentify) {
        String isRoomIdentifyCorrect;
        isRoomIdentifyCorrect = roomIdentifyVerify(roomIdentify);
        if (!(isRoomIdentifyCorrect.equals(InformationMessage.roomIdentifyCorrect()))) {
            return isRoomIdentifyCorrect;
        }

        if (this.roomIdentify.toString().equals(roomIdentify)) {
            return this.roomFacilitiesRepair.toString();
        }
        if (this.nextRoom != null) {
            return this.nextRoom.getRoomFacilitiesRepair(roomIdentify);
        }
        return ExceptionMessage.noMatchRoom();
    }

    /**
     * 提交房间报修申请
     * @param roomIdentify 房间号
     * @param text 报修申请
     * @return String 提交成功情况或失败原因
     */
    public String sendRoomFacilitiesRepair(String roomIdentify, String text) {
        String isRoomIdentifyCorrect;
        isRoomIdentifyCorrect = roomIdentifyVerify(roomIdentify);
        if (!(isRoomIdentifyCorrect.equals(InformationMessage.roomIdentifyCorrect()))) {
            return isRoomIdentifyCorrect;
        }

        if (this.roomIdentify.toString().equals(roomIdentify)) {
            this.roomFacilitiesRepair = new StringBuilder(text);
            return InformationMessage.roomFacilitiesRepairApplymentSendSuccessfully();
        }

        if (this.nextRoom != null) {
            return this.nextRoom.sendRoomFacilitiesRepair(roomIdentify, text);
        }
        return ExceptionMessage.noMatchRoom();
    }

    /**
     * 获取当前房间住户姓名
     * @return 当前住户
     */
    public String getUsername() {
        if (this.username == null) {
            return ExceptionMessage.emptyRoom();
        }
        return username.toString();
    }

    /**
     * 获取指定房间住户姓名
     * @param roomIdentify 房间号
     * @return 住户姓名
     */
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

    /**
     * 设置当前房间住户姓名
     * @param username 住户姓名
     * @return 用户名设置成功
     */
    public String setUsername(String username) {
        if (this.username == null) {
            this.username = new StringBuilder(username);
        } else {
            if (this.nextRoom == null) {
                enableNewRoom(false);
            }
            return this.nextRoom.setUsername(username);
        }
        return InformationMessage.usernameSetSuccessfully();
    }

    /**
     * 设置指定房间的住户姓名
     * @param username 住户姓名
     * @param roomIdentify 指定房间号
     * @return 设置成功或失败原因
     */
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
            enableNewRoom(true);
        }
        return this.nextRoom.setUsername(username, roomIdentify);
    }

    /**
     * 获取指定房间住户性别
     * @param roomIdentify 房间号
     * @return 用户性别
     */
    public String getUserSex(String roomIdentify) {
        String isRoomIdentifyCorrect;
        isRoomIdentifyCorrect = roomIdentifyVerify(roomIdentify);
        if (!(isRoomIdentifyCorrect.equals(InformationMessage.roomIdentifyCorrect()))) {
            return isRoomIdentifyCorrect;
        }

        if (this.roomIdentify.toString().equals(roomIdentify)) {
            return this.userSex.toString();
        }
        if (this.nextRoom != null) {
            return this.nextRoom.getUserSex(roomIdentify);
        }
        return ExceptionMessage.noMatchRoom();
    }

    /**
     * 设置指定房间的用户性别
     * @param roomIdentify 房间号
     * @param userSex 用户性别，只能是"女"、"女性"、"男"、"男性"和"其他" 中的一项
     * @return String 设置成功或失败原因
     */
    public String setUserSex(String roomIdentify, String userSex) {
        String isRoomIdentifyCorrect;
        isRoomIdentifyCorrect = roomIdentifyVerify(roomIdentify);
        if (!(isRoomIdentifyCorrect.equals(InformationMessage.roomIdentifyCorrect()))) {
            return isRoomIdentifyCorrect;
        }

        String isUserSexCorrect;
        isUserSexCorrect = userSexVerify(userSex);
        if (!(isUserSexCorrect.equals(InformationMessage.userSexSetSuccessfully()))) {
            return isUserSexCorrect;
        }

        if (this.roomIdentify.toString().equals(roomIdentify)) {
            this.userSex = new StringBuilder(userSex);
            return InformationMessage.userSexSetSuccessfully();
        }
        if (this.nextRoom != null) {
            return this.nextRoom.setUserSex(roomIdentify, userSex);
        }
        return ExceptionMessage.noMatchRoom();
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

    /**
     * 开启新的房间 方法重载
     */
    public void enableNewRoom() {
        enableNewRoom(true);
    }

    /**
     * 开启新的房间
     * @param allowEmpty boolean 是否允许空房间存在
     */
    public void enableNewRoom(boolean allowEmpty) {
        if (allowEmpty) {
            this.nextRoom = new RoomList();
            return;
        }
        if (this.username != null) {
            this.nextRoom = new RoomList();
        }
    }

    /**
     * 验证房间号是否合法
     * @param roomIdentify 房间号
     * @return String 合法或不合法原因
     */
    public String roomIdentifyVerify(String roomIdentify) {
        if (roomIdentify.length() < 3 || roomIdentify.length() > 5) {
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

    /**
     * 验证用户性别是否合法
     * @param userSex 用户性别
     * @return String 合法或不合法原因
     */
    public String userSexVerify(String userSex) {
        if (userSex.equals("其他")
                || userSex.equals("女")
                || userSex.equals("女性")
                || userSex.equals("男")
                || userSex.equals("男性")) {
            return InformationMessage.userSexSetSuccessfully();
        }
        return ExceptionMessage.wrongSex();
    }

}
