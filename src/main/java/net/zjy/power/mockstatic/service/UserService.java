package net.zjy.power.mockstatic.service;


import net.zjy.power.mocklocal.entity.User;
import net.zjy.power.mockstatic.dao.UserDao;

/**
 * @description:
 * @author:@zhujinyu
 * @date:2021-04-06 19:44
 */
public class UserService {



    public int queryCount() {
        return UserDao.queryCount();
    }

    public void insertUser(User user) {
        UserDao.insertUser(user);
    }


}
