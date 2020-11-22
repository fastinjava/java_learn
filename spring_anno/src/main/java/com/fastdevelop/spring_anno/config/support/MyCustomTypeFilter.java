package com.fastdevelop.spring_anno.config.support;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.core.type.AnnotationMetadata;
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
        String simpleName = metadataReader.getClass().getSimpleName();
        System.out.println(simpleName);
        System.out.println(metadataReader.getClassMetadata());
        System.out.println("当前类注解信息");
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        System.out.println(annotationMetadata);
        System.out.println(metadataReader.getResource());
        System.out.println("当前类注信息");
        System.out.println(metadataReader.getClassMetadata());
        if (metadataReader.getAnnotationMetadata().getClassName().contains("UserController")) {
            return Boolean.TRUE;
        }
        System.out.println("-----------------------------------");
        return Boolean.FALSE;
    }
}
