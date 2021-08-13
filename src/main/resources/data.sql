-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Aug 13, 2021 at 04:17 PM
-- Server version: 5.7.24-log
-- PHP Version: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `book_your_ticket`
--

-- --------------------------------------------------------

--
-- Table structure for table `movie_info`
--

DROP TABLE IF EXISTS `movie_info`;
CREATE TABLE IF NOT EXISTS `movie_info` (
  `movie_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `movie_name` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `released_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`movie_id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `movie_info`
--

INSERT INTO `movie_info` (`movie_id`, `created_at`, `language`, `movie_name`, `released_date`, `status`, `updated_at`) VALUES
(1, '2017-12-22 00:00:00', 'ENGLISH', 'The Suicide Squad (2021)', '2017-12-22 00:00:00', 'A', '2017-12-22 00:00:00'),
(2, '2017-12-22 00:00:00', 'ENGLISH', 'F9: The Fast Saga', '2017-12-22 00:00:00', 'A', '2017-12-22 00:00:00'),
(3, '2017-12-22 00:00:00', 'ENGLISH', 'Tom & Jerry', '2017-12-22 00:00:00', 'A', '2017-12-22 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `screen_info`
--

DROP TABLE IF EXISTS `screen_info`;
CREATE TABLE IF NOT EXISTS `screen_info` (
  `screen_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `screen_name` varchar(255) DEFAULT NULL,
  `no_of_seats` int(11) DEFAULT NULL,
  `theatre_id` bigint(20) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`screen_id`),
  KEY `FKpiy4gfn1v2i7d05221mra721x` (`theatre_id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `screen_info`
--

INSERT INTO `screen_info` (`screen_id`, `created_at`, `no_of_seats`, `screen_name`, `status`, `updated_at`, `theatre_id`) VALUES
(1, '2021-08-12 00:00:00', 20, 'AGS Screen 2', 'A', '2021-08-12 00:00:00', 1),
(2, '2021-08-12 00:00:00', 25, 'AGS Screen 2', 'A', '2021-08-12 00:00:00', 1),
(3, '2021-08-12 00:00:00', 20, 'INOX Screen 1', 'A', '2021-08-12 00:00:00', 2),
(4, '2021-08-12 00:00:00', 25, 'INOX Screen 2', 'A', '2021-08-12 00:00:00', 2),
(5, '2021-08-12 00:00:00', 25, 'INOX Screen 3', 'A', '2021-08-12 00:00:00', 2),
(6, '2021-08-12 00:00:00', 20, 'Rohini Screen 1', 'A', '2021-08-12 00:00:00', 3),
(7, '2021-08-12 00:00:00', 25, 'Rohini Screen 2', 'A', '2021-08-12 00:00:00', 3),
(8, '2021-08-12 00:00:00', 25, 'Rohini Screen 3', 'A', '2021-08-12 00:00:00', 3),
(9, '2021-08-12 00:00:00', 20, 'Luxe Screen 1', 'A', '2021-08-12 00:00:00', 4),
(10, '2021-08-12 00:00:00', 25, 'Luxe Screen 2', 'A', '2021-08-12 00:00:00', 4),
(11, '2021-08-12 00:00:00', 20, 'Mayajaal Screen 1', 'A', '2021-08-12 00:00:00', 5),
(12, '2021-08-12 00:00:00', 25, 'Mayajaal Screen 2', 'A', '2021-08-12 00:00:00', 5);

-- --------------------------------------------------------

--
-- Table structure for table `screen_seat_info`
--

DROP TABLE IF EXISTS `screen_seat_info`;
CREATE TABLE IF NOT EXISTS `screen_seat_info` (
  `screen_seat_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `seat_number` varchar(255) DEFAULT NULL,
  `screen_id` bigint(20) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`screen_seat_id`),
  KEY `FKqhed6f7xs9qv74kqev48lp6jg` (`screen_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `show_info`
--

DROP TABLE IF EXISTS `show_info`;
CREATE TABLE IF NOT EXISTS `show_info` (
  `show_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `movie_id` bigint(20) DEFAULT NULL,
  `screen_id` bigint(20) DEFAULT NULL,
  `show_end_time` datetime DEFAULT NULL,
  `show_start_time` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`show_id`),
  KEY `FK5hrc3sv5tppbl0c87hheroeti` (`movie_id`),
  KEY `FKlj8wq4m5kwxbjeud0p2wv4but` (`screen_id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `show_info`
--

INSERT INTO `show_info` (`show_id`, `created_at`, `show_end_time`, `show_start_time`, `status`, `updated_at`, `movie_id`, `screen_id`) VALUES
(1, '2021-08-12 00:00:00', '2021-08-13 13:00:00', '2021-08-13 10:00:00', 'A', '2021-08-12 00:00:00', 1, 1),
(2, '2021-08-12 00:00:00', '2021-08-13 13:00:00', '2021-08-13 10:00:00', 'A', '2021-08-12 00:00:00', 2, 2),
(3, '2021-08-13 00:00:00', '2021-08-13 18:00:00', '2021-08-13 15:00:00', 'A', '2021-08-13 00:00:00', 1, 1),
(4, '2021-08-13 00:00:00', '2021-08-13 18:00:00', '2021-08-13 15:00:00', 'A', '2021-08-13 00:00:00', 2, 2),
(5, '2021-08-12 00:00:00', '2021-08-13 13:00:00', '2021-08-13 10:00:00', 'A', '2021-08-12 00:00:00', 1, 9),
(6, '2021-08-12 00:00:00', '2021-08-13 13:00:00', '2021-08-13 10:00:00', 'A', '2021-08-12 00:00:00', 3, 10),
(7, '2021-08-13 00:00:00', '2021-08-13 18:00:00', '2021-08-13 15:00:00', 'A', '2021-08-13 00:00:00', 1, 9),
(8, '2021-08-13 00:00:00', '2021-08-13 18:00:00', '2021-08-13 15:00:00', 'A', '2021-08-13 00:00:00', 3, 10),
(9, '2021-08-12 00:00:00', '2021-08-13 13:00:00', '2021-08-13 10:00:00', 'A', '2021-08-12 00:00:00', 2, 11),
(10, '2021-08-12 00:00:00', '2021-08-13 13:00:00', '2021-08-13 10:00:00', 'A', '2021-08-12 00:00:00', 3, 12),
(11, '2021-08-13 00:00:00', '2021-08-13 18:00:00', '2021-08-13 15:00:00', 'A', '2021-08-13 00:00:00', 2, 11),
(12, '2021-08-13 00:00:00', '2021-08-13 18:00:00', '2021-08-13 15:00:00', 'A', '2021-08-13 00:00:00', 3, 12),
(13, '2021-08-12 00:00:00', '2021-08-13 13:00:00', '2021-08-13 10:00:00', 'A', '2021-08-12 00:00:00', 1, 3),
(14, '2021-08-12 00:00:00', '2021-08-13 13:00:00', '2021-08-13 10:00:00', 'A', '2021-08-12 00:00:00', 2, 4),
(15, '2021-08-12 00:00:00', '2021-08-13 13:00:00', '2021-08-13 10:00:00', 'A', '2021-08-12 00:00:00', 3, 5),
(16, '2021-08-13 00:00:00', '2021-08-13 18:00:00', '2021-08-13 15:00:00', 'A', '2021-08-13 00:00:00', 1, 3),
(17, '2021-08-13 00:00:00', '2021-08-13 18:00:00', '2021-08-13 15:00:00', 'A', '2021-08-13 00:00:00', 2, 4),
(18, '2021-08-12 00:00:00', '2021-08-13 13:00:00', '2021-08-13 10:00:00', 'A', '2021-08-12 00:00:00', 3, 5),
(19, '2021-08-12 00:00:00', '2021-08-13 13:00:00', '2021-08-13 10:00:00', 'A', '2021-08-12 00:00:00', 1, 6),
(20, '2021-08-12 00:00:00', '2021-08-13 13:00:00', '2021-08-13 10:00:00', 'A', '2021-08-12 00:00:00', 2, 7),
(21, '2021-08-12 00:00:00', '2021-08-13 13:00:00', '2021-08-13 10:00:00', 'A', '2021-08-12 00:00:00', 3, 8),
(22, '2021-08-13 00:00:00', '2021-08-13 18:00:00', '2021-08-13 15:00:00', 'A', '2021-08-13 00:00:00', 1, 6),
(23, '2021-08-13 00:00:00', '2021-08-13 18:00:00', '2021-08-13 15:00:00', 'A', '2021-08-13 00:00:00', 2, 7),
(24, '2021-08-12 00:00:00', '2021-08-13 13:00:00', '2021-08-13 10:00:00', 'A', '2021-08-12 00:00:00', 3, 8);

-- --------------------------------------------------------

--
-- Table structure for table `theatre_info`
--

DROP TABLE IF EXISTS `theatre_info`;
CREATE TABLE IF NOT EXISTS `theatre_info` (
  `created_at` datetime DEFAULT NULL,
  `theatre_name` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `theatre_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`theatre_id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `theatre_info`
--

INSERT INTO `theatre_info` (`theatre_id`, `created_at`, `status`, `location`, `theatre_name`, `updated_at`) VALUES
(1, '2021-08-13 00:00:00', 'A', 'Chennai', 'AGS Cinemas', '2021-08-13 00:00:00'),
(2, '2021-08-13 00:00:00', 'A', 'Chennai', 'INOX National', '2021-08-13 00:00:00'),
(3, '2021-08-13 00:00:00', 'A', 'Chennai', 'Rohini Silver Screens', '2021-08-13 00:00:00'),
(4, '2021-08-13 00:00:00', 'A', 'Chennai', 'Luxe Cinemas', '2021-08-13 00:00:00'),
(5, '2021-08-13 00:00:00', 'A', 'Chennai', 'Mayajaal Multiplex', '2021-08-13 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
CREATE TABLE IF NOT EXISTS `user_info` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `email_id` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_role` varchar(255) DEFAULT NULL,
  `user_status` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UKtnbxlxth3tfv935ptm61ki8q9` (`email_id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_info`
--

INSERT INTO `user_info` (`user_id`, `created_at`, `email_id`, `first_name`, `last_name`, `password`, `phone_number`, `updated_at`, `user_role`, `user_status`) VALUES
(2, '2021-08-13 18:24:33', 'testuser@yopmail.com', 'Test User', '1', '$2a$12$v8dn/MRGO6akR44pImyNp.kWt5A48lWlQJNnt.QCGI7YOqK2qPV72', '9791081330', '2021-08-13 18:24:33', NULL, 'A');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
