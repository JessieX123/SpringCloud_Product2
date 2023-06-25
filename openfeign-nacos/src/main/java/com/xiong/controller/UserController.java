package com.xiong.controller;

import com.xiong.feign.RoleFeignService;
import com.xiong.feign.TicketFeignService;
import com.xiong.feign.UserFeignService;
import com.xiong.pojo.User;
import com.xiong.utils.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired(required = false)
    private UserFeignService userFeignService;

    @Autowired(required = false)
    private TicketFeignService ticketFeignService;

    @Autowired(required = false)
    private RoleFeignService roleFeignService;

    //登录
    @RequestMapping("login")
    @ResponseBody
    public boolean login(User user, HttpSession session) {
        System.out.println("\n进入login控制器");
        User login = userFeignService.login(user);
        if (login != null) {
            System.out.println("登录成功");
            session.setAttribute("userInfo", login);
            return true;
        } else {
            System.out.println("登录失败");
            return false;
        }
    }

    //退出登录
    @RequestMapping("loginOut")
    public String loginOut(HttpSession session) {
        System.out.println("\n进入loginOut控制器");
        session.invalidate();
        return "redirect:/";
    }

    //验证用户名是否可用session取值
    @RequestMapping("checkName")
    @ResponseBody
    public boolean checkName(User user, HttpSession session) {
        System.out.println("\n进入checkName控制器");
        User userInfo = (User) session.getAttribute("userInfo");
        if (userInfo != null) {
            if (Objects.equals(userInfo.getUUsername(), user.getUUsername())) {
                return false;
            }
        }
        if ("".equals(user.getUUsername())) {
            return true;
        }
        return userFeignService.checkName(user.getUUsername());
    }

    //验证用户名是否可用getById取值
    @RequestMapping("checkName1")
    @ResponseBody
    public boolean checkName1(User user) {
        System.out.println("\n进入checkName1控制器");
        User userInfo = userFeignService.getUserById(user.getUId());
        if (userInfo != null) {
            if (Objects.equals(userInfo.getUUsername(), user.getUUsername())) {
                return false;
            }
        }
        if ("".equals(user.getUUsername())) {
            return true;
        }
        return userFeignService.checkName(user.getUUsername());
    }

    //验证用户名是否可用，管理员添加用户
    @RequestMapping("checkName2")
    @ResponseBody
    public boolean checkName2(User user) {
        System.out.println("\n进入checkName2控制器");
        if ("".equals(user.getUUsername())) {
            return true;
        }
        return userFeignService.checkName(user.getUUsername());
    }

    //添加用户，注册成功自动登录
    @RequestMapping("register")
    public String addUser(User user, HttpSession session) {
        System.out.println("\n进入addUser控制器");
        if (userFeignService.save(user)) {
            session.setAttribute("userInfo", userFeignService.login(user));
            return "redirect:/";
        }
        return "redirect:/main/login";
    }

    //根据ID查询update
    @RequestMapping("getUserById")
    public String getUserById(HttpServletRequest request, Integer id) {
        System.out.println("\n进入getUserById控制器");
        request.setAttribute("userInfo", userFeignService.getUserById(id));
        return "userPage/update";
    }

    //根据ID查询updateList
    @RequestMapping("getUserById1")
    public String getUserById1(HttpServletRequest request,
                               @RequestParam("uId") Integer uId,
                               @RequestParam(defaultValue = "", value = "uUsername") String uUsername) {
        System.out.println("\n进入getUserById1控制器");
        request.setAttribute("uUsername", uUsername);
        request.setAttribute("userInfo", userFeignService.getUserById(uId));
        request.setAttribute("roleList", roleFeignService.getAllRole());
        return "userPage/updateList";
    }

    //根据ID修改update
    @RequestMapping("update")
    public String updateUser(User user, HttpSession session) {
        System.out.println("\n进入updateUser控制器");
        if (userFeignService.updateUser(user)) {
            session.setAttribute("userInfo", userFeignService.login(user));
        }
        return "redirect:/";
    }

    //添加用户，管理员
    @RequestMapping("addUserForAdmin")
    public String addUserForAdmin(User user) {
        System.out.println("\n进入addUserForAdmin控制器");
        user.setUDate(new Date());
        userFeignService.save(user);
        return "redirect:/main/userList?uUsername=" + URLEncoder.encode(user.getUUsername(), StandardCharsets.UTF_8);
    }

    //删除用户
    @RequestMapping("deleteUser")
    public String deleteUser(HttpServletRequest request,
                             @RequestParam(defaultValue = "1") Integer currentPage,
                             @RequestParam(defaultValue = "10") Integer pageSize,
                             @RequestParam(defaultValue = "", value = "uUsername") String uUsername,
                             @RequestParam("uId") Integer uId) {
        System.out.println("\n进入deleteUser控制器");
        userFeignService.removeById(uId);
        if (ticketFeignService.getTicketByUser(uId) != null) {
            ticketFeignService.deleteTicketByUser(uId);
        }
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

    //修改用户，管理员
    @RequestMapping("updateUser")
    public String updateUser(HttpServletRequest request,
                             User user,
                             @RequestParam(defaultValue = "1") Integer currentPage,
                             @RequestParam(defaultValue = "10") Integer pageSize,
                             @RequestParam(defaultValue = "", value = "uUsername") String uUsername) {
        System.out.println("\n进入updateUser控制器");
        System.out.println(user);
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
        userFeignService.updateUser(user);
        return "redirect:/main/userList?uUsername=" + URLEncoder.encode(user.getUUsername(), StandardCharsets.UTF_8);
    }
}
