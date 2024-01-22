CREATE DATABASE  IF NOT EXISTS `cuoiky1` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `cuoiky1`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: cuoiky1
-- ------------------------------------------------------
-- Server version	8.2.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `qlsach`
--

DROP TABLE IF EXISTS `qlsach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qlsach` (
  `MaSach` varchar(45) NOT NULL,
  `TenSach` varchar(45) NOT NULL,
  `TenTacGia` varchar(45) NOT NULL,
  `NgayXuatBan` date NOT NULL,
  `SoLuong` int NOT NULL,
  `GiaTien` double NOT NULL,
  `ID` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qlsach`
--

LOCK TABLES `qlsach` WRITE;
/*!40000 ALTER TABLE `qlsach` DISABLE KEYS */;
INSERT INTO `qlsach` VALUES ('TV1','Bin','Trieu','2005-07-30',20,2300,1),('AOV2','Thánh','AOV','2005-07-30',6,3000,2),('AOV3','Phép','AOV','2005-07-30',30,300,3),('TTTQ1','Trạng Quỷnh','Kim Khánh','2003-06-17',1000,10,4),('TTDRM','Doraemon','Fujiko Fujio','1969-12-25',370,25,5),('TTBVNR','Bảy Viên Ngọc Rồng ','Toriyama Akira','1984-08-25',250,30,6),('TTCN','Thám Tử Lừng Danh Connan','Aoyama Gōshō','1994-07-30',30,1000,7);
/*!40000 ALTER TABLE `qlsach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qlthemuon`
--

DROP TABLE IF EXISTS `qlthemuon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qlthemuon` (
  `MaThe` int NOT NULL AUTO_INCREMENT,
  `TenNguoiMuon` varchar(45) NOT NULL,
  `SoSachDaMuon` int NOT NULL,
  `SoSachDaTra` int NOT NULL,
  `GioiTinh` int NOT NULL,
  `NgaySinh` date NOT NULL,
  PRIMARY KEY (`MaThe`)
) ENGINE=InnoDB AUTO_INCREMENT=1013 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qlthemuon`
--

LOCK TABLES `qlthemuon` WRITE;
/*!40000 ALTER TABLE `qlthemuon` DISABLE KEYS */;
INSERT INTO `qlthemuon` VALUES (4,'Thoa',5,9,0,'2024-01-02'),(1002,'Bin',13,8,1,'2005-07-30');
/*!40000 ALTER TABLE `qlthemuon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tai_khoan`
--

DROP TABLE IF EXISTS `tai_khoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tai_khoan` (
  `ma_tai_khoan` int NOT NULL AUTO_INCREMENT,
  `ten_dang_nhap` varchar(255) NOT NULL,
  `mat_khau` varchar(255) NOT NULL,
  `tinh_trang` int NOT NULL,
  `mail` varchar(45) NOT NULL,
  PRIMARY KEY (`ma_tai_khoan`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tai_khoan`
--

LOCK TABLES `tai_khoan` WRITE;
/*!40000 ALTER TABLE `tai_khoan` DISABLE KEYS */;
INSERT INTO `tai_khoan` VALUES (1,'admin','1234',1,'phamnhuquoctrieu307@gmail.com'),(2,'bin','kimthoa',0,'trieupnq.23itb@vku.udn.vn'),(3,'trieu','quoctrieu',1,'1'),(4,'bin123','121212',1,'1'),(5,'quocbin123','phamnhuquocbin',1,'s');
/*!40000 ALTER TABLE `tai_khoan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tai_khoan1`
--

DROP TABLE IF EXISTS `tai_khoan1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tai_khoan1` (
  `Ten_dang_nhap` varchar(45) NOT NULL,
  `Mat_khau` varchar(45) NOT NULL,
  `Tinh_Trang` int NOT NULL,
  PRIMARY KEY (`Ten_dang_nhap`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tai_khoan1`
--

LOCK TABLES `tai_khoan1` WRITE;
/*!40000 ALTER TABLE `tai_khoan1` DISABLE KEYS */;
INSERT INTO `tai_khoan1` VALUES ('admin','1234',1),('bin','thoa',0),('bina','1',1),('thoa','bin',1),('trieu','bin',1);
/*!40000 ALTER TABLE `tai_khoan1` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-22 11:44:21
