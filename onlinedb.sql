/*
SQLyog Community Edition- MySQL GUI v7.02 
MySQL - 4.1.22-community-nt : Database - onlineshopping
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`onlineshopping` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `onlineshopping`;

/*Table structure for table `addproduct` */

DROP TABLE IF EXISTS `addproduct`;

CREATE TABLE `addproduct` (
  `CId` int(11) NOT NULL auto_increment,
  `Company` varchar(250) default NULL,
  `Category` varchar(150) default NULL,
  `pid` int(100) default NULL,
  `Bname` varchar(200) default NULL,
  `Bprice` varchar(200) default NULL,
  `filename` varchar(250) default NULL,
  `count1` int(199) default NULL,
  `soldno` int(199) default NULL,
  PRIMARY KEY  (`CId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `addproduct` */

insert  into `addproduct`(`CId`,`Company`,`Category`,`pid`,`Bname`,`Bprice`,`filename`,`count1`,`soldno`) values (1,'Fastrack','fbag',1,'Fastrack','599','fastrackbag.jpg',19,6),(2,'Fastrack1','shoe',2,'Fastrack','500','shoe1.png',62,41),(3,'Lifestyle','shoe2',3,'Lifestyle','1000','shoe2.png',13,3),(4,'Lifestyle','bag',4,'Lifestyle','1200','bagggg.png',22,7),(14,'Fastrack','Shoe',5,'redshoe','700','redshoe.png',4,2),(15,'Lifestyle','Handbags',6,'whitebag','3000','whitebag.png',4,2),(16,'Lifestyle','Handbags',7,'blackbag','2500','blackbag.png',4,2);

/*Table structure for table `register` */

DROP TABLE IF EXISTS `register`;

CREATE TABLE `register` (
  `userid` int(11) NOT NULL auto_increment,
  `email` varchar(50) default NULL,
  `username` varchar(50) default NULL,
  `password` varchar(50) default NULL,
  `address` varchar(100) default NULL,
  UNIQUE KEY `userid` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `register` */

insert  into `register`(`userid`,`email`,`username`,`password`,`address`) values (1,'akil@gmail.com','akil','akil','chennai'),(2,'aki@gmail.com','aki','aki','chennai'),(8,'suga@gmail.com','suga','suga','chengalpet'),(9,'akilesh@gmail.com','akilesh','akilesh','chennai'),(10,'akilesh@gmail.com','akilesh','akilesh','chennai'),(12,'bady@gmail.com','bady','bady','UP'),(17,'pingu@gmail.com','ping','ping','AP'),(18,'lily@gmail.com','lily','lily','chennai');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
