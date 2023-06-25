package com.xiong.feign;

import com.xiong.pojo.Cinema;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "cinema-service", path = "cinema")
public interface CinemaFeignService {
    //根据影院ID查询影院信息
    @RequestMapping("getCinemaById/{id}")
    public Cinema getCinemaById(@PathVariable("id") Integer id);
}
