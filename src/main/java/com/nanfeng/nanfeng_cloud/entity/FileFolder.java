package com.nanfeng.nanfeng_cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (FileFolder)文件夹实体类
 */
@AllArgsConstructor
@Data
@Builder
public class FileFolder implements Serializable {

    /**
    * 文件夹ID
    */
    private Integer fileFolderId;
    /**
    * 文件夹名称
    */
    private String fileFolderName;
    /**
    * 父文件夹ID
    */
    private Integer parentFolderId;
    /**
    * 所属文件仓库ID
    */
    private Integer fileStoreId;
    /**
    * 创建时间
    */
    private Date time;

}
