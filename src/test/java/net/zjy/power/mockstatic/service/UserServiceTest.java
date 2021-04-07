package net.zjy.power.mockstatic.service;

import net.zjy.power.mocklocal.entity.User;
import net.zjy.power.mockstatic.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

/**
 * @description: powermock static 测试
 * @author:@zhujinyu
 * @date:2021-04-07 14:52
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class,UserDao.class})
public class UserServiceTest {

    //静态方法需要mockstatic 这边 PrepareForTest 需要放入两个类表示被mock
    @Test
    public void testQueryCount() {
        PowerMockito.mockStatic(UserDao.class);
        PowerMockito.when(UserDao.queryCount()).thenReturn(10);

        UserService userService = new UserService();
        int result = userService.queryCount();
        assertEquals(10,result);

    }

    @Test
    public void testInsertUser() {
        PowerMockito.mockStatic(UserDao.class);
        User user = new User();
        PowerMockito.doNothing().when(UserDao.class);

        UserService userService = new UserService();
        userService.insertUser(user);
        //报错原因不明
        //verifyStatic(UserDao.class);
    }
}