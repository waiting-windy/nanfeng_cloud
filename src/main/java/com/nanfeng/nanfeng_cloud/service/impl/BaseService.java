package com.nanfeng.nanfeng_cloud.service.impl;

import com.nanfeng.nanfeng_cloud.mapper.FileFolderMapper;
import com.nanfeng.nanfeng_cloud.mapper.FileStoreMapper;
import com.nanfeng.nanfeng_cloud.mapper.MyFileMapper;
import com.nanfeng.nanfeng_cloud.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName: BaseService
 * @Description: TODO
 **/
public class BaseService {

    @Autowired
    protected UserMapper userMapper;
    @Autowired
    protected MyFileMapper myFileMapper;
    @Autowired
    protected FileFolderMapper fileFolderMapper;
    @Autowired
    protected FileStoreMapper fileStoreMapper;
}
