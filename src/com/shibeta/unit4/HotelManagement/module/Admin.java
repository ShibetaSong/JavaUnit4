package com.shibeta.unit4.HotelManagement.module;

import com.shibeta.unit4.HotelManagement.view.InformationMessage;
import com.shibeta.unit4.HotelManagement.view.Menu;

public class Admin {
    static Data data = new Data();
    private static String newAdminPasswd = data.getAdminPasswd();
    StringBuilder adminPassword = new StringBuilder(newAdminPasswd);

    public Admin() {}

    public void setAdminPasswd(String password) {
        data.setAdminPasswd(password);
        newAdminPasswd = data.getAdminPasswd();
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

    public void getRoomInformation(RoomList room, boolean allowEmpty) {
        if (allowEmpty) {
            if (room != null) {
                getRoomInformation(room, room.getRoomIdentify());
                if (room.nextRoom != null) {
                    getRoomInformation(room.nextRoom, true);
                }
            }
            return;
        }
        if (room != null) {
            if (!(room.getUsername().equals(InformationMessage.unsettle()))) {
                getRoomInformation(room, room.getRoomIdentify());
            }
            if (room.nextRoom != null) {
                getRoomInformation(room.nextRoom, false);
            }
        }

    }

}
