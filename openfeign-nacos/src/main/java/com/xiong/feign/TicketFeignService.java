package com.xiong.feign;

import com.xiong.pojo.Ticket;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "ticket-service", path = "ticket")
public interface TicketFeignService {
    //查询所有带分页
    @RequestMapping("getAll/{currentPage}/{pageSize}")
    public List<Ticket> getAll(@PathVariable("currentPage") Integer currentPage,
                               @PathVariable("pageSize") Integer pageSize);

    //count
    @RequestMapping("getCount")
    public long getCount();

    //根据ID删除
    @RequestMapping("removeById/{id}")
    public boolean removeById(@PathVariable("id") Integer id);

    //保存
    @RequestMapping("save")
    public Ticket save(@RequestBody Ticket ticket);

    //根据ID查询
    @RequestMapping("getTicketById/{id}")
    public Ticket getTicketById(@PathVariable("id") Integer id);

    //根据userId查询
    @RequestMapping("getTicketByUser/{userId}")
    public List<Ticket> getTicketByUser(@PathVariable("userId") Integer userId);

    //根据userId删除
    @RequestMapping("deleteTicketByUser/{userId}")
    public int deleteTicketByUser(@PathVariable("userId") Integer userId);
}
