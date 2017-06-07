package com.weyland.service;

import com.weyland.dao.UserDao;
import com.weyland.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dell on 2017-5-23.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 注册
     * @param user
     * @return
     */
    public String register(User user){
        //判断账户名是否存在
        if(userDao.findByUserAccount(user.getUserAccount())==null){

        userDao.save(user);

        return "success";

        }else{
            return "failed";
        }

    }

    /**
     * 登录验证
     * @param user
     * @return
     */
    public String login(User user){

        User result=userDao.findByUserAccount(user.getUserAccount());

        if(null!=result){

            if(result.getUserAccount().equals(user.getUserAccount())&&result.getUserPassword().equals(user.getUserPassword())){

                return "success";

            }else{

                return "misMatch";
            }
        }
                return "tan90°";
    }

    //根据账户名返回结果
    public List<User> queryUser(String userAccount){

        return userDao.findUser(userAccount);

    }

    //根据性别返回结果
    public List<User> queryUserGender(String userGender){

        return userDao.findByUserGender(userGender);

    }
}
