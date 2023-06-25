package com.xiong.feign;

import com.xiong.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@FeignClient(value = "user-service", path = "user")
public interface UserFeignService {
    //登录
    @RequestMapping("login")
    public User login(@RequestBody User user);

    //验证用户名是否可用session取值
    @RequestMapping("checkName/{name}")
    public boolean checkName(@PathVariable("name") String name);

    //添加用户
    @RequestMapping("register")
    public boolean save(@RequestBody User user);

    //根据ID查询update
    @RequestMapping("getUserById/{id}")
    public User getUserById(@PathVariable("id") Integer id);

    //根据ID修改update
    @RequestMapping("update")
    public boolean updateUser(@RequestBody User user);

    //查询所有
    @RequestMapping("getAllUserAndRole")
    public List<User> getAllUserAndRole(@RequestBody Map<String, Object> hashMap);

    //count
    @RequestMapping("getCount")
    public long getCount(@RequestBody Map<String, Object> hashMap);

    //根据ID删除userList
    @RequestMapping("removeById/{id}")
    public boolean removeById(@PathVariable("id") Integer id);
}
