package com.weyland.controller;

import com.weyland.domain.User;
import com.weyland.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by Dell on 2017-5-22.
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/addUser")
    public User addUserAct(User user){

        return userService.register(user);

    }

    @PostMapping(value="/queryUser")
    public List<User> QueryUserAct(String userAccount){

        return userService.queryUser(userAccount);

    }

    @RequestMapping(value = "/fuck",method = RequestMethod.GET)
    public String say(){
        return "index";
    }


    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("hello", "hello Thymeleaf!");
        return "hello";
    }

    @RequestMapping("/query")
    public String register(Model model,String queryString){

        List<User> userList=userService.queryUser(queryString);
        model.addAttribute("userList",userList);
        model.addAttribute("queryString",queryString);
        return "query";

    }



}
