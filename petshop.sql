/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50556
 Source Host           : localhost:3306
 Source Schema         : petshop

 Target Server Type    : MySQL
 Target Server Version : 50556
 File Encoding         : 65001

 Date: 22/07/2021 18:52:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_petshop
-- ----------------------------
DROP TABLE IF EXISTS `tb_petshop`;
CREATE TABLE `tb_petshop`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `price` int(11) NULL DEFAULT NULL,
  `weight` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_petshop
-- ----------------------------
INSERT INTO `tb_petshop` VALUES (1, '雪糕', '母', '猫', 1, 800, 4);
INSERT INTO `tb_petshop` VALUES (2, '霸王龙', '公', '恐龙', 88, 99, 55);
INSERT INTO `tb_petshop` VALUES (3, '剑齿虎', '公', '老虎', 56, 89, 49);
INSERT INTO `tb_petshop` VALUES (4, '泽塔', '男', '奥特曼', 5000, 1, 878);
INSERT INTO `tb_petshop` VALUES (5, '特利迦', '男', '奥特曼', 400, 489, 562);

-- ----------------------------
-- Table structure for tb_username
-- ----------------------------
DROP TABLE IF EXISTS `tb_username`;
CREATE TABLE `tb_username`  (
  `pet_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`pet_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_username
-- ----------------------------
INSERT INTO `tb_username` VALUES (1, '雪糕', '123456');

SET FOREIGN_KEY_CHECKS = 1;
