package com.xiong.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiong.dao.RoleMapper;
import com.xiong.dao.UserMapper;
import com.xiong.pojo.User;
import com.xiong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    //登录
    @Override
    public User login(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("u_username", user.getUUsername());
        queryWrapper.eq("u_password", user.getUPassword());
        queryWrapper.eq("u_role_id", user.getURoleId());
        User user1 = userMapper.selectOne(queryWrapper);
        if (user1 != null) {
            user1.setRole(roleMapper.selectById(user1.getURoleId()));
        }
        return user1;
    }

    //验证用户名是否重复，true:不可用，有重复名字；false:可用，没有重复名字
    @Override
    public boolean checkName(String name) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("u_username", name);
        boolean flag = userMapper.exists(queryWrapper);
        System.out.println(flag);
        return flag;
    }

    //查询所有的User，并关联查询Role
    @Override
    public List<User> getAllUserAndRole(int currentPage, int pageSize, String name) {
        return userMapper.getAllUserAndRole((currentPage - 1) * pageSize, pageSize, name);
    }

    //分页查询+模糊
    @Override
    public List<User> getByPage(int currentPage, int pageSize, String name) {
        List<User> userList = null;
        Page<User> page = new Page<>();
        page.setCurrent(currentPage);
        page.setSize(pageSize);
        if (name != null) {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.like("u_username", name);
            userList = userMapper.selectPage(page, queryWrapper).getRecords();
        } else {
            userList = userMapper.selectPage(page, null).getRecords();
        }
        for (User user : userList) {
            user.setRole(roleMapper.selectById(user.getURoleId()));
        }
        return userList;
    }

    //查询count，有用户名时根据用户名模糊查询count
    @Override
    public long getCount(String name) {
        long total = 0;
        if (name != null) {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.like("u_username", name);
            total = userMapper.selectCount(queryWrapper);
        } else {
            total = userMapper.selectCount(null);
        }
        return total;
    }
}
