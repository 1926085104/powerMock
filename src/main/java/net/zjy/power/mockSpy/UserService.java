package net.zjy.power.mockSpy;

/**
 * @description: spy测试私有方法
 * @author:@zhujinyu
 * @date:2021-04-08 20:42
 */
public class UserService {

    public void foo(){
        log();
    }

    public void foo(String userName){
        log();
    }

    private void log(){
        System.out.println("i am log");
    }

    //这边模拟一个私有方法，假设私有方法很重不好拆分
    public boolean exists(String userName){
        return checkUserName(userName);
    }

    private boolean checkUserName(String userName) {
        throw new UnsupportedOperationException();
    }

}
