/*
 Navicat Premium Data Transfer

 Source Server         : mysql80
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : localhost:3306
 Source Schema         : springcloud_movie_cinema

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 25/06/2023 22:36:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for movie_cinema
-- ----------------------------
DROP TABLE IF EXISTS `movie_cinema`;
CREATE TABLE `movie_cinema` (
  `mc_movie_id` int DEFAULT NULL COMMENT '电影外键',
  `mc_cinema_id` int DEFAULT NULL COMMENT '影院外键'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of movie_cinema
-- ----------------------------
BEGIN;
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (1, 1);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (1, 2);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (1, 3);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (2, 3);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (2, 4);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (2, 5);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (3, 6);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (3, 7);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (4, 8);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (4, 9);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (4, 10);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (5, 11);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (5, 12);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (6, 13);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (6, 14);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (6, 15);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (7, 16);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (7, 17);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (8, 18);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (8, 19);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (9, 20);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (9, 1);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (10, 2);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (10, 3);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (11, 4);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (11, 5);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (12, 6);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (12, 7);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (12, 8);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (13, 9);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (13, 10);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (14, 11);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (14, 12);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (15, 13);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (15, 14);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (16, 15);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (16, 16);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (17, 17);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (17, 18);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (18, 19);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (18, 20);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (19, 1);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (19, 2);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (20, 3);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`) VALUES (20, 4);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
