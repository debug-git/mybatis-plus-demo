package com.example.mpdemo.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.mpdemo.entity.City;
import com.example.mpdemo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@MapperScan("com.example.mpdemo.mapper")
@SpringBootTest
public class TestUserMapper {
    @Autowired
    UserMapper userMapper;
    @Autowired
    CityMapper cityMapper;

    @Test
    public void testSelect(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(2, 3, 4));
        System.out.println(users);

        QueryWrapper<City> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq("city", "1101");
        City city = cityMapper.selectOne(queryWrapper);
        System.out.println(city);
    }
}
