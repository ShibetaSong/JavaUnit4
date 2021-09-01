package com.shibeta.test;

public class Demo {
    /*
    先导入jar文件，存放在项目中，然后在项目结构中新建项目库，
    将jar文件作为类添加。然后在模块中检查是否添加成功。
    最后在项目中新建一个测试文件夹，将目录标记为测试根
     */
    // ctrl+shift+t 创建测试类，版本4
    public void haha() {
        System.out.println("haha");
    }

    public void heihei() {
        System.out.println("heihei");
    }

    public int sum(int x, int y) {
        return x * y;
    }

}
