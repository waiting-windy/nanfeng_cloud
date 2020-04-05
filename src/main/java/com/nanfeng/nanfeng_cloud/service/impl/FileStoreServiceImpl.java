package com.nanfeng.nanfeng_cloud.service.impl;

import com.nanfeng.nanfeng_cloud.entity.FileStore;
import com.nanfeng.nanfeng_cloud.service.FileStoreService;
import com.nanfeng.nanfeng_cloud.utils.LogUtils;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

/**
 * @ClassName: FileStoreServiceImpl
 * @Description: 文件仓库业务层接口实现类
 * @author: xw
 * @date 2020/1/26 22:16
 * @Version: 1.0
 **/
@Service
public class FileStoreServiceImpl extends BaseService implements FileStoreService {

    Logger logger = LogUtils.getInstance(UserServiceImpl.class);

    @Override
    public Integer addFileStore(FileStore fileStore) {
        return fileStoreMapper.addFileStore(fileStore);
    }

    @Override
    public FileStore getFileStoreByUserId(Integer userId) {
        return fileStoreMapper.getFileStoreByUserId(userId);
    }

    @Override
    public FileStore getFileStoreById(Integer fileStoreId) {
        return fileStoreMapper.getFileStoreById(fileStoreId);
    }

    @Override
    public Integer addSize(Integer id, Integer size) {
        return fileStoreMapper.addSize(id,size);
    }

    @Override
    public Integer subSize(Integer id, Integer size) {
        return fileStoreMapper.subSize(id,size);
    }
}
