package net.zjy.power.mockSpy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

/**
 * @description: spy mock出来的对象 是会 真实调用 它的方法的
 * spy 有是什么用呢？ 如果是符合 断言条件的，会调用mock,如果不符合,则会走真实的方法
 * @author:@zhujinyu
 * @date:2021-04-08 20:44
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService.class)
public class UserServiceTest {

    @Test
    public void testFoo() throws Exception{
        //这边  不会真实调用 不打印
//        UserService userService = PowerMockito.mock(UserService.class);
//        userService.foo();

        //这边会真实调用
        UserService userService = PowerMockito.spy(new UserService());
        userService.foo();

        // spy 有是什么用呢？ 如果是符合 断言条件的，会调用mock,如果不符合,则会走真实的方法
        String userName="jack";
        PowerMockito.doNothing().when(userService).foo(userName);

        userService.foo(userName);//这句不打印,走mock
        userService.foo("jerry");//这句会打印,走真实方法
    }


    @Test
    public void testCheck() throws Exception{

        //这边会真实调用
        UserService userService = PowerMockito.spy(new UserService());

        // spy 有是什么用呢？ 如果是符合 断言条件的，会调用mock,如果不符合,则会走真实的方法
        String userName="jack";

        //when(...) thenReturn(...)会调用真实的方法，如果你不想调用真实的方法而是想要mock的话，就不要使用这个方法。
        //doReturn(...) when(...) 不会调用真实方法  这边因为方法异常 不调用真实方法
        PowerMockito.doReturn(true).when(userService,"checkUserName",userName);

        //这边需要 加一下powermock的注解
        boolean exists = userService.exists(userName);
        assertTrue(exists);

        //这边 没有按照期望的走 则会调用很是方法,会报错 先注释掉了
        //userService.exists("tony");


    }



}