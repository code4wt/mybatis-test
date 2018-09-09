# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.20)
# Database: myblog
# Generation Time: 2018-09-09 11:05:33 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table article
# ------------------------------------------------------------

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `author_id` int(11) NOT NULL,
  `title` varchar(32) DEFAULT NULL,
  `type` tinyint(4) DEFAULT NULL,
  `content` text,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;

INSERT INTO `article` (`id`, `author_id`, `title`, `type`, `content`, `create_time`)
VALUES
	(1,1,'MyBatis 源码分析系列文章导读',8,'MyBatis 源码分析系列文章导读','2018-07-15 15:30:09'),
	(2,2,'HashMap 源码详细分析(JDK1.8)',1,'HashMap 源码详细分析(JDK1.8)','2018-01-18 15:29:13'),
	(3,1,'Java CAS 原理分析',1,'Java CAS 原理分析','2018-05-15 15:28:33'),
	(4,1,'Spring IOC 容器源码分析 - 获取单例 bean',4,'Spring IOC 容器源码分析 - 获取单例 bean','2018-06-01 00:00:00'),
	(5,1,'Spring IOC 容器源码分析 - 循环依赖的解决办法',4,'Spring IOC 容器源码分析 - 循环依赖的解决办法','2018-06-08 00:00:00'),
	(6,2,'Spring AOP 源码分析系列文章导读',4,'Spring AOP 源码分析系列文章导读','2018-06-17 00:00:00'),
	(7,2,'Spring AOP 源码分析 - 创建代理对象',4,'Spring AOP 源码分析 - 创建代理对象','2018-06-20 00:00:00'),
	(8,1,'Spring MVC 原理探秘 - 一个请求的旅行过程',4,'Spring MVC 原理探秘 - 一个请求的旅行过程','2018-06-29 00:00:00'),
	(9,2,'Spring MVC 原理探秘 - 容器的创建过程',4,'Spring MVC 原理探秘 - 容器的创建过程','2018-06-30 00:00:00'),
	(10,2,'Spring IOC 容器源码分析系列文章导读',4,'Spring IOC 容器源码分析系列文章导读','2018-05-30 00:00:00');

/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table author
# ------------------------------------------------------------

DROP TABLE IF EXISTS `author`;

CREATE TABLE `author` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `age` tinyint(4) DEFAULT NULL,
  `sex` tinyint(4) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `author` WRITE;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;

INSERT INTO `author` (`id`, `name`, `age`, `sex`, `email`)
VALUES
	(1,'coolblog.xyz',28,0,'coolblog.xyz@outlook.com'),
	(2,'nullllun',29,1,'coolblog.xyz@outlook.com');

/*!40000 ALTER TABLE `author` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table student
# ------------------------------------------------------------

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `age` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;

INSERT INTO `student` (`id`, `name`, `age`)
VALUES
	(1,'coolblog',20);

/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
