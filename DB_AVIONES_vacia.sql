-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.6.26-log - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para aeropuerto
DROP DATABASE IF EXISTS `aeropuerto`;
CREATE DATABASE IF NOT EXISTS `aeropuerto` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `aeropuerto`;


-- Volcando estructura para tabla aeropuerto.aeropuerto
DROP TABLE IF EXISTS `aeropuerto`;
CREATE TABLE IF NOT EXISTS `aeropuerto` (
  `code_aeropuerto` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `IATA` varchar(3) NOT NULL DEFAULT '0',
  `nombre_aeropuerto` varchar(50) NOT NULL DEFAULT '0',
  `ciudad_aeropuerto` varchar(50) NOT NULL DEFAULT '0',
  `pais_aeropuerto` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`code_aeropuerto`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla aeropuerto.aeropuerto: ~4 rows (aproximadamente)
DELETE FROM `aeropuerto`;
/*!40000 ALTER TABLE `aeropuerto` DISABLE KEYS */;
INSERT INTO `aeropuerto` (`code_aeropuerto`, `IATA`, `nombre_aeropuerto`, `ciudad_aeropuerto`, `pais_aeropuerto`) VALUES
	(1, 'MAD', 'Aeropuerto Adolfo Suárez Madrid-Barajas', 'Madrid', 'España'),
	(2, 'NYC', 'Aeropuerto Internacional John F. Kennedy', 'Nueva York', 'EE.UU.'),
	(3, 'PAR', 'Aeropuerto de París-Orly', 'París', 'Francia'),
	(4, 'TYO', 'Aeropuerto Internacional de Narita', 'Narita, Tokio', 'Japón');
/*!40000 ALTER TABLE `aeropuerto` ENABLE KEYS */;


-- Volcando estructura para tabla aeropuerto.backup_bebe
DROP TABLE IF EXISTS `backup_bebe`;
CREATE TABLE IF NOT EXISTS `backup_bebe` (
  `codigo` int(10) unsigned NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `nif` varchar(50) NOT NULL,
  `pais` varchar(50) NOT NULL,
  `tutor` int(10) unsigned NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_bebe_pasajeros` (`tutor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- Volcando datos para la tabla aeropuerto.backup_bebe: ~0 rows (aproximadamente)
DELETE FROM `backup_bebe`;
/*!40000 ALTER TABLE `backup_bebe` DISABLE KEYS */;
/*!40000 ALTER TABLE `backup_bebe` ENABLE KEYS */;


-- Volcando estructura para tabla aeropuerto.backup_ocupacion
DROP TABLE IF EXISTS `backup_ocupacion`;
CREATE TABLE IF NOT EXISTS `backup_ocupacion` (
  `codigo` int(10) unsigned NOT NULL,
  `vuelo` int(10) unsigned NOT NULL,
  `asiento` varchar(50) NOT NULL,
  `facturado` int(11) NOT NULL DEFAULT '0',
  `pasajero` int(10) unsigned NOT NULL,
  `booking_code` varchar(50) NOT NULL,
  `importe` double DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- Volcando datos para la tabla aeropuerto.backup_ocupacion: ~0 rows (aproximadamente)
DELETE FROM `backup_ocupacion`;
/*!40000 ALTER TABLE `backup_ocupacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `backup_ocupacion` ENABLE KEYS */;


-- Volcando estructura para tabla aeropuerto.backup_pagos
DROP TABLE IF EXISTS `backup_pagos`;
CREATE TABLE IF NOT EXISTS `backup_pagos` (
  `codigo` int(10) unsigned NOT NULL,
  `booking_code` varchar(50) NOT NULL,
  `fecha` date DEFAULT NULL,
  `cod_cliente` int(10) unsigned NOT NULL,
  `importe_total` double NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_pagos_cliente` (`cod_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- Volcando datos para la tabla aeropuerto.backup_pagos: ~0 rows (aproximadamente)
DELETE FROM `backup_pagos`;
/*!40000 ALTER TABLE `backup_pagos` DISABLE KEYS */;
/*!40000 ALTER TABLE `backup_pagos` ENABLE KEYS */;


-- Volcando estructura para tabla aeropuerto.backup_pasajeros
DROP TABLE IF EXISTS `backup_pasajeros`;
CREATE TABLE IF NOT EXISTS `backup_pasajeros` (
  `codigo` int(10) unsigned NOT NULL,
  `nif` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `pais_expedicion` varchar(50) NOT NULL,
  `tutor` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_pasajeros_pasajeros` (`tutor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- Volcando datos para la tabla aeropuerto.backup_pasajeros: ~0 rows (aproximadamente)
DELETE FROM `backup_pasajeros`;
/*!40000 ALTER TABLE `backup_pasajeros` DISABLE KEYS */;
/*!40000 ALTER TABLE `backup_pasajeros` ENABLE KEYS */;


-- Volcando estructura para tabla aeropuerto.backup_servicios_contratados
DROP TABLE IF EXISTS `backup_servicios_contratados`;
CREATE TABLE IF NOT EXISTS `backup_servicios_contratados` (
  `codigo` int(11) NOT NULL,
  `cod_ocupacion` int(11) DEFAULT NULL,
  `siglas` varchar(50) DEFAULT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla aeropuerto.backup_servicios_contratados: ~0 rows (aproximadamente)
DELETE FROM `backup_servicios_contratados`;
/*!40000 ALTER TABLE `backup_servicios_contratados` DISABLE KEYS */;
/*!40000 ALTER TABLE `backup_servicios_contratados` ENABLE KEYS */;


-- Volcando estructura para tabla aeropuerto.backup_vuelos
DROP TABLE IF EXISTS `backup_vuelos`;
CREATE TABLE IF NOT EXISTS `backup_vuelos` (
  `codigo` int(10) unsigned NOT NULL,
  `conexion` int(10) unsigned NOT NULL,
  `fecha_salida` date NOT NULL,
  `hora_salida` time NOT NULL,
  `duracion` time NOT NULL,
  `numero_vuelo` varchar(50) NOT NULL,
  `precio` double unsigned NOT NULL,
  `plazas` int(10) unsigned NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_vuelo_conexion` (`conexion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- Volcando datos para la tabla aeropuerto.backup_vuelos: ~0 rows (aproximadamente)
DELETE FROM `backup_vuelos`;
/*!40000 ALTER TABLE `backup_vuelos` DISABLE KEYS */;
/*!40000 ALTER TABLE `backup_vuelos` ENABLE KEYS */;


-- Volcando estructura para tabla aeropuerto.bebe
DROP TABLE IF EXISTS `bebe`;
CREATE TABLE IF NOT EXISTS `bebe` (
  `codigo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `nif` varchar(50) NOT NULL,
  `pais` varchar(50) NOT NULL,
  `tutor` int(10) unsigned NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_bebe_pasajeros` (`tutor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla aeropuerto.bebe: ~0 rows (aproximadamente)
DELETE FROM `bebe`;
/*!40000 ALTER TABLE `bebe` DISABLE KEYS */;
/*!40000 ALTER TABLE `bebe` ENABLE KEYS */;


-- Volcando estructura para tabla aeropuerto.cliente
DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `codigo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre_completo` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `fecha_nac` date NOT NULL,
  `nif` varchar(50) NOT NULL,
  `direccion_facturacion` int(10) NOT NULL,
  `telefono` varchar(50) NOT NULL,
  `mail` varchar(50) NOT NULL,
  `tarjeta` varchar(50) DEFAULT NULL,
  `tipoTarjeta` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_cliente_direccionecliente` (`direccion_facturacion`),
  CONSTRAINT `FK_cliente_direccionecliente` FOREIGN KEY (`direccion_facturacion`) REFERENCES `direccioncliente` (`CODIGODIRECC`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla aeropuerto.cliente: ~1 rows (aproximadamente)
DELETE FROM `cliente`;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`codigo`, `nombre_completo`, `password`, `fecha_nac`, `nif`, `direccion_facturacion`, `telefono`, `mail`, `tarjeta`, `tipoTarjeta`) VALUES
	(1, 'Miriam Moreno Sánchez', '277f8d77fceb01b44add2092ff8bbc33', '1992-11-09', '47095727F', 1, '680647564', 'miriamms09@hotmail.com', '7177eefef9cf2eff23ab5175e98fcf27', 'MasterCard');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;


-- Volcando estructura para tabla aeropuerto.conexion
DROP TABLE IF EXISTS `conexion`;
CREATE TABLE IF NOT EXISTS `conexion` (
  `code` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `IATA_origen` int(10) unsigned NOT NULL,
  `IATA_destino` int(10) unsigned NOT NULL,
  PRIMARY KEY (`code`),
  KEY `iataori-FK` (`IATA_origen`),
  KEY `iatades-FK` (`IATA_destino`),
  CONSTRAINT `iatades-FK` FOREIGN KEY (`IATA_destino`) REFERENCES `aeropuerto` (`code_aeropuerto`),
  CONSTRAINT `iataori-FK` FOREIGN KEY (`IATA_origen`) REFERENCES `aeropuerto` (`code_aeropuerto`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla aeropuerto.conexion: ~6 rows (aproximadamente)
DELETE FROM `conexion`;
/*!40000 ALTER TABLE `conexion` DISABLE KEYS */;
INSERT INTO `conexion` (`code`, `IATA_origen`, `IATA_destino`) VALUES
	(1, 1, 2),
	(2, 1, 4),
	(3, 1, 3),
	(4, 2, 1),
	(5, 4, 1),
	(6, 3, 1);
/*!40000 ALTER TABLE `conexion` ENABLE KEYS */;


-- Volcando estructura para tabla aeropuerto.direccioncliente
DROP TABLE IF EXISTS `direccioncliente`;
CREATE TABLE IF NOT EXISTS `direccioncliente` (
  `CODIGODIRECC` int(11) NOT NULL AUTO_INCREMENT,
  `TIPO_VIA` varchar(50) NOT NULL DEFAULT '0',
  `NOMBRE_VIA` varchar(50) NOT NULL DEFAULT '0',
  `NUMERO` varchar(50) NOT NULL DEFAULT '0',
  `POBLACION` varchar(50) NOT NULL DEFAULT '0',
  `PROVINCIA` varchar(50) NOT NULL DEFAULT '0',
  `CODIGO_POSTAL` varchar(50) NOT NULL DEFAULT '0',
  `PAIS` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`CODIGODIRECC`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla aeropuerto.direccioncliente: ~1 rows (aproximadamente)
DELETE FROM `direccioncliente`;
/*!40000 ALTER TABLE `direccioncliente` DISABLE KEYS */;
INSERT INTO `direccioncliente` (`CODIGODIRECC`, `TIPO_VIA`, `NOMBRE_VIA`, `NUMERO`, `POBLACION`, `PROVINCIA`, `CODIGO_POSTAL`, `PAIS`) VALUES
	(1, 'Calle', 'Constitución', '10', 'Madrigueras', 'Albacete', '02230', 'España');
/*!40000 ALTER TABLE `direccioncliente` ENABLE KEYS */;


-- Volcando estructura para tabla aeropuerto.ocupacion
DROP TABLE IF EXISTS `ocupacion`;
CREATE TABLE IF NOT EXISTS `ocupacion` (
  `codigo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `vuelo` int(10) unsigned NOT NULL,
  `asiento` varchar(50) NOT NULL,
  `facturado` int(11) NOT NULL DEFAULT '0',
  `pasajero` int(10) unsigned NOT NULL,
  `booking_code` varchar(50) NOT NULL,
  `importe` double DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla aeropuerto.ocupacion: ~0 rows (aproximadamente)
DELETE FROM `ocupacion`;
/*!40000 ALTER TABLE `ocupacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `ocupacion` ENABLE KEYS */;


-- Volcando estructura para tabla aeropuerto.pagos
DROP TABLE IF EXISTS `pagos`;
CREATE TABLE IF NOT EXISTS `pagos` (
  `codigo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `booking_code` varchar(50) NOT NULL,
  `fecha` date DEFAULT NULL,
  `cod_cliente` int(10) unsigned NOT NULL,
  `importe_total` double NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_pagos_cliente` (`cod_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla aeropuerto.pagos: ~0 rows (aproximadamente)
DELETE FROM `pagos`;
/*!40000 ALTER TABLE `pagos` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagos` ENABLE KEYS */;


-- Volcando estructura para tabla aeropuerto.pasajeros
DROP TABLE IF EXISTS `pasajeros`;
CREATE TABLE IF NOT EXISTS `pasajeros` (
  `codigo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nif` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `pais_expedicion` varchar(50) NOT NULL,
  `tutor` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_pasajeros_pasajeros` (`tutor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla aeropuerto.pasajeros: ~0 rows (aproximadamente)
DELETE FROM `pasajeros`;
/*!40000 ALTER TABLE `pasajeros` DISABLE KEYS */;
/*!40000 ALTER TABLE `pasajeros` ENABLE KEYS */;


-- Volcando estructura para tabla aeropuerto.servicios
DROP TABLE IF EXISTS `servicios`;
CREATE TABLE IF NOT EXISTS `servicios` (
  `codigo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `siglas` varchar(50) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `precio` double unsigned NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla aeropuerto.servicios: ~7 rows (aproximadamente)
DELETE FROM `servicios`;
/*!40000 ALTER TABLE `servicios` DISABLE KEYS */;
INSERT INTO `servicios` (`codigo`, `siglas`, `descripcion`, `precio`) VALUES
	(1, 'S', 'Seguro de viaje', 30),
	(2, 'AA', 'Asiento Automático', 0),
	(3, 'EA', 'Elección Asiento', 15),
	(4, '1M', '1 maleta', 25),
	(5, '2M', '2 maletas', 50),
	(6, 'B', 'Bebé', 25),
	(7, 'PE', 'Prioridad embarque', 20);
/*!40000 ALTER TABLE `servicios` ENABLE KEYS */;


-- Volcando estructura para tabla aeropuerto.servicios_contratados
DROP TABLE IF EXISTS `servicios_contratados`;
CREATE TABLE IF NOT EXISTS `servicios_contratados` (
  `codigo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cod_ocupacion` int(10) unsigned NOT NULL,
  `cod_servicio` int(10) unsigned NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_servicios_contratados_servicios` (`cod_servicio`),
  KEY `FK_servicios_contratados_ocupacion` (`cod_ocupacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla aeropuerto.servicios_contratados: ~0 rows (aproximadamente)
DELETE FROM `servicios_contratados`;
/*!40000 ALTER TABLE `servicios_contratados` DISABLE KEYS */;
/*!40000 ALTER TABLE `servicios_contratados` ENABLE KEYS */;


-- Volcando estructura para tabla aeropuerto.vuelos
DROP TABLE IF EXISTS `vuelos`;
CREATE TABLE IF NOT EXISTS `vuelos` (
  `codigo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `conexion` int(10) unsigned NOT NULL,
  `fecha_salida` date NOT NULL,
  `hora_salida` time NOT NULL,
  `duracion` time NOT NULL,
  `numero_vuelo` varchar(50) NOT NULL,
  `precio` double unsigned NOT NULL,
  `plazas` int(10) unsigned NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_vuelo_conexion` (`conexion`),
  CONSTRAINT `FK_vuelo_conexion` FOREIGN KEY (`conexion`) REFERENCES `conexion` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla aeropuerto.vuelos: ~18 rows (aproximadamente)
DELETE FROM `vuelos`;
/*!40000 ALTER TABLE `vuelos` DISABLE KEYS */;
INSERT INTO `vuelos` (`codigo`, `conexion`, `fecha_salida`, `hora_salida`, `duracion`, `numero_vuelo`, `precio`, `plazas`) VALUES
	(1, 1, '2016-03-12', '16:30:46', '08:40:54', 'MN6012', 748, 8),
	(2, 1, '2016-03-12', '08:00:18', '08:35:25', 'MN6014', 491, 8),
	(3, 4, '2016-03-13', '06:15:01', '07:05:05', 'MN6015', 924, 8),
	(4, 1, '2016-03-14', '07:30:34', '08:35:43', 'MN6012', 653, 8),
	(5, 2, '2016-03-15', '07:00:22', '17:35:27', 'MT7014', 496, 8),
	(6, 2, '2016-03-15', '16:00:51', '20:15:01', 'MT7012', 529, 8),
	(7, 5, '2016-03-16', '05:30:32', '17:15:35', 'MT7011', 650, 8),
	(8, 1, '2016-03-16', '06:15:45', '08:30:49', 'MN6012', 945, 8),
	(9, 2, '2016-03-17', '06:30:16', '20:00:22', 'MT7012', 820, 8),
	(10, 4, '2016-03-17', '08:00:43', '07:15:50', 'MN6015', 1021, 8),
	(11, 3, '2016-03-17', '08:30:00', '02:05:15', 'MP5012', 90, 8),
	(12, 3, '2016-03-17', '13:00:26', '02:10:38', 'MP5014', 104, 8),
	(13, 6, '2016-03-18', '14:20:26', '02:05:35', 'MP5019', 168, 8),
	(14, 3, '2016-03-19', '09:00:10', '02:00:25', 'MP5012', 155, 8),
	(15, 2, '2016-03-20', '08:00:21', '14:40:29', 'MT7012', 649, 8),
	(16, 3, '2016-03-20', '17:00:34', '02:15:41', 'MP5012', 187, 8),
	(17, 5, '2016-03-21', '08:00:50', '16:40:55', 'MT7011', 715, 8),
	(18, 6, '2016-03-22', '11:21:20', '02:15:25', 'MP5019', 146, 8);
/*!40000 ALTER TABLE `vuelos` ENABLE KEYS */;


-- Volcando estructura para disparador aeropuerto.bebe_before_delete
DROP TRIGGER IF EXISTS `bebe_before_delete`;
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `bebe_before_delete` BEFORE DELETE ON `bebe` FOR EACH ROW BEGIN
	insert into backup_bebe values(old.codigo, old.nombre, old.apellidos, old.fechaNacimiento, old.nif, old.pais, old.tutor);
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;


-- Volcando estructura para disparador aeropuerto.ocupacion_before_delete
DROP TRIGGER IF EXISTS `ocupacion_before_delete`;
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `ocupacion_before_delete` BEFORE DELETE ON `ocupacion` FOR EACH ROW BEGIN
	insert into backup_ocupacion values(old.codigo, old.vuelo, old.asiento, old.facturado, old.pasajero, old.booking_code, old.importe);
	delete from servicios_contratados where cod_ocupacion=old.codigo;
	delete from pagos where booking_code = old.booking_code and booking_code not in (select booking_code from ocupacion where booking_code=old.booking_code and vuelo!=old.vuelo);
	delete from pasajeros where codigo=old.pasajero and codigo not in (select pasajero from ocupacion where booking_code=old.booking_code and vuelo!=old.vuelo);
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;


-- Volcando estructura para disparador aeropuerto.pagos_before_delete
DROP TRIGGER IF EXISTS `pagos_before_delete`;
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `pagos_before_delete` BEFORE DELETE ON `pagos` FOR EACH ROW BEGIN
	insert into backup_pagos values(old.codigo, old.booking_code, old.fecha, old.cod_cliente, old.importe_total);
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;


-- Volcando estructura para disparador aeropuerto.pasajeros_before_delete
DROP TRIGGER IF EXISTS `pasajeros_before_delete`;
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `pasajeros_before_delete` BEFORE DELETE ON `pasajeros` FOR EACH ROW BEGIN
	insert into backup_pasajeros values(old.codigo, old.nif, old.nombre, old.apellidos, old.fechaNacimiento, old.pais_expedicion, old.tutor);
	delete from bebe where tutor=old.codigo;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;


-- Volcando estructura para disparador aeropuerto.servicios_contratados_before_delete
DROP TRIGGER IF EXISTS `servicios_contratados_before_delete`;
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `servicios_contratados_before_delete` BEFORE DELETE ON `servicios_contratados` FOR EACH ROW BEGIN

	DECLARE siglasB VARCHAR(50);
	DECLARE descrB VARCHAR(50);
	DECLARE precioB DOUBLE;
	select servicios.siglas INTO siglasB from servicios where codigo=old.cod_servicio;
	select servicios.descripcion INTO descrB from servicios where codigo=old.cod_servicio;
	select servicios.precio INTO precioB from servicios where codigo=old.cod_servicio;
	insert into backup_servicios_contratados values(old.codigo, old.cod_ocupacion, siglasB, descrB, precioB);
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;


-- Volcando estructura para disparador aeropuerto.vuelos_before_delete
DROP TRIGGER IF EXISTS `vuelos_before_delete`;
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `vuelos_before_delete` BEFORE DELETE ON `vuelos` FOR EACH ROW BEGIN
	insert  into backup_vuelos values(old.codigo, old.conexion, old.fecha_salida, old.hora_salida, old.duracion, old.numero_vuelo, old.precio, old.plazas);
	delete from ocupacion where vuelo = old.codigo;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
