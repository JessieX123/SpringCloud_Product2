package com.xiong.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiong.dao.MovieCinemaMapper;
import com.xiong.pojo.MovieCinema;
import com.xiong.service.MovieCinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieCinemaServiceImpl extends ServiceImpl<MovieCinemaMapper, MovieCinema> implements MovieCinemaService {
    @Autowired
    private MovieCinemaService movieCinemaService;

    //根据电影ID获取电影院ID
    @Override
    public List<MovieCinema> getCinemaIDsByMovie(Integer id) {
        QueryWrapper<MovieCinema> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mc_movie_id", id);
        return movieCinemaService.list(queryWrapper);
    }

    //根据电影院ID获取电影ID
    @Override
    public List<MovieCinema> getMovieIDsByCinema(Integer id) {
        QueryWrapper<MovieCinema> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mc_cinema_id", id);
        return movieCinemaService.list(queryWrapper);
    }
}
