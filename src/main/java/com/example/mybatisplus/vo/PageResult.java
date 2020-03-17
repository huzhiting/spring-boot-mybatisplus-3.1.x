package com.example.mybatisplus.vo;

import lombok.Data;

import java.util.List;

/**
 * 分页返回对象
 * @param <T>
 */
@Data
public class PageResult<T> {
    private Long total;
    private List<T> items;
}
