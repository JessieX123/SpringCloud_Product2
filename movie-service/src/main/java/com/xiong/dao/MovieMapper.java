package com.xiong.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiong.pojo.Movie;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MovieMapper extends BaseMapper<Movie> {
    //查询所有的电影信息，并关联查询相关的电影院信息
    List<Movie> getAllMovieAndCinema();

    //根据ID查询电影信息，并关联查询相关的电影院信息
    Movie getMovieAndCinemaById(Integer id);
}
