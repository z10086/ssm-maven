/*
SQLyog Trial v12.2.2 (64 bit)
MySQL - 10.1.13-MariaDB : Database - ssm
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ssm` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `ssm`;

/*Table structure for table `t_permission` */

DROP TABLE IF EXISTS `t_permission`;

CREATE TABLE `t_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pid` int(10) DEFAULT NULL COMMENT '自身关联父id',
  `name` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `value` varchar(300) DEFAULT NULL COMMENT '为null或空,代表有子节点',
  `position` int(10) DEFAULT NULL COMMENT '菜单顺序',
  `lev` int(11) DEFAULT NULL COMMENT '0: 功能权限,非0:菜单权限|1:1级菜单  2:2级菜单',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

/*Data for the table `t_permission` */

insert  into `t_permission`(`id`,`pid`,`name`,`permission`,`value`,`position`,`lev`) values 
(1,0,'系统管理*','','',1,1),
(2,0,'公告管理','','',2,1),
(3,0,'首页管理*','','',2,1),
(4,0,'项目管理','user:create','',4,1),
(5,1,'菜单管理*','system:menu','common/s.do?statement=menu_SpecSql.menuList&tourl=ass/basicmanage/menu/menuList',1,2),
(6,1,'角色管理*','system:role','rolePermission/init.do',1,2),
(7,1,'机构用户管理*','system:user','common/s.do?statement=userManage_SpecSql.getUserRelated&tourl=ass/basicmanage/organization_n&tOrganizationId=1',7,2),
(8,2,'公告权限1','gonggao:1','/user/add8/**',8,2),
(9,2,'公告权限2','gonggao:2','/user/add9/**',9,2),
(10,2,'公告权限3','gonggao:3','/user/add10/**',10,2),
(11,3,'文章管理*','homepage:1','common/s.do?statement=article_SpecSql.articleList&tourl=ass/article/articleList',1,2),
(12,3,'首页权限2','homepage:2','user/add12/**',12,2),
(13,4,'项目权限1','project:1','/user/add13/**',13,2),
(28,0,'工作流程*','','',2,1),
(29,28,'流程申请','workflow:apply','common/s.do?',1,2),
(30,28,'我发起的工作*','workflow:myapply','common/s.do?statement=workFlow_SpecSql.myApplyList&tourl=ass/workflow/myApplyList_n',1,2),
(31,28,'我的待处理工作','workflow:task','common/s.do?',3,2),
(32,28,'我经办的工作','workflow:process','common/s.do?',4,2),
(33,2,'我结束的工作2','workflow:finish','common/s.do?22',4,2),
(34,28,'休假信息汇总','workflow:totaltravels','common/s.do?',6,2),
(35,28,'出差信息汇总','workflow:totalvacations','common/s.do?',7,2),
(38,4,'testDwr',NULL,'/testDwr.jsp',7,2),
(40,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL COMMENT '角色名称',
  `role_value` varchar(1000) DEFAULT NULL,
  `make_time` int(11) DEFAULT NULL,
  `operator` varchar(255) DEFAULT NULL,
  `modify_time` int(11) DEFAULT NULL,
  `modify_operator` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

/*Data for the table `t_role` */

insert  into `t_role`(`id`,`name`,`role_value`,`make_time`,`operator`,`modify_time`,`modify_operator`) values 
(1,'只有神','admin',1429495858,'admin',1434621464,'admin'),
(49,'采购员34','user',1430141042,'000004N',1432816562,'admin'),
(51,'啊啊啊飞飞3','',1430294416,'000004N',1432816573,'admin'),
(54,'超级管理员','',1432817129,'admin',NULL,NULL),
(55,'testerole2','',1432821061,'admin',1433943547,'admin');

/*Table structure for table `t_role_permission` */

DROP TABLE IF EXISTS `t_role_permission`;

CREATE TABLE `t_role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `t_role_id` bigint(20) DEFAULT NULL,
  `t_permission_id` bigint(20) DEFAULT NULL,
  `make_time` int(11) DEFAULT NULL,
  `operator` varchar(255) DEFAULT NULL,
  `modify_time` int(11) DEFAULT NULL,
  `modify_operator` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=739 DEFAULT CHARSET=utf8;

/*Data for the table `t_role_permission` */

insert  into `t_role_permission`(`id`,`t_role_id`,`t_permission_id`,`make_time`,`operator`,`modify_time`,`modify_operator`) values 
(504,51,2,1432817798,'admin',NULL,NULL),
(505,51,8,1432817798,'admin',NULL,NULL),
(506,51,9,1432817798,'admin',NULL,NULL),
(507,51,10,1432817798,'admin',NULL,NULL),
(508,51,3,1432817798,'admin',NULL,NULL),
(509,51,11,1432817798,'admin',NULL,NULL),
(510,51,12,1432817798,'admin',NULL,NULL),
(511,51,28,1432817798,'admin',NULL,NULL),
(512,51,29,1432817798,'admin',NULL,NULL),
(513,51,30,1432817798,'admin',NULL,NULL),
(514,51,31,1432817798,'admin',NULL,NULL),
(515,51,32,1432817798,'admin',NULL,NULL),
(516,51,33,1432817798,'admin',NULL,NULL),
(517,51,34,1432817798,'admin',NULL,NULL),
(518,51,35,1432817798,'admin',NULL,NULL),
(519,49,2,1432820793,'admin',NULL,NULL),
(520,49,8,1432820793,'admin',NULL,NULL),
(521,49,9,1432820793,'admin',NULL,NULL),
(522,49,10,1432820793,'admin',NULL,NULL),
(523,49,3,1432820793,'admin',NULL,NULL),
(524,49,11,1432820793,'admin',NULL,NULL),
(525,49,12,1432820793,'admin',NULL,NULL),
(717,54,1,1446002951,'admin',NULL,NULL),
(718,54,5,1446002951,'admin',NULL,NULL),
(719,54,6,1446002951,'admin',NULL,NULL),
(720,54,7,1446002951,'admin',NULL,NULL),
(721,54,2,1446002951,'admin',NULL,NULL),
(722,54,33,1446002951,'admin',NULL,NULL),
(723,54,8,1446002951,'admin',NULL,NULL),
(724,54,9,1446002951,'admin',NULL,NULL),
(725,54,10,1446002951,'admin',NULL,NULL),
(726,54,3,1446002951,'admin',NULL,NULL),
(727,54,11,1446002951,'admin',NULL,NULL),
(728,54,12,1446002951,'admin',NULL,NULL),
(729,54,28,1446002951,'admin',NULL,NULL),
(730,54,29,1446002951,'admin',NULL,NULL),
(731,54,30,1446002951,'admin',NULL,NULL),
(732,54,31,1446002951,'admin',NULL,NULL),
(733,54,32,1446002951,'admin',NULL,NULL),
(734,54,34,1446002951,'admin',NULL,NULL),
(735,54,35,1446002951,'admin',NULL,NULL),
(736,54,4,1446002951,'admin',NULL,NULL),
(737,54,13,1446002951,'admin',NULL,NULL),
(738,54,39,1446002951,'admin',NULL,NULL);

/*Table structure for table `t_user_role` */

DROP TABLE IF EXISTS `t_user_role`;

CREATE TABLE `t_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `t_user_id` bigint(20) DEFAULT NULL,
  `t_role_id` bigint(20) DEFAULT NULL,
  `make_time` int(11) DEFAULT NULL,
  `operator` varchar(255) DEFAULT NULL,
  `modify_time` int(11) DEFAULT NULL,
  `modify_operator` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=343 DEFAULT CHARSET=utf8;

/*Data for the table `t_user_role` */

insert  into `t_user_role`(`id`,`t_user_id`,`t_role_id`,`make_time`,`operator`,`modify_time`,`modify_operator`) values 
(338,3,1,NULL,NULL,NULL,NULL),
(339,3,49,NULL,NULL,NULL,NULL),
(340,80,42,NULL,NULL,NULL,NULL),
(341,1,42,NULL,NULL,NULL,NULL),
(342,27,49,NULL,NULL,NULL,NULL);

/*Table structure for table `t_users` */

DROP TABLE IF EXISTS `t_users`;

CREATE TABLE `t_users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=latin1;

/*Data for the table `t_users` */

insert  into `t_users`(`id`,`username`,`password`) values 
(1,'11','6b1f007f2212704355de3927c089498f'),
(3,'test1',NULL),
(87,'test14','test14pwd'),
(88,'test14','test14pwd'),
(90,'test14','test14pwd'),
(92,'222222222','1111111111'),
(93,'username','password');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
