-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 10, 2026 at 06:18 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `university`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `EmployeesDesignation` (IN `p_designation` VARCHAR(50))   BEGIN
    SELECT * FROM emp
    WHERE designation = p_designation;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GetDesignation` (IN `p_id` INT, OUT `p_designation` VARCHAR(50))   BEGIN
    SELECT designation
    INTO p_designation
    FROM emp
    WHERE e_id = p_id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertEmployee` ()   BEGIN
    INSERT INTO emp
    VALUES (5,'Rahul',45000,'Ahmedabad','Developer','IT');
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertEmployee2` (IN `p_id` INT, IN `p_name` VARCHAR(50), IN `p_salary` DOUBLE, IN `p_city` VARCHAR(50), IN `p_designation` VARCHAR(50), IN `p_department` VARCHAR(50))   BEGIN
    INSERT INTO emp(e_id, e_name, e_salary, e_city, designation, department)
    VALUES(p_id, p_name, p_salary, p_city, p_designation, p_department);
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `emp`
--

CREATE TABLE `emp` (
  `e_id` int(11) NOT NULL,
  `e_name` varchar(20) NOT NULL,
  `e_salary` int(11) NOT NULL,
  `e_city` varchar(20) NOT NULL,
  `designation` varchar(50) DEFAULT NULL,
  `department` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `emp`
--

INSERT INTO `emp` (`e_id`, `e_name`, `e_salary`, `e_city`, `designation`, `department`) VALUES
(1, 'aaa', 343434, 'amr', 'Manager', 'HR'),
(2, 'bbb', 43434, 'amd', 'Clerk', 'Accounts'),
(3, 'ccc', 34343, 'rj', 'Developer', 'IT'),
(4, 'ABC', 33434, 'st', 'Manager', 'Management'),
(5, 'Rahul', 45000, 'Ahmedabad', 'Developer', 'IT'),
(89, 'Jojo', 786, 'hoko', 'fresh', 'chai-pati');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `pid` int(11) NOT NULL,
  `productname` varchar(30) NOT NULL,
  `price` int(11) NOT NULL,
  `quality` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`pid`, `productname`, `price`, `quality`) VALUES
(2, 'pop', 78, 'we');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `s_id` int(11) NOT NULL,
  `s_name` varchar(20) NOT NULL,
  `s_roll` int(11) NOT NULL,
  `s_address` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`s_id`, `s_name`, `s_roll`, `s_address`) VALUES
(2, 'kalyo', 1001, 'JMG');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `emp`
--
ALTER TABLE `emp`
  ADD PRIMARY KEY (`e_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`pid`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`s_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `emp`
--
ALTER TABLE `emp`
  MODIFY `e_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=90;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `pid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `s_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
