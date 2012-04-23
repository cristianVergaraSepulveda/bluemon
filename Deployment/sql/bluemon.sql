-- MySQL dump 10.13  Distrib 5.1.49, for debian-linux-gnu (i686)
--
-- Host: localhost    Database: monitoreo
-- ------------------------------------------------------
-- Server version	5.1.49-1ubuntu8.1

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
-- Table structure for table `ALARMA`
--

DROP TABLE IF EXISTS `ALARMA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ALARMA` (
  `ID_ALARMA` int(11) NOT NULL AUTO_INCREMENT,
  `ID_MICRO` int(11) NOT NULL,
  `ID_SENSOR` int(11) NOT NULL,
  `ID_DATO` int(11) DEFAULT NULL,
  `ID_TIPOALARMA` int(11) NOT NULL,
  `INICIO` date DEFAULT NULL,
  `FIN` date DEFAULT NULL,
  PRIMARY KEY (`ID_ALARMA`),
  KEY `FK_RELATIONSHIP_12` (`ID_SENSOR`),
  KEY `FK_RELATIONSHIP_4` (`ID_TIPOALARMA`),
  CONSTRAINT `FK_RELATIONSHIP_12` FOREIGN KEY (`ID_SENSOR`) REFERENCES `SENSOR` (`ID_SENSOR`) ON UPDATE CASCADE,
  CONSTRAINT `FK_RELATIONSHIP_4` FOREIGN KEY (`ID_TIPOALARMA`) REFERENCES `TIPO_ALARMA` (`ID_TIPO`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `DATO`
--

DROP TABLE IF EXISTS `DATO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DATO` (
  `ID_DATO` int(11) NOT NULL AUTO_INCREMENT,
  `ID_MICRO` int(11) NOT NULL,
  `ID_SENSOR` int(11) DEFAULT NULL,
  `DATO` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`ID_DATO`),
  KEY `FK_RELATIONSHIP_10` (`ID_SENSOR`),
  KEY `FK_RELATIONSHIP_3` (`ID_MICRO`),
  CONSTRAINT `FK_RELATIONSHIP_10` FOREIGN KEY (`ID_SENSOR`) REFERENCES `SENSOR` (`ID_SENSOR`) ON UPDATE CASCADE,
  CONSTRAINT `FK_RELATIONSHIP_3` FOREIGN KEY (`ID_MICRO`) REFERENCES `MICRO` (`ID_MICRO`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=422870 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = latin1 */ ;
/*!50003 SET character_set_results = latin1 */ ;
/*!50003 SET collation_connection  = latin1_swedish_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`entel`@`localhost`*/ /*!50003 TRIGGER `after_data_insert`         
    AFTER INSERT ON `DATO` FOR EACH ROW     
    BEGIN         
        UPDATE DATO_ACTUAL SET DATO=NEW.DATO,FECHA=CURDATE(),HORA=CURTIME()  WHERE ID_SENSOR = NEW.ID_SENSOR; 
        INSERT REGISTRO VALUES(NULL, CURDATE(), CURTIME(), NEW.ID_DATO);
    END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `DATO_ACTUAL`
--

DROP TABLE IF EXISTS `DATO_ACTUAL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DATO_ACTUAL` (
  `ID_DATO_ACTUAL` int(11) NOT NULL AUTO_INCREMENT,
  `DATO` varchar(50) DEFAULT NULL,
  `FECHA` date DEFAULT NULL,
  `HORA` time DEFAULT NULL,
  `ID_SENSOR` int(11) NOT NULL,
  PRIMARY KEY (`ID_DATO_ACTUAL`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ESTACION`
--

DROP TABLE IF EXISTS `ESTACION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ESTACION` (
  `ID_ESTACION` int(11) NOT NULL AUTO_INCREMENT,
  `ID_COMUNA` int(8) DEFAULT NULL,
  `IP` varchar(15) CHARACTER SET latin1 DEFAULT NULL,
  `NOMBREESTACION` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`ID_ESTACION`),
  KEY `FK_RELATIONSHIP_13` (`ID_COMUNA`),
  CONSTRAINT `FK_RELATIONSHIP_13` FOREIGN KEY (`ID_COMUNA`) REFERENCES `comuna` (`COMUNA_ID`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `LOGIN`
--

DROP TABLE IF EXISTS `LOGIN`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `LOGIN` (
  `ID_LOGIN` int(11) NOT NULL AUTO_INCREMENT,
  `ID_TIPO_LOGIN` int(11) NOT NULL,
  `LOGIN` varchar(25) CHARACTER SET latin1 DEFAULT NULL,
  `PASSWORD` varchar(25) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`ID_LOGIN`),
  KEY `FK_RELATIONSHIP_6` (`ID_TIPO_LOGIN`),
  CONSTRAINT `FK_LOGIN_1` FOREIGN KEY (`ID_TIPO_LOGIN`) REFERENCES `TIPO_LOGIN` (`ID_TIPO_LOGIN`) ON UPDATE CASCADE,
  CONSTRAINT `FK_RELATIONSHIP_6` FOREIGN KEY (`ID_TIPO_LOGIN`) REFERENCES `TIPO_LOGIN` (`ID_TIPO_LOGIN`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `MICRO`
--

DROP TABLE IF EXISTS `MICRO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE  `monitoreo`.`MICRO` (
  `ID_MICRO` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBREMICRO` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  `ID_ESTACION` int(11) DEFAULT NULL,
  `IP_PUBLICA` varchar(16) DEFAULT NULL,
  `IP_LOCAL` varchar(16) DEFAULT NULL,
  `ENERGIA220` tinyint(1) NOT NULL,
  `BATERIA` int(3) unsigned NOT NULL,
  PRIMARY KEY (`ID_MICRO`),
  KEY `FK_RELATIONSHIP_7` (`ID_ESTACION`),
  CONSTRAINT `FK_RELATIONSHIP_7` FOREIGN KEY (`ID_ESTACION`) REFERENCES `ESTACION` (`ID_ESTACION`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `REGISTRO`
--

DROP TABLE IF EXISTS `REGISTRO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `REGISTRO` (
  `ID_REGISTRO` int(11) NOT NULL AUTO_INCREMENT,
  `FECHA` date DEFAULT NULL,
  `HORA` time DEFAULT NULL,
  `ID_DATO` int(11) NOT NULL,
  PRIMARY KEY (`ID_REGISTRO`),
  KEY `FK_RELATIONSHIP_11` (`ID_DATO`),
  CONSTRAINT `FK_RELATIONSHIP_11` FOREIGN KEY (`ID_DATO`) REFERENCES `DATO` (`ID_DATO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=421788 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `REGISTRO_ALARMA`
--

DROP TABLE IF EXISTS `REGISTRO_ALARMA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `REGISTRO_ALARMA` (
  `ID_REGISTRO_ALARMA` int(11) NOT NULL,
  `FECHA` date NOT NULL,
  `HORA` time NOT NULL,
  `ID_ALARMA` int(11) NOT NULL,
  PRIMARY KEY (`ID_REGISTRO_ALARMA`),
  KEY `FK_RELATIONSHIP_14` (`ID_ALARMA`),
  CONSTRAINT `FK_RELATIONSHIP_14` FOREIGN KEY (`ID_ALARMA`) REFERENCES `ALARMA` (`ID_ALARMA`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `SENSOR`
--

DROP TABLE IF EXISTS `SENSOR`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SENSOR` (
  `ID_SENSOR` int(11) NOT NULL,
  `ID_MICRO` int(11) NOT NULL,
  `NOMBRESENSOR` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  `UNIDADMEDIDA` char(10) CHARACTER SET latin1 DEFAULT NULL,
  `MAXIMA` int(5) DEFAULT NULL,
  `MINIMA` int(5) DEFAULT NULL,
  PRIMARY KEY (`ID_SENSOR`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `TIPO_ALARMA`
--

DROP TABLE IF EXISTS `TIPO_ALARMA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TIPO_ALARMA` (
  `ID_TIPO` int(11) NOT NULL,
  `TIPO_ALARMA` varchar(15) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`ID_TIPO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `TIPO_LOGIN`
--

DROP TABLE IF EXISTS `TIPO_LOGIN`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TIPO_LOGIN` (
  `ID_TIPO_LOGIN` int(11) NOT NULL,
  `NOMBRE_TIPO` varchar(25) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`ID_TIPO_LOGIN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `VARIABLE`
--

DROP TABLE IF EXISTS `VARIABLE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `VARIABLE` (
  `ID_VARIABLE` int(8) NOT NULL AUTO_INCREMENT,
  `VALOR` int(11) DEFAULT NULL,
  `NOMBRE_VARIABLE` varchar(25) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`ID_VARIABLE`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `comuna`
--

DROP TABLE IF EXISTS `comuna`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comuna` (
  `COMUNA_ID` int(5) NOT NULL DEFAULT '0',
  `COMUNA_NOMBRE` varchar(20) DEFAULT NULL,
  `COMUNA_PROVINCIA_ID` int(3) DEFAULT NULL,
  PRIMARY KEY (`COMUNA_ID`),
  KEY `COMUNA_PROVINCIA_ID` (`COMUNA_PROVINCIA_ID`),
  CONSTRAINT `comuna_ibfk_1` FOREIGN KEY (`COMUNA_PROVINCIA_ID`) REFERENCES `provincia` (`PROVINCIA_ID`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `provincia`
--

DROP TABLE IF EXISTS `provincia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `provincia` (
  `PROVINCIA_ID` int(3) NOT NULL DEFAULT '0',
  `PROVINCIA_NOMBRE` varchar(23) DEFAULT NULL,
  `PROVINCIA_REGION_ID` int(2) DEFAULT NULL,
  PRIMARY KEY (`PROVINCIA_ID`),
  KEY `PROVINCIA_REGION_ID` (`PROVINCIA_REGION_ID`),
  CONSTRAINT `provincia_ibfk_1` FOREIGN KEY (`PROVINCIA_REGION_ID`) REFERENCES `region` (`REGION_ID`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `region`
--

DROP TABLE IF EXISTS `region`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `region` (
  `REGION_ID` int(2) NOT NULL DEFAULT '0',
  `REGION_NOMBRE` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`REGION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

--
-- Table structure for table 'DATO_OFLINE'
--
DROP TABLE IF EXISTS `monitoreo`.`DATO_OFLINE`;
CREATE TABLE  `monitoreo`.`DATO_OFLINE` (
  `ID_DATO_OFLINE` int(11) NOT NULL AUTO_INCREMENT,
  `DATO` varchar(30) DEFAULT NULL,
  `FECHA` date DEFAULT NULL,
  `HORA` time DEFAULT NULL,
  `ID_SENSOR` int(11) DEFAULT NULL,
  `ID_MICRO` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_DATO_OFLINE`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;


-- Dump completed on 2012-03-15 20:06:12
