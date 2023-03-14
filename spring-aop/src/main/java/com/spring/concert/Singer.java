package com.spring.concert;

import org.springframework.context.annotation.Bean;

public class Singer implements Performance{
    @Override
    public void perform(int num) {
        System.out.println("歌手唱了"+num+"首歌");
    }
}
