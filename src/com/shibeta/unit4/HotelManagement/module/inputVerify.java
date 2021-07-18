package com.shibeta.unit4.HotelManagement.module;


import com.shibeta.unit4.HotelManagement.view.ExceptionMessage;
import com.shibeta.unit4.HotelManagement.view.InformationMessage;

public class inputVerify {
    /**
     * 选择内容替换
     * @param select 用户的选择
     * @param min 最小值
     * @param max 最大值
     * @return 若方法使用错误，返回-2; 若输入超出范围，返回-1; 若输入格式有误，返回-3
     */
    public static int userSelectExchange(int select, int min, int max) {
        if (max < min) {
            // 范围格式有误
            return -2;
        }
        if (select == -1) {
            return -3;
        }
        if (select > max || select < min) {
            // 选择超出范围
            return -1;
        }

        return select;
    }

    /**
     * 用户选择验证
     * @param select 用户选择
     * @return 验证后的结果，若成功则返回selectSuccessfully
     */
    public static String userSelectVerify(int select) {
        if (select == -1) {
            return ExceptionMessage.numberInputOutOfRange();
        }
        if (select == -2) {
            return ExceptionMessage.unknownException("mIV_userSelectVerify_36_46___41");
        }
        if (select == -3) {
            return ExceptionMessage.wrongFormat();
        }
        return InformationMessage.selectSuccessfully();
    }
}
