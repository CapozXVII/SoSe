-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Creato il: Gen 12, 2018 alle 19:58
-- Versione del server: 10.1.19-MariaDB
-- Versione PHP: 7.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cald`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `cinema`
--

CREATE TABLE `cinema` (
  `cinema_id` int(11) NOT NULL,
  `lat` decimal(20,8) NOT NULL,
  `lon` decimal(20,8) NOT NULL,
  `cinema_name` varchar(50) NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  `cap` varchar(10) DEFAULT NULL,
  `city` varchar(50) NOT NULL,
  `telephoneNumber` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `cinema`
--

INSERT INTO `cinema` (`cinema_id`, `lat`, `lon`, `cinema_name`, `address`, `cap`, `city`, `telephoneNumber`) VALUES
(3, '19.00000000', '19.00000000', 'Bo', 'Bo', '67100', 'Rome', NULL),
(4, '19.00000000', '19.00000000', 'Bo', 'Bo', '67100', 'Rome', NULL);

-- --------------------------------------------------------

--
-- Struttura della tabella `discount`
--

CREATE TABLE `discount` (
  `discount_id` int(11) NOT NULL,
  `cinema` int(11) NOT NULL,
  `restaurants` int(11) NOT NULL,
  `price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `films`
--

CREATE TABLE `films` (
  `film_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `director` varchar(50) DEFAULT NULL,
  `cast` varchar(400) DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `rating` varchar(50) DEFAULT NULL,
  `plot` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `halls`
--

CREATE TABLE `halls` (
  `hall_id` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  `seatsNumber` int(11) NOT NULL,
  `cinema` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `halls`
--

INSERT INTO `halls` (`hall_id`, `number`, `seatsNumber`, `cinema`) VALUES
(1, 1, 100, 3),
(2, 10, 101, 4),
(3, 10, 100, 3);

-- --------------------------------------------------------

--
-- Struttura della tabella `hall_film`
--

CREATE TABLE `hall_film` (
  `hall_film_id` int(11) NOT NULL,
  `hall` int(11) NOT NULL,
  `film` int(11) NOT NULL,
  `time` datetime NOT NULL,
  `price` double NOT NULL,
  `freeSeatsNumber` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `restaurants`
--

CREATE TABLE `restaurants` (
  `restaurant_id` int(11) NOT NULL,
  `lat` decimal(20,8) DEFAULT NULL,
  `lon` decimal(20,8) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  `cap` varchar(10) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `telephoneumber` varchar(20) DEFAULT NULL,
  `style` varchar(50) DEFAULT NULL,
  `cuisine` varchar(50) DEFAULT NULL,
  `menu` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `tables`
--

CREATE TABLE `tables` (
  `table_id` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  `seatsNumber` int(11) NOT NULL,
  `restaurant` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `surname` varchar(20) DEFAULT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(100) NOT NULL,
  `username` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `user_hall`
--

CREATE TABLE `user_hall` (
  `user_hall_id` int(11) NOT NULL,
  `user` int(11) NOT NULL,
  `hall` int(11) NOT NULL,
  `seats` int(11) NOT NULL,
  `schedule` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `user_table`
--

CREATE TABLE `user_table` (
  `user_table_id` int(11) NOT NULL,
  `user` int(11) NOT NULL,
  `tables` int(11) NOT NULL,
  `reservation_time` datetime NOT NULL,
  `reservation_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `cinema`
--
ALTER TABLE `cinema`
  ADD PRIMARY KEY (`cinema_id`);

--
-- Indici per le tabelle `discount`
--
ALTER TABLE `discount`
  ADD PRIMARY KEY (`discount_id`),
  ADD KEY `cinema` (`cinema`),
  ADD KEY `restaurants` (`restaurants`);

--
-- Indici per le tabelle `films`
--
ALTER TABLE `films`
  ADD PRIMARY KEY (`film_id`);

--
-- Indici per le tabelle `halls`
--
ALTER TABLE `halls`
  ADD PRIMARY KEY (`hall_id`),
  ADD KEY `cinema` (`cinema`);

--
-- Indici per le tabelle `hall_film`
--
ALTER TABLE `hall_film`
  ADD PRIMARY KEY (`hall_film_id`),
  ADD KEY `hall` (`hall`),
  ADD KEY `film` (`film`);

--
-- Indici per le tabelle `restaurants`
--
ALTER TABLE `restaurants`
  ADD PRIMARY KEY (`restaurant_id`);

--
-- Indici per le tabelle `tables`
--
ALTER TABLE `tables`
  ADD PRIMARY KEY (`table_id`),
  ADD KEY `restaurant` (`restaurant`);

--
-- Indici per le tabelle `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indici per le tabelle `user_hall`
--
ALTER TABLE `user_hall`
  ADD PRIMARY KEY (`user_hall_id`),
  ADD KEY `user` (`user`),
  ADD KEY `hall` (`hall`);

--
-- Indici per le tabelle `user_table`
--
ALTER TABLE `user_table`
  ADD PRIMARY KEY (`user_table_id`),
  ADD KEY `user` (`user`),
  ADD KEY `tables` (`tables`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `cinema`
--
ALTER TABLE `cinema`
  MODIFY `cinema_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT per la tabella `discount`
--
ALTER TABLE `discount`
  MODIFY `discount_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT per la tabella `films`
--
ALTER TABLE `films`
  MODIFY `film_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT per la tabella `halls`
--
ALTER TABLE `halls`
  MODIFY `hall_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT per la tabella `hall_film`
--
ALTER TABLE `hall_film`
  MODIFY `hall_film_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT per la tabella `restaurants`
--
ALTER TABLE `restaurants`
  MODIFY `restaurant_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT per la tabella `tables`
--
ALTER TABLE `tables`
  MODIFY `table_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT per la tabella `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT per la tabella `user_hall`
--
ALTER TABLE `user_hall`
  MODIFY `user_hall_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT per la tabella `user_table`
--
ALTER TABLE `user_table`
  MODIFY `user_table_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `discount`
--
ALTER TABLE `discount`
  ADD CONSTRAINT `discount_ibfk_1` FOREIGN KEY (`cinema`) REFERENCES `cinema` (`cinema_id`),
  ADD CONSTRAINT `discount_ibfk_2` FOREIGN KEY (`restaurants`) REFERENCES `restaurants` (`restaurant_id`);

--
-- Limiti per la tabella `halls`
--
ALTER TABLE `halls`
  ADD CONSTRAINT `halls_ibfk_1` FOREIGN KEY (`cinema`) REFERENCES `cinema` (`cinema_id`);

--
-- Limiti per la tabella `hall_film`
--
ALTER TABLE `hall_film`
  ADD CONSTRAINT `hall_film_ibfk_1` FOREIGN KEY (`hall`) REFERENCES `halls` (`hall_id`),
  ADD CONSTRAINT `hall_film_ibfk_2` FOREIGN KEY (`film`) REFERENCES `films` (`film_id`);

--
-- Limiti per la tabella `tables`
--
ALTER TABLE `tables`
  ADD CONSTRAINT `tables_ibfk_1` FOREIGN KEY (`restaurant`) REFERENCES `restaurants` (`restaurant_id`);

--
-- Limiti per la tabella `user_hall`
--
ALTER TABLE `user_hall`
  ADD CONSTRAINT `user_hall_ibfk_1` FOREIGN KEY (`user`) REFERENCES `users` (`user_id`),
  ADD CONSTRAINT `user_hall_ibfk_2` FOREIGN KEY (`hall`) REFERENCES `halls` (`hall_id`);

--
-- Limiti per la tabella `user_table`
--
ALTER TABLE `user_table`
  ADD CONSTRAINT `user_table_ibfk_1` FOREIGN KEY (`user`) REFERENCES `users` (`user_id`),
  ADD CONSTRAINT `user_table_ibfk_2` FOREIGN KEY (`tables`) REFERENCES `tables` (`table_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
