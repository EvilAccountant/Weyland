package com.weyland.service;

import com.weyland.dao.UserDao;
import com.weyland.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Dell on 2017-5-23.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User register(User user){

        if(userDao.findByUserAccount(user.getUserAccount())==null){

        return userDao.save(user);

//      return "register complete";

        }else{
//            return "register failed";
              return null;
        }

    }

    public User queryUser(String userAccount){


        return userDao.findByUserAccount(userAccount);

    }
}
