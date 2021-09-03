package com.shibeta.unit4.day03.Assignment.Reduce;

/**
 * @author Shibeta
 */
public class ReduceText {
    public static void main(String[] args) {
        String text = "abbbbbbbcddddd";

        System.out.println(reduce(text));
    }

    /**
     * 压缩字符串,若压缩后的字符串没有变短，则返回原字符串
     * @param text - 传入字符串
     * @return - 压缩后字符串
     */
    public static StringBuilder reduce(String text) {
        // 将字符串分隔转化为字符串数组，并定义新字符串变量
        String[] sourceText = text.split("");
        StringBuilder newText = new StringBuilder();

        for (String s : sourceText) {
            // 遍历数组，将数组第一个元素赋给空的新字符串变量，并在其后标记数量为1，开始新一轮循环
            if (newText.length() == 0) {
                newText.append(s);
                newText.append("1");
                continue;
            }

            // 若遍历到的项不为上次遍历到的项，在新字符串中追加该项，并标记数量为1
            if (!(String.valueOf(newText.charAt(newText.length()-2)).equals(s))) {
                newText.append(s);
                newText.append("1");
            } else {
                // 若遍历到的项与上次相同，则获取数量，替换为+1后的值
                newText.replace(
                        // 最后一位，即上次遍历标记的数量所在位置
                        newText.length()-1,
                        newText.length(),
                        // 获取该数量，为转换为整型需先转为字符串，加1后再转换为字符串，替换掉原值
                        String.valueOf(
                                Integer.parseInt(String.valueOf(newText.charAt(newText.length()-1))) + 1
                        )
                );
            }
        }

        // 若压缩后的字符数量不小于原字符数量，则重写压缩后的字符串为原字符串
        if (newText.length() >= sourceText.length) {
            newText.replace(0, newText.length(), "");
            for (String i : sourceText) {
                newText.append(i);
            }
        }

        return newText;
    }
}
