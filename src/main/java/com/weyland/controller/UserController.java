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


//    @PostMapping(value = "/addUser")
//    public User addUserAct(User user){
//
//        return userService.register(user);
//
//    }

//    @RequestMapping(value = "/fuck",method = RequestMethod.GET)
//    public String say(){
//        return "index";
//    }

//    @RequestMapping("/")
//    public String index(ModelMap map) {
//        map.addAttribute("hello", "hello Thymeleaf!");
//        return "hello";
//    }

    @RequestMapping("/query")
    public String query(Model model,String queryString){
        //模糊查询
        List<User> userList=userService.queryUser(queryString);
        model.addAttribute("userList",userList);
        model.addAttribute("queryString",queryString);
        return "query";

    }

    //进入注册页面，使用Get请求
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerGet() {
        return "register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String registerPost(Model model,@ModelAttribute(value = "user") User user){
        String result=userService.register(user);

        if(result.equals("success")){
            //注册成功返回登陆页面进行验证
            model.addAttribute("result",result);
            return "login";
        }else {
            //注册失败返回失败信息
            model.addAttribute("result",result);
            return "register";
        }

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGet(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(Model model,@ModelAttribute(value="user") User user){

        String result=userService.login(user);

        if(result.equals("success")){
            //登陆成功跳转至查询页面
            return "query";

        }else if (result.equals("misMatch")){
            //返回账户或密码错误
            model.addAttribute("result",result);
            model.addAttribute("user",user);

            return "login";

        }else {
            //返回账户不存在
            model.addAttribute("result",result);
            model.addAttribute("user",user);
            return "login";
        }


    }




}
