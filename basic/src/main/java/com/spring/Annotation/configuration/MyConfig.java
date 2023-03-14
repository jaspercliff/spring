package com.spring.Annotation.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;
import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_SINGLETON;

@Configuration()
//声明一个类为配置类 用于取代bean.xml配置文件注册bean对象
//本身有@Component  本身也是一个bean
public class MyConfig {

    @Bean(name = "user")
//    indicate that a method produces a bean to be managed by spring container
    @Scope(SCOPE_SINGLETON)
//
    @Lazy(value = false)//立即加载   默认是立即加载

    public User getUser(){
        System.out.println("User object has been created");
        return new User("jasper",22,dog());
    }

    @Bean
//    org.springframework.beans.
//    factory.NoSuchBeanDefinitionException: No bean named 'User' available
//    不指定bean的名称则默认是类名或者方法名的首字母小写
    @Scope(SCOPE_PROTOTYPE)
    @Lazy(value = true)//此时dog的懒加载失效 因为user是立即加载并且依赖dog
    public Dog dog(){
        System.out.println("Dog object has been created");
        return new Dog("ww",20);
    }
}
