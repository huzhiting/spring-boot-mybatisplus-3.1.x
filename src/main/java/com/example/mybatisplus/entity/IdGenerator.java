package com.example.mybatisplus.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author huzhiting
 * @since 2020-04-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class IdGenerator implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 当前最大id
     */
    private Long maxId;

    /**
     * 号段的布长
     */
    private Integer step;

    /**
     * 业务类型
     */
    private Integer bizType;

    /**
     * 版本号
     */
    private Integer version;


}
