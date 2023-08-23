package com.brtpawn.mpps;

import com.brtpawn.mpps.entity.User;
import com.brtpawn.mpps.mapper.UserMapper;
import com.brtpawn.mpps.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 内置 CRUD 演示
 * </p>
 *
 * @author hubin
 * @since 2018-08-11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void testSelect() {
        User user =userService.queryUserById(1);
        System.out.println(user.toString());
    }

    @Test
    public void testPrimaryKeySelect() {
        User user = userService.queryUserByPKey(1);
        if(user!=null){
            System.out.println(user.toString());
        }else{
            System.out.println("数据不存在");
        }
    }

    @Test
    public void testPrimaryIdSelect() {
        User user = userService.queryUserByPID(1);
        if(user!=null){
            System.out.println(user.toString());
        }else{
            System.out.println("数据不存在");
        }
    }

}
