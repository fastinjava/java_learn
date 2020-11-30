package com.fastdevelop.spring_anno.aop1.test;

import com.fastdevelop.spring_anno.aop1.config.MainConfigAop;
import com.fastdevelop.spring_anno.aop1.develop.MathCalculator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    @org.junit.Test
    public void test1(){

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfigAop.class);
        MathCalculator mathCalculator = ac.getBean(MathCalculator.class);
        int result = mathCalculator.div(1, 1);
//        System.out.println(result);
    }
}
