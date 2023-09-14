/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.196.41
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : 192.168.196.41:3306
 Source Schema         : myaccount

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 14/09/2023 10:12:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ALL_BILL
-- ----------------------------
DROP TABLE IF EXISTS `ALL_BILL`;
CREATE TABLE `ALL_BILL`  (
  `ID` int NOT NULL AUTO_INCREMENT,
  `TIME` datetime NULL DEFAULT NULL,
  `REVENUE` decimal(65, 2) NULL DEFAULT NULL,
  `USE_TO` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `NOTES` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `IS_DELETE` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ALL_BILL
-- ----------------------------
INSERT INTO `ALL_BILL` VALUES (1, '2023-09-14 10:06:22', 1.00, '1', '1', NULL);
INSERT INTO `ALL_BILL` VALUES (2, '2023-09-14 02:08:09', -0.10, '1', '1', NULL);
INSERT INTO `ALL_BILL` VALUES (3, '2023-09-14 02:08:31', -0.10, '1', '1', NULL);

SET FOREIGN_KEY_CHECKS = 1;
