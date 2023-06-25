package com.xiong.controller;

import com.xiong.feign.MovieCinemaFeignService;
import com.xiong.feign.MovieFeignService;
import com.xiong.pojo.Cinema;
import com.xiong.pojo.Movie;
import com.xiong.pojo.MovieCinema;
import com.xiong.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("cinema")
public class CinemaController {
    @Autowired
    private CinemaService cinemaService;

    @Autowired(required = false)
    private MovieCinemaFeignService movieCinemaFeignService;

    @Autowired(required = false)
    private MovieFeignService movieFeignService;

    //电影院列表
    @RequestMapping("cinemaList")
    public List<Cinema> getAllCinemaByPage(@RequestBody Map<String, Object> hashMap) {
        System.out.println("\n进入getAllCinemaByPage控制器");
        return cinemaService.getByPage((Integer) hashMap.get("currentPage"), (Integer) hashMap.get("pageSize"), (String) hashMap.get("name"));
    }

    //根据影院ID查询影院信息
    @RequestMapping("getCinemaById/{id}")
    public Cinema getCinemaById(@PathVariable("id") Integer id) {
        System.out.println("\n进入getCinemaById控制器，获取到的值：" + id);
        return cinemaService.getById(id);
    }

    //count
    @RequestMapping("getCinemaCount")
    public long getCinemaCount(@RequestBody Map<String, Object> hashMap) {
        System.out.println("\n进入getCinemaCount控制器");
        return cinemaService.getCount((String) hashMap.get("name"));
    }

    //根据ID查询电影院，并关联查询相关的电影信息
    @RequestMapping("getCinemaAndMovieById/{id}")
    public List<Movie> getCinemaAndMovieById(@PathVariable("id") Integer id) {
        System.out.println("\n进入getCinemaAndMovieById控制器，获取到的值：" + id);
        //根据电影院ID，查询出对应的电影ID
        List<MovieCinema> list = movieCinemaFeignService.getMovieIDsByCinema(id);
        //根据电影ID查询出对应的电影信息
        List<Movie> movieList = new ArrayList<>();
        System.out.println(list);
        for (MovieCinema movieCinema : list) {
            movieList.add(movieFeignService.getMovieById(movieCinema.getMcMovieId()));
        }
        return movieList;
    }
}
