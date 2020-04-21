package com.example.mybatisplus.controller;


import com.example.mybatisplus.service.IIdGeneratorService;
import com.example.mybatisplus.util.LocalDateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  生成批量id接口
 * </p>
 *
 * @author huzhiting
 * @since 2020-04-20
 */
@RestController
@RequestMapping("/generator")
public class IdGeneratorController {

    private String DATETIME_FORMAT = "yyyyMMdd";

    private Integer SERIAL_NUM = 0;

    @Autowired
    private IIdGeneratorService idGeneratorService;

    /**
     * 格式化，不足6位数，零补齐
     * @param num
     * @return
     */
    private String serialFormat(Integer num){
        return String.format("%06d",num);
    }

    @GetMapping("/serialId")
    public String generatorSerialId(){
        List<Long> serialId = idGeneratorService.generateSerialId(0);
        List<String> idList = new ArrayList<>();
        serialId.forEach(x->{
            StringBuilder idStr = new StringBuilder();
            idStr.append("M").append(LocalDateUtil.formatDate(LocalDateTime.now(),DATETIME_FORMAT)).append(serialFormat(SERIAL_NUM + Integer.parseInt(x.toString())));
            idList.add(idStr.toString());
        });
        return StringUtils.join(idList,",");
    }

}
