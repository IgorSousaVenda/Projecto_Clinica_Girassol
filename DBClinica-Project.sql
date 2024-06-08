-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: clinicaagirassol
-- ------------------------------------------------------
-- Server version	8.3.0

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
-- Table structure for table `consulta`
--

DROP TABLE IF EXISTS `consulta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consulta` (
  `id` int NOT NULL AUTO_INCREMENT,
  `data_consulta` date DEFAULT NULL,
  `hora_consulta` time DEFAULT NULL,
  `paciente_id` int DEFAULT NULL,
  `medico_id` int DEFAULT NULL,
  `especialidade_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `paciente_id` (`paciente_id`),
  KEY `medico_id` (`medico_id`),
  KEY `especialidade_id` (`especialidade_id`),
  CONSTRAINT `consulta_ibfk_1` FOREIGN KEY (`paciente_id`) REFERENCES `paciente` (`id`),
  CONSTRAINT `consulta_ibfk_2` FOREIGN KEY (`medico_id`) REFERENCES `medico` (`id`),
  CONSTRAINT `consulta_ibfk_3` FOREIGN KEY (`especialidade_id`) REFERENCES `especialidade` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consulta`
--

LOCK TABLES `consulta` WRITE;
/*!40000 ALTER TABLE `consulta` DISABLE KEYS */;
/*!40000 ALTER TABLE `consulta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especialidade`
--

DROP TABLE IF EXISTS `especialidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `especialidade` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `descricao` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especialidade`
--

LOCK TABLES `especialidade` WRITE;
/*!40000 ALTER TABLE `especialidade` DISABLE KEYS */;
INSERT INTO `especialidade` VALUES (1,' clinica medica',' não sei '),(2,' cirugiaão plastivo ',' não sei '),(3,' Ofatmologia ',' não sei ');
/*!40000 ALTER TABLE `especialidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `factura` (
  `id` int NOT NULL AUTO_INCREMENT,
  `valor` decimal(10,0) NOT NULL,
  `data_emissao` timestamp NULL DEFAULT NULL,
  `id_paciente` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_paciente` (`id_paciente`),
  CONSTRAINT `factura_ibfk_1` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `cargo` varchar(50) NOT NULL,
  `salario` decimal(9,0) NOT NULL,
  `data_contratacao` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,' Gilberto Bongue','Administrador Geral',1000000,'2024-06-12'),(2,' Igor de Sousa','Diretor de Departamento',2000000,'2024-09-05'),(3,' Abigail Fortuna','Diretora de Departamento',2000000,'2024-01-01');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicamento`
--

DROP TABLE IF EXISTS `medicamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicamento` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `dosagem` varchar(50) NOT NULL,
  `data_fabrico` date DEFAULT NULL,
  `data_caducidade` date DEFAULT NULL,
  `instrucoes` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicamento`
--

LOCK TABLES `medicamento` WRITE;
/*!40000 ALTER TABLE `medicamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `medicamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medico`
--

DROP TABLE IF EXISTS `medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medico` (
  `id` int NOT NULL AUTO_INCREMENT,
  `especialidade` varchar(50) NOT NULL,
  `funcionario_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `funcionario_id` (`funcionario_id`),
  CONSTRAINT `medico_ibfk_1` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medico`
--

LOCK TABLES `medico` WRITE;
/*!40000 ALTER TABLE `medico` DISABLE KEYS */;
/*!40000 ALTER TABLE `medico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente`
--

DROP TABLE IF EXISTS `paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paciente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `numdocldent` varchar(15) NOT NULL,
  `datanascimento` date DEFAULT NULL,
  `endereco` varchar(50) NOT NULL,
  `telefone` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente`
--

LOCK TABLES `paciente` WRITE;
/*!40000 ALTER TABLE `paciente` DISABLE KEYS */;
INSERT INTO `paciente` VALUES (1,' Samsung ',' 123456789BA049','2024-11-10','ISAF',999999999),(2,' Iphone ',' 123456789LA049','2024-10-20','ISPITEC',88888888),(3,' BlacBarry ',' 123456789BA049','2024-09-15','UCAN',11111111);
/*!40000 ALTER TABLE `paciente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prescricao`
--

DROP TABLE IF EXISTS `prescricao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prescricao` (
  `id` int NOT NULL AUTO_INCREMENT,
  `instrucoes` text NOT NULL,
  `consulta_id` int DEFAULT NULL,
  `medicamento_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `consulta_id` (`consulta_id`),
  KEY `medicamento_id` (`medicamento_id`),
  CONSTRAINT `prescricao_ibfk_1` FOREIGN KEY (`consulta_id`) REFERENCES `consulta` (`id`),
  CONSTRAINT `prescricao_ibfk_2` FOREIGN KEY (`medicamento_id`) REFERENCES `medicamento` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prescricao`
--

LOCK TABLES `prescricao` WRITE;
/*!40000 ALTER TABLE `prescricao` DISABLE KEYS */;
/*!40000 ALTER TABLE `prescricao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `secretaria`
--

DROP TABLE IF EXISTS `secretaria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `secretaria` (
  `id` int NOT NULL AUTO_INCREMENT,
  `funcionario_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `funcionario_id` (`funcionario_id`),
  CONSTRAINT `secretaria_ibfk_1` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `secretaria`
--

LOCK TABLES `secretaria` WRITE;
/*!40000 ALTER TABLE `secretaria` DISABLE KEYS */;
/*!40000 ALTER TABLE `secretaria` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-08 11:44:07
