package com.xiong.controller;

import com.xiong.feign.CinemaFeignService;
import com.xiong.feign.MovieCinemaFeignService;
import com.xiong.pojo.Cinema;
import com.xiong.pojo.Movie;
import com.xiong.pojo.MovieCinema;
import com.xiong.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @Autowired(required = false)
    private MovieCinemaFeignService movieCinemaFeignService;

    @Autowired(required = false)
    private CinemaFeignService cinemaFeignService;

    //电影列表
    @RequestMapping("movieList")
    public List<Movie> getAllMovieByPage(@RequestBody Map<String, Object> hashMap) {
        System.out.println("\n进入getAllMovieByPage控制器");
        return movieService.getByPage((Integer) hashMap.get("currentPage"), (Integer) hashMap.get("pageSize"), (String) hashMap.get("name"));
    }

    //根据电影ID查询电影信息
    @RequestMapping("getMovieById/{id}")
    public Movie getMovieById(@PathVariable("id") Integer id) {
        System.out.println("\n进入getMovieById控制器，获取到的值：" + id);
        return movieService.getById(id);
    }

    //count
    @RequestMapping("getMovieCount")
    public long getMovieCount(@RequestBody Map<String, Object> hashMap) {
        System.out.println("\n进入getMovieCount控制器");
        return movieService.getCount((String) hashMap.get("name"));
    }

    //根据ID查询电影，并关联查询相关的电影院信息
    @RequestMapping("getMovieAndCinemaById/{id}")
    public List<Cinema> getMovieAndCinemaById(@PathVariable("id") Integer id) {
        System.out.println("\n进入getMovieAndCinemaById控制器，接收到的值：" + id);
        //根据电影ID，查询出对应的影院ID
        List<MovieCinema> list = movieCinemaFeignService.getCinemaIDsByMovie(id);
        //根据影院ID查询出对应的影院信息
        List<Cinema> cinemaList = new ArrayList<>();
        for (MovieCinema movieCinema : list) {
            cinemaList.add(cinemaFeignService.getCinemaById(movieCinema.getMcCinemaId()));
        }
        return cinemaList;
    }

    //查询所有
    @RequestMapping("list")
    public List<Movie> list() {
        System.out.println("\n进入list控制器");
        return movieService.list();
    }
}
