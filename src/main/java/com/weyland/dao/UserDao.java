package com.weyland.dao;

import com.weyland.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Dell on 2017-5-22.
 */

public interface UserDao extends JpaRepository<User,Integer> {

    /**
     * 通过账户名查找
     * @param queryString
     * @return
     */
    //此处编译错误请无视，能正常工作
    @Query("select u from User u where u.userAccount like %:queryString% " +
            "or u.userName like %:queryString%")
    List<User> findUser(@Param("queryString") String queryString);

    /**
     * 通过用户名查找
     * @param userAccount
     * @return
     */
    @Query("select u from User u where u.userAccount =:userAccount")
    User findByUserAccount(@Param("userAccount") String userAccount);

    /**
     * 通过用户名查找
     * @param userName
     * @return
     */
    List<User> findByUserName(String userName);

    /**
     * 通过电子邮箱查找
     * @param userEmail
     * @return
     */
    List<User> findByUserEmail(String userEmail);

    /**
     * 通过性别查找
     * @param userGender
     * @return
     */
    List<User> findByUserGender(String userGender);

    /**
     * 通过帐号和电子邮箱找回
     * @param userAccount
     * @param userEmail
     * @return
     */
    List<User> findByUserAccountAndUserEmail(String userAccount, String userEmail);




}
