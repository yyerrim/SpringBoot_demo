package com.example.demo;

import org.springframework.stereotype.Component;

// import lombok.Setter;
// import lombok.Getter;
// import lombok.ToString;
// import lombok.AllArgsConstructor;
// import lombok.NoArgsConstructor;
import lombok.Data;

@Component // IoC의 대상이라는 걸 알려줘야함

// @Setter // set 메소드 자동으로 만들어짐
// @Getter // get 메소드 자동으로 만들어짐
// @ToString // tire, model 이라는 변수를 terminal에서 깔끔하게 볼 수 있도록 아래 @Override 코드처럼 만들어줌
// @NoArgsConstructor
// @AllArgsConstructor
@Data // getter, setter, ... 모두 적은거처럼 해주는 annotation

public class Car {
    int tire;
    String model;
    // // lombok 사용 안할땐 get/set 메소드 아래처럼 직접 만들어줘야함
    // public void setTire(int tire) {
    //     this.tire = tire;
    // }

    public void run() {
        System.out.println("Car run!!!");
    }

    // @Override
    // public String toString() {
    //     return "tire : " + tire + ", model : " + model;
    // }
}
