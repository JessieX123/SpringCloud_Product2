package com.xiong.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiong.pojo.MovieCinema;

import java.util.List;

public interface MovieCinemaService extends IService<MovieCinema> {
    //根据电影ID获取电影院ID
    List<MovieCinema> getCinemaIDsByMovie(Integer id);

    //根据电影院ID获取电影ID
    List<MovieCinema> getMovieIDsByCinema(Integer id);
}
