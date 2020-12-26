package com.fastdevelop.jdk_source.optional_;


import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;

import java.io.Console;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

public class Demo1 {


    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        /**
         * 使用Optional.empty()创建一个空的optional
         */
        Optional<Object> objectOptional = Optional.empty();
        System.out.println(objectOptional.get());//为空调用，抛出java.util.NoSuchElementException
    }


    @Test
    public void test2() {
        String a = null;
        //Optional<Object> objectOptional = Optional.of(a);//java.lang.NullPointerException
        Optional<String> objectOptional = Optional.ofNullable(a);//不会报错
        System.out.println(objectOptional);
    }

    @Test
    public void test3() {
        String a = "lifuyong";
        Optional<String> optionalS = Optional.ofNullable(a);
        System.out.println(optionalS.get());
    }

    @Test
    public void test4() {
        try {
            System.out.println("===================");
            String a = null;
            Optional<Object> objectOptional = Optional.of(a);//when null , throw java.lang.NullPointerException
            //isPresent方法用来判断optional实例对象是否有值
            Assert.assertTrue(objectOptional.isPresent());//assertTrue 方法，参数为一个boolean表达式，表达式结果为false时抛出NullPointerException
            System.out.println("===================");
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());//null
        } finally {
            System.out.println("===================");
            String a = "lifuyong";
            Optional<Object> objectOptional = Optional.of(a);//
            Assert.assertTrue(objectOptional.isPresent());//
            System.out.println(objectOptional.get());//lifuyong

            objectOptional.ifPresent(obj -> {
                //
                Assert.assertEquals("lifuyong", a);
            });
            System.out.println("===================");
        }
    }

    /**
     * 检查是否有值的另一个选择是 ifPresent() 方法。
     * 该方法除了执行检查，还接受一个Consumer(消费者) 参数，如果对象不是空的，就对执行传入的 Lambda 表达式
     */
    @Test
    public void test5() {
        String a = null;
        Optional<String> optional = Optional.ofNullable(a);
        optional.ifPresent(System.out::println);
    }


    /**
     * orElse方法：
     * 如果optional实例有值，则直接返回，否则返回传入的默认值
     */
    @Test
    public void test6() {
        String a = null;
        Optional<String> optional = Optional.ofNullable(a);
        System.out.println(optional.orElse("default"));//a为空，所以结果打印default
        String b = "b";
        System.out.println(Optional.ofNullable(b).orElse("default"));//b不等于空，所以返回自身b
    }

    /**
     * orElseGet
     * 有值的时候返回值，如果没有值，它会执行作为参数传入的 Supplier(供应者) 函数式接口，并将返回其执行结果
     */
    @Test
    public void test7() {
        String a = null;
        Optional<String> optional = Optional.ofNullable(a);
//        String defaultO = optional.orElseGet(() -> "default");
        String defaultO = optional.orElseGet(() -> "default");
        System.out.println(defaultO);
    }

    /**
     * orElse和orElseGet方法的区别
     * 当optional实例不为空时，使用orElse方法仍然会调用defaultString方法，而orElseGet方法则不会
     * 当optional实例为空时，都会调用defaultString方法
     */
    @Test
    public void test8() {

        printLine();

        String a = "lifuyong";
        Optional<String> optional = Optional.ofNullable(a);
        System.out.println("使用orElse方法");
        optional.orElse(defaultString());
        System.out.println("使用orElseGet方法");
        optional.orElseGet(() -> defaultString());

        printLine();


    }

    @Test
    public void test9() {

        printLine();

        String a = null;
        Optional<String> optional = Optional.ofNullable(a);
        System.out.println("使用orElse方法");
        optional.orElse(defaultString());
        System.out.println("使用orElseGet方法");
        optional.orElseGet(() -> defaultString());

        printLine();


    }

    /**
     * orElseThrow方法，如果optional实例对象为null时，会抛出指定异常
     */
    @Test
    public void test10() {
        Optional.ofNullable(null).orElseThrow(() -> new RuntimeException("参数错误"));
    }

    /**
     * map() 对值应用(调用)作为参数的函数，然后将返回的值包装在 Optional 中。这就使对返回值进行链试调用的操作成为可能 —— 这里的下一环就是 orElse()。
     */
    @Test
    public void test11() {
        User user = new User();
        Optional<User> optional = Optional.ofNullable(user);
        System.out.println(optional.map(u -> {
            return u.getUsername();
        }).orElse("lifuyong"));
    }

    /**
     * 既然 getter 方法返回 String 值的 Optional，
     * 你可以在对 User 的 Optional 对象调用 flatMap() 时，
     * 用它作为参数。其返回的值是解除包装的 String 值：
     */
    @Test
    public void test12() {
        User user = new User();
        user.setPassword("123456");
        System.out.println(Optional.ofNullable(user).flatMap(u -> {
            return u.getPassword();
        }).orElse("default"));
    }

    /**
     * filter
     * Optional  类也提供了按条件“过滤”值的方法
     * filter() 接受一个 Predicate 参数，返回测试结果为 true 的值。如果测试结果为 false，会返回一个空的 Optional。
     */
    @Test
    public void test13() {
        User user = new User();
        user.setUsername("lifuyong");
        Optional<User> filterOptional = Optional.ofNullable(user).filter(u -> u.getUsername() != null && u.getUsername().contains("lif"));
        Assert.assertTrue(filterOptional.isPresent());

    }


    /**
     * optional的链式调用方法
     */
    @Test
    public void test14() {
        User user = new User();
        /**
         * flatmap
         * map
         * 方法返回的均是一个optional对象
         * 只不过flatmap的参数是一个optional对象，flatmap将其解封的参数另外封装了一个optional对象，并返回
         * 而map直接用参数封装了一个optional对象返回
         */
        String isocode = Optional.ofNullable(user)
                .flatMap(User::getAddress)
                .flatMap(Address::getCountry)
                .map(Country::getIsocode)
                .orElse("default");
//         String isocode = Optional.ofNullable(user)
//                .flatMap(u -> u.getAddress())
//                .flatMap(a -> a.getCountry())
//                .map(c -> c.getIsocode())
//                .orElse("default");
//


        Assert.assertEquals(isocode,"default");
    }


    @Test
    public void test15() {
        ArrayList<User> list = new ArrayList<>();
        User user = new User();
        user.setUsername("lifuyong");
        User u = list.stream().findFirst().orElse(user);
        System.out.println(u.getUsername());
    }

    public static String defaultString() {
        System.out.println("调用了defaultString方法");
        return "default";
    }

    public static void printLine() {
        System.out.println("===================");
    }

}
