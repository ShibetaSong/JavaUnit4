package com.shibeta.unit4.day10.反射;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Demo {
/*
Java反射机制是在运行状态中，获取任意一个类的结构，创建对象，
得到方法，执行方法，属性
这种在运行状态动态获取信息以及动态调用对象方法的功能被称为
Java语言的反射机制


类加载器 负责动态加载Java类到Java虚拟机的内存空间中

BootstrapClassLoader 引导启动类加载器
    嵌在JVM内核中的加载器，负责加载JAVA_HOME/lib 下的类库
ExtensionClassLoader 扩展类加载器
    父类加载器是Bootstrap，主要加载JAVA_HOME/lib/ext目录中的类库
    由sun.misc.Launcher$ExtClassLoader实现
App ClassLoader 应用类加载器
    负责加载应用程序classpath目录下所有jar和class文件
    父加载器为Ext ClassLoader

类通常按需加载，第一次使用该类时才会加载。由于有了类加载器，
Java运行时系统不需要知道文件与文件系统。

多个类加载器在加载类时，如何避免重复加载？
答：
    双亲委派模型。 如果一个类加载器收到了加载请求，不会自己尝试加载，
    而是将请求转交给父类加载器。最终，所有的类加载请求都应该传递到
    最顶层的启动类加载器中。只有当父类加载器反馈无法完成这个加载请求，
    (在它的搜索范围没有找到这个类) 时，子类加载器才会尝试自己加载。

 类名.class.getClassLoader() 获取类加载器
 类加载器.getResourceAsStream(路径)
    当项目中没有source文件夹时，获取src目录下的文件输入流
    当项目中有资源属性的source文件夹时，获取source目录下的文件输入流
 */
    public static void main(String[] args) throws IOException {
        InputStream is = Demo.class.getClassLoader().getResourceAsStream("12.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String text = br.readLine();
        System.out.println(text);
        br.close();

    }
}
