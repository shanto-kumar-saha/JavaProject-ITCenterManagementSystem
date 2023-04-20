-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 28, 2019 at 07:50 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `it training management system`
--

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `courseId` varchar(8) NOT NULL,
  `courseName` varchar(30) NOT NULL,
  `courseFee` double(8,2) NOT NULL,
  `duration` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`courseId`, `courseName`, `courseFee`, `duration`) VALUES
('c01', 'Graphic Design ', 12000.00, '3 months'),
('c02', 'SEO', 10000.00, '4 months'),
('c03', 'CPA Marketing', 10000.00, '3 months'),
('c04', 'Apps Devlopment', 10000.00, '4 months'),
('c05', 'Web Design', 10000.00, '3 months');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `empId` varchar(8) NOT NULL,
  `name` varchar(30) NOT NULL,
  `designation` varchar(30) NOT NULL,
  `salary` double(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`empId`, `name`, `designation`, `salary`) VALUES
('e01', 'khairul Alam', 'Manager', 40000.00),
('e02', 'Prokrity ', 'Trainer', 15000.00),
('e03', 'Roza Mia', 'Trainer', 15000.00),
('e04', 'Krisna Ahmed', 'Trainer', 12000.00),
('e05', 'Saron Ahmed', 'Clerk', 5000.00);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `userId` varchar(8) NOT NULL,
  `password` varchar(20) NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`userId`, `password`, `status`) VALUES
('e01', 'e01', 0),
('e02', 'e02', 1),
('s01', 's01', 2),
('s02', 's02', 2),
('e03', 'e03', 1);

-- --------------------------------------------------------

--
-- Table structure for table `purchase`
--

CREATE TABLE `purchase` (
  `purchaseId` varchar(8) NOT NULL,
  `courseId` varchar(4) NOT NULL,
  `studentId` varchar(8) NOT NULL,
  `studentName` varchar(30) NOT NULL,
  `amount` double(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchase`
--

INSERT INTO `purchase` (`purchaseId`, `courseId`, `studentId`, `studentName`, `amount`) VALUES
('p01', 'c03', 's01', 'Mitila Alam', 10000.00),
('p02', 'c02', 's02', 'Mahajabin Chowdhury', 10000.00),
('p03', 'c05', 's03', 'Jafia Hossain', 10000.00),
('p04', 'c03', 's04', 'Maria Ahmed', 10000.00),
('p05', 'c04', 's05', 'Lalin', 10000.00);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `studentId` varchar(8) NOT NULL,
  `studentName` varchar(30) NOT NULL,
  `courseName` varchar(30) NOT NULL,
  `courseId` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`studentId`, `studentName`, `courseName`, `courseId`) VALUES
('s01', 'Mitila Alam', 'CPA Marketing', 'c03'),
('s02', 'Mahajabin Chowdhury', 'SEO', 'c02'),
('s03', 'Jafia Hossain', 'Web Design', 'c05'),
('s04', 'Maria Ahmed', 'CPA Marketing', 'c03'),
('s05', 'Lalin ', 'Apps Development', 'c04');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
