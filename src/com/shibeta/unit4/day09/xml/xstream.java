package com.shibeta.unit4.day09.xml;

import com.thoughtworks.xstream.XStream;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.util.Objects;

public class xstream {
    /*
    XStream 可以将对象生成为XML文档
     */
    public static void main(String[] args) throws IOException {
        Person p = new Person();
        p.setName("张三");
        p.setAge(18);

        // XStream 使用
        // 创建XStream对象
        XStream x = new XStream();
        // 修改某个类型生成的节点（默认包名.类名）
        // 相当于给第二个参数起了别名
        // .class 生成一个类的class对象。
        // 从某种意义上来说，java有两种对象：实例对象和Class对象。
        // 每个类的运行时的类型信息就是用Class对象表示的。
        x.alias("person", Person.class);
        // 传入对象，开始生成
        String XML = x.toXML(p);
//        FileOutputStream fos = new FileOutputStream("src/com/shibeta/unit4/day09/xml/writeXML2.xml");
        FileWriter fw = new FileWriter("src/com/shibeta/unit4/day09/xml/writeXML2.xml");
        fw.write(XML);
        fw.close();
//        fos.close();
        System.out.println("执行完毕");
//        System.out.println(XML);
//        System.out.println(Person.class);

    }
   public static class Person {
        private String name;
        private int age;

        public Person() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(name, person.name) && Objects.equals(age, person.age);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
