package com.xiong.feign;

import com.xiong.pojo.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "movie-service", path = "movie")
public interface MovieFeignService {
    //根据电影ID查询电影信息
    @RequestMapping("getMovieById/{id}")
    public Movie getMovieById(@PathVariable("id") Integer id);
}
