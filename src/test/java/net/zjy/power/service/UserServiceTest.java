package net.zjy.power.service;

import net.zjy.power.dao.UserDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.PowerMockUtils;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

/**
 * @description:
 * @author:@zhujinyu
 * @date:2021-04-06 19:47
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserDao.class)
public class UserServiceTest {

    private UserService userService;

    @Mock
    private UserDao userDao;

    //junit 调用..
    @Before
    public void setBefore() {
        userService = new UserService(new UserDao());
    }


    @Test
    public void testQueryCountPowerMock() {
        PowerMockito.when(userDao.queryCount()).thenReturn(10);
        userService=new UserService(userDao);
        int count = userService.queryCount();
        assertEquals(10,count);

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