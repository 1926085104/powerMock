package net.zjy.power.mocklocal.service;

import net.zjy.power.mocklocal.dao.UserDao;
import net.zjy.power.mocklocal.dao.UserDao2;
import net.zjy.power.mocklocal.entity.User;
import net.zjy.power.mocklocal.entity.User2;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.doNothing;
import static org.powermock.api.mockito.PowerMockito.mock;

/**
 * @description:
 * @author:@zhujinyu
 * @date:2021-04-06 19:47
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class, UserService2.class})
public class UserServiceTest {

    private UserService userService;


    @Mock
    private UserDao userDao;

    @Mock
    private UserDao2 userDao2;

    //junit 调用..
    @Before
    public void setBefore() {
        userService = new UserService(new UserDao());
    }

    //局部 dao 测试,现在基本看不到了
    @Test
    public void testInsertUserPowerMockNoSug() {
        try {
            UserService2 userService2 = new UserService2();

            User2 user2 = new User2();
            //模拟 new一个对象, 调用方法什么都不做
            UserDao2 userDao2mock = mock(UserDao2.class);
            PowerMockito.whenNew(UserDao2.class).withAnyArguments().thenReturn(userDao2mock);
            doNothing().when(userDao2mock).insertUser(user2);
            userService2.insertUser(user2);
            //判断这个方法有没有被真实调用 1次
            Mockito.verify(userDao2mock, Mockito.times(1)).insertUser(user2);
        } catch (Throwable e) {
            fail();
        }

    }

    //无参数返回 powerMock
    @Test
    public void testInsertUserPowerMock() {
        UserDao uDao = mock(UserDao.class);

        User user = new User();
        PowerMockito.doNothing().when(uDao).insertUser(user);

        UserService userService = new UserService(uDao);
        userService.insertUser(user);

        Mockito.verify(uDao).insertUser(user);
    }

    @Test
    public void testQueryCountPowerMock() {
        PowerMockito.when(userDao.queryCount()).thenReturn(10);
        userService = new UserService(userDao);
        int count = userService.queryCount();
        assertEquals(10, count);

    }


    /**
     * mockito 使用
     */
    @Test
    public void testQueryCountMockito() {
        MockitoAnnotations.initMocks(this);
        //调用queryCount 模拟返回10
        Mockito.when(userDao.queryCount()).thenReturn(10);
        // 两者等价  Mockito.doReturn(10).when(userDao).queryCount();
        userService = new UserService(userDao);
        int count = userService.queryCount();
        assertEquals(10, count);
    }


}