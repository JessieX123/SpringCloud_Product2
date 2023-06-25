package com.xiong.controller;

import com.xiong.pojo.MovieCinema;
import com.xiong.service.MovieCinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("MovieCinema")
public class MovieCinemaController {
    @Autowired
    private MovieCinemaService movieCinemaService;

    //查询所有
    @RequestMapping("getAll")
    public List<MovieCinema> getAll() {
        return movieCinemaService.list();
    }

    //根据电影ID获取电影院ID
    @RequestMapping("getCinemaIDsByMovie/{id}")
    public List<MovieCinema> getCinemaIDsByMovie(@PathVariable("id") Integer id) {
        System.out.println("\n进入getCinemaIDsByMovie控制器，获取到的值：" + id);
        return movieCinemaService.getCinemaIDsByMovie(id);
    }

    //根据电影院ID获取电影ID
    @RequestMapping("getMovieIDsByCinema/{id}")
    public List<MovieCinema> getMovieIDsByCinema(@PathVariable("id") Integer id) {
        System.out.println("\n进入getMovieIDsByCinema控制器，获取到的值：" + id);
        return movieCinemaService.getMovieIDsByCinema(id);
    }
}
