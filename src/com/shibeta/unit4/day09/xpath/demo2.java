package com.shibeta.unit4.day09.xpath;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class demo2 {
    public static void main(String[] args) throws IOException, DocumentException {
        String phone = "13203549900";
        URL url = new URL("http://apis.juhe.cn/mobile/get?phone="+phone+"&dtype=xml&key=9f3923e8f87f1ea50ed4ec8c39cc9253");
        URLConnection conn = url.openConnection();
        InputStream fis = conn.getInputStream();
        SAXReader sr = new SAXReader();
        Document doc = sr.read(fis);
        Node n = doc.selectSingleNode("//city");
        System.out.println(n.getText());

    }
}
