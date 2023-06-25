package com.xiong.feign;

import com.xiong.pojo.MovieCinema;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "movie-cinema-service", path = "MovieCinema")
public interface MovieCinemaFeignService {
    //根据电影ID获取电影院ID
    @RequestMapping("getCinemaIDsByMovie/{id}")
    List<MovieCinema> getCinemaIDsByMovie(@PathVariable("id") Integer id);
}
