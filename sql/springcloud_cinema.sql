/*
 Navicat Premium Data Transfer

 Source Server         : mysql80
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : localhost:3306
 Source Schema         : springcloud_cinema

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 25/06/2023 22:35:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cinema
-- ----------------------------
DROP TABLE IF EXISTS `cinema`;
CREATE TABLE `cinema` (
  `c_id` int NOT NULL COMMENT '影院主键',
  `c_name` varchar(50) DEFAULT NULL COMMENT '影院名称',
  `c_phone` varchar(50) DEFAULT NULL COMMENT '联系方式',
  `c_address` varchar(50) DEFAULT NULL COMMENT '影院地址',
  `c_date` date DEFAULT NULL COMMENT '首营业日期',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of cinema
-- ----------------------------
BEGIN;
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`) VALUES (1, '皇宫影院', '13812345678', '北京市海淀区中关村大街1号', '2020-01-01');
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`) VALUES (2, '星空电影城', '13698765432', '上海市浦东新区张江路88号', '2018-05-12');
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`) VALUES (3, '银光影城', '13987654321', '广州市天河区天河路789号', '2019-11-11');
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`) VALUES (4, '万达影城', '13788889999', '深圳市福田区华强北路168号', '2017-08-02');
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`) VALUES (5, '大地影院', '13512345678', '成都市锦江区春熙路99号', '2021-03-15');
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`) VALUES (6, '金逸国际影城', '15234567890', '南京市鼓楼区汉口路22号', '2015-10-10');
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`) VALUES (7, '橙天嘉禾影城', '13900001111', '武汉市江汉区解放大道666号', '2022-02-22');
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`) VALUES (8, 'UME国际影城', '15811112222', '重庆市渝北区龙头寺路8号', '2016-06-06');
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`) VALUES (9, '华夏星光', '13777778888', '天津市南开区鼓楼大街222号', '2018-09-09');
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`) VALUES (10, '百丽宫影城', '13866667777', '杭州市拱墅区和睦街99号', '2020-12-12');
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`) VALUES (11, '中影国际城', '13600002222', '厦门市思明区软件园二期88号', '2017-07-07');
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`) VALUES (12, '星美国际影城', '15011112222', '长沙市岳麓区麓谷街道麓山路66号', '2021-01-01');
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`) VALUES (13, '保利国际影城', '13855556666', '西安市雁塔区曲江文化新区雁南五路88号', '2019-04-20');
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`) VALUES (14, '幸福蓝海国际影城', '13944445555', '青岛市市北区辽阳西路66号', '2018-08-08');
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`) VALUES (15, '华谊兄弟影院', '15133334444', '福州市仓山区福新东路66号', '2022-03-30');
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`) VALUES (16, '耀莱成龙影城', '13711112222', '合肥市瑶海区临泉路8号', '2016-05-01');
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`) VALUES (17, '中影时代国际影城', '15922223333', '南昌市洪都北大道99号', '2019-12-25');
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`) VALUES (18, '博纳国际影城', '18866667777', '济南市历下区经十路66号', '2017-09-18');
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`) VALUES (19, '金逸珠江国际影城', '13722223333', '东莞市虎门镇轻轨站旁边', '2020-04-04');
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`) VALUES (20, 'SFC上影影城', '13933334444', '苏州市工业园区星海街88号', '2018-11-11');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
