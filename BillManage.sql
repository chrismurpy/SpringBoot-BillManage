-- MySQL dump 10.13  Distrib 8.0.16, for macos10.14 (x86_64)
--
-- Host: 127.0.0.1    Database: bill-manager
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bill_`
--

DROP TABLE IF EXISTS `bill_`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bill_` (
  `id_` bigint(20) NOT NULL AUTO_INCREMENT,
  `title_` varchar(100) DEFAULT NULL,
  `bill_time_` date DEFAULT NULL,
  `type_id_` bigint(20) DEFAULT NULL,
  `price_` double(10,2) DEFAULT NULL,
  `explain_` varchar(100) DEFAULT NULL,
  `file_path_` varchar(500) DEFAULT NULL,
  `file_name_` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id_`),
  KEY `fk_type_bill` (`type_id_`),
  CONSTRAINT `fk_type_bill` FOREIGN KEY (`type_id_`) REFERENCES `bill_type_` (`id_`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill_`
--

LOCK TABLES `bill_` WRITE;
/*!40000 ALTER TABLE `bill_` DISABLE KEYS */;
INSERT INTO `bill_` (`id_`, `title_`, `bill_time_`, `type_id_`, `price_`, `explain_`, `file_path_`, `file_name_`) VALUES (2,'饭补','2017-06-26',1,2.23,'饭餐补偿费',NULL,NULL),(3,'出差费','2017-06-27',2,33.00,'出差相关费用',NULL,NULL),(4,'奖金','2017-06-28',2,44.00,'奖金获取',NULL,NULL),(21,'采购办公用品','2019-05-14',2,1234.00,'办公用品消费','','account.png'),(22,'宝呗青年','2021-08-14',1,101.50,'花呗支付',NULL,NULL),(23,'出借murphy','2021-08-22',4,49.50,'借钱给murphy',NULL,NULL);
/*!40000 ALTER TABLE `bill_` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill_type_`
--

DROP TABLE IF EXISTS `bill_type_`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bill_type_` (
  `id_` bigint(20) NOT NULL AUTO_INCREMENT,
  `name_` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill_type_`
--

LOCK TABLES `bill_type_` WRITE;
/*!40000 ALTER TABLE `bill_type_` DISABLE KEYS */;
INSERT INTO `bill_type_` (`id_`, `name_`) VALUES (1,'收入'),(2,'支出'),(3,'借入'),(4,'借出');
/*!40000 ALTER TABLE `bill_type_` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-23 11:28:09
