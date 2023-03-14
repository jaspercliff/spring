package com.spring.config;

import com.spring.concert.Audience;
import com.spring.concert.Audience1;
import com.spring.concert.Performance;
import com.spring.concert.Singer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
//声明一个类为配置类 用于取代bean.xml配置文件注册bean对象
@EnableAspectJAutoProxy
@ComponentScan
public class concertConfig {

    @Bean
    public Performance singer(){
        return new Singer();
    }

    @Bean
    public Audience1 audience(){
        return new Audience1();
    }
}
