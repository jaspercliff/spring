package com.spring;

import com.spring.concert.Performance;
import com.spring.config.concertConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopTest {

    @Test
    public void test(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(concertConfig.class);
        Performance singer = context.getBean("singer", Performance.class);
        singer.perform(3);
    }
}
