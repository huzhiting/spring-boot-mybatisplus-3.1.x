package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplus.entity.Region;
import com.example.mybatisplus.mapper.RegionMapper;
import com.example.mybatisplus.service.IRegionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huzhiting
 * @since 2019-06-03
 */
@Service
public class RegionServiceImpl extends ServiceImpl<RegionMapper, Region> implements IRegionService {

    @Autowired
    private RegionMapper regionMapper;

    @Override
    public List<Region> getAllRegions() {
        return regionMapper.selectList(null);
    }

    @Override
    public List<Region> searchRegions(Region region) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.setEntity(region);
        //1. 条件相等
        queryWrapper.eq("city",region.getCity());
        //2. 模糊查询
        queryWrapper.like("city",region.getCity());
        //3. 条件不等于
        queryWrapper.ge("city",region.getCity());
        List<Region> regionList=regionMapper.selectList(queryWrapper);
        return regionList;
    }
}
