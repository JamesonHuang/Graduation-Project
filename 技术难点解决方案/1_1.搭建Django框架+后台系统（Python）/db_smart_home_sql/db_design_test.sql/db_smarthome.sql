/*
MySQL Data Transfer
Source Host: localhost
Source Database: db_smart_home
Target Host: localhost
Target Database: db_smart_home
Date: 2014/10/18 16:36:25
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for admin
-- ----------------------------
CREATE TABLE `tb_admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(50) NOT NULL,
  `admin_pwd` varchar(50) NOT NULL,
  `admin_img` varchar(250) DEFAULT NULL,
  `admin_type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for admintype
-- ----------------------------
CREATE TABLE `tb_admintype` (
  `admin_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_type_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`admin_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for device
-- ----------------------------
CREATE TABLE `tb_device` (
  `device_id` int(11) NOT NULL AUTO_INCREMENT,
  `device_name` varchar(50) DEFAULT NULL,
  `user_id` int(50) DEFAULT NULL,
  `device_key` int(11) DEFAULT NULL,
  `is_online` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`device_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for info
-- ----------------------------
CREATE TABLE `tb_info` (
  `info_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_id` int(11) DEFAULT NULL,
  `info_type_id` int(11) DEFAULT NULL,
  `info_con` text,
  `info_title` varchar(70) DEFAULT NULL,
  `info_date` datetime DEFAULT NULL,
  `info_hits` int(11) DEFAULT NULL,
  PRIMARY KEY (`info_id`),
  KEY `FK_Reference_4` (`admin_id`),
  KEY `FK_Reference_5` (`info_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for infoimg
-- ----------------------------
CREATE TABLE `tb_infoimg` (
  `info_img_id` int(11) NOT NULL AUTO_INCREMENT,
  `info_id` int(11) DEFAULT NULL,
  `info_img_name` varchar(100) DEFAULT NULL,
  `info_img_path` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`info_img_id`),
  KEY `FK_Reference_7` (`info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for infotype
-- ----------------------------
CREATE TABLE `tb_infotype` (
  `info_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `info_type_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`info_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for message
-- ----------------------------
CREATE TABLE `tb_message` (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `message_type_id` int(11) DEFAULT NULL,
  `message_con` text,
  PRIMARY KEY (`message_id`),
  KEY `FK_Reference_6` (`message_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for message_type
-- ----------------------------
CREATE TABLE `tb_message_type` (
  `message_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `message_type_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`message_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for pro_detail
-- ----------------------------
CREATE TABLE `tb_pro_detail` (
  `pro_detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `pro_detail_from_task` varchar(50) DEFAULT NULL,
  `pro_detail_con` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`pro_detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for project
-- ----------------------------
CREATE TABLE `tb_project` (
  `pro_id` int(11) NOT NULL AUTO_INCREMENT,
  `pro_name` varchar(50) DEFAULT NULL,
  `pro_intro` varchar(50) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `pro_intro` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`pro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for task
-- ----------------------------
CREATE TABLE `tb_task` (
  `task_id` int(11) NOT NULL AUTO_INCREMENT,
  `task_name` varchar(50) DEFAULT NULL,
  `task_type` varchar(50) DEFAULT NULL,
  `task_from_pro` varchar(50) DEFAULT NULL,
  `task_from_task` varchar(50) DEFAULT NULL,
  `task_date` varchar(50) DEFAULT NULL,
  `task_tomatoes_count` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for task_detail
-- ----------------------------
CREATE TABLE `tb_task_detail` (
  `task_detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `task_detail_from_task` varchar(50) DEFAULT NULL,
  `task_detail_con` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`task_detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
CREATE TABLE `tb_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL,
  `user_pwd` varchar(50) DEFAULT NULL,
  `weibo_key` int(11) DEFAULT NULL,
  `qq_key` int(11) DEFAULT NULL,
  `user_img` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `admintype` VALUES ('2', '超级管理员');
INSERT INTO `admintype` VALUES ('3', '管理员');
INSERT INTO `infotype` VALUES ('1', '简介');
INSERT INTO `infotype` VALUES ('2', '系统设计');
INSERT INTO `infotype` VALUES ('3', '系统实现');
INSERT INTO `infotype` VALUES ('4', '数据库设计');
