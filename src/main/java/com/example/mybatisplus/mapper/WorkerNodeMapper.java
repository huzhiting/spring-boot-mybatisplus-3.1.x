package com.example.mybatisplus.mapper;

import com.example.mybatisplus.entity.WorkerNode;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * DB WorkerID Assigner for UID Generator Mapper 接口
 * </p>
 *
 * @author huzhiting
 * @since 2020-04-23
 */
public interface WorkerNodeMapper extends BaseMapper<WorkerNode> {
    /**
     * Get {@link WorkerNode} by node host
     *
     * @param host
     * @param port
     * @return
     */
    WorkerNode getWorkerNodeByHostPort(@Param("host") String host, @Param("port") String port);

    /**
     * Add {@link WorkerNode}
     *
     * @param workerNodeEntity
     */
    void addWorkerNode(WorkerNode workerNodeEntity);

}
