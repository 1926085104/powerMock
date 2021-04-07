package net.zjy.power.mockverify.service;


import net.zjy.power.mocklocal.entity.User;
import net.zjy.power.mockverify.dao.UserDao;

/**
 * @description:
 * @author:@zhujinyu
 * @date:2021-04-06 19:44
 */
public class UserService {


    public void insertUser(User user) {
        UserDao userDao = new UserDao();
        if (userDao.queryCount() > 0) {
            userDao.updateUser(user);
        }else {
            userDao.insertUser(user);
        }
    }


}
