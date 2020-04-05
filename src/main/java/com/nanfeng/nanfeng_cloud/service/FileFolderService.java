package com.nanfeng.nanfeng_cloud.service;

import com.nanfeng.nanfeng_cloud.entity.FileFolder;
import com.nanfeng.nanfeng_cloud.entity.MyFile;

import java.util.List;

/**
 * @Description 文件夹业务层接口
 **/
public interface FileFolderService{

    /**
     * @Description 根据文件夹的id获取文件夹
     * @Author  nanfeng
     * @Date  9:41 2020/3/28
     * @Param [fileFolderId]
     * @Return com.nanfeng.nanfeng_cloud.entity.FileFolder
     */
    FileFolder getFileFolderById(Integer fileFolderId);


    /**
     * @Description 根据父文件夹获得所有的文件夹
     * @Author  nanfeng
     * @Date  9:41 2020/3/28
     * @Param [parentFolderId]
     * @Return java.util.List<com.nanfeng.nanfeng_cloud.entity.FileFolder>
     */
    List<FileFolder> getFileFolderByParentFolderId(Integer parentFolderId);

    /**
     * @Description 根据仓库Id获得仓库根目录下的所有文件夹
     * @Author  nanfeng
     * @Date  9:41 2020/3/28
     * @Param [fileStoreId]
     * @Return java.util.List<com.nanfeng.nanfeng_cloud.entity.FileFolder>
     */
    List<FileFolder> getRootFoldersByFileStoreId(Integer fileStoreId);

    /**
     * @Description 根据文件夹的id获取文件下的文件
     * @Author  nanfeng
     * @Date  9:42 2020/3/28
     * @Param [fileFolderId]
     * @Return java.util.List<com.nanfeng.nanfeng_cloud.entity.MyFile>
     */
    List<MyFile> getFileByFileFolder(Integer fileFolderId);

    /**
     * @Description 根据文件夹的id删除文件夹
     * @Author  nanfeng
     * @Date  9:42 2020/3/28
     * @Param [fileFolderId]
     * @Return java.lang.Integer
     */
    Integer deleteFileFolderById(Integer fileFolderId);

    /**
     * @Description 增加文件夹
     * @Author  nanfeng
     * @Date  9:42 2020/3/28
     * @Param [fileFolder]
     * @Return java.lang.Integer
     */
    Integer addFileFolder(FileFolder fileFolder);

    /**
     * @Description 根据文件夹的id修改文件夹信息
     * @Author  nanfeng
     * @Date  9:41 2020/3/28
     * @Param [fileFolder]
     * @Return java.lang.Integer
     */
    Integer updateFileFolderById(FileFolder fileFolder);

}
