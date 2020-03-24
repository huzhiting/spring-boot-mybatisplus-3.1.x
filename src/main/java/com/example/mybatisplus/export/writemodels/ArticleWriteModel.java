package com.example.mybatisplus.export.writemodels;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

/**
 * @Description : 导出文章Excel数据集
 * @Author : huzhiting
 * @Date: 2020-03-24 18:12
 */
@Data
public class ArticleWriteModel extends BaseRowModel {


    @ExcelProperty(value = "编号", index = 0)
    private Long id;

    @ExcelProperty(value = "编码", index = 1)
    private String code;

    @ExcelProperty(value = "标题", index = 2)
    private String title;

    @ExcelProperty(value = "关键字", index = 3)
    private String keywords;

    @ExcelProperty(value = "作者", index = 4)
    private String author;

    @ExcelProperty(value = "发布时间", index = 5)
    private String publishTime;

}
