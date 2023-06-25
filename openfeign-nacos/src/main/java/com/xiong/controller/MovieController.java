package com.xiong.controller;

import com.xiong.feign.MovieFeignService;
import com.xiong.pojo.Cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("movie")
public class MovieController {
    @Autowired
    private MovieFeignService movieFeignService;

    //根据电影ID查询对应的电影院信息
    @RequestMapping("getCinemasByMovieId")
    public String getCinemasByMovieId(HttpServletRequest request,
                                      @RequestParam Integer id) {
        System.out.println("\n进入getCinemasByMovieId控制器");
        request.setAttribute("getCinemasByMovieId", movieFeignService.getMovieAndCinemaById(id));
        return "moviePage/cinemaList";
    }
}
