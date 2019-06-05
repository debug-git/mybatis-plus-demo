package com.example.mpdemo.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.mpdemo.entity.City;
import com.example.mpdemo.entity.User;
import com.example.mpdemo.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@MapperScan("com.example.mpdemo.mapper")
@SpringBootTest
public class TestUserMapper {
    @Autowired
    UserMapper userMapper;
    @Autowired
    CityMapper cityMapper;

    /**
     * 测试mybatis-plus的条件构造器
     */
    @Test
    public void testSelect(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(2, 3, 4));
        System.out.println(users);
//
//        QueryWrapper<City> queryWrapper = new QueryWrapper<>();
//        queryWrapper
//                .eq("city", "1101");
//        City city = cityMapper.selectOne(queryWrapper);
//        System.out.println(city);

    }

    /**
     * 测试多表查询
     * 【重点】User类里面有个Role类，看mybatis如何实现一对多关联
     */
    @Test
    public void testBatchTable(){
        List<User> users = userMapper.selectUserAndRole();
        log.info("第一次查询结果: {}", users);

        List<User> userList = userMapper.selectUserByResultMap();
        log.info("第二次查询结果: {}", userList);
    }

    /**
     * 测试一对多关联关系
     */
    @Test
    public void testOne2Many(){
        UserVO userVO = userMapper.selectBatchRoleUser(3);
        log.info(userVO.toString());
    }
}
