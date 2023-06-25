package com.xiong.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiong.pojo.Movie;

import java.util.List;

public interface MovieService extends IService<Movie> {
    //查询所有的电影信息，并关联查询相关的电影院信息
    List<Movie> getAllMovieAndCinema();

    //根据ID查询电影信息，并关联查询相关的电影院信息
    Movie getMovieAndCinemaById(Integer id);

    //根据电影院ID，关联查询对应的电影院信息
    List<Movie> getMoviesByCinemaId(Integer id);

    //分页+模糊查询
    List<Movie> getByPage(int currentPage, int pageSize, String name);

    //总记录数
    long getCount(String name);
}
