package com.xiong.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiong.dao.RoleMapper;
import com.xiong.pojo.Role;
import com.xiong.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
}
