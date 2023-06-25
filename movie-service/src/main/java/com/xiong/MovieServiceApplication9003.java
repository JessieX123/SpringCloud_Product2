package com.xiong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.xiong.dao")
@EnableFeignClients
public class MovieServiceApplication9003 {
    public static void main(String[] args) {
        SpringApplication.run(MovieServiceApplication9003.class, args);
    }
}
