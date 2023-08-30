-- Adminer 4.8.1 MySQL 10.6.12-MariaDB-0ubuntu0.22.04.1 dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

CREATE DATABASE `Heroes` /*!40100 DEFAULT CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci */;
USE `Heroes`;

DROP TABLE IF EXISTS `Player_heroes`;
CREATE TABLE `Player_heroes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class` varchar(200) NOT NULL,
  `name` varchar(200) NOT NULL,
  `health` int(11) NOT NULL,
  `force_value` int(11) NOT NULL,
  `weapons_spells` varchar(200) DEFAULT NULL,
  `shields_potions` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

INSERT INTO `Player_heroes` (`id`, `class`, `name`, `health`, `force_value`, `weapons_spells`, `shields_potions`) VALUES
(1,	'Warrior',	'Ragnar',	8,	8,	NULL,	NULL),
(2,	'Wizard',	'Gandalf',	5,	12,	NULL,	NULL);

-- 2023-08-30 08:01:34
