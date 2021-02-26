package com.shibeta.unit4.day03.Assignment.ReverseWords;

/**
 * @author Shibeta
 */
public class ReverseWords {
    public static void main(String[] args) {
        String text = "Java is more difficult than Python";
        System.out.println(reverse(text));
    }

    /**
     *  反转传入字符串的每个单词字母
     * @param text - 传入需要处理的字符串
     * @return  - 返回处理后的字符串
     */
    public static StringBuilder reverse(String text) {
        // 以空格分隔字符串中的单词，存入字符串数组
        String[] words = text.split(" ");

        // 创建新字符串变量
        StringBuilder newWords = new StringBuilder();

        // 遍历字符串数组，即遍历每个单词
        for (String i : words) {
            // 创建临时字符串变量，用于存储并反转遍历到的单词
            StringBuilder word = new StringBuilder();
            word.append(i);

            // 将反转结果存储入新字符串变量中，并在单词后添加空格
            newWords.append(word.reverse());
            newWords.append(" ");
        }

        return newWords;
    }
}
