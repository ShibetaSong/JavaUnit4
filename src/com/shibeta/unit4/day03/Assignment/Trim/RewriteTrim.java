package com.shibeta.unit4.day03.Assignment.Trim;

/**
 * @author Shibeta
 */
public class RewriteTrim {
    public static void main(String[] args) {
        String text = "  aaaasdf ef aa eee  asdfasdasdf    ";

        // 输出处理结果
        System.out.println(myTrim(text).toString());
    }

    /**
     *  去除字符串首尾处的空格
     * @param text - 传入要处理的字符串
     * @return - 返回处理后的字符串
     */
    public static StringBuilder myTrim(String text) {
        // 初始化前后索引值
        int feetIndex = -1;
        int headIndex = -1;

        // 将字符串分隔并存储在字符串数组中，并创建用于执行操作的新字符串变量
        String[] sourceText = text.split("");
        StringBuilder newText = new StringBuilder();

        // 遍历字符串数组，将新字符串变量赋值为原字符串
        for (int i = 0; i < sourceText.length; i++) {
            newText.append(sourceText[i]);

            // 前索引值设为从前到后第一个非空格字符的位置
            if (!(" ".equals(sourceText[i])) && headIndex == -1) {
                headIndex = i;
            }

            // 后索引值设为从后往前第一个非空格字符的位置
            if (!(" ".equals(sourceText[sourceText.length - i - 1])) && feetIndex == -1) {
                feetIndex = i;
            }
        }

        // 若前\后有空格，则执行去除操作
        if (headIndex != -1) {
            newText = newText.replace(0, headIndex, "");
        }
        if (feetIndex != -1) {
            newText = newText.replace(newText.length()-feetIndex, newText.length(), "");
        }

        // 返回经过去除操作的新字符串
        return newText;

    }
}
