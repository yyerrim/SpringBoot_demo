package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 외워서 쓰는거
public class TestController {
    // DI
    @Autowired Car car;

    @GetMapping("/test") // 외워서 쓰는거
    public String test() {
        car.run();

        return "<h1>테스트 페이지</h1>";
    }
}
// DemoApplication.java 9번째줄 위에 Run 누르고 브라우저 주소창에 localhost:8080/test