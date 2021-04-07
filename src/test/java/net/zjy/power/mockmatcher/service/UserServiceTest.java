package net.zjy.power.mockmatcher.service;

import net.zjy.power.mockmatcher.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.PipedWriter;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;

/**
 * @description: matcher匹配mock
 * @author:@zhujinyu
 * @date:2021-04-07 20:04
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService.class)
public class UserServiceTest {

    @Test
    public void testQueryByName() throws Exception {

        UserDao uDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withNoArguments().thenReturn(uDao);
        //任何字符串查询时都返回 zjy
        PowerMockito.when(uDao.queryByUserName(ArgumentMatchers.anyString())).thenReturn("zjy");

        UserService userService = new UserService();
        //随便输入一个字符串查询
        String jack = userService.queryByName("jack");
        assertEquals("zjy",jack);

//        PowerMockito.when(uDao.queryByUserName("jack2")).thenReturn("zjy2");
//        String jack2 = userService.queryByName("jack2");
//        assertEquals("zjy2",jack2);




    }
}