package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("queryUserById")
    public User queryUserById() {
        User user = userMapper.selectByPrimaryKey(1);
        return user;
    }
}
