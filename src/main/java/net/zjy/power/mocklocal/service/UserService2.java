package net.zjy.power.mocklocal.service;

import net.zjy.power.mocklocal.dao.UserDao2;
import net.zjy.power.mocklocal.entity.User2;

/**
 * @description:
 * @author:@zhujinyu
 * @date:2021-04-06 19:44
 */
public class UserService2 {


    public int queryCount() {
        UserDao2 userDao2=new UserDao2();
        return userDao2.queryCount();
    }

    public void insertUser(User2 user2) {
        UserDao2 userDao2=new UserDao2();
        userDao2.insertUser(user2);
    }


}
