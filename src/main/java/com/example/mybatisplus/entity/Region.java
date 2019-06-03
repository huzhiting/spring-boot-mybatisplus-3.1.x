package com.example.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;


/**
 * <p>
 *
 * </p>
 *
 * @author huzhiting
 * @since 2019-06-03
 */
@Data
@TableName("region")
public class Region implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 主键id
    */
    private Long regionId;

    private String city;

    private String province;

}
