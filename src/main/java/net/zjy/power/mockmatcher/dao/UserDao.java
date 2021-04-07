package net.zjy.power.mockmatcher.dao;

/**
 * @description:模拟构造注入
 * @author:@zhujinyu
 * @date:2021-04-07 19:36
 */
public class UserDao {

    private String userName;
    private String password;

    public UserDao() {

    }

    public UserDao(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public void insert(String userName,String password){
        throw new UnsupportedOperationException("抛出异常...");
    }


    public String queryByUserName(String userName){
        return "111";
    }

}
