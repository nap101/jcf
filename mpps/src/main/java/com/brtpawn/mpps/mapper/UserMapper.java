package com.brtpawn.mpps.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.brtpawn.mpps.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * <p>
 * MyBatis Plus使用的示例(既有继承BaseMapper的数据操作方法，也有自己扩展的类)
 * </p>
 *
 * @author liulingxian
 * @version 1.0
 * @since 1.0
 *
 */
@Component
public interface UserMapper extends BaseMapper<User> {

     User selectByPrimaryKey(Integer id);

    @Select("SELECT id, email, user_name, age from mpps_user where id = #{id,jdbcType=INTEGER}")
    User selectByPrimaryId(Integer id);
}
