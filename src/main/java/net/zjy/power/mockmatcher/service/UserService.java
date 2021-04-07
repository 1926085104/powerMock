package net.zjy.power.mockmatcher.service;

import net.zjy.power.mockmatcher.dao.UserDao;

/**
 * @description:
 * @author:@zhujinyu
 * @date:2021-04-07 19:39
 */
public class UserService {

    public String queryByName(String username){
        UserDao userDao = new UserDao();
        return userDao.queryByUserName(username);
    }

}
