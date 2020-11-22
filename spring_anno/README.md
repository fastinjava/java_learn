

[toc]

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



使用FilterType.ANNOTATION，按照注解指定包含或者排除





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



使用FilterType.ASSIGNABLE_TYPE，排除或者包含指定类型(或者子类类型)的bean

```
@Configuration
@ComponentScans(value = {
        @ComponentScan(
                basePackages = {"com.fastdevelop.spring_anno.develop"},
                includeFilters = {
                        @ComponentScan.Filter(type= FilterType.ANNOTATION,classes = Controller.class),
                        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {UserService.class})
                },
                useDefaultFilters = false//使用includeFilters时，必须制定禁用掉默认扫描规则，因为默认会进行指定包及其子包
        )
})
```

使用FilterType.ASPECTJ，使用ASPECTJ表达式排除或者包含指定类型(或者子类类型)的bean

使用FilterType.REGEX，使用REGEX正则表达式排除或者包含指定类型(或者子类类型)的bean

使用FilterType.CUSTOM，使用CUSTOM自定义规则排除或者包含指定类型(或者子类类型)的bean

```
/** Filter candidates using a given custom
	 * {@link org.springframework.core.type.filter.TypeFilter} implementation.
	 */
	CUSTOM
```





> 想要使用FilterType.CUSTOM的过滤器，需要自定义实现TypeFilter的子类，重写其org.springframework.core.type.filter.TypeFilter#match方法，下面是方法简介

```java
public interface TypeFilter {

   /**
    * Determine whether this filter matches for the class described by
    * the given metadata.
    * @param metadataReader the metadata reader for the target class
    * @param metadataReaderFactory a factory for obtaining metadata readers
    * for other classes (such as superclasses and interfaces)
    */
   boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
         throws IOException;

}
```



metadataReader：当前扫描到的类的信息

- metadataReader.getClassMetadata():获取类的元数据信息
- metadataReader.getAnnotationMetadata()：获取类的注解信息

metadataReaderFactory：

方法返回值：true代表匹配成功，false代表匹配失败;

### @ComponentScans

这个注解相当于我们在一个类上，重复些若干个ComponentScan注解；



### @Scope

bean的作用域

IOC容器中的bean，默认是单实例的;

```java
public class MainConfig1 {

    /**
     * @Bean 注册组件
     * 默认用方法名作为 bean name
     * @Bean("beanName")
     *
     * @Scope():指定作用域，默认是ConfigurableBeanFactory.SCOPE_SINGLETON 单实例的 "singleton"
     * 总共有以下几种作用域类型：
  * ConfigurableBeanFactory#SCOPE_SINGLETON  “singleton”  单例(默认),ioc容器启动会调用构造方法创建对象，之后每次从容其中获取该类型的对象的时候，也不会调用创建方法
     * ConfigurableBeanFactory#SCOPE_PROTOTYPE   “prototype” 多例,ioc容器只会在使用时创建，何时用何时创建，之后每次从容其中获取该类型的对象的时候，均会调用创建方法
     *
     * WebApplicationContext#SCOPE_REQUEST       “request”   同一次请求创建一次
     * WebApplicationContext#SCOPE_SESSION       “session”   同一个session创建一次
     *
     * @return
     */
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Bean(value = "user1")
    public User user1(){
        System.out.println("给spring容器添加对象");
        return new User("user1",11);
    }

```

### @Lazy

```
@Lazy(value = true)
懒加载：
 针对单实例bean：默认非懒加载单实例bean随着ioc容器的创建而创建
 如果设置@Lazy(value = true)，意为懒加载创建bean，只会在第一次使用该对象的时候创建
```

### @Conditional



```
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Conditional {

   /**
    * All {@link Condition}s that must {@linkplain Condition#matches match}
    * in order for the component to be registered.
    */
   Class<? extends Condition>[] value();

}
```



按照某种条件注册

比如下面的场景：

如果当前系统是windows，将bill这个用户注册进去;

如果当前系统是linux，将linus这个用户注册进去;

```
@Conditional(value = {WindowsCondition.class})
@Bean(value = "bill gates")
public User billGates(){
    return new User("bill gates",62);
}


@Conditional(value = {LinuxCondition.class})
@Bean(value = "linus")
public User linus(){
    return new User("linus",70);
}
```

所谓的Condition需要我们自己去实现逻辑;

```
package com.fastdevelop.spring_anno.config.support;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WindowsCondition implements Condition {


    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        BeanDefinitionRegistry registry = context.getRegistry();

        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();

        Environment environment = context.getEnvironment();

        ResourceLoader resourceLoader = context.getResourceLoader();

        if (environment.getProperty("os.name").toUpperCase().contains("WINDOWS")) {
            return true;
        }else {
            return false;
        }
    }
}
```

### @Import

```
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Import {

   /**
    * {@link Configuration}, {@link ImportSelector}, {@link ImportBeanDefinitionRegistrar}
    * or regular component classes to import.
    */
   Class<?>[] value();

}
```

向容器注入组件，可以有四种类型：

```
/*
* 可以指定四种类型Class：
* Configuration：引入别的配置文件
* ImportSelector：自定义ImportSelector 具体参考：MyImportSelector
* ImportBeanDefinitionRegistrar：自定义ImportBeanDefinitionRegistrar 具体参考：MyImportBeanDefinitionRegistrar
* regular component classes：@Import(value = {UserService.class})：向容器中添加UserService类型的组件，组件id，默认为全类名
*
* */
@Import(value = {
        IncludeConfig1.class,
        MyImportSelector.class,
        MyImportBeanDefinitionRegistrar.class,
        UserService.class
})
```

IncludeConfig1

```
package com.fastdevelop.spring_anno.config;

import com.fastdevelop.spring_anno.develop.model.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IncludeConfig1 {

    @Bean
    public Role role(){
        return new Role("test_role");
    }

}
```

MyImportSelector

```
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
```

MyImportBeanDefinitionRegistrar



```
package com.fastdevelop.spring_anno.config.support;

import com.fastdevelop.spring_anno.develop.model.Role;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     *
     * @param importingClassMetadata 使用@import注解的类的注解信息
     * @param registry 注册中心
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //使用@import注解的类的注解信息
        Set<String> annotationTypes = importingClassMetadata.getAnnotationTypes();
        //获取ioc中某个BeanDefinition
        //BeanDefinition beanName = registry.getBeanDefinition("beanName");
        //获取ioc中某个BeanDefinition的个数
        int beanDefinitionCount = registry.getBeanDefinitionCount();
        //获取ioc中beanDefinitionNames
        String[] beanDefinitionNames = registry.getBeanDefinitionNames();

        BeanDefinition beanDefinition = new GenericBeanDefinition();
//        beanDefinition.getPropertyValues().add("roleName","李付勇");
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("李付勇11","java.lang.String");
        beanDefinition.setBeanClassName("com.fastdevelop.spring_anno.develop.model.Role");
        String beanName = "role_from_MyImportBeanDefinitionRegistrar";
        registry.registerBeanDefinition(beanName,beanDefinition);

    }
}
```