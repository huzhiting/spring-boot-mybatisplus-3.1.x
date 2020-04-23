package com.example.mybatisplus.service;

import com.example.mybatisplus.entity.WorkerNode;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * DB WorkerID Assigner for UID Generator 服务类
 * </p>
 *
 * @author huzhiting
 * @since 2020-04-23
 */
public interface IWorkerNodeService extends IService<WorkerNode> {

    long genUid();

}
