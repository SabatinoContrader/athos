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
  `attivo` bit(1) NOT NULL,
  `data_fine` datetime DEFAULT NULL,
  `data_inizio` datetime DEFAULT NULL,
  `descr_evento` varchar(255) DEFAULT NULL,
  `descr_percorso` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `versione` int(11) NOT NULL,
  `id_creatore` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2t0uc7u1p8tn2yxfl2b51kf6t` (`id_creatore`),
  CONSTRAINT `FK2t0uc7u1p8tn2yxfl2b51kf6t` FOREIGN KEY (`id_creatore`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game`
--

LOCK TABLES `game` WRITE;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
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
  `text` varchar(255) NOT NULL,
  `id_receiver` int(11) NOT NULL,
  `id_sender` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqyxddlqh59ce3gqls6qu9w3lq` (`id_receiver`),
  KEY `FK249t1hnaxlacjng5xtud18fi` (`id_sender`),
  CONSTRAINT `FK249t1hnaxlacjng5xtud18fi` FOREIGN KEY (`id_sender`) REFERENCES `user` (`id`),
  CONSTRAINT `FKqyxddlqh59ce3gqls6qu9w3lq` FOREIGN KEY (`id_receiver`) REFERENCES `user` (`id`)
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
  `indizio` varchar(255) NOT NULL,
  `latitudine` varchar(255) NOT NULL,
  `longitudine` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `poi`
--

LOCK TABLES `poi` WRITE;
/*!40000 ALTER TABLE `poi` DISABLE KEYS */;
/*!40000 ALTER TABLE `poi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rel_game_poi`
--

DROP TABLE IF EXISTS `rel_game_poi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `rel_game_poi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ordine` int(11) NOT NULL,
  `id_game` int(11) DEFAULT NULL,
  `id_poi` int(11) DEFAULT NULL,
  `id_sponsor` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6magdn6aep231nvvdvbgqbkwl` (`id_game`),
  KEY `FKh9hskcfkg85apifbph322reg1` (`id_poi`),
  KEY `FK5qd6t10ylxpm8fv2xwxt2ivxu` (`id_sponsor`),
  CONSTRAINT `FK5qd6t10ylxpm8fv2xwxt2ivxu` FOREIGN KEY (`id_sponsor`) REFERENCES `sponsor` (`id`),
  CONSTRAINT `FK6magdn6aep231nvvdvbgqbkwl` FOREIGN KEY (`id_game`) REFERENCES `game` (`id`),
  CONSTRAINT `FKh9hskcfkg85apifbph322reg1` FOREIGN KEY (`id_poi`) REFERENCES `poi` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rel_game_poi`
--

LOCK TABLES `rel_game_poi` WRITE;
/*!40000 ALTER TABLE `rel_game_poi` DISABLE KEYS */;
/*!40000 ALTER TABLE `rel_game_poi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rel_team_game`
--

DROP TABLE IF EXISTS `rel_team_game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `rel_team_game` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_poi` int(11) DEFAULT NULL,
  `id_game` int(11) DEFAULT NULL,
  `id_team` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKal224xso4jd3rs7her0k084pc` (`id_game`),
  KEY `FKjw3mu78bbxw5gn9t4fbe7y471` (`id_team`),
  CONSTRAINT `FKal224xso4jd3rs7her0k084pc` FOREIGN KEY (`id_game`) REFERENCES `game` (`id`),
  CONSTRAINT `FKjw3mu78bbxw5gn9t4fbe7y471` FOREIGN KEY (`id_team`) REFERENCES `team` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rel_team_game`
--

LOCK TABLES `rel_team_game` WRITE;
/*!40000 ALTER TABLE `rel_team_game` DISABLE KEYS */;
/*!40000 ALTER TABLE `rel_team_game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rel_user_game`
--

DROP TABLE IF EXISTS `rel_user_game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `rel_user_game` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_poi` int(11) DEFAULT NULL,
  `id_game` int(11) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1ljli565l7nlxfk5mj4xjvg2l` (`id_game`),
  KEY `FKipb6pr98nh218jqmgxa1a71n7` (`id_user`),
  CONSTRAINT `FK1ljli565l7nlxfk5mj4xjvg2l` FOREIGN KEY (`id_game`) REFERENCES `game` (`id`),
  CONSTRAINT `FKipb6pr98nh218jqmgxa1a71n7` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rel_user_game`
--

LOCK TABLES `rel_user_game` WRITE;
/*!40000 ALTER TABLE `rel_user_game` DISABLE KEYS */;
/*!40000 ALTER TABLE `rel_user_game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rel_user_team`
--

DROP TABLE IF EXISTS `rel_user_team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `rel_user_team` (
  `id_team` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  PRIMARY KEY (`id_team`,`id_user`),
  KEY `FKtfft8nokt0l6c0pmbbabmok3f` (`id_user`),
  CONSTRAINT `FKqffra7gbh9l7d63ub9m402t8k` FOREIGN KEY (`id_team`) REFERENCES `team` (`id`),
  CONSTRAINT `FKtfft8nokt0l6c0pmbbabmok3f` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`)
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
  `attivo` bit(1) NOT NULL,
  `descrizione` varchar(255) NOT NULL,
  `messagio` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sponsor`
--

LOCK TABLES `sponsor` WRITE;
/*!40000 ALTER TABLE `sponsor` DISABLE KEYS */;
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
  `attivo` bit(1) NOT NULL,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team`
--

LOCK TABLES `team` WRITE;
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
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
  `attivo` bit(1) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
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

-- Dump completed on 2019-02-05 13:05:01
