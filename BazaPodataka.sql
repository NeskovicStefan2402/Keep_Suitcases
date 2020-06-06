/*
SQLyog Community v13.1.5  (64 bit)
MySQL - 10.1.37-MariaDB : Database - seminarskips
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`seminarskips` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `seminarskips`;

/*Table structure for table `klijent` */

DROP TABLE IF EXISTS `klijent`;

CREATE TABLE `klijent` (
  `idKlijenta` bigint(20) NOT NULL AUTO_INCREMENT,
  `ime` varchar(50) NOT NULL,
  `prezime` varchar(50) NOT NULL,
  `JMBG` varchar(13) NOT NULL,
  `kontaktBroj` varchar(15) DEFAULT NULL,
  `idRadnika` bigint(20) NOT NULL,
  PRIMARY KEY (`idKlijenta`),
  KEY `idRadnika` (`idRadnika`),
  CONSTRAINT `klijent_ibfk_1` FOREIGN KEY (`idRadnika`) REFERENCES `radnik` (`idRadnika`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `klijent` */

insert  into `klijent`(`idKlijenta`,`ime`,`prezime`,`JMBG`,`kontaktBroj`,`idRadnika`) values 
(1,'Stefan','Krstic','2451896357584','0652315638',1),
(2,'Marko','Vasic','1245124512456','0646523563',1),
(3,'Milos ','Radic','1241241245124','0620262325',1),
(4,'MIlos','Vasic','1232456123456','06332112345',1);

/*Table structure for table `prijemnica` */

DROP TABLE IF EXISTS `prijemnica`;

CREATE TABLE `prijemnica` (
  `idPrijemnice` bigint(10) NOT NULL AUTO_INCREMENT,
  `idRadnika` bigint(10) NOT NULL,
  `idPrtljaga` bigint(10) NOT NULL,
  `idKlijenta` bigint(10) NOT NULL,
  `datum` datetime NOT NULL,
  `preuzeto` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idPrijemnice`),
  KEY `idRadnika` (`idRadnika`),
  KEY `idPrtljaga` (`idPrtljaga`),
  KEY `idKlijenta` (`idKlijenta`),
  CONSTRAINT `prijemnica_ibfk_1` FOREIGN KEY (`idRadnika`) REFERENCES `radnik` (`idRadnika`),
  CONSTRAINT `prijemnica_ibfk_2` FOREIGN KEY (`idPrtljaga`) REFERENCES `prtljag` (`idPrtljaga`),
  CONSTRAINT `prijemnica_ibfk_3` FOREIGN KEY (`idKlijenta`) REFERENCES `klijent` (`idKlijenta`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `prijemnica` */

insert  into `prijemnica`(`idPrijemnice`,`idRadnika`,`idPrtljaga`,`idKlijenta`,`datum`,`preuzeto`) values 
(1,1,2,2,'2020-06-01 15:17:44',0),
(2,1,2,3,'2020-06-01 15:31:33',0),
(3,1,3,2,'2020-06-05 00:47:59',0),
(4,1,2,2,'2020-06-05 00:50:02',0);

/*Table structure for table `prtljag` */

DROP TABLE IF EXISTS `prtljag`;

CREATE TABLE `prtljag` (
  `idPrtljaga` bigint(10) NOT NULL AUTO_INCREMENT,
  `tezina` float NOT NULL,
  `idRadnika` bigint(20) NOT NULL,
  `idTipa` bigint(20) NOT NULL,
  `lomljivost` tinyint(1) NOT NULL,
  PRIMARY KEY (`idPrtljaga`),
  KEY `idRadnika` (`idRadnika`),
  KEY `idTipa` (`idTipa`),
  CONSTRAINT `prtljag_ibfk_1` FOREIGN KEY (`idRadnika`) REFERENCES `radnik` (`idRadnika`),
  CONSTRAINT `prtljag_ibfk_2` FOREIGN KEY (`idTipa`) REFERENCES `tipprtljaga` (`idTipa`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

/*Data for the table `prtljag` */

insert  into `prtljag`(`idPrtljaga`,`tezina`,`idRadnika`,`idTipa`,`lomljivost`) values 
(1,20,1,1,0),
(2,21,1,2,0),
(3,23,1,1,1),
(4,2,1,8,1),
(5,234,1,4,1),
(6,343,1,1,1),
(7,343,1,1,1),
(8,343,1,1,1),
(9,343,1,1,1),
(10,343,1,1,1),
(11,343,1,1,1),
(12,343,1,1,1),
(13,343,1,1,1),
(14,343,1,1,1),
(15,343,1,1,1),
(16,343,1,1,1),
(17,343,1,1,1);

/*Table structure for table `racun` */

DROP TABLE IF EXISTS `racun`;

CREATE TABLE `racun` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `predatoVreme` datetime NOT NULL,
  `preuzetoVreme` datetime DEFAULT NULL,
  `idRadnika` bigint(20) NOT NULL,
  `idKlijenta` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idRadnika` (`idRadnika`),
  KEY `idKlijenta` (`idKlijenta`),
  CONSTRAINT `racun_ibfk_1` FOREIGN KEY (`idRadnika`) REFERENCES `radnik` (`idRadnika`),
  CONSTRAINT `racun_ibfk_2` FOREIGN KEY (`idKlijenta`) REFERENCES `klijent` (`idKlijenta`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `racun` */

insert  into `racun`(`id`,`predatoVreme`,`preuzetoVreme`,`idRadnika`,`idKlijenta`) values 
(3,'2020-06-06 13:09:12',NULL,1,3),
(4,'2020-06-06 13:11:32',NULL,1,3),
(5,'2020-06-06 13:12:54',NULL,2,1);

/*Table structure for table `radnik` */

DROP TABLE IF EXISTS `radnik`;

CREATE TABLE `radnik` (
  `idRadnika` bigint(20) NOT NULL AUTO_INCREMENT,
  `ime` varchar(50) NOT NULL,
  `prezime` varchar(50) NOT NULL,
  `JMBG` varchar(13) NOT NULL,
  `korisnickoIme` varchar(20) NOT NULL,
  `sifra` varchar(20) NOT NULL,
  PRIMARY KEY (`idRadnika`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `radnik` */

insert  into `radnik`(`idRadnika`,`ime`,`prezime`,`JMBG`,`korisnickoIme`,`sifra`) values 
(1,'Stefan','Neskovic','2402998774517','Stefan98','Stefan98'),
(2,'Stefan','Neskovic','1234123412341','Stefan99','Stefan99'),
(4,'Stefan98','Stefan98','1123456123456','Stefan97','Stefan98'),
(5,'Dalibor','Mitic','2415215458712','Dalibor97','Dalibor97'),
(6,'Mateja','Neskovic','2402998774517','Mateja05','Mateja05');

/*Table structure for table `stavkaracuna` */

DROP TABLE IF EXISTS `stavkaracuna`;

CREATE TABLE `stavkaracuna` (
  `idStavke` bigint(20) NOT NULL AUTO_INCREMENT,
  `idRacuna` bigint(20) NOT NULL,
  `idPrtljaga` bigint(20) NOT NULL,
  `cena` decimal(10,0) NOT NULL,
  PRIMARY KEY (`idStavke`),
  KEY `idRacuna` (`idRacuna`),
  KEY `idPrtljaga` (`idPrtljaga`),
  CONSTRAINT `stavkaracuna_ibfk_1` FOREIGN KEY (`idRacuna`) REFERENCES `racun` (`id`),
  CONSTRAINT `stavkaracuna_ibfk_2` FOREIGN KEY (`idPrtljaga`) REFERENCES `prtljag` (`idPrtljaga`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `stavkaracuna` */

insert  into `stavkaracuna`(`idStavke`,`idRacuna`,`idPrtljaga`,`cena`) values 
(1,3,6,150),
(2,4,5,180),
(3,4,9,150),
(4,4,1,150),
(5,5,8,150),
(6,5,4,120);

/*Table structure for table `tipprtljaga` */

DROP TABLE IF EXISTS `tipprtljaga`;

CREATE TABLE `tipprtljaga` (
  `idTipa` bigint(20) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(100) NOT NULL,
  `cena` decimal(10,0) NOT NULL,
  PRIMARY KEY (`idTipa`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `tipprtljaga` */

insert  into `tipprtljaga`(`idTipa`,`naziv`,`cena`) values 
(1,'Plasticni kofer',150),
(2,'Kozni kofer',160),
(3,'Platneni kofer',160),
(4,'Torba',180),
(5,'Ranac',210),
(6,'Torba za Laptop',250),
(7,'Kesa',120),
(8,'Dzak',120);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
