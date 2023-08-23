package com.brtpawn.mpps.service.impl;


import com.brtpawn.mpps.annotation.DataSource;
import com.brtpawn.mpps.enums.DataSourceEnum;
import com.brtpawn.mpps.multiple.DataSourceContextHolder;
import com.brtpawn.mpps.entity.User;
import com.brtpawn.mpps.mapper.UserMapper;
import com.brtpawn.mpps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息服务的实现类
 * </p>
 *
 * @author liulingxian
 * @version 1.0
 * @since 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User queryUserById(Integer id){
        DataSourceContextHolder.setDataSource(DataSourceEnum.db1);
        return userMapper.selectById(id);
    };

    @Override
    @DataSource(DataSourceEnum.db2)
    public User queryUserByPKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    @DataSource(DataSourceEnum.db1)
    public User queryUserByPID(Integer id) {
        return userMapper.selectByPrimaryId(id);
    }
}