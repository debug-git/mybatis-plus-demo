package com.example.mpdemo.service.impl;

import com.example.mpdemo.entity.Role;
import com.example.mpdemo.mapper.RoleMapper;
import com.example.mpdemo.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author mybatis-plus
 * @since 2019-06-05
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
