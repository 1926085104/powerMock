package net.zjy.power.service;

import net.zjy.power.dao.UserDao;
import net.zjy.power.entity.User;

/**
 * @description:
 * @author:@zhujinyu
 * @date:2021-04-06 19:44
 */
public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public int queryCount() {
        return userDao.queryCount();
    }

    public void insertUser(User user) {
        userDao.insertUser(user);
    }


}
