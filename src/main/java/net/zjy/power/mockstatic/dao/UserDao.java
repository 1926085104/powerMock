package net.zjy.power.mockstatic.dao;

import net.zjy.power.mocklocal.entity.User;

/**
 * @description: 静态方法
 * @author:@zhujinyu
 * @date:2021-04-06 19:42
 */
public class UserDao {

    public static int queryCount(){
        throw new UnsupportedOperationException("模拟查询失败");
    }

    public static void insertUser(User user){
        throw new UnsupportedOperationException("模拟新增失败");
    }


}
