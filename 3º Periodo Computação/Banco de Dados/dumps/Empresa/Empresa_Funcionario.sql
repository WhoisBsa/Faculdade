-- MySQL dump 10.13  Distrib 5.7.23, for Linux (x86_64)
--
-- Host: localhost    Database: Empresa
-- ------------------------------------------------------
-- Server version	5.7.23-0ubuntu0.18.04.1

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
-- Table structure for table `Funcionario`
--

DROP TABLE IF EXISTS `Funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Funcionario` (
  `Pnome` varchar(20) NOT NULL,
  `Minicial` varchar(20) NOT NULL,
  `Unome` varchar(20) NOT NULL,
  `Cpf` varchar(11) NOT NULL,
  `Datanasc` date DEFAULT NULL,
  `Endereço` varchar(45) NOT NULL,
  `Sexo` char(1) NOT NULL,
  `Salario` decimal(10,2) DEFAULT NULL,
  `Cpf_Supervisor` varchar(11) NOT NULL,
  `Dnr` int(11) NOT NULL,
  PRIMARY KEY (`Cpf`),
  KEY `Cpf_Supervisor` (`Cpf_Supervisor`),
  KEY `Dnr` (`Dnr`),
  CONSTRAINT `Funcionario_ibfk_1` FOREIGN KEY (`Cpf_Supervisor`) REFERENCES `Funcionario` (`Cpf`),
  CONSTRAINT `Funcionario_ibfk_2` FOREIGN KEY (`Dnr`) REFERENCES `Departamento` (`Dnumero`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Funcionario`
--

LOCK TABLES `Funcionario` WRITE;
/*!40000 ALTER TABLE `Funcionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `Funcionario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-28 11:46:46
