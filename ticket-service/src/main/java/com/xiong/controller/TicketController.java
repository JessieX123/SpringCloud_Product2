package com.xiong.controller;

import com.xiong.feign.CinemaFeignService;
import com.xiong.feign.MovieFeignService;
import com.xiong.feign.UserFeignService;
import com.xiong.pojo.Ticket;
import com.xiong.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @Autowired(required = false)
    private UserFeignService userFeignService;

    @Autowired(required = false)
    private MovieFeignService movieFeignService;

    @Autowired(required = false)
    private CinemaFeignService cinemaFeignService;

    //查询所有带分页
    @RequestMapping("getAll/{currentPage}/{pageSize}")
    public List<Ticket> getAll(@PathVariable("currentPage") Integer currentPage,
                               @PathVariable("pageSize") Integer pageSize) {
        //todo:改成根据User的ID查询信息，根据Movie的ID查询信息，根据Cinema的ID查询信息
        System.out.println("\n进入getAll控制器");
        List<Ticket> ticketList = ticketService.getAll(currentPage, pageSize);
        for (Ticket ticket : ticketList) {
            ticket.setUser(userFeignService.getUserById(ticket.getTUser()));
            ticket.setMovie(movieFeignService.getMovieById(ticket.getTMovie()));
            ticket.setCinema(cinemaFeignService.getCinemaById(ticket.getTCinema()));
        }
        return ticketList;
    }

    //count
    @RequestMapping("getCount")
    public long getCount() {
        System.out.println("\n进入getCount控制器");
        return ticketService.getCount();
    }

    //根据ID删除
    @RequestMapping("removeById/{id}")
    public boolean removeById(@PathVariable("id") Integer id) {
        System.out.println("\n进入removeById控制器，获取到的值：" + id);
        return ticketService.removeById(id);
    }

    //保存
    @RequestMapping("save")
    public Ticket save(@RequestBody Ticket ticket) {
        System.out.println("\n进入save控制器");
        ticket.setTDate(new Date());
        ticketService.save(ticket);
        return ticket;
    }

    //根据ID查询
    @RequestMapping("getTicketById/{id}")
    public Ticket getTicketById(@PathVariable("id") Integer id) {
        System.out.println("\n进入getTicketById控制器，获取到的值：" + id);
        Ticket ticket = ticketService.getById(id);
        //根据用户ID查询用户信息
        ticket.setUser(userFeignService.getUserById(ticket.getTUser()));
        //根据电影ID查询电影信息
        ticket.setMovie(movieFeignService.getMovieById(ticket.getTMovie()));
        //根据影院ID查询影院信息
        ticket.setCinema(cinemaFeignService.getCinemaById(ticket.getTCinema()));
        return ticket;
    }

    //根据userId查询
    @RequestMapping("getTicketByUser/{userId}")
    public List<Ticket> getTicketByUser(@PathVariable("userId") Integer userId) {
        System.out.println("\n进入getTicketByUser控制器，获取到的值：" + userId);
        return ticketService.getTicketByUser(userId);
    }

    //根据userId删除
    @RequestMapping("deleteTicketByUser/{userId}")
    public int deleteTicketByUser(@PathVariable("userId") Integer userId) {
        System.out.println("\n进入deleteTicketByUser控制器，获取到的值：" + userId);
        return ticketService.deleteTicketByUser(userId);
    }
}
