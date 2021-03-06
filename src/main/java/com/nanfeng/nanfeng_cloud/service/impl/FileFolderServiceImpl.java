package com.nanfeng.nanfeng_cloud.service.impl;

import com.nanfeng.nanfeng_cloud.entity.FileFolder;
import com.nanfeng.nanfeng_cloud.entity.MyFile;
import com.nanfeng.nanfeng_cloud.service.FileFolderService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @ClassName: FileFolderServiceImpl
* @Description: TODO
* @author: xw
* @date 2020/2/8 23:00
* @Version: 1.0
**/

@Service
public class FileFolderServiceImpl extends BaseService implements FileFolderService {

    @Override
    public FileFolder getFileFolderById(Integer fileFolderId) {
        return fileFolderMapper.getFileFolderById(fileFolderId);
    }

    @Override
    public List<FileFolder> getFileFolderByParentFolderId(Integer parentFolderId) {
        return fileFolderMapper.getFileFolderByParentFolderId(parentFolderId);
    }

    @Override
    public List<FileFolder> getRootFoldersByFileStoreId(Integer fileStoreId) {
        return fileFolderMapper.getRootFoldersByFileStoreId(fileStoreId);
    }

    @Override
    public List<MyFile> getFileByFileFolder(Integer fileFolderId) {
        return fileFolderMapper.getFileByFileFolder(fileFolderId);
    }

    @Override
    public Integer deleteFileFolderById(Integer fileFolderId) {
        return fileFolderMapper.deleteFileFolderById(fileFolderId);
    }

    @Override
    public Integer addFileFolder(FileFolder fileFolder) {
        return fileFolderMapper.addFileFolder(fileFolder);
    }

    @Override
    public Integer updateFileFolderById(FileFolder fileFolder) {
        return fileFolderMapper.updateFileFolderById(fileFolder);
    }

}
