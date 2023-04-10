CREATE TABLE `tclientes` (
  `idtcliente` bigint(20) NOT NULL AUTO_INCREMENT,
  `contrasena` varchar(255) DEFAULT NULL,
  `estado` bit(1) DEFAULT NULL,
  `idtpersona` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idtcliente`),
  KEY `FKo06jxebve8xlr8hlup686fesr` (`idtpersona`),
  CONSTRAINT `FKo06jxebve8xlr8hlup686fesr` FOREIGN KEY (`idtpersona`) REFERENCES `tpersonas` (`idtpersona`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

CREATE TABLE `tcuentas` (
  `idtcuenta` bigint(20) NOT NULL AUTO_INCREMENT,
  `estado` bit(1) DEFAULT NULL,
  `idtcliente` bigint(20) DEFAULT NULL,
  `numerocuenta` int(11) DEFAULT NULL,
  `saldoinicial` decimal(19,2) DEFAULT NULL,
  `tipocuenta` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idtcuenta`),
  UNIQUE KEY `numerocuenta_UNIQUE` (`numerocuenta`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

CREATE TABLE `tmovimientos` (
  `idtmovimiento` bigint(20) NOT NULL AUTO_INCREMENT,
  `fecha` datetime(6) DEFAULT NULL,
  `numerocuenta` int(11) DEFAULT NULL,
  `saldo` decimal(19,2) DEFAULT NULL,
  `tipomovimiento` varchar(255) DEFAULT NULL,
  `valor` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`idtmovimiento`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

CREATE TABLE `tpersonas` (
  `idtpersona` bigint(20) NOT NULL AUTO_INCREMENT,
  `direccion` varchar(255) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `genero` varchar(255) DEFAULT NULL,
  `identificacion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idtpersona`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;