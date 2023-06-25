package com.xiong.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiong.dao.MovieMapper;
import com.xiong.pojo.Movie;
import com.xiong.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl extends ServiceImpl<MovieMapper, Movie> implements MovieService {
    @Autowired
    private MovieMapper movieMapper;

    //查询所有的电影信息，并关联查询相关的电影院信息
    @Override
    public List<Movie> getAllMovieAndCinema() {
        return movieMapper.getAllMovieAndCinema();
    }


    //根据ID查询电影信息，并关联查询相关的电影院信息
    @Override
    public Movie getMovieAndCinemaById(Integer id) {
        return movieMapper.getMovieAndCinemaById(id);
    }

    @Override
    public List<Movie> getMoviesByCinemaId(Integer id) {
        return null;
    }

    //模糊查询+分页
    @Override
    public List<Movie> getByPage(int currentPage, int pageSize, String name) {
        Page<Movie> page = new Page<>();
        page.setCurrent(currentPage);
        page.setSize(pageSize);
        List<Movie> movieList = null;
        if (name != null) {
            QueryWrapper<Movie> queryWrapper = new QueryWrapper<>();
            queryWrapper.like("m_name", name);
            movieList = movieMapper.selectPage(page, queryWrapper).getRecords();
        } else {
            movieList = movieMapper.selectPage(page, null).getRecords();
        }
        return movieList;
    }

    //总记录数
    @Override
    public long getCount(String name) {
        if (name != null) {
            QueryWrapper<Movie> queryWrapper = new QueryWrapper<>();
            queryWrapper.like("m_name", name);
            return movieMapper.selectCount(queryWrapper);
        } else {
            return movieMapper.selectCount(null);
        }
    }
}
