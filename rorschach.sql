/*
 Navicat Premium Data Transfer

 Source Server         : zcyi
 Source Server Type    : MySQL
 Source Server Version : 50735
 Source Host           : localhost:3306
 Source Schema         : rorschach

 Target Server Type    : MySQL
 Target Server Version : 50735
 File Encoding         : 65001

 Date: 03/10/2022 22:40:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '/img/defaultAvatar.jpg',
  `user_token` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_create_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_slogan` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '未添加Slogan',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'zaoyiii@outlook.com', 'zaoyi...', '/img/defaultAvatar.jpg', 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyTmFtZSI6Inphb3lpaWlAb3V0bG9vay5jb20iLCJleHAiOjE2NjYwODY2MjgsInVzZXJJZCI6IjEifQ.si02gE3jJlKGn_eJF2P5JvGMkT7fsqJc2tNOHPXWvi4', 'zaoyiii@outlook.com', '10086', '2022-10-03 16:16:33', '未添加Slogan');
INSERT INTO `t_user` VALUES (2, 'rorschach@outlook.com', 'rorschach...', '/img/defaultAvatar.jpg', NULL, 'rorschach@outlook.com', '10010', '2022-10-03 16:16:33', '未添加Slogan');

SET FOREIGN_KEY_CHECKS = 1;
