package com.brtpawn.mpps.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户实体对应表 user
 * </p>
 *
 * @author hubin
 * @version 1.0
 * @since 1.0
 */
@Data
@TableName("mpps_user")
public class User {

    private Long id;
    private String userName;
    private Integer age;
    private String email;

    @TableField(exist = false)
    private Integer count;
}
