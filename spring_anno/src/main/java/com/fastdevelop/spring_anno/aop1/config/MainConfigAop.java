package com.fastdevelop.spring_anno.aop1.config;

import com.fastdevelop.spring_anno.aop1.develop.LogAspect;
import com.fastdevelop.spring_anno.aop1.develop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * aop:面向切面编程，能在程序运行期间动态地将某段代码动态地放入到指定位置进行运行
 * 底层原理 动态代理
 * 1、导入aop模块；aspects
 * 2、创建业务逻辑类
 * 3、创建切面类
 *   切面类可以动态地感应到业务逻辑方法运行到哪一步，从而执行不同的通知方法，
 *      通知方法：
 *          前置@Before：目标方法之前执行
 *          后置@After：目标方法之后执行(无论方法正常结束还是异常结束)
 *          返回@AfterReturning：正常返回之后执行
 *          异常@AfterThrowing：异常返回之后执行，记录异常信息
 *
 *          环绕通知：可以实现以上通知
 *4、切面类通过注解配置不同的通知(切入点表达式抽取)
 *5、将切面类和目标类（都加入到容器中）
 *6、告诉spring哪个类是切面类，给切面类加个注解 @Aspect
 * 7、开启注解版切面功能 ,配置类加 @{@link EnableAspectJAutoProxy}
 *
 *
 * 实验总结：
 * 如果目标方法没有异常，执行顺序为：
 * 1、before方法
 * 2、目标方法
 * 3、after方法
 * 4、afterReturning方法
 *
 * 如果目标方法有异常，执行顺序为：
 * 1、 before
 * 2、 目标方法执行
 * 3、 after
 * 4、 afterThrowing
 *
 */
@Configuration
@EnableAspectJAutoProxy
public class MainConfigAop {

    @Bean
    public MathCalculator mathCalculator(){
        return new MathCalculator();
    }
    @Bean
    public LogAspect logAspect(){
        return new LogAspect();
    }

}
