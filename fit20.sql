-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Gegenereerd op: 19 mei 2016 om 14:22
-- Serverversie: 10.1.10-MariaDB
-- PHP-versie: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fit20`
--

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `beschikbaarheid`
--

CREATE TABLE `beschikbaarheid` (
  `id` int(11) NOT NULL,
  `fitnesserid` int(11) DEFAULT NULL,
  `datum` varchar(25) DEFAULT NULL,
  `voorkeurtrainerid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `beschikbaarheid`
--

INSERT INTO `beschikbaarheid` (`id`, `fitnesserid`, `datum`, `voorkeurtrainerid`) VALUES
(5, 27, '12/05/2016 15:00', 26),
(9, 27, '13/05/2016 11:00', 26),
(10, 27, '13/05/2016 13:00', 25),
(11, 27, '12/06/2016 12:00', 25),
(12, 27, '19/05/2016 14:00', 24);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `persoon`
--

CREATE TABLE `persoon` (
  `id` int(11) NOT NULL,
  `naam` varchar(20) DEFAULT NULL,
  `voornaam` varchar(30) DEFAULT NULL,
  `accountnaam` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `rol` int(2) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `wachtwoord` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `persoon`
--

INSERT INTO `persoon` (`id`, `naam`, `voornaam`, `accountnaam`, `email`, `rol`, `status`, `wachtwoord`) VALUES
(24, 'vermeulen', 'Jos', 'trainer1', 'trainer1@hotmail.be', 1, 'Actief', 'trainer1'),
(25, 'Janssen', 'Jan', 'trainer2', 'trainer2@hotmail.be', 1, 'Actief', 'trainer2'),
(26, 'Meus', 'Jejoen', 'trainer3', 'trainer3@hotmail.be', 1, 'Actief', 'trainer3'),
(27, 'De Vries', 'Rogier', 'Fitnesser1', 'fitnesser1@hotmail.be', 2, 'Actief', 'Fitnesser1'),
(28, 'Vancutsem', 'Liesje', 'Fitnesser2', 'fitnesser2@hotmail.be', 2, 'Actief', 'Fitnesser2'),
(29, 'Vanlichtezeden', 'Annabel', 'Fitnesser3', 'fitnesser3@hotmail.be', 2, 'Actief', 'Fitnesser3');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `rollen`
--

CREATE TABLE `rollen` (
  `id` int(11) NOT NULL,
  `type` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `rollen`
--

INSERT INTO `rollen` (`id`, `type`) VALUES
(1, 'Trainer'),
(2, 'Fitnesser');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `trainer`
--

CREATE TABLE `trainer` (
  `id` int(11) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  `werkuren` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `trainingslot`
--

CREATE TABLE `trainingslot` (
  `id` int(11) NOT NULL,
  `fitnesser` int(10) DEFAULT NULL,
  `trainer` int(10) DEFAULT NULL,
  `programma` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `datum` varchar(25) DEFAULT NULL,
  `klantentevredenheid` varchar(999) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `trainingslot`
--

INSERT INTO `trainingslot` (`id`, `fitnesser`, `trainer`, `programma`, `status`, `datum`, `klantentevredenheid`) VALUES
(44, 27, 24, 'Leg day', 'Gepland', '12/05/2016 15:00', NULL),
(45, NULL, 24, 'Leg day', 'Openstaand', '14/05/2016 12:00', NULL),
(46, 28, 24, 'Conditietraining', 'Gepland', 'dan ist goed', NULL),
(48, 29, 25, 'Upper Body Workout', 'Gepland', '11/05/2016 15:30', NULL),
(49, NULL, 25, NULL, 'Openstaand', '14/05/2016 15:30', NULL),
(50, 29, 25, 'Full Workout', 'Gepland', '16/05/2016 11:30', NULL),
(55, 27, 24, 'All round', 'Voltooid', '18/05/2016 16:00', 'Dit is klantentevredenheid'),
(56, 27, 24, NULL, 'Voltooid', '19/05/2016 14:30', NULL),
(57, 27, 25, NULL, 'Voltooid', '17/05/2016 14:30', NULL),
(58, 27, 24, NULL, 'Voltooid', '18/05/2016 14:30', NULL);

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel `beschikbaarheid`
--
ALTER TABLE `beschikbaarheid`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `persoon`
--
ALTER TABLE `persoon`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `rollen`
--
ALTER TABLE `rollen`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `trainer`
--
ALTER TABLE `trainer`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `trainingslot`
--
ALTER TABLE `trainingslot`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT voor geëxporteerde tabellen
--

--
-- AUTO_INCREMENT voor een tabel `beschikbaarheid`
--
ALTER TABLE `beschikbaarheid`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT voor een tabel `persoon`
--
ALTER TABLE `persoon`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
--
-- AUTO_INCREMENT voor een tabel `rollen`
--
ALTER TABLE `rollen`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT voor een tabel `trainer`
--
ALTER TABLE `trainer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT voor een tabel `trainingslot`
--
ALTER TABLE `trainingslot`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
