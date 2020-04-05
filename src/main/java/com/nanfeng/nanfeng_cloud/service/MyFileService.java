package com.nanfeng.nanfeng_cloud.service;

import com.nanfeng.nanfeng_cloud.entity.FileStoreStatistics;
import com.nanfeng.nanfeng_cloud.entity.MyFile;

import java.util.List;

/**
 * @Description: 文件业务层接口
 **/
public interface MyFileService{

    /**
     * @Description 根据文件的id删除文件
     * @Author nanfeng
     * @Date 2020/2/9 15:49
     * @Param [myFileId]
     * @Return Integer
     */
    Integer deleteByFileId(Integer myFileId);

    /**
     * @Description 根据父文件夹的id删除文件
     * @Author nanfeng
     * @Date 2020/2/9 15:49
     * @Param [id]
     * @Return Integer
     */
    Integer deleteByParentFolderId(Integer id);

    /**
     * @Description 添加文件
     * @Author nanfeng
     * @Date 2020/2/9 15:50
     * @Param [myFile]
     * @Return Integer
     */
    Integer addFileByFileStoreId(MyFile myFile);

    /**
     * @Description 根据文件id获得文件
     * @Author naneng
     * @Date 2020/2/9 22:00
     * @Param [myFileId]
     * @Return com.molihub.entity.MyFile
     */

    MyFile getFileByFileId(Integer myFileId);
    /**
     * @Description 根据文件id修改文件
     * @Author nanfneg
     * @Date 2020/2/9 15:55
     * @Param [record]
     * @Return Integer
     */
    Integer updateFile(MyFile record);

    /**
     * @Description 获得仓库根目录下的所有文件
     * @Author nanfeng
     * @Date 23:53 2020/2/9
     * @Param [fileStoreId]
     * @return java.util.List<com.molihub.entity.MyFile>
     **/
    List<MyFile> getRootFilesByFileStoreId(Integer fileStoreId);

    /**
     * @Description 根据父文件夹id获得文件
     * @Author nanfeng
     * @Date 0:06 2020/2/10
     * @Param [parentFolderId]
     * @return java.util.List<com.molihub.entity.MyFile>
     **/
    List<MyFile> getFilesByParentFolderId(Integer parentFolderId);

    /**
     * @Description 根据类别获取文件
     * @Author nanfeng
     * @Date 10:13 2020/2/26
     * @Param [storeId, type]
     * @return java.util.List<com.moti.entity.MyFile>
     **/
    List<MyFile> getFilesByType(Integer storeId, Integer type);

    /**
     * @Description 获取仓库的统计信息
     * @Author nanfeng
     * @Date 21:47 2020/2/10
     * @Param [id]
     * @return com.molihub.entity.FileStoreStatistics
     **/
    FileStoreStatistics getCountStatistics(Integer id);

}
