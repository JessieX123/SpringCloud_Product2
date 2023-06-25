package com.xiong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xiong.dao")
public class MovieCinemaServiceApplication9005 {
    public static void main(String[] args) {
        SpringApplication.run(MovieCinemaServiceApplication9005.class);
    }
}
