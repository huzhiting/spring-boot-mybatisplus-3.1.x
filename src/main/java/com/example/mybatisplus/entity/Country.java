package com.example.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* <p>
* 国家数据表
* </p>
*
* @author huzhiting
* @since 2020-03-24
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("Code")
    private String code;

    @TableField("Name")
    private String name;

    @TableField("Continent")
    private String continent;

    @TableField("Region")
    private String region;

    @TableField("SurfaceArea")
    private Float surfaceArea;

    @TableField("IndepYear")
    private Integer indepYear;

    @TableField("Population")
    private Integer population;

    @TableField("LifeExpectancy")
    private Float lifeExpectancy;

    @TableField("GNP")
    private Float gnp;

    @TableField("GNPOld")
    private Float gNPOld;

    @TableField("LocalName")
    private String localName;

    @TableField("GovernmentForm")
    private String governmentForm;

    @TableField("HeadOfState")
    private String headOfState;

    @TableField("Capital")
    private Integer capital;

    @TableField("Code2")
    private String code2;


}
