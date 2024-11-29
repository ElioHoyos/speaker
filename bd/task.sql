-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-11-2024 a las 22:07:38
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
-- Estructura de tabla para la tabla `score`
--

CREATE TABLE `score` (
  `id` bigint(20) NOT NULL,
  `score` bigint(20) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `speaker_id` bigint(20) NOT NULL,
  `student_id` bigint(20) NOT NULL,
  `score_type` enum('BAD','GOOD','REGULAR') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `score`
--

INSERT INTO `score` (`id`, `score`, `date`, `speaker_id`, `student_id`, `score_type`) VALUES
(1, 40, '2024-11-13', 1, 2, 'REGULAR');

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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `student`
--

CREATE TABLE `student` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `dni` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `cellphone` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `status` bit(1) NOT NULL DEFAULT b'1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `student`
--

INSERT INTO `student` (`id`, `name`, `dni`, `email`, `cellphone`, `age`, `status`) VALUES
(1, 'Gina', '12345678', 'gina@gmail.com', '963852147', 22, b'1'),
(2, 'Pedro', '12345678', 'pedro@gmail.com', '951753852', 28, b'1');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `score`
--
ALTER TABLE `score`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_score_speaker_idx` (`speaker_id`),
  ADD KEY `fk_score_student1_idx` (`student_id`);

--
-- Indices de la tabla `speaker`
--
ALTER TABLE `speaker`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `score`
--
ALTER TABLE `score`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `speaker`
--
ALTER TABLE `speaker`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `student`
--
ALTER TABLE `student`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `score`
--
ALTER TABLE `score`
  ADD CONSTRAINT `fk_score_speaker` FOREIGN KEY (`speaker_id`) REFERENCES `speaker` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_score_student` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
