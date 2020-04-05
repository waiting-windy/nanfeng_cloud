package com.nanfeng.nanfeng_cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * (FileStore)文件仓库实体类
 */
@AllArgsConstructor
@Data
@Builder
public class FileStore implements Serializable {

    /**
    * 文件仓库ID
    */
    private Integer fileStoreId;
    /**
    * 主人ID
    */
    private Integer userId;
    /**
    * 当前容量（单位KB）
    */
    private Integer currentSize;
    /**
    * 最大容量（单位KB）
    */
    private Integer maxSize;

}
