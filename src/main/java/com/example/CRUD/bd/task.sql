-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-10-2024 a las 02:45:32
-- Versión del servidor: 10.4.6-MariaDB
-- Versión de PHP: 7.2.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `task`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `speaker`
--

CREATE TABLE `speaker` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `address` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `salary` decimal(38,2) DEFAULT NULL,
  `cellphone` varchar(255) NOT NULL,
  `status` bit(1) NOT NULL,
  `type` enum('Principal','Secondary') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `speaker`
--

INSERT INTO `speaker` (`id`, `name`, `age`, `address`, `email`, `salary`, `cellphone`, `status`, `type`) VALUES
(1, 'Enrrique', 28, 'dirección', 'enrrique.com', '5000.00', '921423211', b'1', 'Secondary'),
(2, 'Elio', 28, 'dirección', 'elio@gmail.com', '3200.00', '985454992', b'1', 'Principal'),
(3, 'Frankoyci', 26, 'km7', 'ramirez@gmail.com', '1200.00', '963852147', b'1', 'Principal');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `speaker`
--
ALTER TABLE `speaker`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `speaker`
--
ALTER TABLE `speaker`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
