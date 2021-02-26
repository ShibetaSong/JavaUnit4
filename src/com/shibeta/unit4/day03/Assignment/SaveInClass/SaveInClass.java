package com.shibeta.unit4.day03.Assignment.SaveInClass;

/**
 * @author Shibeta
 */
public class SaveInClass {
    public static void main(String[] args) {

        String s = "name=王五 age=18 classNum=1101";
        Student student = splitInfo(s);

        // 输出student对象的属性值
        System.out.println(student.getAge());
        System.out.println(student.getName());
        System.out.println(student.getClassNum());
    }

    /**
     *  处理包含属性的字符串，并赋值给student对象
     * @param text - 传入的包含属性的字符串
     * @return - 返回student对象
     */
    public static Student splitInfo(String text) {
        Student student = new Student();

        // 分隔各部分属性，存入字符串数组
        String[] textList = text.split(" ");

        for (String i : textList) {
            // 遍历数组，分别以等号分隔属性名和值
            String[] item = i.split("=");

            // 再通过判断，将对应属性值赋给student对象
            if ("name".equals(item[0])) {
                student.setName(item[1]);
            } else if ("age".equals(item[0])) {
                student.setAge(Integer.parseInt(item[1]));
            } else if ("classNum".equals(item[0])) {
                student.setClassNum(item[1]);
            }
        }
        return student;
    }
}
