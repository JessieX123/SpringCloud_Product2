package com.xiong.controller;

import com.xiong.pojo.Role;
import com.xiong.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    //查询所有的Role
    @RequestMapping("getAllRole")
    public List<Role> getAllRole() {
        System.out.println("\n进入getAllRole控制器");
        return roleService.list();
    }
}
