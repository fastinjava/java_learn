package com.fastdevelop.jdk_source.io;

import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class IOTest1 {

    @Test
    public void test2(){
        String name = "13.13.spring中的策略设计模式(Av71093907,P3).mp4";
        String subName = name.substring(name.length() - 8);
        System.out.println(subName);
    }

    @Test
    public void test1(){

        File file = new File("E:\\Program Files\\JiJiDown\\Download\\【spring源码全集】B站唯一阿里P8级别的架构师教程");
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            List<File> fileList = Arrays.asList(files);
            Collections.sort(fileList, new Comparator<File>() {
                public int compare(File o1, File o2) {
                    String name1 = o1.getName();
                    String name2 = o2.getName();
                    String nameInt1 = name1.substring(0, 2).replace(".", "");
                    String nameInt2 = name2.substring(0, 2).replace(".", "");
                    return Integer.parseInt(nameInt1) - Integer.parseInt(nameInt2);
                }
            });

            if (fileList.size() > 0) {
                for (File f : files) {
                    String name = f.getName();
                    System.out.println(name);
                }
            }
        }
    }

}
