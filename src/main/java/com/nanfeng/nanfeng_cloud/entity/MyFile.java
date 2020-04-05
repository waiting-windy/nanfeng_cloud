package com.nanfeng.nanfeng_cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (MyFile)文件实体类
 */
@AllArgsConstructor
@Data
@Builder
public class MyFile implements Serializable {
    /**
    * 文件ID
    */
    private Integer myFileId;
    /**
    * 文件名
    */
    private String myFileName;
    /**
    * 文件仓库ID
    */
    private Integer fileStoreId;
    /**
    * 文件存储路径
    */
    private String myFilePath;
    /**
    * 下载次数
    */
    private Integer downloadTime;
    /**
    * 上传时间
    */
    private Date uploadTime;
    /**
    * 父文件夹ID
    */
    private Integer parentFolderId;
    /**
    * 文件大小
    */
    private Integer size;
    /**
    * 文件类型
    */
    private Integer type;
    /**
    * 文件后缀
    */
    private String postfix;

}
