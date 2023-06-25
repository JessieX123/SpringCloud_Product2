/*
 Navicat Premium Data Transfer

 Source Server         : mysql80
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : localhost:3306
 Source Schema         : springcloud_movie

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 25/06/2023 22:35:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for movie
-- ----------------------------
DROP TABLE IF EXISTS `movie`;
CREATE TABLE `movie` (
  `m_id` int NOT NULL COMMENT '电影主键',
  `m_name` varchar(50) DEFAULT NULL COMMENT '电影名',
  `m_date` date DEFAULT NULL COMMENT '上映日期',
  `m_country` varchar(50) DEFAULT NULL COMMENT '上映国家',
  PRIMARY KEY (`m_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of movie
-- ----------------------------
BEGIN;
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`) VALUES (1, '追梦高手', '2022-05-01', '中国');
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`) VALUES (2, '暴走玩家', '2023-01-15', '美国');
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`) VALUES (3, '无人生还', '2022-07-22', '英国');
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`) VALUES (4, '幸福咖啡馆', '2022-09-09', '韩国');
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`) VALUES (5, '神秘花园', '2023-02-18', '法国');
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`) VALUES (6, '魔法小精灵', '2022-11-11', '日本');
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`) VALUES (7, '旅行者', '2023-04-05', '德国');
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`) VALUES (8, '银河守卫队', '2022-08-28', '美国');
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`) VALUES (9, '古墓寻宝', '2023-05-20', '加拿大');
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`) VALUES (10, '超凡蜘蛛侠', '2022-12-25', '美国');
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`) VALUES (11, '森林之王', '2023-03-08', '俄罗斯');
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`) VALUES (12, '时光倒流机', '2022-10-13', '英国');
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`) VALUES (13, '太空冒险家', '2022-06-06', '美国');
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`) VALUES (14, '外星人入侵', '2023-01-01', '日本');
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`) VALUES (15, '红楼梦之梦', '2023-04-28', '中国');
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`) VALUES (16, '缤纷童话屋', '2022-08-08', '法国');
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`) VALUES (17, '快乐小熊维尼', '2022-09-22', '美国');
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`) VALUES (18, '魔法城堡', '2023-02-14', '英国');
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`) VALUES (19, '飞天战机', '2022-07-30', '日本');
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`) VALUES (20, '海底历险记', '2023-03-25', '澳大利亚');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
