/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50615
Source Host           : localhost:3306
Source Database       : aksiologisi

Target Server Type    : MYSQL
Target Server Version : 50615
File Encoding         : 65001

Date: 2014-01-22 19:26:31
*/

SET FOREIGN_KEY_CHECKS=0;
--Create database aksiologisi;
-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `username` varchar(20) DEFAULT NULL,
  `password` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('admin', '1111');
INSERT INTO `login` VALUES ('ioulia', '1234567');
INSERT INTO `login` VALUES ('maria', '1234');
INSERT INTO `login` VALUES ('eleni ', '1991');

-- ----------------------------
-- Table structure for products
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `proionta` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `energy` int(255) DEFAULT NULL,
  `service` int(11) DEFAULT NULL,
  `aksiopistia` int(255) DEFAULT NULL,
  `help` int(255) DEFAULT NULL,
  `vathmologia` int(255) DEFAULT NULL,
  `sxolia` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of products
-- ----------------------------
INSERT INTO `products` VALUES ('Τροφοδοτικό Xilence Eco 550W', '3', '3', '4', '3', '5', '3', 'poly kales epidoseis');
INSERT INTO `products` VALUES ('Ψύκτρα Akasa CPU LGA 1366', '1', '1', '1', '1', '1', '1', '');
INSERT INTO `products` VALUES ('Ψύκτρα Intel Socket 478 Celeron &Pentium 4', '1', '1', '1', '1', '1', '1', null);
INSERT INTO `products` VALUES ('Front Panel 3.5\" 4θύρες USB3.0', '1', '2', '1', '1', '1', '1', '');
INSERT INTO `products` VALUES ('Front Panel 3 θύρες usb', null, null, null, null, null, null, null);
