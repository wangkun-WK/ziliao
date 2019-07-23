package com.itheima.test;

import com.itheima.annocation.MyTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CoreRunner {

    public static void main(String[] args) {
        try {
            Class<DemoTest> demoTestClass = DemoTest.class;
            Method[] methods = demoTestClass.getMethods();
            for (Method method : methods) {
                if(method.isAnnotationPresent(MyTest.class)){
                    method.invoke(demoTestClass.newInstance());
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

}
