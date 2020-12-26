package com.fastdevelop.jdk_source.util.function_;

import com.fastdevelop.jdk_source.optional_.User;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {

    /**
     * Consumer
     * 1、作用：消费某个对象
     * 2、使用场景：Iterable接口的forEach方法需要传入Consumer，大部分集合类都实现了该接口，用于返回Iterator对象进行迭代。
     * 3、设计思想：a）处理逻辑留给使用者，使用灵活多变 b)多变的逻辑封装成一个类，该类实现Consumer接口，将逻辑提取出来。
     *
     * @throws Throwable
     */
    @Test
    public void run0() throws Throwable {
        List<User> users = new ArrayList<User>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            if (i < 3) {
                user.setUsername("username:" + i + "lif");
            } else {
                user.setUsername("username:" + i + "");
            }
            users.add(user);
        }


        users.forEach(new UserPrintNameConsumer());

        System.out.println("-------------");
        users.forEach(user -> {
            System.out.println(user.getUsername());
        });
        System.out.println("----------------");
        users.removeIf(user -> {
            return user.getUsername().equalsIgnoreCase("username:3");
        });
        System.out.println("-------------");
        users.forEach(user -> {
            System.out.println(user.getUsername());
        });
    }

    @Test
    public void run1() throws Throwable {
        Map<String, String> maps = new HashMap<>();
        maps.put("name", "lifuyong");
        maps.put("sex", "male");

        System.out.println("--------------");
        maps.keySet().forEach(key -> {
            System.out.println("key = " + key + ", value = " + maps.get(key));
        });
        System.out.println("--------------");
        /**
         * computeIfAbsent:如果map中第一个参数的key没有，则将第二个参数的返回值作为该key对象value存入
         */
        maps.computeIfAbsent("age", k -> {
            return "18";
        });
        System.out.println("--------------");
        maps.keySet().forEach(key -> {
            System.out.println("key = " + key + ", value = " + maps.get(key));
        });
        System.out.println("--------------");
    }

    @Test
    public void run2() throws Throwable {
        List<User> users = new ArrayList<User>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            if (i < 3) {
                user.setUsername("username:" + i + "lif");
            } else {
                user.setUsername("username:" + i + "");
            }
            users.add(user);
        }

        users.forEach(u->{
            System.out.println(u.getUsername());
        });

        System.out.println("----------------");
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            user.setUsername(operate(user.getUsername(),new UserDoubleNameFunction()));
        }
        users.forEach(u->{
            System.out.println(u.getUsername());
        });

        System.out.println("----------------");

        List<User> userList = users.stream().map(user -> {
            user.setUsername(user.getUsername() + ":" + user.getUsername());
            return user;
        }).collect(Collectors.toList());



    }



    @Test
    public void run3() throws Throwable {
        User user = null;
//        User u = Optional.ofNullable(user).orElseGet(new UserSupplier());
        User u = Optional.ofNullable(user).orElseGet(() -> {
            User user1 = new User();
            user1.setUsername("xiaolongnv");
            return user1;
        });
        System.out.println(u.toString());
    }

    /**
     *
     * @param name
     * @param operationFunction
     * @return
     */
    public static String operate(String name, Function<String,String> operationFunction){
        return operationFunction.apply(name);
    }

}
