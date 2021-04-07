package net.zjy.power.mockconstruct.service;

import net.zjy.power.mockconstruct.dao.UserDao;

/**
 * @description:
 * @author:@zhujinyu
 * @date:2021-04-07 19:39
 */
public class UserService {

    public void insert(String username,String password){
        UserDao userDao = new UserDao(username, password);
        userDao.insert(username,password);

    }

}
