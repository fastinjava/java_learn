package com.fastdevelop.jdk_source.io;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class Demo2 {
    @Test
    public void run0()  {
        String filePath = "C:\\Users\\admin\\Desktop\\kelin\\projects\\blogMdPath1\\";
        File file = new File(filePath);
        try {
            Assert.assertTrue(file.exists());
            Assert.assertTrue(file.isDirectory());
        } finally {
            file.mkdirs();
        }
    }
}
