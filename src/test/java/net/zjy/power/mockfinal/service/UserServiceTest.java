package net.zjy.power.mockfinal.service;

import net.zjy.power.mockfinal.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

/**
 * @description: powermock   final 测试
 * @author:@zhujinyu
 * @date:2021-04-07 15:31
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class,UserDao.class}) //final类 需要写在注解中
public class UserServiceTest {

    @Test
    public void queryCount() {
        UserDao uDao = PowerMockito.mock(UserDao.class);
        PowerMockito.when(uDao.queryCount()).thenReturn(10);
        UserService userService = new UserService(uDao);
        int result = userService.queryCount();
        assertEquals(10,result);
    }
}