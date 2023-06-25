package com.xiong.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiong.dao.CinemaMapper;
import com.xiong.pojo.Cinema;
import com.xiong.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaServiceImpl extends ServiceImpl<CinemaMapper, Cinema> implements CinemaService {
    @Autowired
    private CinemaMapper cinemaMapper;

    //查询所有的电影院，并关联查询相关电影信息
    @Override
    public List<Cinema> getAllCinemaAndMovie() {
        return cinemaMapper.getAllCinemaAndMovie();
    }

    //根据ID查询电影院，并关联查询相关的电影信息
    @Override
    public Cinema getCinemaAndMovieById(Integer id) {
        return cinemaMapper.getCinemaAndMovieById(id);
    }

    //查询所有的电影院，单表查询，分页+模糊
    @Override
    public List<Cinema> getByPage(int currentPage, int pageSize, String name) {
        List<Cinema> cinemaList = null;
        Page<Cinema> page = new Page<>();
        page.setCurrent(currentPage);
        page.setSize(pageSize);
        if (name != null) {
            QueryWrapper<Cinema> queryWrapper = new QueryWrapper<>();
            queryWrapper.like("c_name", name);
            cinemaList = cinemaMapper.selectPage(page, queryWrapper).getRecords();
        } else {
            cinemaList = cinemaMapper.selectPage(page, null).getRecords();
        }
        return cinemaList;
    }

    //记录数
    @Override
    public long getCount(String name) {
        if (name != null) {
            QueryWrapper<Cinema> queryWrapper = new QueryWrapper<>();
            queryWrapper.like("c_name", name);
            return cinemaMapper.selectCount(queryWrapper);
        } else {
            return cinemaMapper.selectCount(null);
        }
    }
}
