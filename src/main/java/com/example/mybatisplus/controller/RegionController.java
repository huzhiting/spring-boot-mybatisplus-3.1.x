package com.example.mybatisplus.controller;


import com.example.mybatisplus.entity.Region;
import com.example.mybatisplus.service.IRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huzhiting
 * @since 2019-06-03
 */
@RestController
@RequestMapping("/region")
public class RegionController {

    @Autowired
    private IRegionService regionService;

    @RequestMapping("/all")
    public List<Region> getAllRegions(){
        List<Region> regionList=regionService.getAllRegions();
        return regionList;
    }

    @RequestMapping("/search")
    public List<Region> searchRegions(@RequestBody Region region){
        List<Region> regionList=regionService.searchRegions(region);
        return regionList;
    }

}
