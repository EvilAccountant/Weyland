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

    public String register(User user){

        if(userDao.findByUserAccount(user.getUserAccount())==null){

        userDao.save(user);

        return "success";

        }else{

            return "failed";
        }

    }

    public String login(User user){
        User result=userDao.findByUserAccount(user.getUserAccount());

        if(null!=result){

            if(result.getUserAccount().equals(user.getUserAccount())&&result.getUserPassword().equals(user.getUserPassword())){

                return "success";

            }else{

                return "misMatch";
            }
        }
                return "tan90";
    }

    public List<User> queryUser(String userAccount){

        return userDao.findUser(userAccount);

    }
}
