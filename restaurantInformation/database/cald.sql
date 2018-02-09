-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Feb 09, 2018 alle 23:16
-- Versione del server: 10.1.22-MariaDB
-- Versione PHP: 7.0.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
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
-- Struttura della tabella `cinemabooking`
--

CREATE TABLE `cinemabooking` (
  `Id` int(11) NOT NULL,
  `hall` int(11) NOT NULL,
  `film` int(11) NOT NULL,
  `user` int(11) NOT NULL,
  `seats` int(11) NOT NULL,
  `schedule` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `cinemas`
--

CREATE TABLE `cinemas` (
  `cinema_id` int(11) NOT NULL,
  `cinema_lat` decimal(20,8) NOT NULL,
  `cinema_lon` decimal(20,8) NOT NULL,
  `cinema_name` varchar(50) NOT NULL,
  `cinema_address` varchar(100) DEFAULT NULL,
  `cinema_cap` varchar(10) DEFAULT NULL,
  `cinema_city` varchar(50) NOT NULL,
  `cinema_telephoneNumber` varchar(20) DEFAULT NULL,
  `owner` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `cinemas`
--

INSERT INTO `cinemas` (`cinema_id`, `cinema_lat`, `cinema_lon`, `cinema_name`, `cinema_address`, `cinema_cap`, `cinema_city`, `cinema_telephoneNumber`, `owner`) VALUES
(3, '19.00000000', '19.00000000', 'Bo', 'Bo', '67100', 'Rome', NULL, NULL),
(4, '19.00000000', '19.00000000', 'Bo', 'Bo', '67100', 'Rome', NULL, NULL),
(5, '42.34697000', '13.95190000', 'davide4', 'davide4', '65011', 'catignano', '3389945', NULL),
(6, '42.34697000', '13.95190000', 'davide4', 'davide4', '65011', 'catignano', '3389945', NULL),
(7, '42.34697000', '13.95190000', 'davide4', 'davide4', '65011', 'catignano', '3389945', NULL),
(8, '42.34697000', '13.95190000', 'davide4', 'davide4', '65011', 'catignano', '3389945', NULL);

-- --------------------------------------------------------

--
-- Struttura della tabella `discount`
--

CREATE TABLE `discount` (
  `discount_id` int(11) NOT NULL,
  `cinema` int(11) NOT NULL,
  `restaurant` int(11) NOT NULL,
  `price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `discount`
--

INSERT INTO `discount` (`discount_id`, `cinema`, `restaurant`, `price`) VALUES
(1, 3, 1, 5),
(2, 4, 2, 3),
(3, 3, 4, 3),
(4, 3, 5, 3),
(5, 3, 6, 3);

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
  `type` varchar(50) DEFAULT NULL,
  `plot` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `films`
--

INSERT INTO `films` (`film_id`, `name`, `director`, `cast`, `duration`, `type`, `plot`) VALUES
(1, 'Avengers: Infinity War', 'Anthony Russo', 'Robert Downey Jr, Josh Brolin, Mark Buffalo, Tom Hiddleston, Chris Evans, Chris Hemsworth, Jeremy Renner, Chris Pratt', 147, 'Action', 'Four years after the events of Guardians of the Galaxy Vol. 2,[1] the Avengers have been torn apart following the events of Captain America: Civil War. When Thanos arrives on Earth to collect the Infinity Stones for a gauntlet that will allow him to bend reality to his will, the Avengers must join forces with the Guardians of the Galaxy to stop him before his onslaught of destruction puts an end to the universe'),
(2, 'nuovofilm33', 'direttore33', 'ciao', 180, 'ciao', 'plot'),
(3, 'nuovofilm22', 'direttore22', 'ciao', 180, 'ciao', 'plot'),
(4, 'blu23', 'blu23', 'ciao2', 1802, 'ciao2', 'plot2'),
(5, 'nuovofilm23', 'direttore22', 'ciao', 180, 'ciao', 'plot'),
(6, 'nuovofilm333', 'direttore33', 'ciao', 180, 'ciao', 'plot');

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
(3, 10, 100, 3),
(4, 25, 100, 5),
(5, 83, 200, 5),
(6, 20, 100, 6),
(7, 21, 200, 6),
(8, 23, 100, 7),
(9, 24, 200, 7),
(10, 23, 100, 8),
(11, 24, 200, 8);

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

--
-- Dump dei dati per la tabella `hall_film`
--

INSERT INTO `hall_film` (`hall_film_id`, `hall`, `film`, `time`, `price`, `freeSeatsNumber`) VALUES
(1, 1, 1, '2018-02-01 16:00:00', 5, 248),
(2, 1, 1, '2018-02-01 22:00:00', 7.5, 118),
(3, 4, 2, '2017-12-12 18:00:00', 10, 100),
(4, 4, 3, '2017-12-12 20:00:00', 10, 100),
(5, 5, 4, '2017-12-12 19:00:00', 20, 200),
(6, 6, 2, '2017-12-12 18:00:00', 10, 100),
(7, 6, 3, '2017-12-12 20:00:00', 10, 100),
(8, 7, 4, '2017-12-12 19:00:00', 20, 200),
(9, 8, 2, '2017-12-12 18:00:00', 10, 100),
(10, 8, 3, '2017-12-12 20:00:00', 10, 100),
(11, 9, 4, '2017-12-12 19:00:00', 20, 200),
(12, 9, 5, '2017-12-12 20:00:00', 10, 100),
(13, 10, 6, '2017-12-12 18:00:00', 10, 100),
(14, 11, 4, '2017-12-12 19:00:00', 20, 200);

-- --------------------------------------------------------

--
-- Struttura della tabella `restaurantbookings`
--

CREATE TABLE `restaurantbookings` (
  `Id_Booking` int(11) NOT NULL,
  `Restaurant` int(11) NOT NULL,
  `User` int(11) NOT NULL,
  `Schedule` datetime NOT NULL,
  `Seats` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `restaurants`
--

CREATE TABLE `restaurants` (
  `restaurant_id` int(11) NOT NULL,
  `restaurant_lat` decimal(20,8) DEFAULT NULL,
  `restaurant_lon` decimal(20,8) DEFAULT NULL,
  `restaurant_name` varchar(50) NOT NULL,
  `restaurant_address` varchar(100) DEFAULT NULL,
  `restaurant_cap` varchar(10) DEFAULT NULL,
  `restaurant_city` varchar(50) DEFAULT NULL,
  `restaurant_telephoneNumber` varchar(20) DEFAULT NULL,
  `style` varchar(50) DEFAULT NULL,
  `cuisine` varchar(50) DEFAULT NULL,
  `menu` varchar(500) DEFAULT NULL,
  `max_seats` int(11) NOT NULL,
  `owner` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `restaurants`
--

INSERT INTO `restaurants` (`restaurant_id`, `restaurant_lat`, `restaurant_lon`, `restaurant_name`, `restaurant_address`, `restaurant_cap`, `restaurant_city`, `restaurant_telephoneNumber`, `style`, `cuisine`, `menu`, `max_seats`, `owner`) VALUES
(1, NULL, NULL, 'Da Paolo', 'Via Mazzini 3', '00123', 'Rome', '3458987666', 'Napoletano', 'Bo', 'Bo', 0, NULL),
(2, '11.00000000', '11.00000000', 'Da Paolo', 'Via Mazzini 3', '00123', 'Rome', '3458987666', 'Napoletano', 'Bo', 'Bo', 100, NULL),
(3, '12.00000000', '12.00000000', 'Arrosticini Divini', 'Via Francia 3', '50121', 'Rome', '3478854123', 'Italian', 'Italian', 'BO', 50, NULL),
(4, '42.34697000', '13.95190000', 'david', 'Via Roma', '65011', 'Catignano', '02586936', 'Agriturismo', 'Italiana', 'ababababa', 0, NULL),
(5, '42.34697000', '13.95190000', 'david', 'Via Roma', '65011', 'Catignano', '02586936', 'Agriturismo', 'Italiana', 'ababababa', 0, NULL),
(6, '42.34697000', '13.95190000', 'david', 'Via Roma', '65011', 'Catignano', '02586936', 'Agriturismo', 'Italiana', 'ababababa', 100, NULL);

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

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `cinemabooking`
--
ALTER TABLE `cinemabooking`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `hall` (`hall`),
  ADD KEY `film` (`film`),
  ADD KEY `user` (`user`);

--
-- Indici per le tabelle `cinemas`
--
ALTER TABLE `cinemas`
  ADD PRIMARY KEY (`cinema_id`),
  ADD KEY `owner` (`owner`);

--
-- Indici per le tabelle `discount`
--
ALTER TABLE `discount`
  ADD PRIMARY KEY (`discount_id`),
  ADD KEY `cinema` (`cinema`),
  ADD KEY `restaurants` (`restaurant`);

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
-- Indici per le tabelle `restaurantbookings`
--
ALTER TABLE `restaurantbookings`
  ADD PRIMARY KEY (`Id_Booking`),
  ADD KEY `Restaurant` (`Restaurant`),
  ADD KEY `User` (`User`);

--
-- Indici per le tabelle `restaurants`
--
ALTER TABLE `restaurants`
  ADD PRIMARY KEY (`restaurant_id`),
  ADD KEY `owner` (`owner`);

--
-- Indici per le tabelle `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `cinemabooking`
--
ALTER TABLE `cinemabooking`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT per la tabella `cinemas`
--
ALTER TABLE `cinemas`
  MODIFY `cinema_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT per la tabella `discount`
--
ALTER TABLE `discount`
  MODIFY `discount_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT per la tabella `films`
--
ALTER TABLE `films`
  MODIFY `film_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT per la tabella `halls`
--
ALTER TABLE `halls`
  MODIFY `hall_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT per la tabella `hall_film`
--
ALTER TABLE `hall_film`
  MODIFY `hall_film_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT per la tabella `restaurantbookings`
--
ALTER TABLE `restaurantbookings`
  MODIFY `Id_Booking` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT per la tabella `restaurants`
--
ALTER TABLE `restaurants`
  MODIFY `restaurant_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT per la tabella `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `cinemabooking`
--
ALTER TABLE `cinemabooking`
  ADD CONSTRAINT `ext_film_id` FOREIGN KEY (`film`) REFERENCES `films` (`film_id`),
  ADD CONSTRAINT `ext_hall_id` FOREIGN KEY (`user`) REFERENCES `halls` (`hall_id`),
  ADD CONSTRAINT `ext_user_id` FOREIGN KEY (`user`) REFERENCES `users` (`user_id`);

--
-- Limiti per la tabella `cinemas`
--
ALTER TABLE `cinemas`
  ADD CONSTRAINT `cinemas_ibfk_1` FOREIGN KEY (`owner`) REFERENCES `users` (`user_id`);

--
-- Limiti per la tabella `discount`
--
ALTER TABLE `discount`
  ADD CONSTRAINT `discount_ibfk_1` FOREIGN KEY (`cinema`) REFERENCES `cinemas` (`cinema_id`),
  ADD CONSTRAINT `discount_ibfk_2` FOREIGN KEY (`restaurant`) REFERENCES `restaurants` (`restaurant_id`);

--
-- Limiti per la tabella `halls`
--
ALTER TABLE `halls`
  ADD CONSTRAINT `halls_ibfk_1` FOREIGN KEY (`cinema`) REFERENCES `cinemas` (`cinema_id`);

--
-- Limiti per la tabella `hall_film`
--
ALTER TABLE `hall_film`
  ADD CONSTRAINT `hall_film_ibfk_1` FOREIGN KEY (`hall`) REFERENCES `halls` (`hall_id`),
  ADD CONSTRAINT `hall_film_ibfk_2` FOREIGN KEY (`film`) REFERENCES `films` (`film_id`);

--
-- Limiti per la tabella `restaurantbookings`
--
ALTER TABLE `restaurantbookings`
  ADD CONSTRAINT `ext_restaurant` FOREIGN KEY (`Restaurant`) REFERENCES `restaurants` (`restaurant_id`),
  ADD CONSTRAINT `ext_user` FOREIGN KEY (`User`) REFERENCES `users` (`user_id`);

--
-- Limiti per la tabella `restaurants`
--
ALTER TABLE `restaurants`
  ADD CONSTRAINT `restaurants_ibfk_1` FOREIGN KEY (`owner`) REFERENCES `users` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
