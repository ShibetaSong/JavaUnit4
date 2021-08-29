package com.shibeta.unit4.day07.Assignment.learn.HW.Model;

import java.io.Serializable;

public class Express implements Comparable<Express>, Serializable {
    private String eNum;
    private String eCompany;
    private int pickupCode;
    private int row;
    private int line;

    public Express(String eNum, int pickupCode, String eCompany, int row, int line) {
        this.row = row;
        this.line = line;
        this.eNum = eNum;
        this.pickupCode = pickupCode;
        this.eCompany = eCompany;
    }
    public Express() {

    }

    /**
     * 设置单号
     * @param eNum int 单号
     */
    public void setENum(String eNum) {
        this.eNum = eNum;
    }

    /**
     * 设置公司
     * @param eCompany String 公司名
     */
    public void setECompany(String eCompany) {
        this.eCompany = eCompany;
    }

    /**
     * 设置取件码
     * @param pickupCode int 取件码
     */
    public void setPickupCode(int pickupCode) {
        this.pickupCode = pickupCode;
    }

    /**
     * 设置行位置
     * @param row 行
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * 设置列位置
     * @param line 列
     */
    public void setLine(int line) {
        this.line = line;
    }

    /**
     * 获取位置
     * @return int[] {行, 列}
     */
    public int[] getLocation() {
        return new int[]{this.row, this.line};
    }

    public String getENum() {
        return eNum;
    }

    public String getECompany() {
        return eCompany;
    }

    public int getPickupCode() {
        return pickupCode;
    }

    @Override
    public String toString() {
        return "快递单号: " + eNum +
                ", \t快递公司: " + eCompany +
                ", \t取件码: " + pickupCode +
                ", \t位置: 第" + row +
                "排，第" + line +
                "列";
    }

    @Override
    public int compareTo(Express e) {
        if (this.row != e.getLocation()[0]) {
            return this.row > e.getLocation()[0]? 1:-1;
        }
        return this.line > e.getLocation()[1]? 1:-1;
    }



}

