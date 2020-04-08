/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : moti-cloud

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2020-04-08 11:55:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for file_folder
-- ----------------------------
DROP TABLE IF EXISTS `file_folder`;
CREATE TABLE `file_folder` (
  `file_folder_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文件夹ID',
  `file_folder_name` varchar(255) DEFAULT NULL COMMENT '文件夹名称',
  `parent_folder_id` int(11) DEFAULT '0' COMMENT '父文件夹ID',
  `file_store_id` int(11) DEFAULT NULL COMMENT '所属文件仓库ID',
  `time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`file_folder_id`)
) ENGINE=InnoDB AUTO_INCREMENT=154 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of file_folder
-- ----------------------------

-- ----------------------------
-- Table structure for file_store
-- ----------------------------
DROP TABLE IF EXISTS `file_store`;
CREATE TABLE `file_store` (
  `file_store_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文件仓库ID',
  `user_id` int(11) DEFAULT NULL COMMENT '主人ID',
  `current_size` int(11) DEFAULT '0' COMMENT '当前容量（单位KB）',
  `max_size` int(11) DEFAULT '1048576' COMMENT '最大容量（单位KB）',
  PRIMARY KEY (`file_store_id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of file_store
-- ----------------------------
INSERT INTO `file_store` VALUES ('1', '1', '88832', '1048576');

-- ----------------------------
-- Table structure for my_file
-- ----------------------------
DROP TABLE IF EXISTS `my_file`;
CREATE TABLE `my_file` (
  `my_file_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文件ID',
  `my_file_name` varchar(255) DEFAULT NULL COMMENT '文件名',
  `file_store_id` int(11) DEFAULT NULL COMMENT '文件仓库ID',
  `my_file_path` varchar(255) DEFAULT '/' COMMENT '文件存储路径',
  `download_time` int(11) DEFAULT '0' COMMENT '下载次数',
  `upload_time` datetime DEFAULT NULL COMMENT '上传时间',
  `parent_folder_id` int(11) DEFAULT NULL COMMENT '父文件夹ID',
  `size` int(11) DEFAULT NULL COMMENT '文件大小',
  `type` int(11) DEFAULT NULL COMMENT '文件类型',
  `postfix` varchar(255) DEFAULT NULL COMMENT '文件后缀',
  PRIMARY KEY (`my_file_id`)
) ENGINE=InnoDB AUTO_INCREMENT=344 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of my_file
-- ----------------------------
INSERT INTO `my_file` VALUES ('242', '2020121154756108200-副本', '1', '1/2020-04-06/0', '0', '2020-04-06 16:03:43', '0', '92', '2', '.jpg');
INSERT INTO `my_file` VALUES ('243', 'avatar-副本', '1', '1/2020-04-06/0', '0', '2020-04-06 16:03:45', '0', '28', '2', '.jpg');
INSERT INTO `my_file` VALUES ('244', '500-副本', '1', '1/2020-04-06/0', '0', '2020-04-06 16:03:46', '0', '42', '2', '.jpg');
INSERT INTO `my_file` VALUES ('245', 'out-副本', '1', '1/2020-04-06/0', '0', '2020-04-06 16:03:47', '0', '13', '2', '.png');
INSERT INTO `my_file` VALUES ('246', 'mmexport1568621179135_gaitubao_', '1', '1/2020-04-06/0', '0', '2020-04-06 18:41:59', '0', '33', '2', '.jpg');
INSERT INTO `my_file` VALUES ('247', 'IMG_20190913_175152', '1', '1/2020-04-06/0', '0', '2020-04-06 18:42:25', '0', '3843', '2', '.jpg');
INSERT INTO `my_file` VALUES ('248', 'gaitubao_FqwEDIBC6mDvWsJG1wDCeGJUXWEc', '1', '1/2020-04-06/0', '0', '2020-04-06 18:42:27', '0', '34', '2', '.jpg');
INSERT INTO `my_file` VALUES ('249', 'IMG_20190913_175152_gaitubao_98x130', '1', '1/2020-04-06/0', '0', '2020-04-06 18:42:28', '0', '10', '2', '.jpg');
INSERT INTO `my_file` VALUES ('250', 'logo_login', '1', '1/2020-04-06/0', '0', '2020-04-06 18:45:00', '0', '7', '2', '.png');
INSERT INTO `my_file` VALUES ('253', 'favicon', '1', '1/2020-04-06/0', '0', '2020-04-06 18:57:44', '0', '16', '2', '.ico');
INSERT INTO `my_file` VALUES ('254', 'yjtp', '1', '1/2020-04-06/0', '0', '2020-04-06 18:57:46', '0', '19', '2', '.png');
INSERT INTO `my_file` VALUES ('255', 'out', '1', '1/2020-04-06/0', '0', '2020-04-06 18:58:30', '0', '13', '2', '.png');
INSERT INTO `my_file` VALUES ('256', '复试面试内容', '1', '1/2020-04-06/0', '0', '2020-04-06 19:03:44', '0', '4', '1', '.md');
INSERT INTO `my_file` VALUES ('257', 'hosts', '1', '1/2020-04-06/0', '0', '2020-04-06 19:03:45', '0', '0', '1', '.txt');
INSERT INTO `my_file` VALUES ('258', '最大的矩形2013-12-3', '1', '1/2020-04-06/0', '0', '2020-04-06 19:03:48', '0', '1', '1', '.md');
INSERT INTO `my_file` VALUES ('259', '20', '1', '1/2020-04-06/0', '0', '2020-04-06 19:06:28', '0', '307', '2', '.png');
INSERT INTO `my_file` VALUES ('260', '19', '1', '1/2020-04-06/0', '0', '2020-04-06 19:06:30', '0', '337', '2', '.png');
INSERT INTO `my_file` VALUES ('261', '21', '1', '1/2020-04-06/0', '0', '2020-04-06 19:06:36', '0', '297', '2', '.png');
INSERT INTO `my_file` VALUES ('262', '17', '1', '1/2020-04-06/0', '0', '2020-04-06 19:12:37', '0', '292', '2', '.png');
INSERT INTO `my_file` VALUES ('263', '18', '1', '1/2020-04-06/0', '0', '2020-04-06 19:12:39', '0', '280', '2', '.png');
INSERT INTO `my_file` VALUES ('264', '14', '1', '1/2020-04-06/0', '0', '2020-04-06 19:15:34', '0', '318', '2', '.png');
INSERT INTO `my_file` VALUES ('265', '13', '1', '1/2020-04-06/0', '0', '2020-04-06 19:15:37', '0', '288', '2', '.png');
INSERT INTO `my_file` VALUES ('266', '31', '1', '1/2020-04-06/0', '0', '2020-04-06 19:18:20', '0', '160', '2', '.png');
INSERT INTO `my_file` VALUES ('267', '32', '1', '1/2020-04-06/0', '0', '2020-04-06 19:19:07', '0', '180', '2', '.png');
INSERT INTO `my_file` VALUES ('268', '34', '1', '1/2020-04-06/0', '0', '2020-04-06 19:19:10', '0', '203', '2', '.png');
INSERT INTO `my_file` VALUES ('269', '33', '1', '1/2020-04-06/0', '0', '2020-04-06 19:19:12', '0', '129', '2', '.png');
INSERT INTO `my_file` VALUES ('270', '32', '1', '1/2020-04-06/0', '0', '2020-04-06 19:19:16', '0', '180', '2', '.png');
INSERT INTO `my_file` VALUES ('271', '15', '1', '1/2020-04-06/0', '0', '2020-04-06 19:19:20', '0', '373', '2', '.png');
INSERT INTO `my_file` VALUES ('272', '36', '1', '1/2020-04-06/0', '0', '2020-04-06 19:19:22', '0', '162', '2', '.png');
INSERT INTO `my_file` VALUES ('273', 'apache-maven-3.5.4-bin', '1', '1/2020-04-06/0', '0', '2020-04-06 19:21:47', '0', '8790', '5', '.zip');
INSERT INTO `my_file` VALUES ('274', 'apache-maven-3.6.3-bin.tar', '1', '1/2020-04-06/0', '0', '2020-04-06 19:23:03', '0', '9283', '5', '.gz');
INSERT INTO `my_file` VALUES ('275', 'cloud_disk', '1', '1/2020-04-06/0', '0', '2020-04-06 19:23:05', '0', '78', '5', '.sql');
INSERT INTO `my_file` VALUES ('276', 'README', '1', '1/2020-04-06/0', '0', '2020-04-06 19:23:07', '0', '0', '1', '.md');
INSERT INTO `my_file` VALUES ('277', 'README', '1', '1/2020-04-06/0', '0', '2020-04-06 19:23:08', '0', '0', '1', '.md');
INSERT INTO `my_file` VALUES ('278', 'mycloud-admin-windows', '1', '1/2020-04-06/0', '0', '2020-04-06 19:23:56', '0', '4259', '5', '.zip');
INSERT INTO `my_file` VALUES ('279', '陈星星-2019论文-终稿', '1', '1/2020-04-06/0', '0', '2020-04-06 19:25:42', '0', '3259', '1', '.doc');
INSERT INTO `my_file` VALUES ('280', 'jquery-3.4.1', '1', '1/2020-04-06/0', '0', '2020-04-06 21:51:55', '0', '111', '5', '.zip');
INSERT INTO `my_file` VALUES ('281', 'mysql-connector-java-8.0.11', '1', '1/2020-04-06/0', '0', '2020-04-06 21:52:38', '0', '5605', '5', '.zip');
INSERT INTO `my_file` VALUES ('282', 'mysql-connector-java-5.1.47', '1', '1/2020-04-06/0', '0', '2020-04-06 21:53:19', '0', '4695', '5', '.zip');
INSERT INTO `my_file` VALUES ('283', '4.3网盘管理-文件重命名', '1', '1/2020-04-06/0', '0', '2020-04-06 22:44:10', '0', '26', '2', '.png');
INSERT INTO `my_file` VALUES ('284', '4.4网盘管理-分享资源', '1', '1/2020-04-06/0', '0', '2020-04-06 22:44:14', '0', '60', '2', '.png');
INSERT INTO `my_file` VALUES ('285', '4.5网盘管理-链接分享', '1', '1/2020-04-06/0', '0', '2020-04-06 22:44:16', '0', '230', '2', '.png');
INSERT INTO `my_file` VALUES ('286', '5.1分享管理', '1', '1/2020-04-06/0', '0', '2020-04-06 22:44:20', '0', '58', '2', '.png');
INSERT INTO `my_file` VALUES ('287', '4.1网盘管理', '1', '1/2020-04-06/0', '0', '2020-04-06 22:44:50', '0', '94', '2', '.png');
INSERT INTO `my_file` VALUES ('288', '3.1-首页', '1', '1/2020-04-06/0', '0', '2020-04-06 22:44:57', '0', '175', '2', '.png');
INSERT INTO `my_file` VALUES ('289', '2.1注册', '1', '1/2020-04-06/0', '0', '2020-04-06 22:45:09', '0', '82', '2', '.png');
INSERT INTO `my_file` VALUES ('290', '2.2找回密码', '1', '1/2020-04-06/0', '0', '2020-04-06 22:45:12', '0', '27', '2', '.png');
INSERT INTO `my_file` VALUES ('291', '8.2个人信息-安全设置', '1', '1/2020-04-06/0', '0', '2020-04-06 22:45:18', '0', '76', '2', '.png');
INSERT INTO `my_file` VALUES ('292', '8.7系统管理-文件上传', '1', '1/2020-04-06/0', '0', '2020-04-06 22:58:43', '0', '199', '2', '.png');
INSERT INTO `my_file` VALUES ('293', '8.9系统管理-字典管理', '1', '1/2020-04-06/0', '0', '2020-04-06 22:58:46', '0', '90', '2', '.png');
INSERT INTO `my_file` VALUES ('294', '8.8系统管理-文件上传-配置', '1', '1/2020-04-06/0', '0', '2020-04-06 22:58:48', '0', '110', '2', '.png');
INSERT INTO `my_file` VALUES ('295', '1后台登陆页面', '1', '1/2020-04-06/0', '0', '2020-04-06 23:05:33', '0', '69', '2', '.png');
INSERT INTO `my_file` VALUES ('296', '3.1用户管理-列表', '1', '1/2020-04-06/0', '0', '2020-04-06 23:05:35', '0', '100', '2', '.png');
INSERT INTO `my_file` VALUES ('297', '3.2用户管理-新增', '1', '1/2020-04-06/0', '0', '2020-04-06 23:05:37', '0', '120', '2', '.png');
INSERT INTO `my_file` VALUES ('298', '2后台首页', '1', '1/2020-04-06/0', '0', '2020-04-06 23:05:41', '0', '220', '2', '.png');
INSERT INTO `my_file` VALUES ('299', '8.5系统管理-定时任务-添加', '1', '1/2020-04-06/0', '0', '2020-04-06 23:23:05', '0', '78', '2', '.png');
INSERT INTO `my_file` VALUES ('300', 'IMG_20200229_115346', '1', '1/2020-04-06/0', '0', '2020-04-06 23:23:23', '0', '2488', '2', '.jpg');
INSERT INTO `my_file` VALUES ('301', '8.1系统管理-菜单-列表', '1', '1/2020-04-06/0', '0', '2020-04-06 23:25:04', '0', '183', '2', '.png');
INSERT INTO `my_file` VALUES ('302', 'TIM图片20200316173831', '1', '1/2020-04-06/0', '0', '2020-04-06 23:25:34', '0', '2384', '2', '.jpg');
INSERT INTO `my_file` VALUES ('303', 'wechatpay', '1', '1/2020-04-06/0', '0', '2020-04-06 23:26:12', '0', '101', '2', '.png');
INSERT INTO `my_file` VALUES ('304', 'TIM图片20200321150335', '1', '1/2020-04-06/0', '0', '2020-04-06 23:26:27', '0', '1983', '2', '.jpg');
INSERT INTO `my_file` VALUES ('305', 'TIM图片20200204211147', '1', '1/2020-04-06/0', '0', '2020-04-06 23:41:47', '0', '2057', '2', '.jpg');
INSERT INTO `my_file` VALUES ('306', 'TIM图片20200204211200', '1', '1/2020-04-06/0', '0', '2020-04-06 23:47:08', '0', '3778', '2', '.jpg');
INSERT INTO `my_file` VALUES ('307', 'layuimini-master', '1', '1/2020-04-06/0', '0', '2020-04-06 23:58:35', '0', '1880', '5', '.zip');
INSERT INTO `my_file` VALUES ('308', 'lyear_7_LightYear-admin', '1', '1/2020-04-07/0', '0', '2020-04-07 00:00:40', '0', '2645', '5', '.zip');
INSERT INTO `my_file` VALUES ('309', '下载', '1', '1/2020-04-07/0', '0', '2020-04-07 17:04:45', '0', '8', '2', '.jpg');
INSERT INTO `my_file` VALUES ('310', 'ChMlWl0oUkmIKEkcAAGPjZqsIeMAALxGgBh0CEAAY-l439', '1', '1/2020-04-07/0', '0', '2020-04-07 17:05:49', '0', '99', '2', '.jpg');
INSERT INTO `my_file` VALUES ('311', '7z_v19.00', '1', '1/2020-04-07/0', '0', '2020-04-07 17:15:18', '0', '1413', '5', '.exe');
INSERT INTO `my_file` VALUES ('312', 'amtlib', '1', '1/2020-04-07/0', '0', '2020-04-07 17:15:30', '0', '1751', '5', '.dll');
INSERT INTO `my_file` VALUES ('313', 'application', '1', '1/2020-04-07/0', '0', '2020-04-07 17:17:17', '0', '0', '5', '.yml');
INSERT INTO `my_file` VALUES ('314', 'application-prod', '1', '1/2020-04-07/0', '0', '2020-04-07 17:17:21', '0', '1', '5', '.yml');
INSERT INTO `my_file` VALUES ('315', 'application-dev', '1', '1/2020-04-07/0', '0', '2020-04-07 17:17:26', '0', '1', '5', '.yml');
INSERT INTO `my_file` VALUES ('316', 'ValidationMessages', '1', '1/2020-04-07/0', '0', '2020-04-07 17:18:10', '0', '0', '5', '.properties');
INSERT INTO `my_file` VALUES ('317', 'spy', '1', '1/2020-04-07/0', '0', '2020-04-07 17:18:14', '0', '0', '5', '.properties');
INSERT INTO `my_file` VALUES ('318', 'logback-spring', '1', '1/2020-04-07/0', '0', '2020-04-07 17:18:15', '0', '2', '5', '.xml');
INSERT INTO `my_file` VALUES ('319', 'LoginLogMapper', '1', '1/2020-04-07/0', '0', '2020-04-07 17:24:33', '0', '1', '5', '.xml');
INSERT INTO `my_file` VALUES ('320', 'UserMapper', '1', '1/2020-04-07/0', '0', '2020-04-07 17:24:34', '0', '3', '5', '.xml');
INSERT INTO `my_file` VALUES ('321', 'MenuMapper', '1', '1/2020-04-07/0', '0', '2020-04-07 17:24:35', '0', '2', '5', '.xml');
INSERT INTO `my_file` VALUES ('322', 'apache-maven-3.3.9-bin', '1', '1/2020-04-07/0', '0', '2020-04-07 17:26:02', '0', '8415', '5', '.zip');
INSERT INTO `my_file` VALUES ('323', '05_决策树算法族', '1', '1/2020-04-07/0', '0', '2020-04-07 20:08:24', '0', '470', '1', '.pptx');
INSERT INTO `my_file` VALUES ('324', '04_线性回归', '1', '1/2020-04-07/0', '0', '2020-04-07 20:08:47', '0', '1363', '1', '.pptx');
INSERT INTO `my_file` VALUES ('325', '03_贝叶斯概率', '1', '1/2020-04-07/0', '0', '2020-04-07 20:09:05', '0', '1234', '1', '.pptx');
INSERT INTO `my_file` VALUES ('326', '板书', '1', '1/2020-04-07/0', '0', '2020-04-07 20:09:33', '0', '10', '1', '.xlsx');
INSERT INTO `my_file` VALUES ('327', '02_Python基本语法', '1', '1/2020-04-07/0', '0', '2020-04-07 20:09:35', '0', '20', '1', '.docx');
INSERT INTO `my_file` VALUES ('328', '04_实验MNIST-CNN', '1', '1/2020-04-07/0', '0', '2020-04-07 20:52:34', '0', '12', '1', '.docx');
INSERT INTO `my_file` VALUES ('329', '08_RNN与LSTM', '1', '1/2020-04-07/0', '0', '2020-04-07 20:52:51', '0', '2597', '1', '.pptx');
INSERT INTO `my_file` VALUES ('330', '06_DROPOUT', '1', '1/2020-04-07/0', '0', '2020-04-07 20:53:04', '0', '700', '1', '.pptx');
INSERT INTO `my_file` VALUES ('331', '01_实验_MNIST多层网络', '1', '1/2020-04-07/0', '0', '2020-04-07 20:58:57', '0', '13', '1', '.docx');
INSERT INTO `my_file` VALUES ('332', '01_反向传播网络', '1', '1/2020-04-07/0', '0', '2020-04-07 20:59:01', '0', '543', '1', '.pptx');
INSERT INTO `my_file` VALUES ('333', '02_随机梯度下降', '1', '1/2020-04-07/0', '0', '2020-04-07 20:59:15', '0', '1256', '1', '.pptx');
INSERT INTO `my_file` VALUES ('334', '04_VOC实验SSD-VGG', '1', '1/2020-04-07/0', '0', '2020-04-07 21:13:43', '0', '2617', '1', '.docx');
INSERT INTO `my_file` VALUES ('335', '03_图片风格变换2-FastStyle', '1', '1/2020-04-07/0', '0', '2020-04-07 21:13:47', '0', '28', '1', '.pptx');
INSERT INTO `my_file` VALUES ('336', '02_图片风格变换实验', '1', '1/2020-04-07/0', '0', '2020-04-07 21:13:48', '0', '16', '1', '.docx');
INSERT INTO `my_file` VALUES ('337', '01_FaceNetonMsCeleb', '1', '1/2020-04-07/0', '0', '2020-04-07 21:15:08', '0', '244', '1', '.docx');
INSERT INTO `my_file` VALUES ('338', '01_FaceNetonLFW', '1', '1/2020-04-07/0', '0', '2020-04-07 21:15:15', '0', '953', '1', '.docx');
INSERT INTO `my_file` VALUES ('339', '05_DQN实验', '1', '1/2020-04-07/0', '0', '2020-04-07 21:16:52', '0', '382', '1', '.docx');
INSERT INTO `my_file` VALUES ('340', 'IMG_20200321_101045', '1', '1/2020-04-07/0', '0', '2020-04-07 22:34:45', '0', '1567', '2', '.jpg');
INSERT INTO `my_file` VALUES ('341', '接口隔离原则', '1', '1/2020-04-07/0', '0', '2020-04-07 22:36:57', '0', '16', '2', '.png');
INSERT INTO `my_file` VALUES ('342', '单一职责原则', '1', '1/2020-04-07/0', '0', '2020-04-07 22:38:07', '0', '7', '1', '.md');
INSERT INTO `my_file` VALUES ('343', 'MatinFlower微服务论文', '1', '1/2020-04-07/0', '0', '2020-04-07 22:39:08', '0', '34', '1', '.md');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `open_id` varchar(255) DEFAULT NULL COMMENT '用户的openid',
  `file_store_id` int(11) DEFAULT NULL COMMENT '文件仓库ID',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `register_time` datetime DEFAULT NULL COMMENT '注册时间',
  `image_path` varchar(255) DEFAULT '' COMMENT '头像地址',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', '1', '南风', '2020-03-25 07:37:51', 'http://www.lizeyu.xyz/images/avatar.jpg');
