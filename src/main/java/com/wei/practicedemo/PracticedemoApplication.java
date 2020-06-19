package com.wei.practicedemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.wei.practicedemo.*"})
@MapperScan("com.wei.practicedemo.dao")
public class PracticedemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticedemoApplication.class, args);
    }

}
