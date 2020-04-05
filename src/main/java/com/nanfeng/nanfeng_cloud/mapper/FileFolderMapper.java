package com.nanfeng.nanfeng_cloud.mapper;

import com.nanfeng.nanfeng_cloud.entity.FileFolder;
import com.nanfeng.nanfeng_cloud.entity.MyFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description: 与文件夹相关的数据库操作
 **/
@Mapper
public interface FileFolderMapper {

    /**
     * @Description 根据文件夹的id获取文件夹
     * @Author  nanfeng
     * @Date  13:15 2020/3/27
     * @Param [fileFolderId]
     * @Return com.nanfeng.nanfeng_cloud.entity.FileFolder
     */
    FileFolder getFileFolderById(Integer fileFolderId);

    /**
     * @Description 根据父文件夹的id获取文件夹
     * @Author  nanfeng
     * @Date  13:15 2020/3/27
     * @Param [parentFolderId]
     * @Return java.util.List<com.nanfeng.nanfeng_cloud.entity.FileFolder>
     */
    List<FileFolder> getFileFolderByParentFolderId(Integer parentFolderId);

    /**
     * @Description 根据仓库的id获取文件夹
     * @Author  nanfeng
     * @Date  13:16 2020/3/27
     * @Param [fileStoreId]
     * @Return java.util.List<com.nanfeng.nanfeng_cloud.entity.FileFolder>
     */
    List<FileFolder> getFileFolderByFileStoreId(Integer fileStoreId);

    /**
     * @Description 根据仓库Id获得仓库根目录下的所有文件夹
     * @Author  nanfeng
     * @Date  13:16 2020/3/27
     * @Param [fileStoreId]
     * @Return java.util.List<com.nanfeng.nanfeng_cloud.entity.FileFolder>
     */
    List<FileFolder> getRootFoldersByFileStoreId(Integer fileStoreId);

    /**
     * @Description 根据文件夹的id获取文件夹下面的文件
     * @Author  nanfeng
     * @Date  13:18 2020/3/27
     * @Param [fileStoreId]
     * @Return java.util.List<com.nanfeng.nanfeng_cloud.entity.MyFile>
     */
    List<MyFile> getFileByFileFolder(Integer fileStoreId);

    /**
     * @Description 根据文件夹的id删除文件夹
     * @Author  nanfeng
     * @Date  13:14 2020/3/27
     * @Param [fileFolderId]
     * @Return java.lang.Integer
     */
    Integer deleteFileFolderById(Integer fileFolderId);

    /**
     * @Description 根据父文件夹的id删除文件夹
     * @Author  nanfeng
     * @Date  13:14 2020/3/27
     * @Param [parentFolderId]
     * @Return java.lang.Integer
     */
    Integer deleteFileFolderByParentFolderId(Integer parentFolderId);

    /**
     * @Description 根据仓库的id删除文件夹
     * @Author  nanfeng
     * @Date  13:15 2020/3/27
     * @Param [fileStoreId]
     * @Return java.lang.Integer
     */
    Integer deleteFileFolderByFileStoreId(Integer fileStoreId);

    /**
     * @Description 增加文件夹
     * @Author  nanfeng
     * @Date  13:15 2020/3/27
     * @Param [fileFolder]
     * @Return java.lang.Integer
     */
    Integer addFileFolder(FileFolder fileFolder);

    /**
     * @Description 根据文件夹的id修改文件夹信息
     * @Author  nanfeng
     * @Date  13:18 2020/3/27
     * @Param [fileFolder]
     * @Return java.lang.Integer
     */
    Integer updateFileFolderById(FileFolder fileFolder);

    /**
     * @Description 获得仓库的文件夹数量
     * @Author  nanfeng
     * @Date  13:16 2020/3/27
     * @Param [fileStoreId]
     * @Return java.lang.Integer
     */
    Integer getFileFolderCountByFileStoreId(Integer fileStoreId);

}
