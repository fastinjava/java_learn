package com.fastdevelop.design_patterns.stragey;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface SrvCodeAnnotation {
    String srvCode();
}
