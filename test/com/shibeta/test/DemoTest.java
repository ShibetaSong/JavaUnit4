package com.shibeta.test;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DemoTest {

    @Test
    public void haha() {
        new Demo().haha();
    }

    @Test
    public void heihei() {
        new Demo().heihei();
        throw new RuntimeException("Exception");
    }

    @Test
    public void haHei() {
        new Demo().haha();
        new Demo().heihei();
    }

    @Test
    public void sum() {
        int sum = new Demo().sum(100, 200);
        // 断言
        Assert.assertEquals(300, sum);
    }
}