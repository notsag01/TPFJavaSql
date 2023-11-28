-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3307
-- Tiempo de generación: 27-11-2023 a las 21:16:33
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
  `CantPesos` int(11) DEFAULT NULL,
  `TipoMoneda` varchar(25) DEFAULT NULL,
  `ImpPais` int(11) DEFAULT NULL,
  `ImpGcias` int(11) DEFAULT NULL,
  `Cambio` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `ClienteID` int(11) NOT NULL,
  `Nombre` varchar(50) DEFAULT NULL,
  `Apellido` varchar(50) DEFAULT NULL,
  `FechaNacimiento` date DEFAULT NULL,
  `Genero` varchar(10) DEFAULT NULL,
  `Cuil` varchar(20) DEFAULT NULL,
  `Domicilio` varchar(100) DEFAULT NULL,
  `Localidad` varchar(50) DEFAULT NULL,
  `Provincia` varchar(50) DEFAULT NULL,
  `EstadoCivil` varchar(20) DEFAULT NULL,
  `CantHijos` int(11) DEFAULT NULL,
  `Mail` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`ClienteID`, `Nombre`, `Apellido`, `FechaNacimiento`, `Genero`, `Cuil`, `Domicilio`, `Localidad`, `Provincia`, `EstadoCivil`, `CantHijos`, `Mail`) VALUES
(1, 'Juan', 'Pérez', '0002-01-19', 'MASCULINO', '20345678901', 'Calle 123', 'Ciudad A', 'Capital Federal', 'SOLTERO', 3, 'juan@example.com'),
(2, 'María', 'García', '1990-08-15', 'Femenino', '20456789012', 'Avenida 456', 'Ciudad B', 'Provincia Y', 'Soltera', 0, 'maria@example.com'),
(3, 'Pedro', 'López', '1982-02-20', 'Masculino', '20567890123', 'Boulevard 789', 'Ciudad C', 'Provincia Z', 'Viudo', 3, 'pedro@example.com'),
(4, 'Ana', 'Martínez', '1978-11-25', 'Femenino', '20678901234', 'Ruta 101', 'Ciudad D', 'Provincia W', 'Casado', 1, 'ana@example.com'),
(5, 'Carlos', 'Fernández', '1989-07-05', 'Masculino', '20789012345', 'Calle Principal', 'Ciudad E', 'Provincia V', 'Soltero', 0, 'carlos@example.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamos`
--

CREATE TABLE `prestamos` (
  `PrestamoID` int(11) NOT NULL,
  `UsuarioID` int(11) DEFAULT NULL,
  `ClienteID` int(11) DEFAULT NULL,
  `ServicioID` int(11) DEFAULT NULL,
  `Capital` int(11) DEFAULT NULL,
  `Tiempo` int(11) DEFAULT NULL,
  `Interes` int(11) DEFAULT NULL,
  `Cuota` int(11) DEFAULT NULL,
  `Monto` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `prestamos`
--

INSERT INTO `prestamos` (`PrestamoID`, `UsuarioID`, `ClienteID`, `ServicioID`, `Capital`, `Tiempo`, `Interes`, `Cuota`, `Monto`) VALUES
(1, 1, 1, 2, 250000, 24, 100, 20833, 500000),
(2, 1, 1, 2, 450000, 9, 150, 125000, 1125000),
(3, 2, 2, 2, 800000, 9, 150, 222222, 2000000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `segurohogar`
--

CREATE TABLE `segurohogar` (
  `SeguroHogarID` int(11) NOT NULL,
  `UsuarioID` int(11) DEFAULT NULL,
  `ClienteID` int(11) DEFAULT NULL,
  `ServicioID` int(11) DEFAULT NULL,
  `incendio` tinyint(4) DEFAULT NULL,
  `robo` tinyint(4) DEFAULT NULL,
  `inundacion` tinyint(4) DEFAULT NULL,
  `heladera` tinyint(4) DEFAULT NULL,
  `lavarropas` tinyint(4) DEFAULT NULL,
  `cocina` tinyint(4) DEFAULT NULL,
  `notebooks` tinyint(4) DEFAULT NULL,
  `cantNotebooks` int(11) DEFAULT NULL,
  `consola` tinyint(4) DEFAULT NULL,
  `televisor` tinyint(4) DEFAULT NULL,
  `cantTelevisor` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `segurohogar`
--

INSERT INTO `segurohogar` (`SeguroHogarID`, `UsuarioID`, `ClienteID`, `ServicioID`, `incendio`, `robo`, `inundacion`, `heladera`, `lavarropas`, `cocina`, `notebooks`, `cantNotebooks`, `consola`, `televisor`, `cantTelevisor`) VALUES
(1, 1, 1, 5, 1, 1, 0, 1, 1, 0, 1, 5, 0, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `segurovehiculo`
--

CREATE TABLE `segurovehiculo` (
  `SeguroVehiculoID` int(11) NOT NULL,
  `UsuarioID` int(11) DEFAULT NULL,
  `ClienteID` int(11) DEFAULT NULL,
  `ServicioID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `segurovida`
--

CREATE TABLE `segurovida` (
  `SeguroVidaID` int(11) NOT NULL,
  `UsuarioID` int(11) DEFAULT NULL,
  `ClienteID` int(11) DEFAULT NULL,
  `ServicioID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicios`
--

CREATE TABLE `servicios` (
  `ServicioID` int(11) NOT NULL,
  `TipoServicio` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `servicios`
--

INSERT INTO `servicios` (`ServicioID`, `TipoServicio`) VALUES
(1, 'Cambio de Moneda'),
(2, 'Préstamos'),
(3, 'Seguro de Vida'),
(4, 'Seguro de Vehículo'),
(5, 'Seguro de Hogar');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `UsuarioID` int(11) NOT NULL,
  `UserName` varchar(50) DEFAULT NULL,
  `Contraseña` varchar(50) DEFAULT NULL,
  `Nombre` varchar(50) DEFAULT NULL,
  `Apellido` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`UsuarioID`, `UserName`, `Contraseña`, `Nombre`, `Apellido`) VALUES
(1, 'admin', 'admin', 'Admin', 'Admin'),
(2, 'juanito', 'juan123', 'Juan', 'Gómez'),
(3, 'maria123', 'maria456', 'María', 'Rodríguez'),
(4, 'carlitos', 'carlos789', 'Carlos', 'Fernández'),
(5, 'Gaston', 'Cordoba', 'Gast10', 'Gast123');

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
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`ClienteID`);

--
-- Indices de la tabla `prestamos`
--
ALTER TABLE `prestamos`
  ADD PRIMARY KEY (`PrestamoID`),
  ADD KEY `UsuarioID` (`UsuarioID`),
  ADD KEY `ClienteID` (`ClienteID`),
  ADD KEY `ServicioID` (`ServicioID`);

--
-- Indices de la tabla `segurohogar`
--
ALTER TABLE `segurohogar`
  ADD PRIMARY KEY (`SeguroHogarID`),
  ADD KEY `UsuarioID` (`UsuarioID`),
  ADD KEY `ClienteID` (`ClienteID`),
  ADD KEY `ServicioID` (`ServicioID`);

--
-- Indices de la tabla `segurovehiculo`
--
ALTER TABLE `segurovehiculo`
  ADD PRIMARY KEY (`SeguroVehiculoID`),
  ADD KEY `UsuarioID` (`UsuarioID`),
  ADD KEY `ClienteID` (`ClienteID`),
  ADD KEY `ServicioID` (`ServicioID`);

--
-- Indices de la tabla `segurovida`
--
ALTER TABLE `segurovida`
  ADD PRIMARY KEY (`SeguroVidaID`),
  ADD KEY `UsuarioID` (`UsuarioID`),
  ADD KEY `ClienteID` (`ClienteID`),
  ADD KEY `ServicioID` (`ServicioID`);

--
-- Indices de la tabla `servicios`
--
ALTER TABLE `servicios`
  ADD PRIMARY KEY (`ServicioID`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`UsuarioID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cambiomoneda`
--
ALTER TABLE `cambiomoneda`
  MODIFY `CambioMonedaID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `ClienteID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `prestamos`
--
ALTER TABLE `prestamos`
  MODIFY `PrestamoID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `segurohogar`
--
ALTER TABLE `segurohogar`
  MODIFY `SeguroHogarID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `segurovehiculo`
--
ALTER TABLE `segurovehiculo`
  MODIFY `SeguroVehiculoID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `segurovida`
--
ALTER TABLE `segurovida`
  MODIFY `SeguroVidaID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `servicios`
--
ALTER TABLE `servicios`
  MODIFY `ServicioID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `UsuarioID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

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

--
-- Filtros para la tabla `prestamos`
--
ALTER TABLE `prestamos`
  ADD CONSTRAINT `prestamos_ibfk_1` FOREIGN KEY (`UsuarioID`) REFERENCES `usuarios` (`UsuarioID`),
  ADD CONSTRAINT `prestamos_ibfk_2` FOREIGN KEY (`ClienteID`) REFERENCES `clientes` (`ClienteID`),
  ADD CONSTRAINT `prestamos_ibfk_3` FOREIGN KEY (`ServicioID`) REFERENCES `servicios` (`ServicioID`);

--
-- Filtros para la tabla `segurohogar`
--
ALTER TABLE `segurohogar`
  ADD CONSTRAINT `segurohogar_ibfk_1` FOREIGN KEY (`UsuarioID`) REFERENCES `usuarios` (`UsuarioID`),
  ADD CONSTRAINT `segurohogar_ibfk_2` FOREIGN KEY (`ClienteID`) REFERENCES `clientes` (`ClienteID`),
  ADD CONSTRAINT `segurohogar_ibfk_3` FOREIGN KEY (`ServicioID`) REFERENCES `servicios` (`ServicioID`);

--
-- Filtros para la tabla `segurovehiculo`
--
ALTER TABLE `segurovehiculo`
  ADD CONSTRAINT `segurovehiculo_ibfk_1` FOREIGN KEY (`UsuarioID`) REFERENCES `usuarios` (`UsuarioID`),
  ADD CONSTRAINT `segurovehiculo_ibfk_2` FOREIGN KEY (`ClienteID`) REFERENCES `clientes` (`ClienteID`),
  ADD CONSTRAINT `segurovehiculo_ibfk_3` FOREIGN KEY (`ServicioID`) REFERENCES `servicios` (`ServicioID`);

--
-- Filtros para la tabla `segurovida`
--
ALTER TABLE `segurovida`
  ADD CONSTRAINT `segurovida_ibfk_1` FOREIGN KEY (`UsuarioID`) REFERENCES `usuarios` (`UsuarioID`),
  ADD CONSTRAINT `segurovida_ibfk_2` FOREIGN KEY (`ClienteID`) REFERENCES `clientes` (`ClienteID`),
  ADD CONSTRAINT `segurovida_ibfk_3` FOREIGN KEY (`ServicioID`) REFERENCES `servicios` (`ServicioID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
