package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.component.Bean3;
import com.example.demo.component.ImageUtil;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
    // HTML
    @GetMapping("/test/html")
    public String testHtml() {
        return "home"; // HTML 파일명을 "" 안에 써주면됨
    }
    // home.html 안에 있는 내용이 브라우저에 출력됨

    @GetMapping("/test/html2")
    @ResponseBody
    public String testHtml2() {
        return "home";
    }
    // home 글자 자체가 브라우저에 출력됨

    // JSON
    @GetMapping("/test/json")
    @ResponseBody
    public Map testJson() { // 노란색 경고 뜨는거 싫으면 제네릭 써주면됨
        Map map = new HashMap();
        map.put("key1", true);
        map.put("key2", 2324);
        map.put("key3", "Hello");
        return map;
    }

    @GetMapping("/test/json2")
    @ResponseBody
    public List testJson2() {
        List list = new ArrayList();
        Map map = new HashMap();
        map.put("key1", true);
        map.put("key2", 2324);
        map.put("key3", "Hello");
        list.add(map);
        return list;
    }

    @GetMapping("/test/json3")
    @ResponseBody
    public Car testJson3() {
        Car car = new Car();
        car.setTire(4);
        car.setModel("EV6");
        return car;
    }

    // // 연습) emp 테이블의 테이터를 JSON으로 출력하기
    // @GetMapping("/test/emp2")
    // @ResponseBody
    // public List emp2Json() {
    //     List list = jt.queryForList("select * from emp");
    //     return list;
    // }
    // 강사님 풀이
    @Autowired JdbcTemplate jdbcTemplate; // DB 조회하는거
    @GetMapping("/test/emp")
    @ResponseBody
    public List<Map<String, Object>> testEmp() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from emp");
        return list;
    }

    @Autowired ImageUtil imageUtil;

    @Autowired Car car;

    @Autowired Bean3 bean3;

    @Autowired Game game;

    @Autowired String bean1;

    @Autowired JdbcTemplate jt;

    @RequestMapping("/")
    public String home() {
        try {
            imageUtil.save("http://ggoreb.com/images/luffy.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.car.run();
        // this : 전역변수 사용할때

        log.info(bean3.run());

        log.info(game.play());

        log.info(bean1);

        Car car = new Car();
        car.setTire(3);
        car.setModel("KIA");
        log.info(car.toString());

        List<Map<String, Object>> list = jt.queryForList("select * from dept");
        System.out.println(list);

        log.info(list.toString()); // 스프링 개발할때 System.out.println 보다 log 사용 (다시 찾아볼 수 있게)

        return "home"; // view
        // resources - templates - home.html 로 찾아들어감
    }
}
