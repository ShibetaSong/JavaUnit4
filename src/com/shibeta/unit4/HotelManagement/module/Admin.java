package com.shibeta.unit4.HotelManagement.module;

public class Admin {
    StringBuilder adminPassword = new StringBuilder("admin123");

    public Admin(StringBuilder password){
        adminPassword = new StringBuilder(password.toString());
    }
    public Admin() {}

    public void setAdminPasswd(StringBuilder password) {
        this.adminPassword = password;
    }

    public String getAdminPasswd() {
        return this.adminPassword.toString();
    }



}
