package com.example.mybatisplus.service;

import com.example.mybatisplus.entity.Region;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huzhiting
 * @since 2019-06-03
 */
public interface IRegionService extends IService<Region> {

    List<Region> getAllRegions();

    List<Region> searchRegions(Region region);
}
