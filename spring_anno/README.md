# spring_anno该工程主要用来学习spring注解驱动开发
# Spring注解驱动开发

##  常见注解

### @Configuration

### @Bean

首先我们看一下注解类的定义:

```java
public @interface Bean {
	@AliasFor("name")
	String[] value() default {};
	@AliasFor("value")
	String[] name() default {};
	String initMethod() default "";
	String destroyMethod() default AbstractBeanDefinition.INFER_METHOD;
}
```



@bean的使用



```
@Bean(name = "userName")
```

```
@Bean(value = "userName")
```

### @ComponentScan



自定义扫描规则

- //指定要扫描的包

```
@AliasFor("basePackages")
String[] value() default {};
```

- //指定要扫描的包

```
@AliasFor("value")
String[] basePackages() default {};
```

- 指定包含规则(过滤器)

```
Filter[] includeFilters() default {}
```
- 指定排除规则(过滤器)

```
Filter[] excludeFilters() default {};
```



### @ComponentScan.Filter



```
@ComponentScans(value = {
        @ComponentScan(
                basePackages = {"com.fastdevelop.spring_anno.develop"},
                excludeFilters = {
                        @ComponentScan.Filter(type= FilterType.ANNOTATION,classes = {Controller.class})
                }
        )
})
```



```
@ComponentScans(value = {
        @ComponentScan(
                basePackages = {"com.fastdevelop.spring_anno.develop"},
                includeFilters = {
                        @ComponentScan.Filter(type= FilterType.ANNOTATION,classes = Controller.class)
                },
                useDefaultFilters = false//使用includeFilters时，必须制定禁用掉默认扫描规则，因为默认会进行指定包及其子包
        )
})
```

