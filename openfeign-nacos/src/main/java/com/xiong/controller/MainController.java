package com.xiong.controller;

import com.xiong.feign.*;
import com.xiong.pojo.Ticket;
import com.xiong.utils.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("main")
public class MainController {
    @Autowired(required = false)
    private RoleFeignService roleFeignService;

    @Autowired(required = false)
    private CinemaFeignService cinemaFeignService;

    @Autowired(required = false)
    private MovieFeignService movieFeignService;

    @Autowired(required = false)
    private TicketFeignService ticketFeignService;

    @Autowired(required = false)
    private UserFeignService userFeignService;

    //进入login页面，并传递Role
    @RequestMapping("login")
    public String loginPage(HttpServletRequest request) {
        System.out.println("\n进入login页面");

        request.setAttribute("roleList", roleFeignService.getAllRole());
        return "userPage/login";
    }

    //进入register页面
    @RequestMapping("register")
    public String registerPage() {
        System.out.println("\n进入registerPage页面");
        return "userPage/register";
    }

    //进入userList页面，并传递User以及对应的Role
    @RequestMapping("userList")
    public String userList(HttpServletRequest request,
                           @RequestParam(defaultValue = "1") Integer currentPage,
                           @RequestParam(defaultValue = "10") Integer pageSize,
                           @RequestParam(defaultValue = "", value = "uUsername") String uUsername) {
        System.out.println("\n进入userList页面");
        if ("".equals(uUsername)) {
            request.setAttribute("name1", "");
        } else {
            request.setAttribute("name1", uUsername);
        }
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("currentPage", currentPage);
        hashMap.put("pageSize", pageSize);
        hashMap.put("name", uUsername);
        request.setAttribute("userList", userFeignService.getAllUserAndRole(hashMap));
        request.setAttribute("pages", new Pages(currentPage, pageSize, (int) userFeignService.getCount(hashMap)));
        return "userPage/userList";
    }

    //进入addUser页面
    @RequestMapping("addUserForAdmin")
    public String addUserForAdmin(HttpServletRequest request) {
        System.out.println("\n进入addUserForAdmin页面");
        request.setAttribute("roleList", roleFeignService.getAllRole());
        return "userPage/addUser";
    }

    //进入cinemaList页面，电影院列表
    @RequestMapping("cinemaList")
    public String cinemaList(HttpServletRequest request,
                             @RequestParam(defaultValue = "1") Integer currentPage,
                             @RequestParam(defaultValue = "10") Integer pageSize,
                             @RequestParam(defaultValue = "", value = "cName") String name) {
        System.out.println("\n进入cinemaList页面");
        if ("".equals(name)) {
            request.setAttribute("name1", "");
        } else {
            request.setAttribute("name1", name);
        }
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("currentPage", currentPage);
        hashMap.put("pageSize", pageSize);
        hashMap.put("name", name);
        request.setAttribute("cinemaList", cinemaFeignService.getAllCinemaByPage(hashMap));
        request.setAttribute("pages", new Pages(currentPage, pageSize, (int) cinemaFeignService.getCinemaCount(hashMap)));
        return "cinemaPage/cinemaList";
    }

    //进入movieList页面，电影列表
    @RequestMapping("movieList")
    public String movieList(HttpServletRequest request,
                            @RequestParam(defaultValue = "1") Integer currentPage,
                            @RequestParam(defaultValue = "10") Integer pageSize,
                            @RequestParam(defaultValue = "", value = "mName") String name) {
        System.out.println("\n进入movieList页面");
        if ("".equals(name)) {
            request.setAttribute("name1", "");
        } else {
            request.setAttribute("name1", name);
        }
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("currentPage", currentPage);
        hashMap.put("pageSize", pageSize);
        hashMap.put("name", name);
        request.setAttribute("movieList", movieFeignService.getAllMovieByPage(hashMap));
        request.setAttribute("pages", new Pages(currentPage, pageSize, (int) movieFeignService.getMovieCount(hashMap)));
        return "moviePage/movieList";
    }

    //进入ticketList页面，已购列表
    @RequestMapping("ticketList")
    public String ticketList(HttpServletRequest request,
                             @RequestParam(defaultValue = "1") Integer currentPage,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        System.out.println("\n进入ticketList页面");
        request.setAttribute("ticketList", ticketFeignService.getAll(currentPage, pageSize));
        request.setAttribute("pages", new Pages(currentPage, pageSize, (int) ticketFeignService.getCount()));
        return "ticketPage/ticketList";
    }

    //进入addTicket页面，购票页面，选择电影
    @RequestMapping("addTicket")
    public String addTicket(HttpServletRequest request) {
        System.out.println("\n进入addTicket页面");
        request.setAttribute("movieList", movieFeignService.list());
        return "ticketPage/addTicket";
    }

    //进入addTicket1页面，购票页面，选择影院
    @RequestMapping("addTicket1")
    public String addTicket1(Ticket ticket, HttpServletRequest request) {
        System.out.println("\n进入addTicket1页面");
        request.setAttribute("movie", movieFeignService.getMovieById(ticket.getTMovie()));
        request.setAttribute("cinemaList", movieFeignService.getMovieAndCinemaById(ticket.getTMovie()));
        return "ticketPage/addTicket1";
    }
}
