# 南风网盘

针对现有网盘下载限速问题，采用非侵入式框架SpringBoot为后端，在云服务器搭建FTP服务器作为对象存储容器、Nginx服务器作为负载均衡，模拟真实网络云盘开发、部署。本系统为二次开发，原作者"[莫提](http://xuewei.world/)"。本人对该系统使用layui重构大部分功能，优化显示和操作。希望有志人士协作开发。

## 技术

### 后端

- SpringBoot 2.2.4
- Mysql 8.0.13
- Tomcat 9、Nginx 1.16.1

### 前端

- LayUI 2.5.6
- Bootstrap 3
- 诸多扩展插件

## 如何部署

- 修改application.yaml使测试模块配置生效
- 修改application-test.yaml中个人数据库数据
- 修改qqconnectconfig.properties中QQ接口数据
- 修改FtpUtil中FTP服务器连接数据

## 之后计划

- [x] 上传进度条根据服务端实时显示

- [ ] 后台FTP并发上传
- [ ] 文件移动功能
- [ ] 回收站功能
- [ ] 优化音乐、视频在线预览