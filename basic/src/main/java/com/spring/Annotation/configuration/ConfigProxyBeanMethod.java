package com.spring.Annotation.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_SINGLETON;

@Configuration(proxyBeanMethods = false)
public class ConfigProxyBeanMethod {

    @Bean
    @Scope(SCOPE_SINGLETON)
    public User user(){
        System.out.println("User object has been created");
        return new User("jasper",22,dog());
    }

    @Bean
    public Dog dog(){
        System.out.println("Dog object has been created");
        return new Dog("ww",20);
    }

}
