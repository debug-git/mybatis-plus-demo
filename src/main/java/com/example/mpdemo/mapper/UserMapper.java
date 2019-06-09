package com.example.mpdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mpdemo.vo.UserVO;
import com.example.mpdemo.entity.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    /**
     * 实现一对一关联的第一种方式,在Role使用别名  role.id 和 role.name
     * @return
     */
    List<User> selectUserAndRole();

    /**
     * 实现一对一关联的第二种方式,,使用association
     * @return
     */
    List<User> selectUserByResultMap();

    UserVO selectBatchRoleUser(int userId);

    Page<User> selectByPage(IPage page);
}
