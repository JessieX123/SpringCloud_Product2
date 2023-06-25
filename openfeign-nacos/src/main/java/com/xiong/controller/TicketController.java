package com.xiong.controller;

import com.xiong.feign.TicketFeignService;
import com.xiong.pojo.Ticket;
import com.xiong.utils.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("ticket")
public class TicketController {
    @Autowired(required = false)
    private TicketFeignService ticketFeignService;

    //删除
    @RequestMapping("deleteTicket")
    public String deleteTicket(HttpServletRequest request,
                               @RequestParam(defaultValue = "1") Integer currentPage,
                               @RequestParam(defaultValue = "10") Integer pageSize,
                               @RequestParam("tId") Integer id) {
        System.out.println("\n进入deleteTicket控制器");
        ticketFeignService.removeById(id);
        request.setAttribute("ticketList", ticketFeignService.getAll(currentPage, pageSize));
        request.setAttribute("pages", new Pages(currentPage, pageSize, (int) ticketFeignService.getCount()));
        return "ticketPage/ticketList";
    }

    //添加
    @RequestMapping("addTicket")
    public String addTicket(Ticket ticket, HttpServletRequest request) {
        System.out.println("\n进入addTicket控制器");
        Ticket saved = ticketFeignService.save(ticket);
        request.setAttribute("ticketInfo", ticketFeignService.getTicketById(saved.getTId()));
        return "ticketPage/ticketSuccess";//跳转，打印刚刚的数据
    }
}
