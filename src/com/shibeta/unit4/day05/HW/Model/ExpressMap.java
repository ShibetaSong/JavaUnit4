package com.shibeta.unit4.day05.HW.Model;

import java.io.Serializable;
import java.util.*;

public class ExpressMap implements Serializable {
    final Random random = new Random();
    /**
     * 设置最大行数、列数，
     * 初始化最大存储数量为行数 * 列数
     */
    private static final int MAX_LINE = 20;
    private static final int MAX_ROW = 20;
    private static final int MAX_SIZE = MAX_LINE * MAX_ROW;
    private int size = 0;

    /**
     * 设置取件码、位置码、单号集合，用于查重
     */
    private final HashSet<Integer> pickupCodeSet = new HashSet<>();
    private final HashSet<ArrayList<Integer>> locationSet = new HashSet<>();
    private final HashSet<String> ENumSet = new HashSet<>();

    /**
     * 快递存储容器
     */
    private final TreeMap<Integer, Express> expressMap = new TreeMap<>();

    public ExpressMap() {
    }

    /**
     * 生成取件码
     * @param e 快递
     * @return 若设置成功，返回取件码，否则为快递已满，返回-1
     */
    public int setPickupCode(Express e) {
        int pickupCode = random.nextInt(9000) + 1000;
        while(size < MAX_SIZE) {
            if (pickupCodeSet.add(pickupCode)) {
                e.setPickupCode(pickupCode);
                return pickupCode;
            }
        }
        return -1;
    }

    /**
     * 重新设置取件码
     * @param e 快递
     * @return 若设置成功，返回取件码，否则为快递已满，返回-1
     */
    public int resetPickupCode(Express e) {
        if (e.getPickupCode() != 0) {
            pickupCodeSet.remove(e.getPickupCode());
        }
        return setPickupCode(e);

    }

    /**
     * 设置快递单号
     */
    public Boolean setENum(Express e, String eNum) {
        if (this.ENumSet.add(eNum)) {
            e.setENum(eNum);
            return true;
        }
        return false;
    }

    /**
     * 重设快递单号
     * @param e 快递实例
     * @param eNum 快递单号
     * @param newENum 新快递单号
     * @return boolean
     */
    public Boolean resetENum(Express e, String eNum, String newENum) {
        if (eNum.equals(newENum)) {
            return true;
        }
        if (this.setENum(e, newENum)) {
            this.ENumSet.remove(eNum);
            return true;
        }
        return false;
    }

    /**
     * 设置快递公司
     * @param e 快递
     * @param eCompany String 快递公司
     */
    public void setECompany(Express e, String eCompany) {
        e.setECompany(eCompany);
    }

    /**
     * 添加
     * @param pickCode 取件码
     * @param e 快递
     */
    public Boolean add(int pickCode, Express e) {
        if (expressMap.containsKey(pickCode) || pickCode == -1) {
            return false;
        }
        if (this.size < MAX_SIZE) {
            expressMap.put(pickCode, e);
            size += 1;
            return true;
        }
        return false;
    }

    /**
     *
     * @param ENum 修改的快递单号
     * @param newECompany 新快递公司
     * @param newENum 新快递单号
     * @return 0: 修改成功; 1: 新快递单号冲突; 2: 快递不存在
     */
    public int reset(String ENum, String newENum, String newECompany) {
        for (Express e : this.expressMap.values()) {
            if (!e.getENum().equals(ENum)) {
                continue;
            }
            if (!this.resetENum(e, ENum, newENum)) {
                return 1;
            }
            e.setECompany(newECompany);
            return 0;
        }
        return 2;
    }

    /**
     * 删除快递
     * @param ENum 快递单号
     * @return boolean
     */
    public Boolean remove(String ENum) {
        for (Express e: this.expressMap.values()) {
            if (e.getENum().equals(ENum)) {
                this.expressMap.remove(e.getPickupCode());
                return true;
            }
        }
        return false;
    }

    /**
     * 由取件码获取
     * @param pickupCode 取件码
     * @return 若获取到，返回Express快递对象，否则返回null
     */
    public Express getByCode(int pickupCode) {
        if (this.expressMap.containsKey(pickupCode)) {
            Express e = expressMap.get(pickupCode);
            expressMap.remove(pickupCode);
            return e;
        }
        return null;
    }

    /**
     * 设置快递位置
     * @param e 快递
     * @return 位置信息或null
     */
    public ArrayList<Integer> setLocation(Express e) {
        // 设置行、列位置
        int row = random.nextInt(MAX_ROW) + 1;
        int line = random.nextInt(MAX_LINE) + 1;
        ArrayList<Integer> locationList = new ArrayList<>();
        locationList.add(row);
        locationList.add(line);

        // 若位置已存在，递归调用本方法再次生成一个位置
        if (this.locationSet.contains(locationList)) {
            if (this.size < MAX_SIZE) {
                return this.setLocation(e);
            }
            return null;
        }
        this.locationSet.add(locationList);

        // 设置快递位置
        e.setLine(line);
        e.setRow(row);
        return locationList;
    }

    /**
     * 显示所有快递
     */
    public void showExpress() {
        // 将快递存储入列表，排序后输出
        List<Express> list = new ArrayList<>(this.expressMap.values());
        Collections.sort(list);
        for (Express e : list) {
            System.out.println(e);
        }
    }
}
