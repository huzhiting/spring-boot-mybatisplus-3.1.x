package com.example.mybatisplus.service;

import com.example.mybatisplus.entity.IdGenerator;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huzhiting
 * @since 2020-04-20
 */
public interface IIdGeneratorService extends IService<IdGenerator> {

    /**
     * 生成批次id
     * @param type
     * @return
     */
    List<Long> generateSerialId(Integer type);

    /**
     * 生成id
     * @param type
     * @return
     */
    Long generateId(Integer type);

}
