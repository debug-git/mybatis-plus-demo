package com.example.mpdemo.service.impl;

import com.example.mpdemo.entity.City;
import com.example.mpdemo.mapper.CityMapper;
import com.example.mpdemo.service.ICityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 全国身份证地区编码 服务实现类
 * </p>
 *
 * @author mybatis-plus
 * @since 2019-06-04
 */
@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements ICityService {

}
