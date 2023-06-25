package com.xiong.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiong.pojo.Ticket;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TicketMapper extends BaseMapper<Ticket> {
    //查询所有，连表
    List<Ticket> getAll(@Param("start") Integer start, @Param("pageSize") Integer pageSize);

    //查询所有，连表，没有分页
    List<Ticket> getAll1();
}
