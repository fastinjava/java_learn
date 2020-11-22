package com.fastdevelop.spring_anno.config.support;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
    /**
     *
     * @param importingClassMetadata 使用@import注解的类的注解信息
     * @return String[]数组：数组元素为要导入的组件全类名，且组件id为全类名
     */
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.fastdevelop.spring_anno.develop.dao.UserDao"};
    }
}
