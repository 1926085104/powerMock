package net.zjy.power.mockconstruct.service;

import net.zjy.power.mockconstruct.dao.UserDao;
import net.zjy.power.mocklocal.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

/**
 * @description: 构造方法mock
 * @author:@zhujinyu
 * @date:2021-04-07 19:41
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService.class)
public class UserServiceTest {

    //
    @Test
    public void testInsert() throws Exception {

        String userName="zjy";
        String password="12345";

        //模拟构造方法
        UserDao uDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withArguments(userName,password).thenReturn(uDao);

        UserService userService = new UserService();
        userService.insert(userName,password);
        //最终调用了uDao的方法
        Mockito.verify(uDao).insert(userName,password);

    }
}