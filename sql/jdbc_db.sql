-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: jdbc_db
-- ------------------------------------------------------
-- Server version	5.7.9-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `bookid` int(11) NOT NULL,
  `bookname` varchar(40) DEFAULT NULL,
  `publisher` varchar(40) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`bookid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'축구의 역사','굿스포츠',7000),(2,'축구아는 여자','나무수',13000),(3,'축구의 이해','대한미디어',22000),(4,'골프 바이블','대한미디어',35000),(5,'피겨 교본','굿스포츠',8000),(6,'역도 단계별기술','굿스포츠',6000),(7,'야구의 추억','이상미디어',20000),(8,'야구를 부탁해','이상미디어',13000),(9,'올림픽 이야기','삼성당',7500),(10,'Olympic Champions','Pearson',13000);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `custid` int(11) NOT NULL,
  `name` varchar(40) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`custid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'박지성','영국 맨체스타','000-5000-0001'),(2,'김연아','대한민국 서울','000-6000-0001'),(3,'장미란','대한민국 강원도','000-7000-0001'),(4,'추신수','미국 클리블랜드','000-8000-0001'),(5,'박세리','대한민국 대전',NULL);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imported_book`
--

DROP TABLE IF EXISTS `imported_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `imported_book` (
  `bookid` int(11) DEFAULT NULL,
  `bookname` varchar(40) DEFAULT NULL,
  `publisher` varchar(40) DEFAULT NULL,
  `price` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imported_book`
--

LOCK TABLES `imported_book` WRITE;
/*!40000 ALTER TABLE `imported_book` DISABLE KEYS */;
INSERT INTO `imported_book` VALUES (21,'Zen Golf','Pearson',12000),(22,'Soccer Skills','Human Kinetics',15000);
/*!40000 ALTER TABLE `imported_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mem`
--

DROP TABLE IF EXISTS `mem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mem` (
  `num` int(11) NOT NULL,
  `id` char(15) NOT NULL,
  `name` char(10) NOT NULL,
  `sex` char(1) DEFAULT NULL,
  `post_num` char(8) DEFAULT NULL,
  `address` char(80) DEFAULT NULL,
  `tel` char(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mem`
--

LOCK TABLES `mem` WRITE;
/*!40000 ALTER TABLE `mem` DISABLE KEYS */;
INSERT INTO `mem` VALUES (1,'yjhwang','황영주','M','100-011','서울시 중구 충무로1가','234-8879',35),(2,'khshul','설기형','M','607-010','부산시 동래구 명륜동','764-3784',33),(3,'chpark','박철호','M','503-200','광주시 남구 지석동','298-9730',34),(4,'shlee','이상훈','M','503-201','광주시 남구 도금동','838-4347',32),(5,'jyjang','장영숙','W','606-065','부산시 영도구 봉래동5가','399-9809',24),(6,'yjbae','배용진','M','122-014','서울시 은평구 응암4동','857-5683',30),(7,'hbpark','박혜빈','W','427-760','경기도 과천시 중앙동','234-7677',22),(8,'mskim','김문수','M','429-020','경기도 시흥시 신천동','370-6003',63),(9,'bkcha','차범길','M','302-121','대전시 서구 둔산1동','432-9877',49),(10,'kskim','김길수','M','440-747','경기도 수원시 장안구 파장동','324-5875',54),(11,'srkim','김수련','M','704-701','대구시 달서구 신당동','987-3688',23),(12,'shlee','이성현','M','441-081','경기도 수원시 권선구 매산로1가','243-6844',36),(13,'hnjang','정한나','W','502-763','광주시 서구 화정4동','845-4547',58),(14,'mylee','이명연','W','502-791','광주시 서구 쌍촌동','837-9432',33),(15,'yskim','김영숙','W','429-010','경기도 시흥시 대야동','374-8438',53),(16,'jekim','김정은','W','503-202','광주시 남구 원산동','347-8873',29),(17,'yjko','고영주','W','122-020','서울시 은평구 녹번동','479-3874',32),(18,'cyahn','안철영','M','122-030','서울시 은평구 대조동','347-4687',34),(19,'jmkim','김진모','M','530-140','전라남도 목포시 항동','379-8349',28),(20,'ycshul','설영찬','M','606-070','부산시 영도구 청학동','983-8748',41),(21,'jjko','고재진','M','100-013','서울시 중구 충무로3가','836-4655',28),(22,'hwlee','이현우','M','606-071','부산시 영도구 청학1동','346-8892',32),(23,'cskang','강찬숙','W','668-890','경상남도 남해군 설천면','377-6879',21),(24,'ypji','지영필','M','122-040','서울시 은평구 불광동','366-3747',52),(25,'jbkim','김진배','M','427-600','경기도 과천시 과천동','382-4993',47),(26,'jepark','박지은','W','670-800','경상남도 거창군 거창읍','328-8743',26),(27,'jhlee','이지현','W','704-702','대구시 달서구 월성동','386-7988',27),(28,'bykang','강부영','M','302-120','대전시 서구 둔산동','798-3243',62),(29,'jymoon','문진영','W','302-122','대전시 서구 둔산2동','987-3248',18),(30,'jyjun','전지연','W','100-012','서울시 중구 충무로2가','347-2236',28),(31,'jkko','고진길','M','122-013','서울시 은평구 응암3동','234-7466',27),(32,'myjung','정명윤','M','502-771','광주시 서구 치평동','374-8786',47),(33,'jsyou','유지수','W','502-772','광주시 서구 치평동','309-3897',49),(34,'dsshin','신수진','W','530-145','전라남도 신안군 장산면','399-8789',53),(35,'sjshin','신수진','W','606-796','부산시 영도구 봉래동5가','389-8930',47);
/*!40000 ALTER TABLE `mem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `orderid` int(11) NOT NULL,
  `custid` int(11) DEFAULT NULL,
  `bookid` int(11) DEFAULT NULL,
  `saleprice` int(11) DEFAULT NULL,
  `orderdate` date DEFAULT NULL,
  PRIMARY KEY (`orderid`),
  KEY `custid` (`custid`),
  KEY `bookid` (`bookid`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`custid`) REFERENCES `customer` (`custid`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`bookid`) REFERENCES `book` (`bookid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,1,1,6000,'2014-07-01'),(2,1,3,21000,'2014-07-03'),(3,2,5,8000,'2014-07-03'),(4,3,6,6000,'2014-07-04'),(5,4,7,20000,'2014-07-05'),(6,1,2,12000,'2014-07-07'),(7,4,8,13000,'2014-07-07'),(8,3,10,12000,'2014-07-08'),(9,2,10,7000,'2014-07-09'),(10,3,8,13000,'2014-07-10');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` varchar(20) NOT NULL,
  `pw` varchar(20) NOT NULL,
  `addr` varchar(45) NOT NULL,
  `cash` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('apple','starfruit','melon',20000),('chair','desk','key',1000),('deck','keyboard','mouse',0),('dog','cat','lion',5000);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-03 16:47:59
