package com.example.mybatisplus.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 文章表
 * </p>
 *
 * @author huzhiting
 * @since 2019-06-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Long id;

    /**
     * 栏目id
     */
    private Long catId;

    /**
     * 文章编码
     */
    private String code;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 子标题
     */
    private String childTitle;

    /**
     * 扩展标题
     */
    private String expendTitle;

    /**
     * 关键字
     */
    private String keywords;

    /**
     * 描述
     */
    private String description;

    /**
     * 作者
     */
    private String author;

    /**
     * 外部链接
     */
    private String extLink;

    /**
     * 内容
     */
    private String content;

    /**
     * 站点编码
     */
    private String site;

    /**
     * 状态：0-启用；1-禁用
     */
    private Integer status;

    /**
     * 访问量
     */
    private Long visits;

    /**
     * 发布时间
     */
    private LocalDateTime publishTime;

    /**
     * 下架时间
     */
    private LocalDateTime offlineTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除
     */
    private Integer isDeleted;

    /**
     * 创建人
     */
    private Long createBy;

    /**
     * 更新人
     */
    private Long updateBy;


}
