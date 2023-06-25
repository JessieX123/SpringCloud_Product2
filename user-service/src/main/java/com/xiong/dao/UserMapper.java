package com.xiong.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiong.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    //查询所有的User，并关联查询Role
    List<User> getAllUserAndRole(@Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("name") String name);
}
