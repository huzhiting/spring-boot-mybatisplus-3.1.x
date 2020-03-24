package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.entity.Country;
import com.example.mybatisplus.mapper.CountryMapper;
import com.example.mybatisplus.service.ICountryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huzhiting
 * @since 2020-03-24
 */
@Service
public class CountryServiceImpl extends ServiceImpl<CountryMapper, Country> implements ICountryService {

}
