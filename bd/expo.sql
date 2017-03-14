-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 14-03-2017 a las 17:50:30
-- Versión del servidor: 10.0.29-MariaDB-0ubuntu0.16.10.1
-- Versión de PHP: 7.0.15-0ubuntu0.16.10.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `expo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `antinarcoticos`
--

CREATE TABLE `antinarcoticos` (
  `idAntinarcoticos` int(11) NOT NULL,
  `descripcionMercancia` text NOT NULL,
  `numerosPrecintos` varchar(15) NOT NULL,
  `agenciaAduanas` int(11) NOT NULL,
  `alcanceVuce` enum('Si','No') NOT NULL,
  `idEstadoAnti` int(11) NOT NULL,
  `idCiudadDestino` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `antinarcoticos`
--

INSERT INTO `antinarcoticos` (`idAntinarcoticos`, `descripcionMercancia`, `numerosPrecintos`, `agenciaAduanas`, `alcanceVuce`, `idEstadoAnti`, `idCiudadDestino`) VALUES
(100, 'Manzanas', '2547893', 3678829, 'Si', 1, 22),
(101, 'El contenido del viaje:Uchuva,Manzana y Durazno', '2593892', 3678010, 'Si', 2, 24),
(104, 'Uchuva y Ciruela', '2544893', 3671899, 'No', 4, 30),
(105, 'Banana', '2582819', 3673282, 'Si', 3, 27);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudades`
--

CREATE TABLE `ciudades` (
  `idCiudad` int(11) NOT NULL,
  `nombreCiudad` varchar(40) NOT NULL,
  `idPais` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ciudades`
--

INSERT INTO `ciudades` (`idCiudad`, `nombreCiudad`, `idPais`) VALUES
(1, 'Bogotá', 43),
(2, 'Medellín', 43),
(3, 'Cali', 43),
(4, 'Barranquilla', 43),
(5, 'Cartagena de Indias', 43),
(6, 'Bucaramanga', 43),
(7, 'Pereira', 43),
(8, 'Manizales', 43),
(9, 'Cúcuta', 43),
(10, 'Santa Marta', 43),
(11, 'Ibagué', 43),
(12, 'Villavicencio', 43),
(13, 'Montería', 43),
(14, 'Armenia', 43),
(15, 'Tunja', 43),
(16, 'Quibdó', 43),
(17, 'Facatativa', 43),
(18, 'Soacha', 43),
(19, 'Honda', 43),
(20, 'Mitú', 43),
(21, 'Girardot', 43),
(22, 'Berlín', 2),
(23, 'Colonia', 2),
(24, 'Dresden', 2),
(25, 'Bonn', 2),
(26, 'Hannover', 2),
(27, 'Maguncia', 2),
(28, 'Tréveris', 2),
(29, 'Bremen', 2),
(30, 'Bamberg', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `idClienteUsuario` int(11) NOT NULL,
  `nombreEmpresa` varchar(30) NOT NULL,
  `sigla` varchar(10) NOT NULL,
  `numeroLegal` bigint(20) NOT NULL,
  `codPostal` varchar(10) NOT NULL,
  `idEstadoCliente` int(11) NOT NULL,
  `idCiudad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`idClienteUsuario`, `nombreEmpresa`, `sigla`, `numeroLegal`, `codPostal`, `idEstadoCliente`, `idCiudad`) VALUES
(105, 'Fruty\'s', 'AD3', 2563456541, '10115', 2, 22),
(106, 'Ecost', 'EF6', 938212819, '13980', 1, 24),
(107, 'Lops', 'JR7', 756634677, '53111', 2, 25),
(108, 'FrutiKi', 'A4D', 237118943, '13899', 3, 24),
(109, 'Luips', 'W44', 196332289, '96047', 2, 30),
(110, 'Trarp', 'IKO', 102983894, '10928', 1, 22),
(111, 'Komist', 'SOR', 390483921, '10174', 1, 22),
(112, 'Woplw', 'SFG', 768392002, '96755', 4, 30),
(113, 'Kaios', 'BJN', 676564344, '50239', 3, 23),
(114, 'Toront\'s', 'SD6', 192003763, '50121', 2, 23),
(115, 'Frutas', '3MN', 820398889, '13502', 3, 24);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `continentes`
--

CREATE TABLE `continentes` (
  `idContinente` int(11) NOT NULL,
  `nombreContinente` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `continentes`
--

INSERT INTO `continentes` (`idContinente`, `nombreContinente`) VALUES
(20, 'África'),
(21, 'Asia'),
(22, 'Oceanía'),
(23, 'Europa'),
(24, 'Antártida'),
(25, 'Centroamérica'),
(26, 'Sudamérica'),
(27, 'Norteamérica');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallespedidos`
--

CREATE TABLE `detallespedidos` (
  `idDetallePedido` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `moneda` varchar(15) NOT NULL,
  `idPedido` int(11) NOT NULL,
  `idPallet` int(11) NOT NULL,
  `idTipoEmpaque` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `detallespedidos`
--

INSERT INTO `detallespedidos` (`idDetallePedido`, `idProducto`, `cantidad`, `moneda`, `idPedido`, `idPallet`, `idTipoEmpaque`) VALUES
(1, 1000, 5, 'colombiana', 1, 7, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresastransportes`
--

CREATE TABLE `empresastransportes` (
  `idEmpresaTransporte` int(11) NOT NULL,
  `nombreEmpresa` varchar(20) NOT NULL,
  `telefono` int(11) NOT NULL,
  `idTipoTransporte` int(11) NOT NULL,
  `idCiudad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empresastransportes`
--

INSERT INTO `empresastransportes` (`idEmpresaTransporte`, `nombreEmpresa`, `telefono`, `idTipoTransporte`, `idCiudad`) VALUES
(100, 'Fluvial', 3400000, 3, 4),
(101, 'Viva Colombia', 4409200, 1, 2),
(102, 'Avianca', 5618989, 1, 1),
(103, 'Maersk Line', 5418223, 3, 5),
(104, 'Maersk Line', 5418224, 2, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadosantinarcoticos`
--

CREATE TABLE `estadosantinarcoticos` (
  `idEstadoAntinarcoticos` int(11) NOT NULL,
  `nombreEstadoAntinarcoticos` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estadosantinarcoticos`
--

INSERT INTO `estadosantinarcoticos` (`idEstadoAntinarcoticos`, `nombreEstadoAntinarcoticos`) VALUES
(1, 'Activado'),
(2, 'En Proceso'),
(3, 'Completado'),
(4, 'Cancelado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadosclientes`
--

CREATE TABLE `estadosclientes` (
  `idEstadoCliente` int(11) NOT NULL,
  `nombreEstadoCliente` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estadosclientes`
--

INSERT INTO `estadosclientes` (`idEstadoCliente`, `nombreEstadoCliente`) VALUES
(1, 'Inactivo'),
(2, 'Activo'),
(3, 'En Mora'),
(4, 'Eliminado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadospedidos`
--

CREATE TABLE `estadospedidos` (
  `idEstadoPedido` int(11) NOT NULL,
  `nombreEstadoPedido` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estadospedidos`
--

INSERT INTO `estadospedidos` (`idEstadoPedido`, `nombreEstadoPedido`) VALUES
(1, 'Pendiente'),
(2, 'Autorizado'),
(3, 'En Proceso'),
(4, 'Exportado'),
(5, 'Cancelado'),
(6, 'Finalizado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadosproductos`
--

CREATE TABLE `estadosproductos` (
  `idEstadoProducto` int(11) NOT NULL,
  `nombreEstadoProducto` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estadosproductos`
--

INSERT INTO `estadosproductos` (`idEstadoProducto`, `nombreEstadoProducto`) VALUES
(1, 'Activo'),
(2, 'Agotado'),
(3, 'Eliminado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inconterms`
--

CREATE TABLE `inconterms` (
  `idInconterm` int(11) NOT NULL,
  `INCONTERM` varchar(5) NOT NULL,
  `descripcion` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `inconterms`
--

INSERT INTO `inconterms` (`idInconterm`, `INCONTERM`, `descripcion`) VALUES
(2, 'FCA', 'Franco transportista lugar con'),
(3, 'DAT', 'Entregado en terminal...puerto'),
(4, 'DAP', 'Entregado en un punto...lugar '),
(5, 'DDP', 'Entregado derechos pagados…lug'),
(6, 'CIF', 'Coste, seguro y flete...puerto'),
(7, 'Prub', 'sdfghjhioi8273872yiysdiuydsi'),
(8, 'ols', 'sdfghjkl');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medidascajas`
--

CREATE TABLE `medidascajas` (
  `idMedidaCaja` int(11) NOT NULL,
  `medidaCaja` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `medidascajas`
--

INSERT INTO `medidascajas` (`idMedidaCaja`, `medidaCaja`) VALUES
(1, 'Pequeña'),
(2, 'Mediana'),
(3, 'Grande');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paises`
--

CREATE TABLE `paises` (
  `idPais` int(11) NOT NULL,
  `nombrePais` varchar(40) NOT NULL,
  `idContinente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `paises`
--

INSERT INTO `paises` (`idPais`, `nombrePais`, `idContinente`) VALUES
(1, 'Albania', 23),
(2, 'Alemania', 23),
(3, 'Andorra', 23),
(4, 'Armenia', 23),
(5, 'Austria', 23),
(6, 'Azerbaiyán', 23),
(7, 'Bélgica', 23),
(8, 'Bielorrusia', 23),
(9, 'Bosnia y Herzegovina', 23),
(10, 'Bulgaria', 23),
(11, 'Chipre', 23),
(12, 'Ciudad del Vaticano', 23),
(13, 'Croacia', 23),
(14, 'Dinamarca', 23),
(15, 'Eslovaquia', 23),
(16, 'Paises Bajos', 23),
(17, 'Noruega', 23),
(18, 'Polonia', 23),
(19, 'Portugal', 23),
(20, 'Reino Unido', 23),
(21, 'República Checa', 23),
(22, 'República de Macedonia', 23),
(23, 'Rumanía', 23),
(24, 'Rusia', 23),
(25, 'Suecia', 23),
(26, 'Suiza', 23),
(27, 'Turquía', 23),
(28, 'Ucrania', 23),
(29, 'Canadá', 27),
(30, 'Estados Unidos', 27),
(31, 'México', 27),
(32, 'Belice', 25),
(33, 'Costa Rica', 25),
(34, 'El Salvador', 25),
(35, 'Guatemala', 25),
(36, 'Honduras', 25),
(37, 'Nicaragua', 25),
(38, 'Panamá', 25),
(39, 'Argentina', 26),
(40, 'Bolivia', 26),
(41, 'Brasil', 26),
(42, 'Chile', 26),
(43, 'Colombia', 26),
(44, 'Ecuador', 26),
(45, 'Guyana', 26),
(46, 'Paraguay', 26),
(47, 'Perú', 26),
(48, 'Surinam', 26),
(49, 'Uruguay', 26),
(50, 'Venezuela', 26);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pallets`
--

CREATE TABLE `pallets` (
  `idPallet` int(11) NOT NULL,
  `palletStandar` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pallets`
--

INSERT INTO `pallets` (`idPallet`, `palletStandar`) VALUES
(1, '1150 x 1100 mm'),
(2, '1200 x 1200 mm'),
(3, '1140 × 1140 mm'),
(4, '1250 x 1500 mm'),
(5, '1250 x 1250 mm'),
(6, '1219 × 1016 mm'),
(7, '1067 × 1067 mm'),
(8, '1219 × 1219 mm'),
(9, '52 x 56 mm'),
(10, '56 x 20 mm'),
(11, '120 x 120 mm'),
(12, '250 x 360 mm');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `idPedido` int(11) NOT NULL,
  `fechaPedido` date NOT NULL,
  `fechaEntrega` date NOT NULL,
  `observacion` text,
  `idEstadoPedido` int(11) NOT NULL,
  `idInconterm` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idAntinarcoticos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pedidos`
--

INSERT INTO `pedidos` (`idPedido`, `fechaPedido`, `fechaEntrega`, `observacion`, `idEstadoPedido`, `idInconterm`, `idCliente`, `idAntinarcoticos`) VALUES
(1, '2017-03-03', '2017-03-11', 'Pedido', 2, 2, 107, 104);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permisos`
--

CREATE TABLE `permisos` (
  `idPermiso` int(11) NOT NULL,
  `nombrePermiso` varchar(30) NOT NULL,
  `tipoMenu` enum('S','I') NOT NULL,
  `permisoPadre` int(11) DEFAULT NULL,
  `estado` bit(1) NOT NULL,
  `url` tinytext,
  `icon` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `permisos`
--

INSERT INTO `permisos` (`idPermiso`, `nombrePermiso`, `tipoMenu`, `permisoPadre`, `estado`, `url`, `icon`) VALUES
(1, 'Usuarios', 'S', NULL, b'1', NULL, NULL),
(2, 'Lista Usuarios', 'I', 1, b'1', '/ExpoChickPro/faces/sesionProtegido/newTemplateClient.xhtml', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permisosroles`
--

CREATE TABLE `permisosroles` (
  `idPermiso` int(11) NOT NULL,
  `idRol` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `permisosroles`
--

INSERT INTO `permisosroles` (`idPermiso`, `idRol`) VALUES
(1, 1),
(1, 2),
(2, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `precioscantidades`
--

CREATE TABLE `precioscantidades` (
  `idPrecioCantidad` int(11) NOT NULL,
  `peso` varchar(7) NOT NULL,
  `costo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `precioscantidades`
--

INSERT INTO `precioscantidades` (`idPrecioCantidad`, `peso`, `costo`) VALUES
(1, '1Kg', 1000),
(2, '1,3Kg', 1200),
(3, '2Kg', 1500),
(4, '1,5Kg', 1500),
(5, '0,5Kg', 1000),
(6, '11Kg', 200),
(7, '2g', 3000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `presentaciones`
--

CREATE TABLE `presentaciones` (
  `idPresentacion` int(11) NOT NULL,
  `presentacion` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `presentaciones`
--

INSERT INTO `presentaciones` (`idPresentacion`, `presentacion`) VALUES
(1, 'Ninguna'),
(2, 'Bolsa'),
(3, 'Seco'),
(4, 'Triturado'),
(5, 'Prueba');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `idProducto` int(11) NOT NULL,
  `nombreProducto` varchar(40) NOT NULL,
  `descripcion` tinytext,
  `categoria` int(2) NOT NULL,
  `calibre` int(11) NOT NULL,
  `gradoMadurez` int(3) NOT NULL,
  `foto` text,
  `idPrecioCantidad` int(11) NOT NULL,
  `idPresentacion` int(11) NOT NULL,
  `idEstadoProducto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`idProducto`, `nombreProducto`, `descripcion`, `categoria`, `calibre`, `gradoMadurez`, `foto`, `idPrecioCantidad`, `idPresentacion`, `idEstadoProducto`) VALUES
(1000, 'Manzana', 'Verde', 1, 3, 40, NULL, 2, 1, 1),
(1001, 'Uchuva', 'Exótico', 2, 2, 60, NULL, 1, 3, 1),
(1002, 'Banano', NULL, 1, 4, 20, NULL, 3, 2, 1),
(1003, 'Pera', NULL, 1, 3, 90, NULL, 2, 1, 1),
(1004, 'Mamoncillo', NULL, 1, 2, 97, NULL, 1, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `idRol` int(11) NOT NULL,
  `nombreRol` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`idRol`, `nombreRol`) VALUES
(1, 'Administrador'),
(2, 'Gerente de Logistica'),
(3, 'Cliente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rolesusuarios`
--

CREATE TABLE `rolesusuarios` (
  `idUsuario` int(11) NOT NULL,
  `idRol` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `telefonos`
--

CREATE TABLE `telefonos` (
  `idTelefono` int(11) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `idUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `telefonos`
--

INSERT INTO `telefonos` (`idTelefono`, `telefono`, `idUsuario`) VALUES
(1, '7888788', 106),
(2, '7887788', 106),
(3, '3219872837', 109),
(4, '3229027836', 112),
(5, '3209309899', 120),
(6, '3018892767', 116),
(7, '3102982090', 115),
(8, '2304893', 115),
(9, '3129029929', 117),
(10, '3017786296', 103);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tiposempaques`
--

CREATE TABLE `tiposempaques` (
  `idTipoEmpaque` int(11) NOT NULL,
  `marcaCaja` varchar(25) NOT NULL,
  `idMedidaCaja` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tiposempaques`
--

INSERT INTO `tiposempaques` (`idTipoEmpaque`, `marcaCaja`, `idMedidaCaja`) VALUES
(1, 'Green', 2),
(2, 'Loraine', 2),
(3, 'Lulues', 3),
(4, 'Fruver', 1),
(5, 'Pands', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipostransportes`
--

CREATE TABLE `tipostransportes` (
  `idTipoTransporte` int(11) NOT NULL,
  `nombreTipoTransporte` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipostransportes`
--

INSERT INTO `tipostransportes` (`idTipoTransporte`, `nombreTipoTransporte`) VALUES
(1, 'Aereo'),
(2, 'Terrestre'),
(3, 'Maritimo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transportes`
--

CREATE TABLE `transportes` (
  `idTransporte` int(11) NOT NULL,
  `fechaArribo` date NOT NULL,
  `nombreUsuarioTransportador` int(11) DEFAULT NULL,
  `idPedido` int(11) NOT NULL,
  `idEmpresaTransporte` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `transportes`
--

INSERT INTO `transportes` (`idTransporte`, `fechaArribo`, `nombreUsuarioTransportador`, `idPedido`, `idEmpresaTransporte`) VALUES
(2, '2010-12-12', 1, 1, 100);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `trazabilidades`
--

CREATE TABLE `trazabilidades` (
  `idTrazabilidad` int(11) NOT NULL,
  `nombreEmpresa` varchar(35) NOT NULL,
  `predioProduccion` varchar(20) NOT NULL,
  `registroICA` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `idCiudad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `trazabilidades`
--

INSERT INTO `trazabilidades` (`idTrazabilidad`, `nombreEmpresa`, `predioProduccion`, `registroICA`, `idProducto`, `idCiudad`) VALUES
(11, 'Empresa Uno', 'La Esmeralda', 23948, 1001, 1),
(12, 'Empresa Dos', 'La Sonora', 12909, 1001, 2),
(13, 'Empresa Tres', 'La Ladera', 29309, 1003, 1),
(14, 'Empresa Tres', 'Las Carmelitas', 59208, 1001, 1),
(15, 'Empresa Dos', 'Altamira', 34902, 1002, 2),
(16, 'Empresa Uno', 'Jardin', 75837, 1001, 1),
(17, 'Empresa Dos', 'La Esmeralda', 20939, 1003, 1),
(18, 'Empresa Dos', 'La Sonora', 68393, 1004, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `idUsuario` int(11) NOT NULL,
  `cedula` bigint(20) NOT NULL,
  `primerNombre` varchar(45) NOT NULL,
  `segundonombre` varchar(45) DEFAULT NULL,
  `primerApellido` varchar(45) NOT NULL,
  `segundoApellido` varchar(45) DEFAULT NULL,
  `clave` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `idRol` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`idUsuario`, `cedula`, `primerNombre`, `segundonombre`, `primerApellido`, `segundoApellido`, `clave`, `email`, `idRol`) VALUES
(100, 16122608121, 'Juan', 'Camilo', 'Martinez', 'Aguirre', '5678', 'juanca@correo.com', 2),
(101, 10002839289, 'Johana', 'Yised', 'Cely', 'Sandoval', '9876', 'johana10@correo.com', 2),
(102, 98278277878, 'Cristian', 'David', 'Rojas', NULL, '3456', 'crisrojas@correo.com', 3),
(103, 99030602214, 'Mariana', 'Alexandra', 'Martinez', 'Saldaña', '1234', 'ma412@misena.edu.co', 1),
(104, 88767564987, 'Gabriel', '', 'Santofinio', NULL, '5644', 'gabriel88@correo.com', 3),
(105, 41703556, 'Manuel', 'Alejandro', 'Guzman', 'Benavides', '8765', 'guzmanb@correo.com', 3),
(106, 89928997, 'Ruth', 'Giovanna', 'Botica', NULL, '3874', 'ruthbotica@correo.com', 3),
(107, 95672665, 'Andres', 'Felipe', 'Rojas', 'Sandoval', '9899', 'andresrojas@correo.com', 3),
(108, 82623640, 'Dalia', 'Andrea', 'Rosales', 'Sanchez', '8787', 'dalia82@correo.com', 3),
(109, 12309948, 'Fernando', NULL, 'Sanchez', 'Rodriguez', '4545', '12sanchez@correo.com', 3),
(110, 92837764, 'Esteban', '', 'Gonzalez', 'Ramos', '6541', 'esteban654@correo.com', 3),
(111, 76526135, 'Juan', 'Jose', 'Baquero', 'Rodriguez', '8727', ' juanjo@correo.com', 3),
(112, 46729376, 'Miguel', 'Angel', 'Solano', 'Panadero', '2345', 'miguel76@correo.com', 3),
(113, 87988974, 'Angela', 'Gisell', 'Lozano', 'Tapias', '9456', 'angela2016@correo.com', 3),
(114, 87998056, 'Evan', 'Marcus', 'Brunet', 'Cassina', '2332', 'evanmark@correo.com', 3),
(115, 23564533, 'Nathan', 'Alexander', 'Stonen', NULL, '8789', 'natlax@correo.com', 2),
(116, 887656433, 'Daniel', NULL, 'Pinilla', 'Morales', '8456', 'danipinilla@correo.com', 3),
(117, 987657855, 'Laura', 'Sofia', 'Torres', 'Trujillo', '2345', 'lau98@correo.com', 3),
(118, 234563344, 'Marcos', 'Andres', 'Patiño', NULL, '2332', 'marpa@correo.com', 3),
(119, 414232287, 'Bruno', 'Alexander', 'Diaz', 'Rojas', '8978', 'bruno22@correo.com', 2),
(120, 873889099, 'Kevin', 'Tobias', 'Lopez', 'Trujillo', '9999', 'tobias99@correo.com', 3),
(121, 99703558, 'Miguel ', 'Angel', 'Solano', NULL, '1234', 'miguel@correo.com', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `antinarcoticos`
--
ALTER TABLE `antinarcoticos`
  ADD PRIMARY KEY (`idAntinarcoticos`),
  ADD KEY `antiCiudad_idx` (`idCiudadDestino`),
  ADD KEY `antiEstado_idx` (`idEstadoAnti`);

--
-- Indices de la tabla `ciudades`
--
ALTER TABLE `ciudades`
  ADD PRIMARY KEY (`idCiudad`),
  ADD KEY `ciudadPais_idx` (`idPais`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`idClienteUsuario`),
  ADD UNIQUE KEY `sigla_UNIQUE` (`sigla`),
  ADD KEY `clienteEstado_idx` (`idEstadoCliente`),
  ADD KEY `clienteCiudad_idx` (`idCiudad`);

--
-- Indices de la tabla `continentes`
--
ALTER TABLE `continentes`
  ADD PRIMARY KEY (`idContinente`);

--
-- Indices de la tabla `detallespedidos`
--
ALTER TABLE `detallespedidos`
  ADD PRIMARY KEY (`idDetallePedido`),
  ADD KEY `detPedProducto_idx` (`idProducto`),
  ADD KEY `detPedPallet_idx` (`idPallet`),
  ADD KEY `detPedPedido_idx` (`idPedido`),
  ADD KEY `detPedTipoEmp_idx` (`idTipoEmpaque`);

--
-- Indices de la tabla `empresastransportes`
--
ALTER TABLE `empresastransportes`
  ADD PRIMARY KEY (`idEmpresaTransporte`),
  ADD KEY `empTransCiudad_idx` (`idCiudad`),
  ADD KEY `empTransTipoTrans_idx` (`idTipoTransporte`);

--
-- Indices de la tabla `estadosantinarcoticos`
--
ALTER TABLE `estadosantinarcoticos`
  ADD PRIMARY KEY (`idEstadoAntinarcoticos`);

--
-- Indices de la tabla `estadosclientes`
--
ALTER TABLE `estadosclientes`
  ADD PRIMARY KEY (`idEstadoCliente`);

--
-- Indices de la tabla `estadospedidos`
--
ALTER TABLE `estadospedidos`
  ADD PRIMARY KEY (`idEstadoPedido`);

--
-- Indices de la tabla `estadosproductos`
--
ALTER TABLE `estadosproductos`
  ADD PRIMARY KEY (`idEstadoProducto`);

--
-- Indices de la tabla `inconterms`
--
ALTER TABLE `inconterms`
  ADD PRIMARY KEY (`idInconterm`);

--
-- Indices de la tabla `medidascajas`
--
ALTER TABLE `medidascajas`
  ADD PRIMARY KEY (`idMedidaCaja`);

--
-- Indices de la tabla `paises`
--
ALTER TABLE `paises`
  ADD PRIMARY KEY (`idPais`),
  ADD KEY `paisContinente_idx` (`idContinente`);

--
-- Indices de la tabla `pallets`
--
ALTER TABLE `pallets`
  ADD PRIMARY KEY (`idPallet`);

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`idPedido`),
  ADD KEY `pedidoEstado_idx` (`idEstadoPedido`),
  ADD KEY `pedidoInconterm_idx` (`idInconterm`),
  ADD KEY `pedidoCliente_idx` (`idCliente`),
  ADD KEY `pedidoAntinarcoticos_idx` (`idAntinarcoticos`);

--
-- Indices de la tabla `permisos`
--
ALTER TABLE `permisos`
  ADD PRIMARY KEY (`idPermiso`),
  ADD KEY `permisoPerPadre_idx` (`permisoPadre`);

--
-- Indices de la tabla `permisosroles`
--
ALTER TABLE `permisosroles`
  ADD PRIMARY KEY (`idPermiso`,`idRol`),
  ADD KEY `permisoRolRol_idx` (`idRol`);

--
-- Indices de la tabla `precioscantidades`
--
ALTER TABLE `precioscantidades`
  ADD PRIMARY KEY (`idPrecioCantidad`);

--
-- Indices de la tabla `presentaciones`
--
ALTER TABLE `presentaciones`
  ADD PRIMARY KEY (`idPresentacion`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`idProducto`),
  ADD KEY `productoPrecioCant_idx` (`idPrecioCantidad`),
  ADD KEY `productoPresentacion_idx` (`idPresentacion`),
  ADD KEY `productoEstado_idx` (`idEstadoProducto`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`idRol`);

--
-- Indices de la tabla `rolesusuarios`
--
ALTER TABLE `rolesusuarios`
  ADD PRIMARY KEY (`idUsuario`,`idRol`),
  ADD KEY `FK_rolesusuarios_idRol` (`idRol`);

--
-- Indices de la tabla `telefonos`
--
ALTER TABLE `telefonos`
  ADD PRIMARY KEY (`idTelefono`),
  ADD KEY `telefonoUsuario_idx` (`idUsuario`);

--
-- Indices de la tabla `tiposempaques`
--
ALTER TABLE `tiposempaques`
  ADD PRIMARY KEY (`idTipoEmpaque`),
  ADD KEY `tipoEmpMedidaCaja_idx` (`idMedidaCaja`);

--
-- Indices de la tabla `tipostransportes`
--
ALTER TABLE `tipostransportes`
  ADD PRIMARY KEY (`idTipoTransporte`);

--
-- Indices de la tabla `transportes`
--
ALTER TABLE `transportes`
  ADD PRIMARY KEY (`idTransporte`),
  ADD KEY `transportePedido_idx` (`idPedido`),
  ADD KEY `transporteEmpresaTrans_idx` (`idEmpresaTransporte`);

--
-- Indices de la tabla `trazabilidades`
--
ALTER TABLE `trazabilidades`
  ADD PRIMARY KEY (`idTrazabilidad`),
  ADD KEY `trazabilidadProducto_idx` (`idProducto`),
  ADD KEY `trazabilidadCiudad_idx` (`idCiudad`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idUsuario`),
  ADD UNIQUE KEY `cedula_UNIQUE` (`cedula`),
  ADD KEY `rolUsuario` (`idRol`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `antinarcoticos`
--
ALTER TABLE `antinarcoticos`
  MODIFY `idAntinarcoticos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=106;
--
-- AUTO_INCREMENT de la tabla `ciudades`
--
ALTER TABLE `ciudades`
  MODIFY `idCiudad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT de la tabla `continentes`
--
ALTER TABLE `continentes`
  MODIFY `idContinente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
--
-- AUTO_INCREMENT de la tabla `detallespedidos`
--
ALTER TABLE `detallespedidos`
  MODIFY `idDetallePedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `empresastransportes`
--
ALTER TABLE `empresastransportes`
  MODIFY `idEmpresaTransporte` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=105;
--
-- AUTO_INCREMENT de la tabla `estadosantinarcoticos`
--
ALTER TABLE `estadosantinarcoticos`
  MODIFY `idEstadoAntinarcoticos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `estadosclientes`
--
ALTER TABLE `estadosclientes`
  MODIFY `idEstadoCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `estadospedidos`
--
ALTER TABLE `estadospedidos`
  MODIFY `idEstadoPedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `estadosproductos`
--
ALTER TABLE `estadosproductos`
  MODIFY `idEstadoProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `inconterms`
--
ALTER TABLE `inconterms`
  MODIFY `idInconterm` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT de la tabla `medidascajas`
--
ALTER TABLE `medidascajas`
  MODIFY `idMedidaCaja` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `paises`
--
ALTER TABLE `paises`
  MODIFY `idPais` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;
--
-- AUTO_INCREMENT de la tabla `pallets`
--
ALTER TABLE `pallets`
  MODIFY `idPallet` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  MODIFY `idPedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `permisos`
--
ALTER TABLE `permisos`
  MODIFY `idPermiso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `precioscantidades`
--
ALTER TABLE `precioscantidades`
  MODIFY `idPrecioCantidad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT de la tabla `presentaciones`
--
ALTER TABLE `presentaciones`
  MODIFY `idPresentacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1007;
--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `idRol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `telefonos`
--
ALTER TABLE `telefonos`
  MODIFY `idTelefono` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT de la tabla `tiposempaques`
--
ALTER TABLE `tiposempaques`
  MODIFY `idTipoEmpaque` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `tipostransportes`
--
ALTER TABLE `tipostransportes`
  MODIFY `idTipoTransporte` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `transportes`
--
ALTER TABLE `transportes`
  MODIFY `idTransporte` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `trazabilidades`
--
ALTER TABLE `trazabilidades`
  MODIFY `idTrazabilidad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=122;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `antinarcoticos`
--
ALTER TABLE `antinarcoticos`
  ADD CONSTRAINT `antiCiudad` FOREIGN KEY (`idCiudadDestino`) REFERENCES `ciudades` (`idCiudad`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `antiEstado` FOREIGN KEY (`idEstadoAnti`) REFERENCES `estadosantinarcoticos` (`idEstadoAntinarcoticos`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `ciudades`
--
ALTER TABLE `ciudades`
  ADD CONSTRAINT `ciudadPais` FOREIGN KEY (`idPais`) REFERENCES `paises` (`idPais`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD CONSTRAINT `clienteCiudad` FOREIGN KEY (`idCiudad`) REFERENCES `ciudades` (`idCiudad`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `clienteEstado` FOREIGN KEY (`idEstadoCliente`) REFERENCES `estadosclientes` (`idEstadoCliente`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `clienteUsuario` FOREIGN KEY (`idClienteUsuario`) REFERENCES `usuarios` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `detallespedidos`
--
ALTER TABLE `detallespedidos`
  ADD CONSTRAINT `detPedPallet` FOREIGN KEY (`idPallet`) REFERENCES `pallets` (`idPallet`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `detPedPedido` FOREIGN KEY (`idPedido`) REFERENCES `pedidos` (`idPedido`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `detPedProducto` FOREIGN KEY (`idProducto`) REFERENCES `productos` (`idProducto`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `detPedTipoEmp` FOREIGN KEY (`idTipoEmpaque`) REFERENCES `tiposempaques` (`idTipoEmpaque`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `empresastransportes`
--
ALTER TABLE `empresastransportes`
  ADD CONSTRAINT `empTransCiudad` FOREIGN KEY (`idCiudad`) REFERENCES `ciudades` (`idCiudad`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `empTransTipoTrans` FOREIGN KEY (`idTipoTransporte`) REFERENCES `tipostransportes` (`idTipoTransporte`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `paises`
--
ALTER TABLE `paises`
  ADD CONSTRAINT `paisContinente` FOREIGN KEY (`idContinente`) REFERENCES `continentes` (`idContinente`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD CONSTRAINT `pedidoAntinarcoticos` FOREIGN KEY (`idAntinarcoticos`) REFERENCES `antinarcoticos` (`idAntinarcoticos`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pedidoCliente` FOREIGN KEY (`idCliente`) REFERENCES `clientes` (`idClienteUsuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pedidoEstado` FOREIGN KEY (`idEstadoPedido`) REFERENCES `estadospedidos` (`idEstadoPedido`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pedidoInconterm` FOREIGN KEY (`idInconterm`) REFERENCES `inconterms` (`idInconterm`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `permisos`
--
ALTER TABLE `permisos`
  ADD CONSTRAINT `permisoPerPadre` FOREIGN KEY (`permisoPadre`) REFERENCES `permisos` (`idPermiso`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `permisosroles`
--
ALTER TABLE `permisosroles`
  ADD CONSTRAINT `permisoRolPermiso` FOREIGN KEY (`idPermiso`) REFERENCES `permisos` (`idPermiso`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `permisoRolRol` FOREIGN KEY (`idRol`) REFERENCES `roles` (`idRol`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `productoEstado` FOREIGN KEY (`idEstadoProducto`) REFERENCES `estadosproductos` (`idEstadoProducto`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `productoPrecioCant` FOREIGN KEY (`idPrecioCantidad`) REFERENCES `precioscantidades` (`idPrecioCantidad`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `productoPresentacion` FOREIGN KEY (`idPresentacion`) REFERENCES `presentaciones` (`idPresentacion`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `rolesusuarios`
--
ALTER TABLE `rolesusuarios`
  ADD CONSTRAINT `FK_rolesusuarios_idRol` FOREIGN KEY (`idRol`) REFERENCES `roles` (`idRol`),
  ADD CONSTRAINT `FK_rolesusuarios_idUsuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`);

--
-- Filtros para la tabla `telefonos`
--
ALTER TABLE `telefonos`
  ADD CONSTRAINT `telefonoUsuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tiposempaques`
--
ALTER TABLE `tiposempaques`
  ADD CONSTRAINT `tipoEmpMedidaCaja` FOREIGN KEY (`idMedidaCaja`) REFERENCES `medidascajas` (`idMedidaCaja`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `transportes`
--
ALTER TABLE `transportes`
  ADD CONSTRAINT `transporteEmpresaTrans` FOREIGN KEY (`idEmpresaTransporte`) REFERENCES `empresastransportes` (`idEmpresaTransporte`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `transportePedido` FOREIGN KEY (`idPedido`) REFERENCES `pedidos` (`idPedido`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `trazabilidades`
--
ALTER TABLE `trazabilidades`
  ADD CONSTRAINT `trazabilidadCiudad` FOREIGN KEY (`idCiudad`) REFERENCES `ciudades` (`idCiudad`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `trazabilidadProducto` FOREIGN KEY (`idProducto`) REFERENCES `productos` (`idProducto`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `rolUsuario` FOREIGN KEY (`idRol`) REFERENCES `roles` (`idRol`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
