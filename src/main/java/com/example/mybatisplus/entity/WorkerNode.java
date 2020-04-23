package com.example.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;

import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * DB WorkerID Assigner for UID Generator
 * </p>
 *
 * @author huzhiting
 * @since 2020-04-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WorkerNode implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * auto increment id
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * host name
     */
    @TableField("HOST_NAME")
    private String hostName;

    /**
     * port
     */
    @TableField("PORT")
    private String port;

    /**
     * node type: ACTUAL or CONTAINER
     */
    @TableField("TYPE")
    private Integer type;

    /**
     * launch date
     */
    @TableField("LAUNCH_DATE")
    private LocalDate launchDate;

    /**
     * modified time
     */
    @TableField("MODIFIED")
    private LocalDateTime modified;

    /**
     * created time
     */
    @TableField("CREATED")
    private LocalDateTime created;


}
