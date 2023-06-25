package com.xiong.feign;

import com.xiong.pojo.Cinema;
import com.xiong.pojo.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@FeignClient(value = "cinema-service", path = "cinema")
public interface CinemaFeignService {
    //电影院列表
    @RequestMapping("cinemaList")
    public List<Cinema> getAllCinemaByPage(@RequestBody Map<String, Object> hashMap);

    //count
    @RequestMapping("getCinemaCount")
    public long getCinemaCount(@RequestBody Map<String, Object> hashMap);

    //根据ID查询电影院，并关联查询相关的电影信息
    @RequestMapping("getCinemaAndMovieById/{id}")
    public List<Movie> getCinemaAndMovieById(@PathVariable("id") Integer id);
}
