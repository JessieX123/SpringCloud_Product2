/*
 Navicat Premium Data Transfer

 Source Server         : mysql80
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : localhost:3306
 Source Schema         : springcloud_user

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 25/06/2023 22:36:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `r_id` int NOT NULL COMMENT '角色主键',
  `r_name` varchar(50) DEFAULT NULL COMMENT '角色名',
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` (`r_id`, `r_name`) VALUES (1, '管理员');
INSERT INTO `role` (`r_id`, `r_name`) VALUES (2, '游客');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_id` int NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `u_username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `u_password` varchar(50) DEFAULT NULL COMMENT '密码',
  `u_phone` varchar(50) DEFAULT NULL COMMENT '电话',
  `u_date` date DEFAULT NULL COMMENT '创建日期（不可修改）',
  `u_role_id` int DEFAULT NULL COMMENT '角色外键',
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`) VALUES (1, '熊熊', '123456', '1899999666', '2001-09-04', 1);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`) VALUES (2, '张三', '123456', '13800001111', '2021-01-01', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`) VALUES (3, '李四', '654321', '13900002222', '2021-02-02', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`) VALUES (4, '王五', '111111', '13700003333', '2021-03-03', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`) VALUES (5, '赵六', '222222', '13600004444', '2021-04-04', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`) VALUES (6, '钱七', '333333', '13500005555', '2021-05-05', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`) VALUES (7, '孙八', '444444', '13400006666', '2021-06-06', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`) VALUES (8, '周九', '555555', '13300007777', '2021-07-07', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`) VALUES (9, '吴十', '666666', '13200008888', '2021-08-08', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`) VALUES (10, '郑一', '777777', '13100009999', '2021-09-09', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`) VALUES (11, '王二', '888888', '13000001000', '2021-10-10', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`) VALUES (12, '张三丰', '999999', '13900001111', '2021-11-11', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`) VALUES (13, '李逵', '000000', '13800002222', '2021-12-12', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`) VALUES (14, '孙悟空', '111111', '13700003333', '2022-01-01', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`) VALUES (15, '猪八戒', '222222', '13600004444', '2022-02-02', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`) VALUES (16, '唐僧', '333333', '13500005555', '2022-03-03', 1);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`) VALUES (17, '白骨精', '444444', '13400006666', '2022-04-04', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`) VALUES (18, '黑熊精', '555555', '13300007777', '2022-05-05', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`) VALUES (19, '红孩儿', '666666', '13200008888', '2022-06-06', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`) VALUES (20, '观音菩萨', '777777', '13100009999', '2022-07-07', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`) VALUES (21, '牛魔王', '888888', '13000001000', '2022-08-08', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`) VALUES (22, '千一', '100001', '1000000001', '2023-04-21', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`) VALUES (23, '测试123', '112233', '112233445566', '2023-04-22', 2);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
