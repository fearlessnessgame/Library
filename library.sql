/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.7.26-log : Database - library
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`library` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `library`;

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `bkid` varchar(30) NOT NULL,
  `bkname` varchar(30) NOT NULL,
  `author` varchar(30) DEFAULT NULL,
  `press` varchar(30) DEFAULT NULL,
  `bkdate` varchar(50) DEFAULT NULL,
  `introduction` varchar(50) DEFAULT NULL,
  `sum` int(11) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  PRIMARY KEY (`bkid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `book` */

insert  into `book`(`bkid`,`bkname`,`author`,`press`,`bkdate`,`introduction`,`sum`,`num`) values ('123','123','123','123','2018','123',123,122);

/*Table structure for table `borrow` */

DROP TABLE IF EXISTS `borrow`;

CREATE TABLE `borrow` (
  `bkid` varchar(30) NOT NULL,
  `stid` varchar(20) DEFAULT NULL,
  `brdate` varchar(50) DEFAULT NULL,
  `redate` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`bkid`),
  KEY `borrow` (`stid`),
  CONSTRAINT `borrow_ibfk_1` FOREIGN KEY (`bkid`) REFERENCES `book` (`bkid`),
  CONSTRAINT `borrow_ibfk_2` FOREIGN KEY (`stid`) REFERENCES `student` (`stid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `borrow` */

insert  into `borrow`(`bkid`,`stid`,`brdate`,`redate`) values ('123','001','1557975802358','1560567802358');

/*Table structure for table `manger` */

DROP TABLE IF EXISTS `manger`;

CREATE TABLE `manger` (
  `mgname` varchar(30) NOT NULL,
  `mgpassword` varchar(30) NOT NULL,
  PRIMARY KEY (`mgname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `manger` */

insert  into `manger`(`mgname`,`mgpassword`) values ('admin','1234');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `stid` varchar(20) NOT NULL,
  `stname` varchar(20) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `proname` varchar(20) DEFAULT NULL,
  `grade` int(11) DEFAULT NULL,
  `stpassword` varchar(20) DEFAULT NULL,
  `department` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`stid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`stid`,`stname`,`sex`,`proname`,`grade`,`stpassword`,`department`) values ('001','姜燕辉','Man','alvin',2018,'1234','123');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
