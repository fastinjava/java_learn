package com.fastdevelop.spring_anno.aop1.develop;

import cn.hutool.json.JSONUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 切入点表达式
 * https://www.cnblogs.com/sjqq/p/10241781.html
 */
@Aspect//@Aspect告诉spring这是一个切面组件
public class LogAspect {
    // 本类引入pointcut()
    //外部引入com.fastdevelop.spring_anno.aop1.develop.LogAspect.pointcut()
    @Pointcut(value = "execution( * com.fastdevelop.spring_anno.aop1.develop.MathCalculator.*(..))")
    public void pointcut() {
    }
//
//    ;
//
//    //    @Before(value = "public int com.fastdevelop.spring_anno.aop1.develop.MathCalculator.div(int,int)")
////    @Before(value = "public int com.fastdevelop.spring_anno.aop1.develop.MathCalculator.*(int,int)") //任意方法(参数列表有限制)
////    @Before(value = "public int com.fastdevelop.spring_anno.aop1.develop.MathCalculator.*(..)")//任意方法(参数列表没有限制)
////    @Before(value = " int com.fastdevelop.spring_anno.aop1.develop.MathCalculator.*(..)") //public可省略
////    @Before(value = " * com.fastdevelop.spring_anno.aop1.develop.MathCalculator.*(..)") //方法返回值任意
//    @Before(value = "pointcut()")
//    public void before(JoinPoint jPoint) {
//        System.out.println(" before " + jPoint.getSignature() //方法签名
//                .getName()//方法名称
//                +
//                "  "
//                +
//                JSONUtil.toJsonPrettyStr(jPoint.getArgs()) // 参数列表
//        );
//    }
//
//    @After(value = "com.fastdevelop.spring_anno.aop1.develop.LogAspect.pointcut()")
//    public void after(JoinPoint jPoint) {
//        System.out.println("after");
//    }
//
//    /**
//     * 方法正常返回，可以拿到返回值
//     * joinPoint：如果要使用，必须放在参数列表第一个
//     */
//    @AfterReturning(value = "com.fastdevelop.spring_anno.aop1.develop.LogAspect.pointcut()",returning = "result")
//    public void afterReturning(JoinPoint joinPoint,Object result) {
//        System.out.println("afterReturning " + joinPoint.getSignature().getName() + " " + result);
//    }
//
//    /**
//     * 方法异常
//     */
//    @AfterThrowing(value = "com.fastdevelop.spring_anno.aop1.develop.LogAspect.pointcut()",throwing = "exp")
//    public void afterThrowing(JoinPoint joinPoint,Exception exp) {
//        System.out.println("afterThrowing " + joinPoint.getSignature().getName() + " " + exp.getMessage());
//    }

    /**
     * 本质上来说环绕通知更加强大，且易于理解
     * 就顺序而言，不放记住先前总结的几种通知顺序
     * 环绕通知的话，按照java语法来就可以了
     * @param proceedingJoinPoint
     * @return
     */
    @Around(value = "pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint){
        Object result;
        try {
            System.out.println("前置");
            result = proceedingJoinPoint.proceed();
            System.out.println("后置");
            return result;
        } catch (Throwable throwable) {
            System.out.println("异常通知");
            throw new RuntimeException(throwable);
        }finally {
            System.out.println("最终通知");
        }
    }
}
