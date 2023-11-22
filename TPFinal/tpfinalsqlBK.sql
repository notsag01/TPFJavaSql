-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3307
-- Tiempo de generación: 22-11-2023 a las 21:10:18
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tpfinalsql`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cambiomoneda`
--

CREATE TABLE `cambiomoneda` (
  `CambioMonedaID` int(11) NOT NULL,
  `UsuarioID` int(11) DEFAULT NULL,
  `ClienteID` int(11) DEFAULT NULL,
  `ServicioID` int(11) DEFAULT NULL,
  `CantPesos` decimal(10,2) DEFAULT NULL,
  `TipoMoneda` varchar(25) DEFAULT NULL,
  `ImpPais` decimal(10,2) DEFAULT NULL,
  `ImpGcias` decimal(10,2) DEFAULT NULL,
  `Cambio` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cambiomoneda`
--

INSERT INTO `cambiomoneda` (`CambioMonedaID`, `UsuarioID`, `ClienteID`, `ServicioID`, `CantPesos`, `TipoMoneda`, `ImpPais`, `ImpGcias`, `Cambio`) VALUES
(4, 1, 2, 1, 5000.00, '3', 82830.00, 96635.00, 455565.00);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cambiomoneda`
--
ALTER TABLE `cambiomoneda`
  ADD PRIMARY KEY (`CambioMonedaID`),
  ADD KEY `UsuarioID` (`UsuarioID`),
  ADD KEY `ClienteID` (`ClienteID`),
  ADD KEY `ServicioID` (`ServicioID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cambiomoneda`
--
ALTER TABLE `cambiomoneda`
  MODIFY `CambioMonedaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cambiomoneda`
--
ALTER TABLE `cambiomoneda`
  ADD CONSTRAINT `cambiomoneda_ibfk_1` FOREIGN KEY (`UsuarioID`) REFERENCES `usuarios` (`UsuarioID`),
  ADD CONSTRAINT `cambiomoneda_ibfk_2` FOREIGN KEY (`ClienteID`) REFERENCES `clientes` (`ClienteID`),
  ADD CONSTRAINT `cambiomoneda_ibfk_3` FOREIGN KEY (`ServicioID`) REFERENCES `servicios` (`ServicioID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
