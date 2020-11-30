CREATE DATABASE  IF NOT EXISTS `hotel` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `hotel`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: hotel
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `actividad`
--

DROP TABLE IF EXISTS `actividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actividad` (
  `id_actividad` varchar(10) NOT NULL,
  `tipo_actividad` varchar(50) DEFAULT NULL,
  `descripcion` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id_actividad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividad`
--

LOCK TABLES `actividad` WRITE;
/*!40000 ALTER TABLE `actividad` DISABLE KEYS */;
INSERT INTO `actividad` VALUES ('1','Capacitacion','nuevos'),('2','Induccion','nuevos'),('3','Desempeño','Empleados');
/*!40000 ALTER TABLE `actividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `actividad_empleado`
--

DROP TABLE IF EXISTS `actividad_empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actividad_empleado` (
  `id_empleado` varchar(10) NOT NULL,
  `id_actividad` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_empleado`),
  KEY `id_actividad` (`id_actividad`),
  CONSTRAINT `actividad_empleado_ibfk_1` FOREIGN KEY (`id_empleado`) REFERENCES `empleado_contratado` (`id_empleado`),
  CONSTRAINT `actividad_empleado_ibfk_2` FOREIGN KEY (`id_actividad`) REFERENCES `actividad` (`id_actividad`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividad_empleado`
--

LOCK TABLES `actividad_empleado` WRITE;
/*!40000 ALTER TABLE `actividad_empleado` DISABLE KEYS */;
INSERT INTO `actividad_empleado` VALUES ('1010','1'),('1011','2'),('1012','3');
/*!40000 ALTER TABLE `actividad_empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aplicacion`
--

DROP TABLE IF EXISTS `aplicacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aplicacion` (
  `id_aplicacion` varchar(10) NOT NULL,
  `dpi_persona` varchar(13) DEFAULT NULL,
  `cumple_requisitos` char(1) DEFAULT NULL,
  PRIMARY KEY (`id_aplicacion`),
  KEY `dpi_persona` (`dpi_persona`),
  CONSTRAINT `aplicacion_ibfk_1` FOREIGN KEY (`dpi_persona`) REFERENCES `curriculum` (`dpi_persona`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aplicacion`
--

LOCK TABLES `aplicacion` WRITE;
/*!40000 ALTER TABLE `aplicacion` DISABLE KEYS */;
INSERT INTO `aplicacion` VALUES ('1','3110','S'),('2','3111','S'),('3','3112','S');
/*!40000 ALTER TABLE `aplicacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aplicacion_prueba`
--

DROP TABLE IF EXISTS `aplicacion_prueba`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aplicacion_prueba` (
  `id_ap` varchar(10) NOT NULL,
  `id_prueba` varchar(10) DEFAULT NULL,
  `id_aplicacion` varchar(10) DEFAULT NULL,
  `estatus_prueba` char(1) DEFAULT NULL,
  PRIMARY KEY (`id_ap`),
  KEY `id_prueba` (`id_prueba`),
  KEY `id_aplicacion` (`id_aplicacion`),
  CONSTRAINT `aplicacion_prueba_ibfk_1` FOREIGN KEY (`id_prueba`) REFERENCES `tipo_pruebas` (`id_prueba`),
  CONSTRAINT `aplicacion_prueba_ibfk_2` FOREIGN KEY (`id_aplicacion`) REFERENCES `aplicacion` (`id_aplicacion`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aplicacion_prueba`
--

LOCK TABLES `aplicacion_prueba` WRITE;
/*!40000 ALTER TABLE `aplicacion_prueba` DISABLE KEYS */;
INSERT INTO `aplicacion_prueba` VALUES ('1','1','1','A'),('2','2','2','A'),('3','3','3','A');
/*!40000 ALTER TABLE `aplicacion_prueba` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `banco`
--

DROP TABLE IF EXISTS `banco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `banco` (
  `id_banco` varchar(10) NOT NULL,
  `nombre_banco` varchar(50) DEFAULT NULL,
  `nombre_cuenta` varchar(50) DEFAULT NULL,
  `clave_banco` varchar(10) DEFAULT NULL,
  `funcionario` varchar(50) DEFAULT NULL,
  `telefono` int DEFAULT NULL,
  `numero_plaza` int DEFAULT NULL,
  `numero_sucursal` int DEFAULT NULL,
  `saldo_inicial` float DEFAULT NULL,
  `id_moneda` varchar(10) DEFAULT NULL,
  `id_movEnc` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_banco`),
  KEY `id_moneda` (`id_moneda`),
  KEY `id_movEnc` (`id_movEnc`),
  CONSTRAINT `banco_ibfk_1` FOREIGN KEY (`id_moneda`) REFERENCES `moneda` (`id_moneda`),
  CONSTRAINT `banco_ibfk_2` FOREIGN KEY (`id_movEnc`) REFERENCES `mov_bancenc` (`id_movEnc`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `banco`
--

LOCK TABLES `banco` WRITE;
/*!40000 ALTER TABLE `banco` DISABLE KEYS */;
INSERT INTO `banco` VALUES ('1','Banco X','ADMINISTRADOR 1','1203','David de Paz',45852555,1,1,15000,'1','1'),('2','Banco Y','ADMINISTRADOR 2','1597','Karla Santos',58256522,1,1,5000,'2','2');
/*!40000 ALTER TABLE `banco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bitacora_empleado`
--

DROP TABLE IF EXISTS `bitacora_empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bitacora_empleado` (
  `id_bitacora` int NOT NULL AUTO_INCREMENT,
  `id_empleado_B` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_bitacora`),
  KEY `id_empleado_B` (`id_empleado_B`),
  CONSTRAINT `bitacora_empleado_ibfk_1` FOREIGN KEY (`id_empleado_B`) REFERENCES `empleado_contratado` (`id_empleado`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bitacora_empleado`
--

LOCK TABLES `bitacora_empleado` WRITE;
/*!40000 ALTER TABLE `bitacora_empleado` DISABLE KEYS */;
INSERT INTO `bitacora_empleado` VALUES (1,'1010'),(2,'1011'),(3,'1012'),(4,'1013'),(5,'1013');
/*!40000 ALTER TABLE `bitacora_empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clasificacion_cuenta`
--

DROP TABLE IF EXISTS `clasificacion_cuenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clasificacion_cuenta` (
  `id_clasificacion` varchar(10) NOT NULL,
  `nombre_clasificacion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_clasificacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clasificacion_cuenta`
--

LOCK TABLES `clasificacion_cuenta` WRITE;
/*!40000 ALTER TABLE `clasificacion_cuenta` DISABLE KEYS */;
INSERT INTO `clasificacion_cuenta` VALUES ('1','Corriente'),('2','No Corriente'),('3','Ingresos'),('4','Pérdida'),('5','Ganancia');
/*!40000 ALTER TABLE `clasificacion_cuenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `concepto_bancario`
--

DROP TABLE IF EXISTS `concepto_bancario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `concepto_bancario` (
  `codigo_concepto` varchar(10) NOT NULL,
  `nombre_concepto` varchar(50) DEFAULT NULL,
  `afecta` char(1) DEFAULT NULL,
  `estatus_concepto` char(1) DEFAULT NULL,
  `id_cuenta` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`codigo_concepto`),
  KEY `id_cuenta` (`id_cuenta`),
  CONSTRAINT `concepto_bancario_ibfk_1` FOREIGN KEY (`id_cuenta`) REFERENCES `cuenta_contable` (`id_cuenta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `concepto_bancario`
--

LOCK TABLES `concepto_bancario` WRITE;
/*!40000 ALTER TABLE `concepto_bancario` DISABLE KEYS */;
INSERT INTO `concepto_bancario` VALUES ('1','Concepto 1','+','A','1'),('2','Concepto 2','+','A','2'),('3','Concepto 3','+','A','3'),('4','Concepto 4','-','A','4'),('5','Compra','-','A','1');
/*!40000 ALTER TABLE `concepto_bancario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `concepto_planilla`
--

DROP TABLE IF EXISTS `concepto_planilla`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `concepto_planilla` (
  `id_conceptoPlanilla` varchar(10) NOT NULL,
  `nombre_concepto` varchar(20) DEFAULT NULL,
  `tipo_concepto` varchar(10) DEFAULT NULL,
  `clase_concepto` varchar(25) DEFAULT NULL,
  `Valor_concepto` float DEFAULT NULL,
  PRIMARY KEY (`id_conceptoPlanilla`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `concepto_planilla`
--

LOCK TABLES `concepto_planilla` WRITE;
/*!40000 ALTER TABLE `concepto_planilla` DISABLE KEYS */;
INSERT INTO `concepto_planilla` VALUES ('1','IGSS','Porcentaje','Deducccion',0.0483),('2','ISR1','Porcentaje','Deducccion',0.05),('3','ISR2','Porcentaje','Deducccion',0.06),('4','ISR3','Porcentaje','Deducccion',0.08),('5','Comisiones','Monto','Percepcion',0),('6','Sueldo','Cuota','Percepcion',0);
/*!40000 ALTER TABLE `concepto_planilla` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conciliacion_bancaria_det`
--

DROP TABLE IF EXISTS `conciliacion_bancaria_det`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `conciliacion_bancaria_det` (
  `id_encabezado` varchar(10) NOT NULL,
  `codigo_concepto` varchar(10) NOT NULL,
  `fecha_aplicacion` date DEFAULT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `id_formapago` varchar(10) NOT NULL,
  `beneficiario` varchar(35) DEFAULT NULL,
  `estado_conciliacion` char(1) DEFAULT NULL,
  `cargo` float DEFAULT NULL,
  `abono` float DEFAULT NULL,
  PRIMARY KEY (`id_encabezado`,`codigo_concepto`,`id_formapago`),
  KEY `codigo_concepto` (`codigo_concepto`),
  KEY `id_formapago` (`id_formapago`),
  CONSTRAINT `conciliacion_bancaria_det_ibfk_1` FOREIGN KEY (`codigo_concepto`) REFERENCES `concepto_bancario` (`codigo_concepto`),
  CONSTRAINT `conciliacion_bancaria_det_ibfk_2` FOREIGN KEY (`id_formapago`) REFERENCES `forma_pago` (`id_formapago`),
  CONSTRAINT `conciliacion_bancaria_det_ibfk_3` FOREIGN KEY (`id_encabezado`) REFERENCES `conciliacion_bancenc` (`id_encabezado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conciliacion_bancaria_det`
--

LOCK TABLES `conciliacion_bancaria_det` WRITE;
/*!40000 ALTER TABLE `conciliacion_bancaria_det` DISABLE KEYS */;
INSERT INTO `conciliacion_bancaria_det` VALUES ('1','1','2020-08-15','operacion','1','cliente','A',800,200),('2','3','2020-08-15','operacion','3','Proveedor','A',1000,500);
/*!40000 ALTER TABLE `conciliacion_bancaria_det` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conciliacion_bancenc`
--

DROP TABLE IF EXISTS `conciliacion_bancenc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `conciliacion_bancenc` (
  `id_encabezado` varchar(10) NOT NULL,
  `cargo_conciliar` float DEFAULT NULL,
  `abono_conciliar` float DEFAULT NULL,
  `saldo_corte` float DEFAULT NULL,
  `cargo_conciliado` float DEFAULT NULL,
  `abono_conciliado` float DEFAULT NULL,
  `saldo_final` float DEFAULT NULL,
  PRIMARY KEY (`id_encabezado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conciliacion_bancenc`
--

LOCK TABLES `conciliacion_bancenc` WRITE;
/*!40000 ALTER TABLE `conciliacion_bancenc` DISABLE KEYS */;
INSERT INTO `conciliacion_bancenc` VALUES ('1',1000,50,800,60,40,100),('2',500,80,200,100,500,800);
/*!40000 ALTER TABLE `conciliacion_bancenc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contratacion`
--

DROP TABLE IF EXISTS `contratacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contratacion` (
  `id_contratacion` varchar(10) NOT NULL,
  `id_periodop` varchar(10) DEFAULT NULL,
  `fecha_contratacion` date DEFAULT NULL,
  `duracion_contrato` varchar(35) DEFAULT NULL,
  `estatus_contratacion` char(1) DEFAULT NULL,
  PRIMARY KEY (`id_contratacion`),
  KEY `id_periodop` (`id_periodop`),
  CONSTRAINT `contratacion_ibfk_1` FOREIGN KEY (`id_periodop`) REFERENCES `periodo_prueba` (`id_periodop`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contratacion`
--

LOCK TABLES `contratacion` WRITE;
/*!40000 ALTER TABLE `contratacion` DISABLE KEYS */;
INSERT INTO `contratacion` VALUES ('1','1','2019-08-15','1 año','A'),('2','2','2019-08-15','6 meses','A'),('3','3','2019-08-15','2 años','A');
/*!40000 ALTER TABLE `contratacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuenta_contable`
--

DROP TABLE IF EXISTS `cuenta_contable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuenta_contable` (
  `id_cuenta` varchar(10) NOT NULL,
  `nombre_cuenta` varchar(35) DEFAULT NULL,
  `tipo_cuenta` varchar(35) DEFAULT NULL,
  `id_clasificacion` varchar(10) DEFAULT NULL,
  `saldo_anterior` float DEFAULT NULL,
  `cargos_acumulados` float DEFAULT NULL,
  `abonos_acumulados` float DEFAULT NULL,
  `saldo_actual` float DEFAULT NULL,
  `descripcion_cuenta` varchar(35) DEFAULT NULL,
  PRIMARY KEY (`id_cuenta`),
  KEY `id_clasificacion` (`id_clasificacion`),
  CONSTRAINT `cuenta_contable_ibfk_1` FOREIGN KEY (`id_clasificacion`) REFERENCES `clasificacion_cuenta` (`id_clasificacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuenta_contable`
--

LOCK TABLES `cuenta_contable` WRITE;
/*!40000 ALTER TABLE `cuenta_contable` DISABLE KEYS */;
INSERT INTO `cuenta_contable` VALUES ('1','Caja','Activo','1',11200,0,0,0,'Efectivo'),('2','Bancos','Activo','1',20700,0,0,0,'Cheques'),('3','Ventas','Estado de Resultados','5',53200,0,0,0,'Ganancias'),('4','Préstamos Bancarios','Activo','1',15000,0,0,0,'Cheques');
/*!40000 ALTER TABLE `cuenta_contable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curriculum`
--

DROP TABLE IF EXISTS `curriculum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curriculum` (
  `dpi_persona` varchar(13) NOT NULL,
  `nombres_persona` varchar(100) DEFAULT NULL,
  `apellidos_persona` varchar(100) DEFAULT NULL,
  `telefono_persona` int DEFAULT NULL,
  `correo_electronico` varchar(80) DEFAULT NULL,
  `direccion_persona` varchar(80) DEFAULT NULL,
  `genero_persona` char(1) DEFAULT NULL,
  `edad_persona` int DEFAULT NULL,
  `id_nivel_academico` varchar(10) DEFAULT NULL,
  `id_referenciaP` varchar(10) DEFAULT NULL,
  `id_referenciaL` varchar(10) DEFAULT NULL,
  `id_experiencia` varchar(10) DEFAULT NULL,
  `id_medio` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`dpi_persona`),
  KEY `id_nivel_academico` (`id_nivel_academico`),
  KEY `id_referenciaP` (`id_referenciaP`),
  KEY `id_referenciaL` (`id_referenciaL`),
  KEY `id_experiencia` (`id_experiencia`),
  KEY `id_medio` (`id_medio`),
  CONSTRAINT `curriculum_ibfk_1` FOREIGN KEY (`id_nivel_academico`) REFERENCES `nivel_academico` (`id_nivel_academico`),
  CONSTRAINT `curriculum_ibfk_2` FOREIGN KEY (`id_referenciaP`) REFERENCES `referenciasp` (`id_referenciaP`),
  CONSTRAINT `curriculum_ibfk_3` FOREIGN KEY (`id_referenciaL`) REFERENCES `referenciasl` (`id_referenciaL`),
  CONSTRAINT `curriculum_ibfk_4` FOREIGN KEY (`id_experiencia`) REFERENCES `experiencia_laboral` (`id_experiencia`),
  CONSTRAINT `curriculum_ibfk_5` FOREIGN KEY (`id_medio`) REFERENCES `medio` (`id_medio`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curriculum`
--

LOCK TABLES `curriculum` WRITE;
/*!40000 ALTER TABLE `curriculum` DISABLE KEYS */;
INSERT INTO `curriculum` VALUES ('3110','Jose','Migel',4567895,'Jose@gmail.com','Ciudad','M',22,'2','1','1','1','1'),('3111','Carlos','Marcos',56561245,'Carlos@gmail.com','Ciudad','M',25,'2','2','2','2','2'),('3112','Daniel','Guitierrez',78985623,'Daniel@gmail.com','Ciudad','M',30,'3','3','3','3','3');
/*!40000 ALTER TABLE `curriculum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departamento` (
  `id_departamento` varchar(10) NOT NULL,
  `nombre_departamento` varchar(35) DEFAULT NULL,
  `estatus_departamento` char(1) DEFAULT NULL,
  PRIMARY KEY (`id_departamento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES ('1','Sistemas','A'),('2','Financiero','A'),('3','Seguridad','A');
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `documento_bancario`
--

DROP TABLE IF EXISTS `documento_bancario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `documento_bancario` (
  `codigo_Documento` varchar(10) NOT NULL,
  `nombre_Documento` varchar(50) DEFAULT NULL,
  `afecta` char(1) DEFAULT NULL,
  `estatus_documento` char(1) DEFAULT NULL,
  PRIMARY KEY (`codigo_Documento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documento_bancario`
--

LOCK TABLES `documento_bancario` WRITE;
/*!40000 ALTER TABLE `documento_bancario` DISABLE KEYS */;
INSERT INTO `documento_bancario` VALUES ('0001','Pago','+','A'),('0002','Cheque','+','A'),('0003','Factura','+','A'),('0004','Depósito','-','A'),('0005','Compra','-','A');
/*!40000 ALTER TABLE `documento_bancario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado_contratado`
--

DROP TABLE IF EXISTS `empleado_contratado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado_contratado` (
  `id_empleado` varchar(10) NOT NULL,
  `id_contratacion` varchar(10) DEFAULT NULL,
  `id_puesto` varchar(10) DEFAULT NULL,
  `id_departamento` varchar(10) DEFAULT NULL,
  `sueldo_empleado` float DEFAULT NULL,
  PRIMARY KEY (`id_empleado`),
  KEY `id_contratacion` (`id_contratacion`),
  KEY `id_puesto` (`id_puesto`),
  KEY `id_departamento` (`id_departamento`),
  CONSTRAINT `empleado_contratado_ibfk_1` FOREIGN KEY (`id_contratacion`) REFERENCES `contratacion` (`id_contratacion`),
  CONSTRAINT `empleado_contratado_ibfk_2` FOREIGN KEY (`id_puesto`) REFERENCES `puesto` (`id_puesto`),
  CONSTRAINT `empleado_contratado_ibfk_3` FOREIGN KEY (`id_departamento`) REFERENCES `departamento` (`id_departamento`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado_contratado`
--

LOCK TABLES `empleado_contratado` WRITE;
/*!40000 ALTER TABLE `empleado_contratado` DISABLE KEYS */;
INSERT INTO `empleado_contratado` VALUES ('1010','1','1','1',10000),('1011','2','2','2',8000),('1012','3','3','3',7000),('1013','3','2','3',9000),('1014','2','2','3',5500);
/*!40000 ALTER TABLE `empleado_contratado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `experiencia_laboral`
--

DROP TABLE IF EXISTS `experiencia_laboral`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `experiencia_laboral` (
  `id_experiencia` varchar(10) NOT NULL,
  `id_tipoexp` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_experiencia`),
  KEY `id_tipoexp` (`id_tipoexp`),
  CONSTRAINT `experiencia_laboral_ibfk_1` FOREIGN KEY (`id_tipoexp`) REFERENCES `explab_detallado` (`id_tipoexp`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `experiencia_laboral`
--

LOCK TABLES `experiencia_laboral` WRITE;
/*!40000 ALTER TABLE `experiencia_laboral` DISABLE KEYS */;
INSERT INTO `experiencia_laboral` VALUES ('1','1'),('2','2'),('3','3'),('4','4');
/*!40000 ALTER TABLE `experiencia_laboral` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `explab_detallado`
--

DROP TABLE IF EXISTS `explab_detallado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `explab_detallado` (
  `id_tipoexp` varchar(10) NOT NULL,
  `nombre_tipo` varchar(50) DEFAULT NULL,
  `nombre_empresa` varchar(50) DEFAULT NULL,
  `tiempo_inicio` date DEFAULT NULL,
  `tiempo_finalizacion` date DEFAULT NULL,
  PRIMARY KEY (`id_tipoexp`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `explab_detallado`
--

LOCK TABLES `explab_detallado` WRITE;
/*!40000 ALTER TABLE `explab_detallado` DISABLE KEYS */;
INSERT INTO `explab_detallado` VALUES ('1','Inventarios','Carro Modelo','1996-08-15','2019-05-10'),('2','Ventas','El hacer','1980-05-14','2000-08-06'),('3','Servicio','LTD','2015-05-02','2019-04-04'),('4','Computacion','TFC','2013-05-15','2020-01-13');
/*!40000 ALTER TABLE `explab_detallado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forma_pago`
--

DROP TABLE IF EXISTS `forma_pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `forma_pago` (
  `id_formapago` varchar(10) NOT NULL,
  `tipo_pago` varchar(35) DEFAULT NULL,
  PRIMARY KEY (`id_formapago`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forma_pago`
--

LOCK TABLES `forma_pago` WRITE;
/*!40000 ALTER TABLE `forma_pago` DISABLE KEYS */;
INSERT INTO `forma_pago` VALUES ('1','Efectivo'),('2','Crédito'),('3','Cuota'),('4','Cheque');
/*!40000 ALTER TABLE `forma_pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `impuesto_huesped`
--

DROP TABLE IF EXISTS `impuesto_huesped`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `impuesto_huesped` (
  `id_impuesto` varchar(10) NOT NULL,
  `tipo_impuesto` varchar(50) DEFAULT NULL,
  `cantidad_impuesto` float DEFAULT NULL,
  `descripcion_impuesto` varchar(80) DEFAULT NULL,
  `estatus_impuesto` char(1) DEFAULT NULL,
  PRIMARY KEY (`id_impuesto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `impuesto_huesped`
--

LOCK TABLES `impuesto_huesped` WRITE;
/*!40000 ALTER TABLE `impuesto_huesped` DISABLE KEYS */;
/*!40000 ALTER TABLE `impuesto_huesped` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medio`
--

DROP TABLE IF EXISTS `medio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medio` (
  `id_medio` varchar(10) NOT NULL,
  `id_solicitud` varchar(10) DEFAULT NULL,
  `nombre_medio` varchar(35) DEFAULT NULL,
  `descripcion` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id_medio`),
  KEY `id_solicitud` (`id_solicitud`),
  CONSTRAINT `medio_ibfk_1` FOREIGN KEY (`id_solicitud`) REFERENCES `solicitud_empresarial` (`id_solicitud`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medio`
--

LOCK TABLES `medio` WRITE;
/*!40000 ALTER TABLE `medio` DISABLE KEYS */;
INSERT INTO `medio` VALUES ('1','1','Prensa','Ninguna'),('2','2','Television','Ninguna'),('3','3','Internet','Ninguna');
/*!40000 ALTER TABLE `medio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `moneda`
--

DROP TABLE IF EXISTS `moneda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `moneda` (
  `id_moneda` varchar(10) NOT NULL,
  `nombre_moneda` varchar(20) NOT NULL,
  `tipo_cambio` float DEFAULT NULL,
  `estatus_moneda` char(1) DEFAULT NULL,
  PRIMARY KEY (`id_moneda`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `moneda`
--

LOCK TABLES `moneda` WRITE;
/*!40000 ALTER TABLE `moneda` DISABLE KEYS */;
INSERT INTO `moneda` VALUES ('1','Quetzal',0,'A'),('2','Dólar',7.78,'A'),('3','Euro',0.11,'A'),('4','Yen Japones',13.51,'A');
/*!40000 ALTER TABLE `moneda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mov_bancdet`
--

DROP TABLE IF EXISTS `mov_bancdet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mov_bancdet` (
  `id_movEnc` varchar(10) NOT NULL,
  `codigo_concepto` varchar(10) NOT NULL,
  `saldo_deudor` float DEFAULT NULL,
  `saldo_acreedor` float DEFAULT NULL,
  PRIMARY KEY (`id_movEnc`,`codigo_concepto`),
  KEY `codigo_concepto` (`codigo_concepto`),
  CONSTRAINT `mov_bancdet_ibfk_1` FOREIGN KEY (`id_movEnc`) REFERENCES `mov_bancenc` (`id_movEnc`),
  CONSTRAINT `mov_bancdet_ibfk_2` FOREIGN KEY (`codigo_concepto`) REFERENCES `concepto_bancario` (`codigo_concepto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mov_bancdet`
--

LOCK TABLES `mov_bancdet` WRITE;
/*!40000 ALTER TABLE `mov_bancdet` DISABLE KEYS */;
INSERT INTO `mov_bancdet` VALUES ('1','1',800,0),('1','2',0,1000),('1','3',10000,0),('1','4',0,2000),('2','2',4000,0),('2','4',3000,0),('3','2',1500,0),('3','3',800,0),('4','1',8000,0),('4','2',0,300),('4','4',10000,0);
/*!40000 ALTER TABLE `mov_bancdet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mov_bancenc`
--

DROP TABLE IF EXISTS `mov_bancenc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mov_bancenc` (
  `id_movEnc` varchar(10) NOT NULL,
  `codigo_Documento` varchar(10) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `monto` float DEFAULT NULL,
  `descripcion` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id_movEnc`),
  KEY `codigo_Documento` (`codigo_Documento`),
  CONSTRAINT `mov_bancenc_ibfk_1` FOREIGN KEY (`codigo_Documento`) REFERENCES `documento_bancario` (`codigo_Documento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mov_bancenc`
--

LOCK TABLES `mov_bancenc` WRITE;
/*!40000 ALTER TABLE `mov_bancenc` DISABLE KEYS */;
INSERT INTO `mov_bancenc` VALUES ('1','0001','2020-11-10',10000,'Diferentes operaciones'),('2','0002','2020-11-09',15000,'Distintas Transacciones'),('3','0003','2020-11-08',18000,'Distintas transacciones'),('4','0005','2020-11-12',20000,'Distintas compras');
/*!40000 ALTER TABLE `mov_bancenc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nivel_academico`
--

DROP TABLE IF EXISTS `nivel_academico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nivel_academico` (
  `id_nivel_academico` varchar(10) NOT NULL,
  `nombre_nivel` varchar(100) DEFAULT NULL,
  `descripcion` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id_nivel_academico`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nivel_academico`
--

LOCK TABLES `nivel_academico` WRITE;
/*!40000 ALTER TABLE `nivel_academico` DISABLE KEYS */;
INSERT INTO `nivel_academico` VALUES ('1','Nivel Medio','ninguna'),('2','Universitario','ninguna'),('3','Magister','ninguna'),('4','Doctorado','ninguna');
/*!40000 ALTER TABLE `nivel_academico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `periodo_prueba`
--

DROP TABLE IF EXISTS `periodo_prueba`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `periodo_prueba` (
  `id_periodop` varchar(10) NOT NULL,
  `id_seleccion` varchar(10) DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_finalizacion` date DEFAULT NULL,
  `pago` float DEFAULT NULL,
  `id_actividad` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_periodop`),
  KEY `id_actividad` (`id_actividad`),
  KEY `id_seleccion` (`id_seleccion`),
  CONSTRAINT `periodo_prueba_ibfk_1` FOREIGN KEY (`id_actividad`) REFERENCES `actividad` (`id_actividad`),
  CONSTRAINT `periodo_prueba_ibfk_2` FOREIGN KEY (`id_seleccion`) REFERENCES `seleccion` (`id_seleccion`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `periodo_prueba`
--

LOCK TABLES `periodo_prueba` WRITE;
/*!40000 ALTER TABLE `periodo_prueba` DISABLE KEYS */;
INSERT INTO `periodo_prueba` VALUES ('1','1','2020-08-15','2020-09-15',2000,'1'),('2','2','2020-08-15','2020-10-08',3000,'2'),('3','3','2020-08-15','2020-12-09',10000,'2');
/*!40000 ALTER TABLE `periodo_prueba` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planilla_det`
--

DROP TABLE IF EXISTS `planilla_det`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `planilla_det` (
  `id_planillaDe` varchar(10) NOT NULL,
  `id_planillaenc` varchar(10) NOT NULL,
  `id_empleado` varchar(10) NOT NULL,
  `id_conceptoPlanilla` varchar(10) NOT NULL,
  `valor_conceptoDet` float DEFAULT NULL,
  PRIMARY KEY (`id_planillaDe`,`id_planillaenc`,`id_empleado`,`id_conceptoPlanilla`),
  KEY `id_planillaenc` (`id_planillaenc`),
  KEY `id_conceptoPlanilla` (`id_conceptoPlanilla`),
  KEY `id_empleado` (`id_empleado`),
  CONSTRAINT `planilla_det_ibfk_1` FOREIGN KEY (`id_planillaenc`) REFERENCES `planilla_enc` (`id_planillaenc`),
  CONSTRAINT `planilla_det_ibfk_2` FOREIGN KEY (`id_conceptoPlanilla`) REFERENCES `concepto_planilla` (`id_conceptoPlanilla`),
  CONSTRAINT `planilla_det_ibfk_3` FOREIGN KEY (`id_empleado`) REFERENCES `empleado_contratado` (`id_empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planilla_det`
--

LOCK TABLES `planilla_det` WRITE;
/*!40000 ALTER TABLE `planilla_det` DISABLE KEYS */;
INSERT INTO `planilla_det` VALUES ('1','1','1010','1',483),('1','2','1011','1',386.4),('2','1','1010','5',100),('2','2','1011','5',200),('3','1','1010','6',10000);
/*!40000 ALTER TABLE `planilla_det` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planilla_enc`
--

DROP TABLE IF EXISTS `planilla_enc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `planilla_enc` (
  `id_planillaenc` varchar(10) NOT NULL,
  `total_percepcion` float DEFAULT NULL,
  `total_deduccion` float DEFAULT NULL,
  `total_liquido` float DEFAULT NULL,
  PRIMARY KEY (`id_planillaenc`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planilla_enc`
--

LOCK TABLES `planilla_enc` WRITE;
/*!40000 ALTER TABLE `planilla_enc` DISABLE KEYS */;
INSERT INTO `planilla_enc` VALUES ('1',10100,483,9617),('2',200,386.4,-186.4);
/*!40000 ALTER TABLE `planilla_enc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `poliza_detalle`
--

DROP TABLE IF EXISTS `poliza_detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `poliza_detalle` (
  `id_encabezado` varchar(10) NOT NULL,
  `id_cuenta` varchar(10) NOT NULL,
  `descripcion_movpoliza` varchar(50) DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_final` date DEFAULT NULL,
  `debe` float DEFAULT NULL,
  `haber` float DEFAULT NULL,
  `estatus_poliza` char(1) DEFAULT NULL,
  PRIMARY KEY (`id_encabezado`,`id_cuenta`),
  KEY `id_cuenta` (`id_cuenta`),
  CONSTRAINT `poliza_detalle_ibfk_1` FOREIGN KEY (`id_encabezado`) REFERENCES `poliza_encab` (`id_encabezado`),
  CONSTRAINT `poliza_detalle_ibfk_2` FOREIGN KEY (`id_cuenta`) REFERENCES `cuenta_contable` (`id_cuenta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `poliza_detalle`
--

LOCK TABLES `poliza_detalle` WRITE;
/*!40000 ALTER TABLE `poliza_detalle` DISABLE KEYS */;
/*!40000 ALTER TABLE `poliza_detalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `poliza_encab`
--

DROP TABLE IF EXISTS `poliza_encab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `poliza_encab` (
  `id_encabezado` varchar(10) NOT NULL,
  `tipo_poliza` varchar(50) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `descripcion_poliza` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id_encabezado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `poliza_encab`
--

LOCK TABLES `poliza_encab` WRITE;
/*!40000 ALTER TABLE `poliza_encab` DISABLE KEYS */;
/*!40000 ALTER TABLE `poliza_encab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puesto`
--

DROP TABLE IF EXISTS `puesto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `puesto` (
  `id_puesto` varchar(10) NOT NULL,
  `nombre_puesto` varchar(35) DEFAULT NULL,
  `descripcion` varchar(35) DEFAULT NULL,
  `estatus_puesto` char(1) DEFAULT NULL,
  PRIMARY KEY (`id_puesto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puesto`
--

LOCK TABLES `puesto` WRITE;
/*!40000 ALTER TABLE `puesto` DISABLE KEYS */;
INSERT INTO `puesto` VALUES ('1','Desarrollador','Conocimientos','A'),('2','Administrador','ninguna','A'),('3','Analista','De riesgos','A');
/*!40000 ALTER TABLE `puesto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `referenciasl`
--

DROP TABLE IF EXISTS `referenciasl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `referenciasl` (
  `id_referenciaL` varchar(10) NOT NULL,
  `nombre_personaL` varchar(50) DEFAULT NULL,
  `telefono_personaL` int DEFAULT NULL,
  PRIMARY KEY (`id_referenciaL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `referenciasl`
--

LOCK TABLES `referenciasl` WRITE;
/*!40000 ALTER TABLE `referenciasl` DISABLE KEYS */;
INSERT INTO `referenciasl` VALUES ('1','Alex Diego',45678222),('2','Juan Daniel',15985222),('3','Artemio Dominguez',45658545);
/*!40000 ALTER TABLE `referenciasl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `referenciasp`
--

DROP TABLE IF EXISTS `referenciasp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `referenciasp` (
  `id_referenciaP` varchar(10) NOT NULL,
  `nombre_personaP` varchar(50) DEFAULT NULL,
  `telefono_personaP` int DEFAULT NULL,
  PRIMARY KEY (`id_referenciaP`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `referenciasp`
--

LOCK TABLES `referenciasp` WRITE;
/*!40000 ALTER TABLE `referenciasp` DISABLE KEYS */;
INSERT INTO `referenciasp` VALUES ('1','Ernesto Paco',45785625),('2','Juan Cal',55558555),('3','Danien Juarez',45212781);
/*!40000 ALTER TABLE `referenciasp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seleccion`
--

DROP TABLE IF EXISTS `seleccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seleccion` (
  `id_seleccion` varchar(10) NOT NULL,
  `id_ap` varchar(10) DEFAULT NULL,
  `estatus_seleccion` char(1) DEFAULT NULL,
  PRIMARY KEY (`id_seleccion`),
  KEY `id_ap` (`id_ap`),
  CONSTRAINT `seleccion_ibfk_1` FOREIGN KEY (`id_ap`) REFERENCES `aplicacion_prueba` (`id_ap`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seleccion`
--

LOCK TABLES `seleccion` WRITE;
/*!40000 ALTER TABLE `seleccion` DISABLE KEYS */;
INSERT INTO `seleccion` VALUES ('1','1','A'),('2','2','A'),('3','3','A');
/*!40000 ALTER TABLE `seleccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitud_empresarial`
--

DROP TABLE IF EXISTS `solicitud_empresarial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `solicitud_empresarial` (
  `id_solicitud` varchar(10) NOT NULL,
  `rango_edad_menor` int DEFAULT NULL,
  `rango_edad_mayor` int DEFAULT NULL,
  `genero` char(1) DEFAULT NULL,
  `id_puesto` varchar(10) DEFAULT NULL,
  `id_departamento` varchar(10) DEFAULT NULL,
  `id_nivel_academico` varchar(10) DEFAULT NULL,
  `id_experiencia` varchar(10) DEFAULT NULL,
  `descripcion` text,
  PRIMARY KEY (`id_solicitud`),
  KEY `id_puesto` (`id_puesto`),
  KEY `id_departamento` (`id_departamento`),
  KEY `id_nivel_academico` (`id_nivel_academico`),
  KEY `id_experiencia` (`id_experiencia`),
  CONSTRAINT `solicitud_empresarial_ibfk_1` FOREIGN KEY (`id_puesto`) REFERENCES `puesto` (`id_puesto`),
  CONSTRAINT `solicitud_empresarial_ibfk_2` FOREIGN KEY (`id_departamento`) REFERENCES `departamento` (`id_departamento`),
  CONSTRAINT `solicitud_empresarial_ibfk_3` FOREIGN KEY (`id_nivel_academico`) REFERENCES `nivel_academico` (`id_nivel_academico`),
  CONSTRAINT `solicitud_empresarial_ibfk_4` FOREIGN KEY (`id_experiencia`) REFERENCES `experiencia_laboral` (`id_experiencia`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitud_empresarial`
--

LOCK TABLES `solicitud_empresarial` WRITE;
/*!40000 ALTER TABLE `solicitud_empresarial` DISABLE KEYS */;
INSERT INTO `solicitud_empresarial` VALUES ('1',20,35,'M','1','1','2','1','ninguna'),('2',20,35,'M','2','2','2','2','ninguna'),('3',20,35,'M','3','3','3','3','ninguna');
/*!40000 ALTER TABLE `solicitud_empresarial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_pruebas`
--

DROP TABLE IF EXISTS `tipo_pruebas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_pruebas` (
  `id_prueba` varchar(10) NOT NULL,
  `tipo_prueba` varchar(35) DEFAULT NULL,
  PRIMARY KEY (`id_prueba`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_pruebas`
--

LOCK TABLES `tipo_pruebas` WRITE;
/*!40000 ALTER TABLE `tipo_pruebas` DISABLE KEYS */;
INSERT INTO `tipo_pruebas` VALUES ('1','Psicologo'),('2','Polígrafo'),('3','Habilidades');
/*!40000 ALTER TABLE `tipo_pruebas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `NombreUsuario` varchar(30) NOT NULL,
  `Pass` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES ('Brayan','12345'),('Administrador','123'),('Admin','12345');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'hotel'
--

--
-- Dumping routines for database 'hotel'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-13 15:37:13
