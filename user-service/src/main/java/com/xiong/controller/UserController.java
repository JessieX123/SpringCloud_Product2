package com.xiong.controller;

import com.xiong.pojo.User;
import com.xiong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    //登录
    @RequestMapping("login")
    public User login(@RequestBody User user) {
        System.out.println("\n进入login控制器");
        System.out.println(user);
        User login = userService.login(user);
        System.out.println(login);
        return login;
    }

    //验证用户名是否可用session取值
    @RequestMapping("checkName/{name}")
    public boolean checkName(@PathVariable("name") String name) {
        System.out.println("\n进入checkName控制器，获取到的值：" + name);
        return userService.checkName(name);
    }

    //添加用户
    @RequestMapping("register")
    public boolean save(@RequestBody User user) {
        System.out.println("\n进入addUser控制器");
        user.setUDate(new Date());
        return userService.save(user);
    }

    //根据ID查询
    @RequestMapping("getUserById/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        System.out.println("\n进入getUserById控制器，获取到的值：" + id);
        return userService.getById(id);
    }

    //根据ID修改update
    @RequestMapping("update")
    public boolean updateUser(@RequestBody User user) {
        System.out.println("\n进入updateUser控制器");
        return userService.updateById(user);
    }

    //查询所有
    @RequestMapping("getAllUserAndRole")
    public List<User> getAllUserAndRole(@RequestBody Map<String, Object> hashMap) {
        System.out.println("\n进入getAllUserAndRole控制器");
        return userService.getAllUserAndRole((Integer) hashMap.get("currentPage"), (Integer) hashMap.get("pageSize"), (String) hashMap.get("name"));
    }

    //count
    @RequestMapping("getCount")
    public long getCount(@RequestBody Map<String, Object> hashMap) {
        System.out.println("\n进入getCount控制器");
        return userService.getCount((String) hashMap.get("name"));
    }

    //根据ID删除userList
    @RequestMapping("removeById/{id}")
    public boolean removeById(@PathVariable("id") Integer id) {
        System.out.println("\n进入removeById控制器，获取到的值：" + id);
        return userService.removeById(id);
    }
}
