package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.mybatisplus.entity.IdGenerator;
import com.example.mybatisplus.mapper.IdGeneratorMapper;
import com.example.mybatisplus.service.IIdGeneratorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author huzhiting
 * @since 2020-04-20
 */
@Service
public class IdGeneratorServiceImpl extends ServiceImpl<IdGeneratorMapper, IdGenerator> implements IIdGeneratorService {

    /**
     * 批次个数
     */
    private static final Integer BATCH_SIZE = 100;

    /**
     * 重试次数
     */
    private static final Integer TRY_TIMES = 5;

    @Resource
    private IdGeneratorMapper idGeneratorMapper;

    @Override
    public List<Long> generateSerialId(Integer type) {
        List<Long> idList = new ArrayList<>();
        for (int i = 0; i < BATCH_SIZE; i++) {
            Long id = generateId(type);
            idList.add(id);
        }
        return idList;
    }

    @Transactional
    @Override
    public Long generateId(Integer type) {
        //可能失败，需要重试
        for (int i = 0; i < TRY_TIMES; i++) {
            QueryWrapper<IdGenerator> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().eq(IdGenerator::getBizType,type);
            IdGenerator idGenerator = idGeneratorMapper.selectOne(queryWrapper);
            if (idGenerator == null) {
                try {
                    idGenerator = new IdGenerator().setBizType(0).setMaxId(1L).setStep(2).setVersion(0);
                    idGeneratorMapper.insert(idGenerator);
                    return idGenerator.getMaxId();
                } catch (Exception e) {
                    log.error("失败了");
                }
            } else {
                try {
                    Long oldMax =idGenerator.getMaxId();
                    Long newMax = oldMax + idGenerator.getStep();
                    LambdaUpdateWrapper<IdGenerator> updateWrapper = new LambdaUpdateWrapper<>();
                    updateWrapper.eq(IdGenerator::getBizType,type).eq(IdGenerator::getVersion,idGenerator.getVersion()).eq(IdGenerator::getMaxId,oldMax);
                    idGenerator.setMaxId(newMax);
                    idGenerator.setVersion(idGenerator.getVersion() + 1);
                    int row = idGeneratorMapper.update(idGenerator, updateWrapper);
                    if(row == 1){
                        return idGenerator.getMaxId();
                    }else{
                        log.error("失败了");
                    }
                } catch (Exception e) {
                    log.error("失败了");
                }

            }
        }
        return null;
    }

}
