package com.xiong.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiong.pojo.Cinema;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CinemaMapper extends BaseMapper<Cinema> {
    //查询所有的电影院，并关联查询相关电影信息
    List<Cinema> getAllCinemaAndMovie();

    //根据ID查询电影院，并关联查询相关的电影信息
    Cinema getCinemaAndMovieById(Integer id);
}
