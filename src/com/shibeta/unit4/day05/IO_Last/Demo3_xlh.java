package com.shibeta.unit4.day05.IO_Last;

import java.io.*;
import java.util.*;

public class Demo3_xlh {
    // 序列化 与 反序列化
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*
        序列化

        若不想序列化，可加transient关键字
         */
//        Book b = new Book("金苹果", "讲述了苹果种植的过程");
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d://haha/book.txt"));
//        // 若不标记为Serializable, 会提示异常: Book类不能序列化
//        oos.writeObject(b);
//        oos.close();

        /*
        反序列化
         */
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d://haha/book.txt"));
////        Object o = ois.readObject();
//        Book o = (Book) ois.readObject();
//        System.out.println(o.getInfo());
//
        List<String> tl = new ArrayList<>();
        tl.add("t1");
        tl.add("t2");

        Student s1 = new Student(tl, "S1");
        ObjectOutputStream objOt = new ObjectOutputStream(new FileOutputStream("d://haha/student.txt"));
        ObjectInputStream objIt = new ObjectInputStream(new FileInputStream("d://haha/student.txt"));
        s1.writeExternal(objOt);
        s1.readExternal(objIt);
        System.out.println(s1);
    /*
        实现部分序列化：
        1、transient 关键字
        2、static 关键字
        3、私有方法
            private void writeObject(java.io.ObjectOutputStream out)
            private void readObject(java.io.ObjectInputStream in)
        4、实现Externalizable 接口
         */
    }
    static class Student implements Externalizable {
        private List<String> teachList;
        private String stuNum;

        public Student(List<String> teachList, String stuNum) {
            this.teachList = teachList;
            this.stuNum = stuNum;
        }

        public Student() {
        }

        public List<String> getTeachList() {
            return teachList;
        }

        public void setTeachList(List<String> teachList) {
            this.teachList = teachList;
        }

        public String getStuNum() {
            return stuNum;
        }

        public void setStuNum(String stuNum) {
            this.stuNum = stuNum;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            System.out.print("----------序列化操作\t");
            out.writeObject(stuNum);
//            out.writeObject(teachList);
            System.out.println("...OK");

        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            System.out.print("------------反序列化操作\t");
            stuNum = (String) in.readObject();
            System.out.println("...OK");
//            teachList = (List) in.readObject();
//            Object newTl = in.readObject();
//            if (newTl instanceof List) {
//                List ntl = (List) newTl;
//                if (ntl.get(0) instanceof String) {
//                    List<String> tl = (List<String>) newTl;
//                }
//            }
        }
    }
    // Serializable 属于标记接口
    static class Book implements Serializable {
        // transient: 不参与序列化
        private transient String name;

        // static: static修饰的属性也不会被序列化
        private static String s_info;

        private String info;

        public Book(String name, String info) {
            this.name = name;
            this.info = info;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getInfo() {
            return info;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "name='" + name + '\'' +
                    ", info='" + info + '\'' +
                    '}';
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }
}
