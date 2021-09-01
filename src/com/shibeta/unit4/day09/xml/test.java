package com.shibeta.unit4.day09.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class test {
/*
引入jar文件
*/
public static void main(String[] args) throws FileNotFoundException, DocumentException {
    // 创建指定XML文件的输入流
    FileInputStream fis = new FileInputStream("src/com/shibeta/unit4/day09/xml/demo1.xml");
    // 创建XML读取工具对象
    SAXReader sr = new SAXReader();
    // 使用读取工具对象，读取输入流，得到文档对象
    Document doc = sr.read(fis);
    // 通过文档对象获取XML文档中的根元素对象
    Element root = doc.getRootElement();
    // 解析元素
    System.out.println(root.getName());

    //
    /*Element book = root.element("book");
    Element name = book.element("name");
    System.out.println(name.getText());*/
    List<Element> es = root.elements();
    for (int i = 0; i < 2; i++) {
        Element e = es.get(i);
        System.out.println(e.attributeValue("id"));
        System.out.println(e.elementText("name"));
        System.out.println(e.elementText("info"));
        System.out.println("=============================");
    }


}
}
