-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Creato il: Feb 19, 2018 alle 12:54
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

--
-- Dump dei dati per la tabella `cinemabooking`
--

INSERT INTO `cinemabooking` (`Id`, `hall`, `film`, `user`, `seats`, `schedule`) VALUES
(1, 14, 1, 2, 2, '2018-02-20 20:00:00');

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
(4, '41.94095252', '12.42412059', 'Movieplex', 'Via Cola di Rienzo', '00192', 'Rome', '1234567', 3),
(5, '43.77470000', '11.25051000', 'Best Cinema', 'Via Della Scala', '50123', 'Florence', '0987654', 3),
(6, '45.44240660', '10.99790350', 'ProvaUpdated', 'Via Giuseppe Mazzini', '37121', 'Verona', '08632', 4),
(7, '42.46391000', '14.21354000', 'Super', 'Via Roma', '65122', 'Pescara', '0987652', 4),
(9, '45.44240660', '10.99790350', 'PopoCorn', 'Via Giuseppe Mazzini', '37121', 'Verona', '0863241515', 6),
(10, '45.44240660', '10.99790350', 'Salatini', 'Via Giuseppe Mazzini', '37121', 'Verona', '1234567', 6),
(11, '45.44240660', '10.99790350', 'Da Giovanni', 'Via Giuseppe Mazzini', '37121', 'Verona', '1234567', 3),
(12, '41.94095248', '12.42412053', 'Da Luca', 'Via Monte Mario ', '37121', 'Rome', '0987', 6),
(15, '41.94095248', '12.42412053', 'Da Luca2', 'Via Monte Mario ', '37121', 'Rome', '0987', 6);

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
(2, 4, 2, 3),
(7, 4, 8, 3),
(8, 4, 9, 12),
(9, 4, 10, 1.5),
(10, 12, 11, 30),
(12, 7, 13, 20);

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
(2, 'Pirates of Caribbean', 'Gore Verbinski', 'Jonny Depp', 180, 'Action, Fantastic', 'Pyrates...'),
(3, 'Avengers: Infinity War2', 'Anthony Russo', 'Robert Downey Jr, Josh Brolin, Mark Buffalo, Tom Hiddleston, Chris Evans, Chris Hemsworth, Jeremy Renner, Chris Pratt', 147, 'Action', 'Four years after the events of Guardians of the Galaxy Vol. 2,[1] the Avengers have been torn apart following the events of Captain America: Civil War. When Thanos arrives on Earth to collect the Infinity Stones for a gauntlet that will allow him to bend reality to his will, the Avengers must join forces with the Guardians of the Galaxy to stop him before his onslaught of destruction puts an end to the universe');

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
(2, 10, 101, 4),
(4, 1, 2, 5),
(5, 1, 100, 6),
(6, 1, 2, 7),
(9, 1, 80, 9),
(10, 1, 80, 9),
(11, 1, 22, 10),
(12, 1, 20, 10),
(13, 1, 22, 11),
(14, 1, 20, 11),
(15, 1, 240, 12),
(16, 1, 110, 12),
(21, 1, 120, 15),
(22, 1, 120, 15);

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
(3, 4, 2, '2018-02-02 21:00:00', 7, 10),
(5, 6, 2, '2018-02-02 21:00:00', 7, 10),
(6, 2, 1, '2018-02-09 20:00:00', 7, 100),
(9, 9, 1, '2018-02-18 17:00:00', 5, 248),
(10, 10, 1, '2018-02-18 21:00:00', 7.5, 110),
(11, 11, 1, '2018-02-20 16:00:00', 5, 20),
(12, 12, 1, '2018-02-20 20:00:00', 8, 18),
(14, 14, 1, '2018-02-20 20:00:00', 8, 16),
(15, 15, 1, '2018-02-20 16:00:00', 8, 240),
(16, 16, 1, '2018-02-20 20:00:00', 7.5, 110),
(21, 21, 1, '2018-02-20 16:00:00', 8, 120),
(22, 22, 1, '2018-02-20 20:00:00', 7.5, 120);

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

--
-- Dump dei dati per la tabella `restaurantbookings`
--

INSERT INTO `restaurantbookings` (`Id_Booking`, `Restaurant`, `User`, `Schedule`, `Seats`) VALUES
(1, 9, 2, '2018-02-15 00:00:00', 2),
(3, 3, 2, '2018-03-04 00:00:00', 30),
(4, 2, 2, '2018-02-14 00:00:00', 80),
(5, 8, 2, '2018-02-14 00:00:00', 90),
(6, 3, 2, '2018-02-15 00:00:00', 43),
(7, 10, 2, '2018-07-19 00:00:00', 53),
(8, 3, 2, '2018-10-19 00:00:00', 50),
(9, 3, 2, '2018-12-19 00:00:00', 50);

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
(2, '11.00000000', '11.00000000', 'Da Paolo', 'Via Mazzini 3', '00123', 'Rome', '3458987666', 'Napoletano', 'Bo', 'Bo', 100, 3),
(3, '12.00000000', '12.00000000', 'Arrosticini Divini', 'Via Francia 3', '50121', 'Rome', '3478854123', 'Italian', 'Italian', 'BO', 50, 3),
(8, '45.44240660', '10.99790350', 'Da Bobo', 'Via Giuseppe Mazzini', '31076', 'Verona', '09876540988', 'bo', 'si', 'no', 90, 4),
(9, '42.47109950', '14.21417970', 'Pizza e Pasta', 'Via Firenze', '67100', 'Pescara', '123478', 'bobo', 'nono', 'no', 94, 6),
(10, '41.94095248', '12.42412053', 'Da Davide', 'Via Monte Mario', '67100', 'Rome', '092222', 'booooooo', 'voooooo', 'noooooo', 80, 6),
(11, '42.41891038', '14.19135688', 'La Pecora Nera', 'Via Europa 9', '66100', 'San Giovanni Teatino', '0854408574', 'Italian', 'Boh', 'Rustell: 0.80, Ratafia: 3', 75, 6),
(13, '42.33351518', '14.16621698', 'L''altro Pianeta', 'Strada della Pace 70', '66100', 'Chieti', '0871403780', 'Italian', 'Misto', 'Bistecca di angus: 20, pizza margherita: 7', 150, 6);

-- --------------------------------------------------------

--
-- Struttura della tabella `sessions`
--

CREATE TABLE `sessions` (
  `id` int(20) UNSIGNED NOT NULL,
  `token` varchar(256) DEFAULT NULL,
  `user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `sessions`
--

INSERT INTO `sessions` (`id`, `token`, `user`) VALUES
(940, '1234567890', 2),
(951, '4286655664067353383', 6),
(952, '1846196729694188206', 6);

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
-- Dump dei dati per la tabella `users`
--

INSERT INTO `users` (`user_id`, `name`, `surname`, `email`, `password`, `username`) VALUES
(2, 'Luca', 'Grillo', 'lucag', 'luca', 'lucgril'),
(3, 'Davide', 'Mariotti', 'davidemariotti@hotmail.it', 'davide', 'dado'),
(4, 'Cristian', 'Capozucco', 'cristian@gmail.com', 'cricri', 'cri'),
(6, 'Luca', 'Grillo', 'lucag.8595@gmail.com', 'luca', 'lucgril2');

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
  ADD KEY `User` (`User`),
  ADD KEY `Restaurant_2` (`Restaurant`),
  ADD KEY `User_2` (`User`);

--
-- Indici per le tabelle `restaurants`
--
ALTER TABLE `restaurants`
  ADD PRIMARY KEY (`restaurant_id`),
  ADD KEY `owner` (`owner`);

--
-- Indici per le tabelle `sessions`
--
ALTER TABLE `sessions`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user` (`user`);

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
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT per la tabella `cinemas`
--
ALTER TABLE `cinemas`
  MODIFY `cinema_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT per la tabella `discount`
--
ALTER TABLE `discount`
  MODIFY `discount_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT per la tabella `films`
--
ALTER TABLE `films`
  MODIFY `film_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT per la tabella `halls`
--
ALTER TABLE `halls`
  MODIFY `hall_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
--
-- AUTO_INCREMENT per la tabella `hall_film`
--
ALTER TABLE `hall_film`
  MODIFY `hall_film_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
--
-- AUTO_INCREMENT per la tabella `restaurantbookings`
--
ALTER TABLE `restaurantbookings`
  MODIFY `Id_Booking` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT per la tabella `restaurants`
--
ALTER TABLE `restaurants`
  MODIFY `restaurant_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT per la tabella `sessions`
--
ALTER TABLE `sessions`
  MODIFY `id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=953;
--
-- AUTO_INCREMENT per la tabella `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `cinemabooking`
--
ALTER TABLE `cinemabooking`
  ADD CONSTRAINT `cinemabooking_ibfk_1` FOREIGN KEY (`hall`) REFERENCES `halls` (`hall_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `cinemabooking_ibfk_2` FOREIGN KEY (`film`) REFERENCES `films` (`film_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `cinemabooking_ibfk_3` FOREIGN KEY (`user`) REFERENCES `users` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limiti per la tabella `cinemas`
--
ALTER TABLE `cinemas`
  ADD CONSTRAINT `cinemas_ibfk_1` FOREIGN KEY (`owner`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

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
  ADD CONSTRAINT `restaurantbookings_ibfk_1` FOREIGN KEY (`Restaurant`) REFERENCES `restaurants` (`restaurant_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `restaurantbookings_ibfk_2` FOREIGN KEY (`User`) REFERENCES `users` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limiti per la tabella `restaurants`
--
ALTER TABLE `restaurants`
  ADD CONSTRAINT `restaurants_ibfk_1` FOREIGN KEY (`owner`) REFERENCES `users` (`user_id`);

--
-- Limiti per la tabella `sessions`
--
ALTER TABLE `sessions`
  ADD CONSTRAINT `sessions_ibfk_1` FOREIGN KEY (`user`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
