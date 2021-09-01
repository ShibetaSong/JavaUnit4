package com.shibeta.unit4.day09.xml;

import com.shibeta.unit4.day05.字节流.FileInput;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class test2 {
    public static void main(String[] args) throws IOException, DocumentException {
        // 1. 获取到XML输入流
        String phone = "13203549900";
        URL url = new URL("http://apis.juhe.cn/mobile/get?phone="+phone+"&dtype=xml&key=9f3923e8f87f1ea50ed4ec8c39cc9253");
        URLConnection conn = url.openConnection();
        InputStream is = conn.getInputStream();
        // 2. 创建一个XML读取对象
        SAXReader sr = new SAXReader();
        // 3. 读取XML数据并返回文档对象
        Document doc = sr.read(is);
        // 4. 获取根节点
        Element root = doc.getRootElement();
        // 5. 解析内容
        String resultcode = root.elementText("resultcode");
        if ("200".equals(resultcode)) {
            Element result = root.element("result");
            String prov = result.elementText("province");
            String city = result.elementText("city");
            String comp = result.elementText("company");
            String zip = result.elementText("zip");

            if (prov.equals(city)) {
                System.out.println("手机号码归属地为: " + city);
            } else {
                System.out.println("手机号码归属地为: " + prov + " " + city);
            }
            System.out.println("邮政编码: " + zip);
            System.out.println("运营商: " + comp);

        }
    }

}
