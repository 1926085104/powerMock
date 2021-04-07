package net.zjy.power.mockfinal.dao;

import net.zjy.power.mocklocal.entity.User;

/**
 * @description: 此类被 final修饰
 * @author:@zhujinyu
 * @date:2021-04-06 19:42
 */
final public class UserDao {

    public int queryCount(){
        throw new UnsupportedOperationException("模拟查询失败");
    }

    public void insertUser(User user){
        throw new UnsupportedOperationException("模拟新增失败");
    }


}
