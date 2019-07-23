package com.itheima.test;

import com.itheima.annocation.Controller;
import com.itheima.annocation.MyTest;

/**
 * 测试类
 */
@Controller("abcd")
public class DemoTest {

    @MyTest
    public void test1() {
        System.out.println("test1...");
    }


    public void test2() {
        System.out.println("test2...");
    }


    @MyTest
    public void test3() {
        System.out.println("test3...");
    }

}