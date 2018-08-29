/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-08-16 16:45:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dish
-- ----------------------------
DROP TABLE IF EXISTS `dish`;
CREATE TABLE `dish` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `TXT` varchar(255) DEFAULT NULL,
  `IMG` varchar(255) DEFAULT NULL,
  `ISRECOMMENDED` char(1) DEFAULT NULL,
  `PRICE` double DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dish
-- ----------------------------
INSERT INTO `dish` VALUES ('1', '菲力牛排', '菲力牛排', '嫩牛肉，好吃', '../imgs/img_1.jpg', '是', '67.5');
INSERT INTO `dish` VALUES ('2', '霍香鲫鱼', '藿香配鲫鱼', '藿香的香和鲫鱼的嫩，好吃的不得了', '../imgs/img_2.jpg', '否', '53.5');
INSERT INTO `dish` VALUES ('4', '拔丝牛柳', '拔丝牛柳', '牛柳，好吃', '../imgs/img_3.jpg', '是', '87.5');
INSERT INTO `dish` VALUES ('5', '拔丝煎饼', '拔丝煎饼', '好吃', '../imgs/img_3.jpg', '是', '78.98');
INSERT INTO `dish` VALUES ('10', '菲力牛排', '菲力牛排', '嫩牛肉，好吃', '../imgs/img_1.jpg', '是', '67.5');
INSERT INTO `dish` VALUES ('11', '霍香鲫鱼', '藿香配鲫鱼', '藿香的香和鲫鱼的嫩，好吃的不得了', '../imgs/img_2.jpg', '否', '53.5');
INSERT INTO `dish` VALUES ('12', '拔丝牛柳', '拔丝牛柳', '牛柳，好吃', '../imgs/img_3.jpg', '是', '87.5');
INSERT INTO `dish` VALUES ('13', '拔丝煎饼', '拔丝煎饼', '好吃', '../imgs/img_3.jpg', '是', '78.98');
INSERT INTO `dish` VALUES ('18', '菲力牛排', '菲力牛排', '嫩牛肉，好吃', '../imgs/img_1.jpg', '是', '67.5');
INSERT INTO `dish` VALUES ('19', '霍香鲫鱼', '藿香配鲫鱼', '藿香的香和鲫鱼的嫩，好吃的不得了', '../imgs/img_2.jpg', '否', '53.5');
INSERT INTO `dish` VALUES ('20', '拔丝牛柳', '拔丝牛柳', '牛柳，好吃', '../imgs/img_3.jpg', '是', '87.5');
INSERT INTO `dish` VALUES ('21', '拔丝煎饼', '拔丝煎饼', '好吃', '../imgs/img_3.jpg', '是', '78.98');
INSERT INTO `dish` VALUES ('22', '红烧排骨', '红烧排骨', '红烧排骨', '../imgs/img_6.jpg', '是', '65');
INSERT INTO `dish` VALUES ('23', '回锅肉', '回锅肉', '回锅肉', '../imgs/img_5.jpg', '是', '34');
INSERT INTO `dish` VALUES ('24', '肝腰合炒', '肝腰合炒', '肝腰合炒', '../imgs/img_6.jpg', '否', '45.5');

-- ----------------------------
-- Table structure for ordercontent
-- ----------------------------
DROP TABLE IF EXISTS `ordercontent`;
CREATE TABLE `ordercontent` (
  `ID` int(11) NOT NULL,
  `dishid` int(11) DEFAULT NULL,
  `DISHNUMBER` int(11) DEFAULT NULL,
  `orderid` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK94AA616B6A04080F` (`dishid`),
  KEY `FK94AA616B2B8769F7` (`orderid`),
  CONSTRAINT `FK94AA616B2B8769F7` FOREIGN KEY (`orderid`) REFERENCES `orders` (`ID`),
  CONSTRAINT `FK94AA616B6A04080F` FOREIGN KEY (`dishid`) REFERENCES `dish` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ordercontent
-- ----------------------------

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `ID` int(11) NOT NULL,
  `BEGINTIME` datetime DEFAULT NULL,
  `ENDTIME` datetime DEFAULT NULL,
  `stateid` int(11) DEFAULT NULL,
  `WAITERID` int(11) DEFAULT NULL,
  `TABLEID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK8B7256E527FBCD8F` (`stateid`),
  CONSTRAINT `FK8B7256E527FBCD8F` FOREIGN KEY (`stateid`) REFERENCES `orderstate` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------

-- ----------------------------
-- Table structure for orderstate
-- ----------------------------
DROP TABLE IF EXISTS `orderstate`;
CREATE TABLE `orderstate` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderstate
-- ----------------------------
INSERT INTO `orderstate` VALUES ('1', '传菜');
INSERT INTO `orderstate` VALUES ('2', '取消');
INSERT INTO `orderstate` VALUES ('3', '烹饪');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `score` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 'lili', '21', '343');
INSERT INTO `student` VALUES ('2', 'nana', '21', '23');
INSERT INTO `student` VALUES ('3', 'feifei', '20', '34');
INSERT INTO `student` VALUES ('4', 'lili', '21', '343');
INSERT INTO `student` VALUES ('5', 'nana', '21', '23');
INSERT INTO `student` VALUES ('6', 'feifei', '20', '34');
INSERT INTO `student` VALUES ('7', 'lili', '21', '343');
INSERT INTO `student` VALUES ('8', 'nana', '21', '23');
INSERT INTO `student` VALUES ('9', 'feifei', '20', '34');
INSERT INTO `student` VALUES ('10', 'lili', '21', '343');
INSERT INTO `student` VALUES ('11', 'nana', '21', '23');
INSERT INTO `student` VALUES ('12', 'feifei', '20', '34');
INSERT INTO `student` VALUES ('14', 'lili', '21', '343');
INSERT INTO `student` VALUES ('15', 'nana', '21', '23');
INSERT INTO `student` VALUES ('16', 'feifei', '20', '34');
INSERT INTO `student` VALUES ('46', 'nana', '21', '23');
INSERT INTO `student` VALUES ('62', 'lili', '21', '343');
INSERT INTO `student` VALUES ('67', 'feifei', '20', '34');

-- ----------------------------
-- Table structure for tables
-- ----------------------------
DROP TABLE IF EXISTS `tables`;
CREATE TABLE `tables` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ISFREE` char(1) DEFAULT NULL,
  `SIZE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tables
-- ----------------------------
INSERT INTO `tables` VALUES ('1', '是', '10');
INSERT INTO `tables` VALUES ('2', '是', '8');
INSERT INTO `tables` VALUES ('3', '是', '10');
INSERT INTO `tables` VALUES ('4', '是', '2');
INSERT INTO `tables` VALUES ('5', '是', '8');
INSERT INTO `tables` VALUES ('6', '是', '10');
INSERT INTO `tables` VALUES ('7', '是', '10');
INSERT INTO `tables` VALUES ('8', '是', '4');
INSERT INTO `tables` VALUES ('9', '是', '10');
INSERT INTO `tables` VALUES ('10', '是', '10');
INSERT INTO `tables` VALUES ('11', '是', '10');
INSERT INTO `tables` VALUES ('12', '是', '8');
INSERT INTO `tables` VALUES ('13', '是', '10');
INSERT INTO `tables` VALUES ('14', '是', '2');
INSERT INTO `tables` VALUES ('15', '是', '8');
INSERT INTO `tables` VALUES ('16', '是', '10');
INSERT INTO `tables` VALUES ('17', '是', '10');
INSERT INTO `tables` VALUES ('18', '是', '4');
INSERT INTO `tables` VALUES ('19', '是', '10');
INSERT INTO `tables` VALUES ('20', '是', '10');
INSERT INTO `tables` VALUES ('21', '是', '10');
INSERT INTO `tables` VALUES ('22', '是', '8');
INSERT INTO `tables` VALUES ('23', '是', '10');
INSERT INTO `tables` VALUES ('24', '是', '2');
INSERT INTO `tables` VALUES ('25', '是', '8');
INSERT INTO `tables` VALUES ('26', '是', '10');
INSERT INTO `tables` VALUES ('27', '是', '10');
INSERT INTO `tables` VALUES ('28', '是', '4');
INSERT INTO `tables` VALUES ('29', '是', '10');
INSERT INTO `tables` VALUES ('31', '是', '10');

-- ----------------------------
-- Table structure for userposition
-- ----------------------------
DROP TABLE IF EXISTS `userposition`;
CREATE TABLE `userposition` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userposition
-- ----------------------------
INSERT INTO `userposition` VALUES ('1', '经理');
INSERT INTO `userposition` VALUES ('2', '服务员');
INSERT INTO `userposition` VALUES ('3', '后厨');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ACCOUNT` varchar(255) DEFAULT NULL,
  `PWD` varchar(255) DEFAULT NULL,
  `FACEIMG` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `SEX` char(1) DEFAULT NULL,
  `PHONENUMBER` varchar(255) DEFAULT NULL,
  `ADDRESS` varchar(255) DEFAULT NULL,
  `POSITION_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK4D495E88437542F` (`POSITION_ID`),
  CONSTRAINT `FK4D495E88437542F` FOREIGN KEY (`POSITION_ID`) REFERENCES `userposition` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'admin', '123456', '../imgs/logo.png', '空空', '女', '12345678', '成都市', '1');
INSERT INTO `users` VALUES ('2', 'waiter', '123456', '/images/1.jpg', '飞飞', '男', '234234324', '成都市', '2');
INSERT INTO `users` VALUES ('3', 'kitchen', '123456', '/images/1.jpg', '飞飞', '男', '234234324', '成都市', '3');
INSERT INTO `users` VALUES ('4', 'lili', '123456', '../imgs/鹊桥.jpg', '丽丽', '女', '12345678', '成都市', '2');
INSERT INTO `users` VALUES ('5', 'feifei', '123456', '../imgs/chat.jpg', '菲菲', '女', '12345678', '成都市', '2');
INSERT INTO `users` VALUES ('6', 'nana', '123456', '../imgs/logo2.jpg', '娜娜', '女', '12345678', '成都市', '3');
INSERT INTO `users` VALUES ('7', 'zhangsan', '123456', '../imgs/phone.png', '张三', '男', '12345678', '成都市', '3');

-- ----------------------------
-- Table structure for vipcustomer
-- ----------------------------
DROP TABLE IF EXISTS `vipcustomer`;
CREATE TABLE `vipcustomer` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  `SEX` char(1) DEFAULT NULL,
  `PHONENUMBER` varchar(255) DEFAULT NULL,
  `DINNINGTIMES` int(11) DEFAULT NULL,
  `DINNINGSUM` double DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vipcustomer
-- ----------------------------
INSERT INTO `vipcustomer` VALUES ('1', '张三', '男', '12312341231', '1', '1');
INSERT INTO `vipcustomer` VALUES ('2', '王五', '女', '12312341231', '2', '2');
INSERT INTO `vipcustomer` VALUES ('4', '赵六', '男', '234234234234', '2', '2');
