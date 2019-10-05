package com.bo.service;

import com.bo.entity.User;
import com.bo.utils.Md5Util;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * @author suyuxi
 * @className UserService
 * @Description TODO
 * @Date 2019/9/26
 * @Version 1.0
 **/
public class UserService {
    private List<User> userList;

    /**
     * @return List<User>
     * @Description
     **/

    public void setUserList(List<User> userList){
        this.userList = userList;
    }


    /**
     * @param account
     * @return
     * @Description
     */
    public User signIn(String account, String password) {
        for (User user : userList) {
            if (user.getAccount().equals(account) && user.getPassword().equals(Md5Util.crypt(password))) {
                return user;
            }
        }
        return null;
    }
}
