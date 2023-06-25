package com.xiong.feign;

import com.xiong.pojo.Role;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "user-service", path = "role")
public interface RoleFeignService {
    //查询所有的Role
    @RequestMapping("getAllRole")
    public List<Role> getAllRole();
}
