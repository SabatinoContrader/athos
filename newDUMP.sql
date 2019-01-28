CREATE DATABASE  IF NOT EXISTS `athos_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `athos_db`;
-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: athos_db
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `game`
--

DROP TABLE IF EXISTS `game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `game` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_creatore` int(11) DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `descr_percorso` varchar(200) DEFAULT NULL,
  `versione` varchar(45) DEFAULT NULL,
  `attivo` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idCreatore_idx` (`id_creatore`),
  CONSTRAINT `FK2t0uc7u1p8tn2yxfl2b51kf6t` FOREIGN KEY (`id_creatore`) REFERENCES `user` (`id`),
  CONSTRAINT `idCreatore` FOREIGN KEY (`id_creatore`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game`
--

LOCK TABLES `game` WRITE;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
INSERT INTO `game` VALUES (1,2,'a','a','1',1),(4,18,'prova','prova','1',1),(5,18,'prova','prova ','2',1),(6,2,'master','ciaociaofra','1',0),(7,2,'master','ciaociaofra','1',1),(8,2,'master','ciao   ciao     fra','2',1),(9,2,'master','ciao   ciao     fra','3',1),(10,2,'bellaaaaaaa','ciao bello','1',0),(11,2,'bellaaaaaaiiiiiiiiiiiiiiia','ciao belloooooooooooooooooooooo','1',0),(12,2,'bellaaaaaaiiiiiiiiiiiiiiia3','ciao belloooooooooooooooooooooo3','1',0),(13,2,'bellaaaaaaiiiiiiiiiiiiiiia3','ciao belloooooooooooooooooooooo3','1',0);
/*!40000 ALTER TABLE `game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_receiver` int(11) NOT NULL,
  `id_sender` int(11) NOT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `text` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `poi`
--

DROP TABLE IF EXISTS `poi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `poi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `latitudine` float DEFAULT NULL,
  `longitudine` float DEFAULT NULL,
  `indizio` varchar(600) DEFAULT NULL,
  `id_sponsor` int(11) DEFAULT NULL,
  `attivo` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idSponsor_idx` (`id_sponsor`),
  CONSTRAINT `FKj3p5pktmk6a34pmc6emgu1vy` FOREIGN KEY (`id_sponsor`) REFERENCES `sponsor` (`id`),
  CONSTRAINT `idSponsor` FOREIGN KEY (`id_sponsor`) REFERENCES `sponsor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `poi`
--

LOCK TABLES `poi` WRITE;
/*!40000 ALTER TABLE `poi` DISABLE KEYS */;
INSERT INTO `poi` VALUES (6,1,2,'a',1,1),(7,1,1,'a',1,1),(8,1,1,'a',1,1),(11,999,999,'klsjflasjfpoasjkdfljk',13,1),(12,0,45645600,'sdgsdfsdfhfhfjfg',14,1);
/*!40000 ALTER TABLE `poi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rel_giochi_poi`
--

DROP TABLE IF EXISTS `rel_giochi_poi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `rel_giochi_poi` (
  `id_poi` int(11) DEFAULT NULL,
  `id_giochi` int(11) DEFAULT NULL,
  `ordine` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `idPoi_idx` (`id_poi`),
  KEY `idGiochi_idx` (`id_giochi`),
  CONSTRAINT `idGiochi` FOREIGN KEY (`id_giochi`) REFERENCES `game` (`id`),
  CONSTRAINT `idPoi` FOREIGN KEY (`id_poi`) REFERENCES `poi` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rel_giochi_poi`
--

LOCK TABLES `rel_giochi_poi` WRITE;
/*!40000 ALTER TABLE `rel_giochi_poi` DISABLE KEYS */;
INSERT INTO `rel_giochi_poi` VALUES (6,1,1,1),(7,1,2,2),(8,1,3,3),(11,4,1,4),(12,4,2,5);
/*!40000 ALTER TABLE `rel_giochi_poi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rel_team_giochi`
--

DROP TABLE IF EXISTS `rel_team_giochi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `rel_team_giochi` (
  `id_team` int(11) DEFAULT NULL,
  `id_gioco` int(11) DEFAULT NULL,
  `id` tinyint(1) DEFAULT '1',
  KEY `idTeam2_idx` (`id_team`),
  KEY `idGame2_idx` (`id_gioco`),
  CONSTRAINT `idGame2` FOREIGN KEY (`id_gioco`) REFERENCES `game` (`id`),
  CONSTRAINT `idTeam2` FOREIGN KEY (`id_team`) REFERENCES `team` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rel_team_giochi`
--

LOCK TABLES `rel_team_giochi` WRITE;
/*!40000 ALTER TABLE `rel_team_giochi` DISABLE KEYS */;
/*!40000 ALTER TABLE `rel_team_giochi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rel_user_giochi`
--

DROP TABLE IF EXISTS `rel_user_giochi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `rel_user_giochi` (
  `id_user` int(11) DEFAULT NULL,
  `id_giochi` int(11) DEFAULT NULL,
  `id_poi` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_p` int(11) DEFAULT NULL,
  `id_game` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idUser_idx` (`id_user`),
  KEY `idGame_idx` (`id_giochi`),
  KEY `idPoi2_idx` (`id_poi`),
  KEY `FK8w9ty0he5n8vsks5mglvw56sl` (`id_game`),
  CONSTRAINT `FK8w9ty0he5n8vsks5mglvw56sl` FOREIGN KEY (`id_game`) REFERENCES `game` (`id`),
  CONSTRAINT `FKqy6capx31h45ytofj3g7qw8jd` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`),
  CONSTRAINT `idGame` FOREIGN KEY (`id_giochi`) REFERENCES `game` (`id`),
  CONSTRAINT `idPoi2` FOREIGN KEY (`id_poi`) REFERENCES `poi` (`id`),
  CONSTRAINT `idUser` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rel_user_giochi`
--

LOCK TABLES `rel_user_giochi` WRITE;
/*!40000 ALTER TABLE `rel_user_giochi` DISABLE KEYS */;
/*!40000 ALTER TABLE `rel_user_giochi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rel_user_team`
--

DROP TABLE IF EXISTS `rel_user_team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `rel_user_team` (
  `id_user` int(11) DEFAULT NULL,
  `id_team` int(11) DEFAULT NULL,
  KEY `idUser2_idx` (`id_user`),
  KEY `idTeam_idx` (`id_team`),
  CONSTRAINT `idTeam` FOREIGN KEY (`id_team`) REFERENCES `team` (`id`),
  CONSTRAINT `idUser2` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rel_user_team`
--

LOCK TABLES `rel_user_team` WRITE;
/*!40000 ALTER TABLE `rel_user_team` DISABLE KEYS */;
/*!40000 ALTER TABLE `rel_user_team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sponsor`
--

DROP TABLE IF EXISTS `sponsor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sponsor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `attivo` tinyint(1) DEFAULT '1',
  `messaggio` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sponsor`
--

LOCK TABLES `sponsor` WRITE;
/*!40000 ALTER TABLE `sponsor` DISABLE KEYS */;
INSERT INTO `sponsor` VALUES (1,'b','a',1,''),(13,'a','aaaaaaaaa',1,''),(14,'aa','a',1,'');
/*!40000 ALTER TABLE `sponsor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team`
--

DROP TABLE IF EXISTS `team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `team` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `attivo` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team`
--

LOCK TABLES `team` WRITE;
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
INSERT INTO `team` VALUES (36,'a',1),(37,'a',1),(38,'b',1),(39,'c',1),(40,'z',1),(41,'aaa',1),(42,'aaaaaaaaaaaaa',1);
/*!40000 ALTER TABLE `team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` int(11) DEFAULT '2',
  `attivo` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','admin',0,1),(2,'master','master',1,1),(3,'player','player',2,1),(17,'prova','prova',2,1),(18,'io','io',1,1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'athos_db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-28 16:34:53
