package com.example.mybatisplus.export.writemodels;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

/**
 * @Description : 导出国家Excel数据集
 * @Author : huzhiting
 * @Date: 2020-03-24 18:11
 */
@Data
public class CountryWriteModel extends BaseRowModel {

    @ExcelProperty(value = "编码", index = 0)
    private String code;

    @ExcelProperty(value = "名称", index = 1)
    private String name;

    @ExcelProperty(value = "所属洲", index = 2)
    private String continent;

    @ExcelProperty(value = "所属地区", index = 3)
    private String region;

    @ExcelProperty(value = "人口", index = 4)
    private Integer population;

}
