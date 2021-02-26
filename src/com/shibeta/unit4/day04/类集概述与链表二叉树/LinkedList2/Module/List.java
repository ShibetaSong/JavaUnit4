package com.shibeta.unit4.day04.类集概述与链表二叉树.LinkedList2.Module;
import  com.shibeta.unit4.day04.类集概述与链表二叉树.LinkedList2.View.*;

import java.math.BigDecimal;

/**
 * @author Shibeta
 */
public class List {
    private Object data;
    private List n;
    protected int thisLocation;
    protected static int location = 0;
    protected static StringBuilder details = new StringBuilder();

    /**
     * 初始化当前位置
     */
    public List() {
        thisLocation = location;
        if (location == 0) {
            ShowMessage.linkedListCreated();
        }
        location ++;
    }

    /**
     * 添加新的数据至链表
     * @param data 新添加的数据
     * @param <T>  泛型，提供多种类型数据的添加
     */
    public <T> void add(T data) {
        if (this.data == null) {
            this.data = data;
            details.append(this.data);
            ShowMessage.dataAppendSuccessfully();
        } else {
            if (n == null) {
                n = new List();
            }
            n.add(data);
        }
    }

    /**
     * getByLocation的重载
     * @return 返回链表的第一个元素
     */
    public String getByLocation() {
        return getByLocation(0);
    }

    /**
     * 按下标搜索数据，需先获取位置信息
     * @param location 位置下标
     * @return String, 搜索到的数据
     */
    public String getByLocation(int location) {
        if (thisLocation < location) {
            if (this.n != null) {
                return n.getByLocation(location);
            } else {
                return Message.wrongLocation();
            }
        }
        if (this.data != null) {
            return this.data.toString();
        } else {
            return Message.noSuchData();
        }
    }

    /**
     * 按数据搜索下标，需先获取链表位置信息
     * @param data Object，要查找下标的数据
     * @return 数据对应的下标
     */
    public int getByData(Object data) {
        if (data instanceof String) {
            if (this.data instanceof String) {
                if (this.data.equals(data)) {
                    return thisLocation;
                }
            }

            if (this.n != null) {
                return this.n.getByData(data);
            } else {
                return -1;
            }
        }

        if (data instanceof Integer) {
            BigDecimal intData = new BigDecimal(data.toString());
            if (this.data instanceof Integer) {
                BigDecimal thisData = new BigDecimal(this.data.toString());
                if (thisData.intValue() == intData.intValue()) {
                    return thisLocation;
                }
            }
            if (this.n != null) {
                return this.getByData(data);
            } else {
                return -1;
            }
        }

        if (data instanceof Float) {
            BigDecimal floatData = new BigDecimal(data.toString());
            if (this.data instanceof Float) {
                BigDecimal sourceData = new BigDecimal(this.data.toString());
                if (floatData.floatValue() == sourceData.floatValue()) {
                    return thisLocation;
                }
            }
            if (this.n != null) {
                return this.n.getByData(data);
            } else {
                return -1;
            }
        }

        ShowMessage.unknownError("MLS_GetByData_077_120");
        return -2;
    }

    /**
     * 返回当前链表的长度
     * @return int，当前链表的长度
     */
    public int getNum() {
        if (this.n == null) {
            return 1;
        } else {
            return n.getNum() + 1;
        }
    }

    /**
     * 删除指定位置的数据
     * @param location 指定的删除位置
     */
    public String deleteByLocation(int location) {
        if (thisLocation != location) {
            if (this.n != null) {
                return this.n.deleteByLocation(location);
            } else {
                return Message.wrongLocation();
            }
        } else {
            if (this.n != null) {
                this.data = this.n.data;
                this.n = this.n.n;
            } else {
                this.data = null;
            }
            return Message.dataRemoveSuccessfully();
        }
    }

    /**
     * 删除指定内容的数据
     * @param data 指定删除的数据项
     * @return 删除结果
     */
    public String deleteByData(Object data) {
        if (data instanceof String) {
            if (this.data instanceof String) {
                if (this.data.equals(data)) {
                    return this.deleteByLocation(thisLocation);
                }
            }
            if (this.n != null) {
                return this.n.deleteByData(data);
            } else {
                return Message.noSuchData();
            }
        }

        if (data instanceof Integer) {
            BigDecimal intData = new BigDecimal(data.toString());
            if (this.data instanceof Integer) {
                BigDecimal sourceData = new BigDecimal(this.data.toString());
                if (intData.intValue() == sourceData.intValue()) {
                    return this.deleteAndReloadByLocation(thisLocation);
                }
            }
            if (this.n != null) {
                return this.n.deleteByData(data);
            } else {
                return Message.noSuchData();
            }
        }

        if (data instanceof Float) {
            BigDecimal floatData = new BigDecimal(data.toString());
            if (this.data instanceof Float) {
                BigDecimal sourceData = new BigDecimal(this.data.toString());
                if (floatData.floatValue() == sourceData.floatValue()) {
                    return this.deleteAndReloadByLocation(thisLocation);
                }
            }
            if (this.n != null) {
                return this.n.deleteByData(data);
            } else {
                return Message.noSuchData();
            }
        }

        if (data instanceof Boolean) {
            return Message.wrongDataType();
        }

        return Message.unknownError();
    }

    /**
     * 删除指定位置的数据，并更新链表各数据所在位置
     * @param location 指定位置
     */
    public String deleteAndReloadByLocation(int location) {
        String notice = deleteByLocation(location);
        cleanLocation();
        loadLocation();
        return notice;
    }

    /**
     * 删除指定内容的数据，并更新链表各数据所在位置
     * @param data 指定数据
     */
    public String deleteAndReloadByData(Object data) {
        String notice = deleteByData(data);
        cleanLocation();
        loadLocation();
        return notice;
    }

    /**
     * 重新载入位置信息，需先清除位置信息后，在链表开头使用
     */
    public void loadLocation() {
        thisLocation = location;
        location += 1;
        if (this.n != null) {
            n.loadLocation();
        }
    }

    /**
     * 清除位置信息
     */
    public void cleanLocation() {
        location = 0;
    }

    /**
     * 删除遍历记录，遍历链表
     * @return StringBuilder，链表数据
     */
    public StringBuilder getDetails() {
        cleanDetails();
        return getDetailsWithoutClean();
    }

    /**
     * 不删除历史记录，遍历链表
     * @return StringBuilder，链表数据
     */
    private StringBuilder getDetailsWithoutClean() {
        if (this.data != null) {
            details.append(thisLocation+1);
            details.append("、");
            details.append(this.data);
            details.append("\t类型：");
        } else {
            details.append(thisLocation + 1);
            details.append("、");
            details.append(Message.noSuchData());
        }

        if (this.data instanceof String) {
            details.append("字符串\n");
        } else if (this.data instanceof Integer) {
            details.append("整型\n");
        } else if (this.data instanceof Float) {
            details.append("浮点型\n");
        }

        if (this.n != null) {
            return n.getDetailsWithoutClean();
        }
        return details;
    }

    /**
     * 清除遍历历史
     */
    private void cleanDetails() {
        details = new StringBuilder();
    }

    /**
     * 根据对应数据类型处理数据
     */
    public static Object processData(String sourceInput, int dataType) {
        return processData(sourceInput, dataType, false);
    }

    public static Object processData(String sourceInput, int dataType, boolean multiple) {
        if (!multiple) {
            if (dataType == 1) {
                try {
                    return Integer.parseInt(sourceInput);
                } catch (Exception e) {
                    return Message.wrongDataType();
                }
            } else if (dataType == 2) {
                return sourceInput;
            } else if (dataType == 3) {
                try {
                    return Float.parseFloat(sourceInput);
                } catch (Exception e) {
                    return Message.wrongDataType();
                }
            } else {
                return false;
            }
        }

        // 处理字符串sourceInput
        String[] sourceArray = sourceInput.split(" ");

        if (dataType == 1) {
            if (sourceArray.length == 1) {
                try {
                    return Integer.parseInt(sourceArray[0]);
                } catch (Exception e) {
                    return Message.wrongDataType();
                }
            }
            int[] resultArray = new int[sourceArray.length];
            for (int i = 0; i < sourceArray.length; i++) {
                try {
                    resultArray[i] = Integer.parseInt(sourceArray[i]);
                } catch (Exception e) {
                    return Message.wrongDataType();
                }
            }
            return resultArray;

        } else if (dataType == 2) {
            if (sourceArray.length == 1) {
                return sourceArray[0];
            }
            return sourceArray;

        } else if (dataType == 3) {
            if (sourceArray.length == 1) {
                try {
                    return Float.parseFloat(sourceArray[0]);
                } catch (Exception e) {
                    return Message.wrongDataType();
                }
            }

            float[] resultArray = new float[sourceArray.length];
            for (int i = 0; i < sourceArray.length; i++) {
                try {
                    resultArray[i] = Float.parseFloat(sourceArray[i]);
                } catch (Exception e) {
                    return Message.wrongDataType();
                }
            }
            return resultArray;

        } else {
            return false;
        }

    }

    public void saveInLinkedList(Object dataList) {
        if (dataList instanceof String[]) {
            for (String i : (String[]) dataList) {
                if (!(i.strip().equals(""))){
                    add(i);
                }

            }
        }

        if (dataList instanceof int[]) {
            for (int i : (int[]) dataList) {
                add(i);
            }
        }

        if (dataList instanceof float[]) {
            for (float i : (float[]) dataList) {
                add(i);
            }
        }
    }
}
