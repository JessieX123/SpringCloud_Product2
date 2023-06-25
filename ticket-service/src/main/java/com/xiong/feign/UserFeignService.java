package com.xiong.feign;

import com.xiong.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "user-service", path = "user")
public interface UserFeignService {
    //根据ID查询
    @RequestMapping("getUserById/{id}")
    public User getUserById(@PathVariable("id") Integer id);
}
