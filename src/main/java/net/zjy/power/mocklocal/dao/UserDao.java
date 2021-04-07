package net.zjy.power.mocklocal.dao;

import net.zjy.power.mocklocal.entity.User;

/**
 * @description:
 * @author:@zhujinyu
 * @date:2021-04-06 19:42
 */
public class UserDao {

    public int queryCount(){
        throw new UnsupportedOperationException("模拟查询失败");
    }

    public void insertUser(User user){
        throw new UnsupportedOperationException("模拟新增失败");
    }


}
