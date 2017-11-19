-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 19, 2017 at 12:08 PM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ark_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `reg_users`
--

CREATE TABLE IF NOT EXISTS `reg_users` (
`id` int(20) NOT NULL,
  `username` varchar(70) NOT NULL,
  `password` varchar(40) NOT NULL,
  `email` varchar(50) NOT NULL,
  `mobile` int(15) DEFAULT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT NULL,
  `PRFD_LOC` text
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reg_users`
--

INSERT INTO `reg_users` (`id`, `username`, `password`, `email`, `mobile`, `created_at`, `updated_at`, `PRFD_LOC`) VALUES
(3, 'saas', 'asdsad', 'dd@gg.com', 98989898, '0000-00-00 00:00:00', NULL, ''),
(21, 'sdsds', 'ssdsds', 's@f.c', 1, '0000-00-00 00:00:00', NULL, ''),
(22, 'anand', 'anand', 'anand@gm.com', 0, '2017-11-19 12:21:25', NULL, NULL),
(23, 'anand', 'anand', 'anand@a.com', 0, '2017-11-19 12:21:54', NULL, NULL),
(24, 'kiran', 'kirana', 'ki@d.c', 23456, '2017-11-19 12:48:26', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `USER_NAME` char(30) DEFAULT NULL,
  `PASSWORD` char(30) DEFAULT NULL,
  `USER_TYPE` char(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `reg_users`
--
ALTER TABLE `reg_users`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `reg_users`
--
ALTER TABLE `reg_users`
MODIFY `id` int(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=25;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
