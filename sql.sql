/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.7.20-log : Database - newsaas_backstage
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`newsaas_backstage` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `newsaas_backstage`;

/*Table structure for table `newsaas_user` */

DROP TABLE IF EXISTS `newsaas_user`;

CREATE TABLE `newsaas_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(64) DEFAULT NULL,
  `account` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `phone` varchar(25) DEFAULT NULL,
  `is_admin` tinyint(1) unsigned NOT NULL COMMENT '判断是否为超级管理员，0不是，1是',
  `identity_id` int(11) NOT NULL COMMENT '0为默认身份，1为管理员',
  `register_time` datetime NOT NULL,
  `pwd` varchar(255) NOT NULL DEFAULT '123456',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8;

/*Table structure for table `newsaas_user_mac` */

DROP TABLE IF EXISTS `newsaas_user_mac`;

CREATE TABLE `newsaas_user_mac` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) DEFAULT NULL COMMENT 'newsaas_user表中的user_id字段',
  `mac` varchar(255) DEFAULT NULL COMMENT 'mac地址',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT 'mac状态：0待认证，1已认证，2删除',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
