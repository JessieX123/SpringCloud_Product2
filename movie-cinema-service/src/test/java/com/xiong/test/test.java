package com.xiong.test;

import com.xiong.service.MovieCinemaService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan("com.xiong.dao")
public class test {
    @Autowired
    private MovieCinemaService movieCinemaService;

    @Test
    public void test01(){
        movieCinemaService.list().forEach(System.out::println);
    }

    @Test
    public void getCinemaIDsByMovieTest(){
        movieCinemaService.getCinemaIDsByMovie(1).forEach(System.out::println);
    }

    @Test
    public void getMovieIDsByCinemaTest(){
        movieCinemaService.getMovieIDsByCinema(1).forEach(System.out::println);
    }
}
