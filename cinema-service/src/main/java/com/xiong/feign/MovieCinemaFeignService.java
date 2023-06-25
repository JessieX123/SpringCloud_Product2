package com.xiong.feign;

import com.xiong.pojo.MovieCinema;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "movie-cinema-service", path = "MovieCinema")
public interface MovieCinemaFeignService {
    //根据电影院ID获取电影ID
    @RequestMapping("getMovieIDsByCinema/{id}")
    public List<MovieCinema> getMovieIDsByCinema(@PathVariable("id") Integer id);
}
