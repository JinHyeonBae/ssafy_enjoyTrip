-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ssafyweb
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `board` (
  `article_no` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(16) DEFAULT NULL,
  `subject` varchar(100) DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `hit` int DEFAULT '0',
  `register_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`article_no`),
  KEY `board_to_members_user_id_fk` (`user_id`),
  CONSTRAINT `board_to_members_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `members` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES (1,'ssafy','고맙네','gg',0,'2023-10-18 06:40:04'),(2,'ssafy','ㅎㅇ','피곤누적',0,'2023-10-19 00:36:57'),(3,'ssafy','11','22',0,'2023-10-19 01:57:00'),(4,'ssafy','22','44',0,'2023-10-19 01:57:32'),(5,'ssafy','33','44',0,'2023-10-19 01:59:01'),(6,'ssafy','11','암호화한 내용 ::: 22',0,'2023-10-19 02:02:32'),(7,'ssafy','영주시러','john',0,'2023-10-23 03:03:29'),(8,'ssafy','그 유명한','람다',0,'2023-10-23 03:05:48'),(10,'ssafy','영주 니','다이어트 좀 해',1,'2023-10-23 06:55:12'),(11,'ssafy','영주시러','응 시러',1,'2023-10-23 06:55:25'),(12,'honey','fdfdfdf','dfdfdf',0,'2023-10-24 08:21:47'),(13,'honey','dfdf','dfdf',3,'2023-10-24 08:22:09'),(14,'honey','그 유명한','람다',0,'2023-10-24 08:22:57'),(15,'honey','50분이에여?','쉬고오삼~~~',3,'2023-10-25 06:50:28'),(16,'honey','오늘은','머리자르는날',5,'2023-10-25 07:14:18'),(18,'honey','오늘은?','힘든날일까용?',88,'2023-11-07 06:17:00');
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `comment_no` int NOT NULL AUTO_INCREMENT,
  `article_no` int NOT NULL,
  `userId` varchar(255) NOT NULL,
  `content` varchar(255) NOT NULL,
  `registerTime` date NOT NULL,
  PRIMARY KEY (`commentNo`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,18,'ssafy','넘모싫당 헿헤헿헿헿헿헤','2023-11-10'),(2,18,'ssafy','넘모싫당 헿헤헿헿헿헿헤','2023-11-10'),(3,18,'ssafy','넘모싫당 헿헤헿헿헿헿헤','2023-11-10'),(4,18,'ssafy','넘모싫당 헿헤헿헿헿헿헤','2023-11-10'),(5,18,'ssafy','qweqwe','2023-11-10'),(6,18,'ssafy','12312','2023-11-10'),(7,18,'ssafy','rtrtyrtyrty','2023-11-10'),(8,18,'ssafy','234234234234234','2023-11-10'),(9,18,'ssafy','234234234234234','2023-11-10'),(10,18,'ssafy','23234','2023-11-10'),(11,18,'ssafy','ㅇㅀㅇㄹㅀ','2023-11-10'),(12,18,'ssafy','하이','2023-11-10');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `file_info`
--

DROP TABLE IF EXISTS `file_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `file_info` (
  `idx` int NOT NULL AUTO_INCREMENT,
  `article_no` int DEFAULT NULL,
  `save_folder` varchar(45) DEFAULT NULL,
  `original_file` varchar(50) DEFAULT NULL,
  `save_file` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idx`),
  KEY `file_info_to_board_article_no_fk` (`article_no`),
  CONSTRAINT `file_info_to_board_article_no_fk` FOREIGN KEY (`article_no`) REFERENCES `board` (`article_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file_info`
--

LOCK TABLES `file_info` WRITE;
/*!40000 ALTER TABLE `file_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `file_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guestbook`
--

--
-- Dumping data for table `guestbook`
--
--
-- Table structure for table `members`
--

DROP TABLE IF EXISTS `members`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `members` (
  `user_id` varchar(16) NOT NULL,
  `user_name` varchar(20) NOT NULL,
  `user_password` varchar(16) NOT NULL,
  `email_id` varchar(20) DEFAULT NULL,
  `email_domain` varchar(45) DEFAULT NULL,
  `join_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `members`
--

LOCK TABLES `members` WRITE;
/*!40000 ALTER TABLE `members` DISABLE KEYS */;
INSERT INTO `members` VALUES ('admin','관리자','1234','admin','google.com','2023-10-18 06:39:51'),('honey','honey','123456','honey','ssafy.com','2023-10-23 07:01:25'),('honeychoco','허니펫','1234','honeychoco','ssafy.com','2023-10-24 05:43:54'),('jayoung977','최자영','jayoung','jayoung','ssafy','2023-11-03 06:28:14'),('ssafy','김싸피','12344','ssafy','ssafy.com','2023-10-18 06:39:51'),('ssss','ssss','ssss','ssss','ssss','2023-11-03 09:00:53');
/*!40000 ALTER TABLE `members` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `memo`
--

DROP TABLE IF EXISTS `memo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `memo` (
  `memo_no` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(16) DEFAULT NULL,
  `comment` varchar(500) DEFAULT NULL,
  `memo_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `article_no` int DEFAULT NULL,
  PRIMARY KEY (`memo_no`),
  KEY `memo_to_board_article_no_fk` (`article_no`),
  KEY `memo_to_member_fk_idx` (`user_id`),
  CONSTRAINT `memo_to_board_article_no_fk` FOREIGN KEY (`article_no`) REFERENCES `board` (`article_no`),
  CONSTRAINT `memo_to_member_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `members` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `memo`
--

LOCK TABLES `memo` WRITE;
/*!40000 ALTER TABLE `memo` DISABLE KEYS */;
/*!40000 ALTER TABLE `memo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ssafy_member`
--
--
-- Dumping data for table `ssafy_member`
--

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-10 18:09:28
