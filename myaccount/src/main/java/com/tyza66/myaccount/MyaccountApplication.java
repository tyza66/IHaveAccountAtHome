package com.tyza66.myaccount;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tyza66.myaccount.mapper")
public class MyaccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyaccountApplication.class, args);
    }

}
