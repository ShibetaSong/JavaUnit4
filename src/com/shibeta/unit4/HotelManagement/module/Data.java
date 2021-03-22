package com.shibeta.unit4.HotelManagement.module;

public class Data {
    private static final String defaultAdminPasswd = "admin123";
    private static StringBuilder adminPasswd = new StringBuilder(defaultAdminPasswd);

    public void setAdminPasswd(String passwd) {
        adminPasswd = new StringBuilder(passwd);
    }

    public String getAdminPasswd() {
        return adminPasswd.toString();
    }
}
