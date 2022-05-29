-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: admin_recursos
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `organizaciones`
--

DROP TABLE IF EXISTS `organizaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `organizaciones` (
  `id_org` varchar(20) NOT NULL,
  `nombre_org` varchar(50) NOT NULL,
  `dir_org` varchar(70) DEFAULT NULL,
  `telefono` varchar(8) DEFAULT NULL,
  `correo` varchar(30) DEFAULT NULL,
  `estado` char(1) NOT NULL,
  PRIMARY KEY (`id_org`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organizaciones`
--

LOCK TABLES `organizaciones` WRITE;
/*!40000 ALTER TABLE `organizaciones` DISABLE KEYS */;
INSERT INTO `organizaciones` VALUES ('123ABC','Universidad Mariano Galvez de Guatemala','San Juan Sacatepequez','55555555','umg.sanjuan@umg.edu.gt','A'),('ABC123','Ministerio de Educación de Guatemala','Zona 10, Ciudad de Guatemala','77778888','mineduc@mineduc.gob.gt','A');
/*!40000 ALTER TABLE `organizaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recursos`
--

DROP TABLE IF EXISTS `recursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recursos` (
  `id_recurso` varchar(20) NOT NULL,
  `nombre_recurso` varchar(50) NOT NULL,
  `aprobar` char(1) NOT NULL,
  `usuarioIdAprobador` varchar(20) DEFAULT NULL,
  `confirmacion` char(1) NOT NULL,
  `usuarioIdEntrega` varchar(20) DEFAULT NULL,
  `usuarioIdRecepcion` varchar(20) DEFAULT NULL,
  `maximo_horas` decimal(4,2) NOT NULL,
  `costo` decimal(4,2) DEFAULT NULL,
  `estado` char(1) NOT NULL,
  `estado_recurso` varchar(30) NOT NULL,
  `orgId` varchar(20) NOT NULL,
  PRIMARY KEY (`id_recurso`),
  KEY `orgId` (`orgId`),
  KEY `usuarioIdAprobador` (`usuarioIdAprobador`),
  KEY `usuarioIdEntrega` (`usuarioIdEntrega`),
  KEY `usuarioIdRecepcion` (`usuarioIdRecepcion`),
  CONSTRAINT `org_FK_R` FOREIGN KEY (`orgId`) REFERENCES `organizaciones` (`id_org`),
  CONSTRAINT `recursos_ibfk_1` FOREIGN KEY (`usuarioIdAprobador`) REFERENCES `usuarios` (`id_usuario`),
  CONSTRAINT `recursos_ibfk_2` FOREIGN KEY (`usuarioIdEntrega`) REFERENCES `usuarios` (`id_usuario`),
  CONSTRAINT `recursos_ibfk_3` FOREIGN KEY (`usuarioIdRecepcion`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recursos`
--

LOCK TABLES `recursos` WRITE;
/*!40000 ALTER TABLE `recursos` DISABLE KEYS */;
/*!40000 ALTER TABLE `recursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id_usuario` varchar(20) NOT NULL,
  `tipo_usuario` char(1) NOT NULL,
  `nombre_usuario` varchar(20) NOT NULL,
  `contraseña` varchar(20) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `telefono` varchar(8) DEFAULT NULL,
  `direccion` varchar(70) DEFAULT NULL,
  `rol_usuario` varchar(20) NOT NULL,
  `estado` char(1) NOT NULL,
  `orgId` varchar(20) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `orgId` (`orgId`),
  CONSTRAINT `org_FK` FOREIGN KEY (`orgId`) REFERENCES `organizaciones` (`id_org`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES ('U1234','A','pperez','1234abc!','Pablo Perez','pperez@umg.edu.gt','55555555','Ciudad de Guatemala','','A','123ABC'),('U5678','U','jlopez','3154afd*','Juna Lopez','jlopez@umg.edu.gt','65484315','Ciudad de Guatemala','Autorizador','A','123ABC');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-28 23:18:16
