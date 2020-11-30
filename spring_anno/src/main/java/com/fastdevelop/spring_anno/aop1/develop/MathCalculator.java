package com.fastdevelop.spring_anno.aop1.develop;

public class MathCalculator {

    /**
     * 通知方法：
     *     前置@Before：目标方法之前执行
     *     后置@After：目标方法之后执行(无论方法正常结束还是异常结束)
     *     返回@AfterReturning：正常返回之后执行
     *     异常@AfterThrowing：异常返回之后执行，记录异常信息
     * @param i
     * @param j
     * @return
     */
    public int div(int i,int j){
//        try {
        //前置@Before
//            //目标方法执行
        //@AfterReturning 正常返回
//        } catch (Exception e) {
//            e.printStackTrace();
        //@AfterThrowing
//        }finally {
        //@After
//        }
        System.out.println("目标方法执行");
        return i/j;
    }

}
