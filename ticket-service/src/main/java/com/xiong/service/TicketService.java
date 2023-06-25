package com.xiong.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiong.pojo.Ticket;

import java.util.List;

public interface TicketService extends IService<Ticket> {
    //查询所有，连表
    List<Ticket> getAll(Integer currentPage, Integer pageSize);

    //查询记录数
    long getCount();

    //查询所有，连表，没有分页
    List<Ticket> getAll1();

    //根据用户ID查询
    List<Ticket> getTicketByUser(Integer id);

    //根据用户ID删除
    int deleteTicketByUser(Integer id);
}
