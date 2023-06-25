package com.xiong.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiong.pojo.User;

import java.util.List;

public interface UserService extends IService<User> {
    //登录
    User login(User user);

    //验证用户名是否重复
    boolean checkName(String name);

    //查询所有的User，并关联查询Role
    List<User> getAllUserAndRole(int currentPage, int pageSize, String name);

    //分页查询
    List<User> getByPage(int currentPage, int pageSize, String name);

    //查询count，有用户名时根据用户名模糊查询count
    long getCount(String name);
}
