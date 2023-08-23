package com.brtpawn.mpps.controller;

import com.alibaba.fastjson.JSON;
import com.brtpawn.mpps.entity.User;
import com.brtpawn.mpps.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 用户信息服务的控制类
 * </p>
 *
 * @author liulingxian
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @ApiOperation(value = "展示MP(Mybatis-Plus)框架内Maapper的方法，返回是Map")
    @RequestMapping(value ="/getUserInfoMap", method = RequestMethod.GET)
    public Map<String,String> getUserInfoMap(@ApiParam(value = "ID",required = true,defaultValue="1") @RequestParam(value = "id")String id){
        Map map = new HashMap();
        if(StringUtils.isEmpty(id)){
            map.put("msg","ID不能为空");
        }else{
            Integer userId = 0;
            boolean flag=false;
            try{
                userId = Integer.parseInt(id);
                flag = true;
            }catch (Exception e){
                map.put("msg","您输入的不是一个整数");
            }
            if(flag){
                User user= userService.queryUserById(userId);
                if(user==null){
                    map.put("msg","数据不存在");
                }else{
                    map.put("usrname", user.getUserName());
                    map.put("age", String.valueOf(user.getAge()));
                    map.put("email", user.getEmail());
                }
            }
        }
        return map;
    }

    @ApiOperation(value = "展示返回是json串")
    @RequestMapping(value ="/getUserInfo", method = RequestMethod.GET)
    public String getUserInfo(@ApiParam(value = "ID",required = true,defaultValue="1") @RequestParam(value = "id")String id){
        return JSON.toJSONString(getUserInfoMap(id));
    }

    @ApiOperation(value = "展示MP(Mybatis-Plus)框架扩展Maapper的xml方法")
    @RequestMapping(value ="/getUserInfoByPKey", method = RequestMethod.GET)
    public Map<String,String> getUserInfoByPKey(@ApiParam(value = "ID",required = true,defaultValue="1") @RequestParam(value = "id")String id){
        Map map = new HashMap();
        if(StringUtils.isEmpty(id)){
            map.put("msg","ID不能为空");
        }else{
            Integer userId = 0;
            boolean flag=false;
            try{
                userId = Integer.parseInt(id);
                flag = true;
            }catch (Exception e){
                map.put("msg","您输入的不是一个整数");
            }
            if(flag){
                User user= userService.queryUserByPKey(userId);
                if(user==null){
                    map.put("msg","数据不存在");
                }else{
                    map.put("usrname", user.getUserName());
                    map.put("age", String.valueOf(user.getAge()));
                    map.put("email", user.getEmail());
                }
            }
        }
        return map;
    }

    @ApiOperation(value = "展示MP(Mybatis-Plus)框架扩展Maapper上直接用select注解的方法")
    @RequestMapping(value ="/getUserInfoByPID", method = RequestMethod.GET)
    public Map<String,String> getUserInfoByPID(@ApiParam(value = "ID",required = true,defaultValue="1") @RequestParam(value = "id")String id){
        Map map = new HashMap();
        if(StringUtils.isEmpty(id)){
            map.put("msg","ID不能为空");
        }else{
            Integer userId = 0;
            boolean flag=false;
            try{
                userId = Integer.parseInt(id);
                flag = true;
            }catch (Exception e){
                map.put("msg","您输入的不是一个整数");
            }
            if(flag){
                User user= userService.queryUserByPID(userId);
                if(user==null){
                    map.put("msg","数据不存在");
                }else{
                    map.put("usrname", user.getUserName());
                    map.put("age", String.valueOf(user.getAge()));
                    map.put("email", user.getEmail());
                }
            }
        }
        return map;
    }
}
