package com.shibeta.unit4.HotelManagement.module;

import com.shibeta.unit4.HotelManagement.view.Menu;

public class Admin {
    StringBuilder adminPassword = new StringBuilder("admin123");

    public Admin() {}

    public void setAdminPasswd(String password) {
        this.adminPassword = new StringBuilder(password);
    }

    public String getAdminPasswd() {
        return this.adminPassword.toString();
    }

    public void getRoomInformation(RoomList room, String roomIdentify) {
        Menu.getRoomInformation(roomIdentify,
                room.getRoomType(roomIdentify),
                room.getUsername(roomIdentify),
                room.getUserIdentify(roomIdentify),
                room.getUserSex(roomIdentify),
                room.getUserPhone(roomIdentify),
                room.getRoomFacilitiesRepair(roomIdentify));
    }

    public void getRoomInformation(RoomList room) {
        if (room != null) {
            getRoomInformation(room, room.getRoomIdentify());
            if (room.nextRoom != null) {
                getRoomInformation(room.nextRoom);
            }
        }
    }

}
