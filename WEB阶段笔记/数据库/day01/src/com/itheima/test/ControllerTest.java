package com.itheima.test;

import com.itheima.annocation.Controller;

public class ControllerTest {

    public static void main(String[] args) {
        Class<DemoTest> demoTestClass = DemoTest.class;
        boolean annotationPresent = demoTestClass.isAnnotationPresent(Controller.class);
        if(annotationPresent){
            Controller annotation = demoTestClass.getAnnotation(Controller.class);
            String value = annotation.value();
            System.out.println(value);
        }
    }

}
