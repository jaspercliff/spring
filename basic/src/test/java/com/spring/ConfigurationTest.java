package com.spring;

import com.spring.Annotation.configuration.ConfigProxyBeanMethod;
import com.spring.Annotation.configuration.Dog;
import com.spring.Annotation.configuration.MyConfig;
import com.spring.Annotation.configuration.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationTest {

    @Test
    public void test1(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        System.out.println("=======================");
        User user = context.getBean("user", User.class);
        User user1 = context.getBean("user", User.class);
        System.out.println("user==user1 ?" + (user == user1));
//        user对象 SCOPE_SINGLETON
        Dog dog = context.getBean("dog", Dog.class);
        Dog dog1 = context.getBean("dog", Dog.class);
        System.out.println("dog==dog ?" + (dog == dog1));
//        dog 对象 SCOPE_PROTOTYPE
//        System.out.println(user);
//        System.out.println(dog);
    }

    @Test
    public void test2(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigProxyBeanMethod.class);
        ConfigProxyBeanMethod config = context.getBean("configProxyBeanMethod", ConfigProxyBeanMethod.class);
        System.out.println(config);
    }


    @Test
    public void test3(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigProxyBeanMethod.class);
        System.out.println("===================");
        ConfigProxyBeanMethod config = context.getBean("configProxyBeanMethod", ConfigProxyBeanMethod.class);
        User user = config.user();
        User user1 = config.user();
        Dog dog = config.dog();
        Dog dog1 = config.dog();
        System.out.println(user == user1);
        System.out.println(dog == dog1);
    }
}
