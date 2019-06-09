package com.example.mpdemo.mapper;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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
     * 【重点】User类里面有个Role类，看mybatis如何实现一对一关联
     */
    @Test
    public void testBatchTable(){
        //方法一，在SQL里使用别名
        List<User> users = userMapper.selectUserAndRole();
        log.info("第一次查询结果: {}", users);
        log.info("第一次查询结果,数据大小:{}", users.size());

        //方法二，在resultMap里使用标签association
        List<User> userList = userMapper.selectUserByResultMap();
        log.info("第二次查询结果: {}", userList);
        log.info("第二次查询结果,数据大小:{}", userList.size());
    }

    /**
     * 测试一对多关联关系
     */
    @Test
    public void testOne2Many(){
        //在resultMap里使用collection
        UserVO userVO = userMapper.selectBatchRoleUser(3);
        log.info(userVO.toString());
    }

    @Test
    public void testUpdateColumu(){
        //方法一,先查询后更新
//        User users = userMapper.selectById(4);
//        log.info(users.toString());
//        users.setPassword("ppp");
//        users.setCreateTime(new Date());
//        users.setPhone(null);
//        userMapper.updateById(users);

        //直接new一个对象,然后使用eq方法作为更新的的where条件
        User user = new User();
        user.setPhone("11111111111111");
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
//        updateWrapper.set("phone", "kkkkk");    //当实体和UpdateWrapper都有set相同的字段时,UpdateWrapper的优先级更高
        updateWrapper.eq("userId", 5);
        int update = userMapper.update(user, updateWrapper);
        log.info(user.toString());
    }
}
