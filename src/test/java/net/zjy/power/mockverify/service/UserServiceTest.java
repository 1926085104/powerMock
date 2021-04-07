package net.zjy.power.mockverify.service;

import net.zjy.power.mocklocal.entity.User;
import net.zjy.power.mockverify.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

/**
 * @description: verify 測試
 * @author:@zhujinyu
 * @date:2021-04-07 16:34
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class})
public class UserServiceTest {

    @Test
    public void testInsertUserWithNoUser() throws Exception {
        User user = new User();
        //模拟new
        UserDao uDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(uDao);
        //模拟count查询
        PowerMockito.when(uDao.queryCount()).thenReturn(0);

        UserService userService = new UserService();
        userService.insertUser(user);

        //按逻辑最终调用insert方法，不调用update方法
        Mockito.verify(uDao).insertUser(user);
        Mockito.verify(uDao,Mockito.never()).updateUser(user);
    }

    @Test
    public void testInsertUserWithHasUser() throws Exception {
        User user = new User();
        //模拟new
        UserDao uDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(uDao);
        //模拟count查询
        PowerMockito.when(uDao.queryCount()).thenReturn(1);

        UserService userService = new UserService();
        userService.insertUser(user);

        //按逻辑最终调用update方法，不调用insert方法
        Mockito.verify(uDao,Mockito.never()).insertUser(user);
        Mockito.verify(uDao).updateUser(user);
    }
}