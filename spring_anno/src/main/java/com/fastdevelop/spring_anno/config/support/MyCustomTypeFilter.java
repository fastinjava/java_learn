package com.fastdevelop.spring_anno.config.support;

import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class MyCustomTypeFilter implements TypeFilter {

    /**
     *
     * @param metadataReader the metadata reader for the target class
     *                       这里的target的class，指的是：spring拿到各个bean(的类型进行一一匹配)
     * @param metadataReaderFactory
     * @return true or false
     * @throws IOException
     */
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        System.out.println("-----------------------------------");
        System.out.println(metadataReader.getClass());
        System.out.println(metadataReader.getClassMetadata());
        System.out.println(metadataReader.getResource());
        System.out.println(metadataReader.getClassMetadata());
        System.out.println("-----------------------------------");
        return true;
    }
}
