package com.brtpawn.mpps.service;


import com.brtpawn.mpps.entity.User;
/**
 * <p>
 * 用户信息服务的接口类
 * </p>
 *
 * @author liulingxian
 * @version 1.0
 * @since 1.0
 */
public interface UserService {
    User queryUserById(Integer id);
    User queryUserByPKey(Integer id);
    User queryUserByPID(Integer id);
}