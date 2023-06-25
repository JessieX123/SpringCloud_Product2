package com.xiong.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiong.pojo.Cinema;

import java.util.List;

public interface CinemaService extends IService<Cinema> {
    //查询所有的电影院，并关联查询相关电影信息
    List<Cinema> getAllCinemaAndMovie();

    //根据ID查询电影院，并关联查询相关的电影信息
    Cinema getCinemaAndMovieById(Integer id);

    //查询所有的电影院，单表查询，分页+模糊
    List<Cinema> getByPage(int currentPage, int pageSize, String name);

    //记录数
    long getCount(String name);
}
