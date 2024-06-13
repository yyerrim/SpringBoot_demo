package com.example.demo;

import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// import com.example.demo.component.ImageUtil;

@Configuration
// @ComponentScan(basePackages = "com.example.demo.component")
// 따로 적용하지 않아도 run 이라는 메소드가 실행시키고 있음
public class BeanConfig {
    // // PDF 2.17 연습문제 : @Configuration 으로 쓰는 방법
    // @Bean
    // public ImageUtil imageUtil() {
    //     return new ImageUtil();
    // }

    // 내가 코드를 수정할 수 없을때 @Configuration 사용
    @Bean
    public String bean1() {
        return new String("Bean 1");
    }

    @Bean
    public Game game() {
        return new Game();
    }
}
