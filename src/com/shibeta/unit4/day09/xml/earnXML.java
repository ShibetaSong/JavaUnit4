package com.shibeta.unit4.day09.xml;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.IOException;

public class earnXML {
    public static void main(String[] args) throws IOException {
        // 通过文档帮助器创建空的文档对象
        Document doc = DocumentHelper.createDocument();
        // 添加根节点

        Element root = doc.addElement("books");
        // 丰富节点
        for (int i = 0; i < 100; i++) {
            Element book = root.addElement("book");
            Element name = book.addElement("name");
            name.setText(i+"种苹果的小姑娘");
            Element info = book.addElement("info");
            info.setText(i+"辛勤种植苹果的故事");
            // 设置属性
            book.addAttribute("id", 100+i+"");
        }
        // 创建文件输出流
        FileOutputStream fos = new FileOutputStream("src/com/shibeta/unit4/day09/xml/writeXML.xml");
        // 将输出流转换为XML输出流
        XMLWriter xw = new XMLWriter(fos);
        // 写出文档
        xw.write(doc);
        // 释放资源
        xw.close();
        fos.close();
        System.out.println("执行完毕");

    }

}
