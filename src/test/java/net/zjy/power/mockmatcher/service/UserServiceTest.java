package net.zjy.power.mockmatcher.service;

import net.zjy.power.mockmatcher.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.PipedWriter;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;

/**
 * @description: matcher 匹配 mock + answer
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

    @Test
    public void testQueryByNameForAnswer() throws Exception {

        UserDao uDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withNoArguments().thenReturn(uDao);

        // 这边使用的是 answer,对于查询的值,mock出期望的返回值
        PowerMockito.when(uDao.queryByUserName(Mockito.anyString())).then(invocation->{
            String username = (String)invocation.getArgument(0);
            switch (username){
                case "jack":
                    return "i am jack";
                case "tom":
                    return "i am tom";
                default:
                    throw new RuntimeException();
            }
        });

        UserService userService = new UserService();
        String result = userService.queryByName("jack");

        assertEquals("i am jack",result);
        String result2 = userService.queryByName("tom");
        assertEquals("i am tom",result2);

        try {
            String tony = userService.queryByName("tony");
            fail("never execute here");
        }catch (Exception e){
            assertTrue(e instanceof RuntimeException);
        }


    }



}