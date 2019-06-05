package com.example.mpdemo.service.impl;

import com.example.mpdemo.entity.UserRole;
import com.example.mpdemo.mapper.UserRoleMapper;
import com.example.mpdemo.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户-角色关联表 服务实现类
 * </p>
 *
 * @author mybatis-plus
 * @since 2019-06-05
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
