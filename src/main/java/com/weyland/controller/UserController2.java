package com.weyland.controller;

import com.weyland.dao.UserDao;
import com.weyland.domain.User;
import com.weyland.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController2 {

    @Autowired
    private UserService userService;

    /**
     * 根据账户名返回json
     * @param userAccount
     * @return
     */
    @PostMapping(value="/queryUser")
    public List<User> queryAccount(String userAccount){

        return userService.queryUser(userAccount);

    }

    /**
     * 根据性别返回json数组
     * @param userGender
     * @return
     */
    @PostMapping(value="/querySex")
    public List<User> QuerySex(String userGender){

        return userService.queryUserGender(userGender);

    }
}
