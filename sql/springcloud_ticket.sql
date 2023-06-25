/*
 Navicat Premium Data Transfer

 Source Server         : mysql80
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : localhost:3306
 Source Schema         : springcloud_ticket

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 25/06/2023 22:36:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ticket
-- ----------------------------
DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket` (
  `t_id` int NOT NULL AUTO_INCREMENT COMMENT '电影票主键',
  `t_movie` int DEFAULT NULL COMMENT '电影外键（getName）',
  `t_cinema` int DEFAULT NULL COMMENT '电影院外键（getName）',
  `t_date` date DEFAULT NULL COMMENT '购买时间',
  `t_user` int DEFAULT NULL COMMENT '购买者外键（getName）',
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of ticket
-- ----------------------------
BEGIN;
INSERT INTO `ticket` (`t_id`, `t_movie`, `t_cinema`, `t_date`, `t_user`) VALUES (1, 5, 11, '2023-04-19', 2);
INSERT INTO `ticket` (`t_id`, `t_movie`, `t_cinema`, `t_date`, `t_user`) VALUES (2, 11, 5, '2023-04-18', 12);
INSERT INTO `ticket` (`t_id`, `t_movie`, `t_cinema`, `t_date`, `t_user`) VALUES (3, 13, 10, '2023-04-17', 6);
INSERT INTO `ticket` (`t_id`, `t_movie`, `t_cinema`, `t_date`, `t_user`) VALUES (4, 2, 3, '2023-04-16', 20);
INSERT INTO `ticket` (`t_id`, `t_movie`, `t_cinema`, `t_date`, `t_user`) VALUES (5, 8, 19, '2023-04-15', 14);
INSERT INTO `ticket` (`t_id`, `t_movie`, `t_cinema`, `t_date`, `t_user`) VALUES (6, 19, 1, '2023-04-14', 1);
INSERT INTO `ticket` (`t_id`, `t_movie`, `t_cinema`, `t_date`, `t_user`) VALUES (7, 1, 3, '2023-04-13', 9);
INSERT INTO `ticket` (`t_id`, `t_movie`, `t_cinema`, `t_date`, `t_user`) VALUES (8, 20, 4, '2023-04-12', 3);
INSERT INTO `ticket` (`t_id`, `t_movie`, `t_cinema`, `t_date`, `t_user`) VALUES (9, 7, 17, '2023-04-11', 17);
INSERT INTO `ticket` (`t_id`, `t_movie`, `t_cinema`, `t_date`, `t_user`) VALUES (10, 16, 15, '2023-04-10', 5);
INSERT INTO `ticket` (`t_id`, `t_movie`, `t_cinema`, `t_date`, `t_user`) VALUES (11, 6, 15, '2023-04-18', 4);
INSERT INTO `ticket` (`t_id`, `t_movie`, `t_cinema`, `t_date`, `t_user`) VALUES (12, 15, 13, '2023-04-03', 8);
INSERT INTO `ticket` (`t_id`, `t_movie`, `t_cinema`, `t_date`, `t_user`) VALUES (13, 6, 13, '2023-04-23', 3);
INSERT INTO `ticket` (`t_id`, `t_movie`, `t_cinema`, `t_date`, `t_user`) VALUES (14, 2, 5, '2023-04-16', 7);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
