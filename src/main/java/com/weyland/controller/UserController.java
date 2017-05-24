package com.weyland.controller;

import com.weyland.domain.User;
import com.weyland.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by Dell on 2017-5-22.
 */

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/addUser")
    public User addUserAct(User user){

        return userService.register(user);

    }

    @PostMapping(value="/queryUser")
    public User QueryUserAct(String userAccount){

        return userService.queryUser(userAccount);

    }

//    @RequestMapping("")
//    public String turnIndex(HttpServletResponse response){
//
//        return response.encodeRedirectURL("/index");
//
//    }
//
//    @RequestMapping("/index")
//    public String goHome(Model model){
//        return "index";
//    }
//
//
//
//    //跳转到注册页面
//    @RequestMapping(value = "/register", method = RequestMethod.GET)
//    public String getRegister(){
//        return "/register";
//    }
//
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public String haveRegister(Model model, @ModelAttribute(value = "user") User user, HttpServletResponse response){
//
//        String result=userService.register(user);
//
//        model.addAttribute("result",result);
//
//        return response.encodeRedirectURL("/index");
//
//    }







}
