package com.xiong.controller;

import com.xiong.feign.CinemaFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("cinema")
public class CinemaController {
    @Autowired
    private CinemaFeignService cinemaFeignService;

    //根据电影院ID查询相关电影
    @RequestMapping("getMoviesByCinemaId")
    public String getMoviesByCinemaId(HttpServletRequest request,
                                      @RequestParam Integer id) {
        System.out.println("\n进入getMoviesByCinemaId控制器");
        request.setAttribute("getCinemaAndMovieById", cinemaFeignService.getCinemaAndMovieById(id));
        return "cinemaPage/movieList";
    }
}
