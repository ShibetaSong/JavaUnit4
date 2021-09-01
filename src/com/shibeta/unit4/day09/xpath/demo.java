package com.shibeta.unit4.day09.xpath;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class demo {
    /*
    通过路径快速查找一个或一组元素

    * / 从根节点开始查找
    * // 从发起查找的节点位置开始查找
    * . 查找当前节点
    * .. 查找父节点
    * @ 选择属性
           [@属性名 = ""]
           [@属性名 > ""]
           [@属性名 < ""]
           [@属性名 != ""]
    * */
    public static void main(String[] args) throws FileNotFoundException, DocumentException {

        FileInputStream fis = new FileInputStream("src/com/shibeta/unit4/day09/xml/demo1.xml");
        SAXReader sr = new SAXReader();
        Document doc = sr.read(fis);
        // 通过文档对象 + xpath查找name节点
//        List<Node> names = doc.selectNodes("//book[@id='1001']//name");
//        for (int i=0; i<names.size(); i++) {
//            System.out.println(names.get(i).getText());
//        }
        Node n = doc.selectSingleNode("//book[@id='1001']//name");
        System.out.println(n.getText());


    }


}
