package com.example.mpdemo.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.example.mpdemo.entity.Role;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserVO {
    private static final long serialVersionUID = 1L;

    @TableId(value = "userId", type = IdType.AUTO)
    private Integer userId;

    @TableField("userName")
    private String userName;

    private String password;

    private String phone;

    @TableField("modifyTime")
    private Date modifyTime;

    @TableField("createTime")
    private Date createTime;

    private List<Role> role;
}
