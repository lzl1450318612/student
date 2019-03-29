/*
Navicat MySQL Data Transfer

Source Server         : localSQL
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : grade

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2019-01-20 02:25:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for repair_management
-- ----------------------------
DROP TABLE IF EXISTS `repair_management`;
CREATE TABLE `repair_management` (
  `id` bigint(100) NOT NULL AUTO_INCREMENT COMMENT '维修管理id',
  `user_id` bigint(100) DEFAULT NULL COMMENT '维修人员id',
  `purchase_id` bigint(100) DEFAULT NULL COMMENT '订单id',
  `materiel_id` bigint(100) DEFAULT NULL COMMENT '物料编号',
  `select_style` int(100) DEFAULT NULL COMMENT '维修类型编码',
  `materiel_num` int(100) DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_persian_ci COMMENT='维修管理表';

-- ----------------------------
-- Records of repair_management
-- ----------------------------
INSERT INTO `repair_management` VALUES ('1', null, '10', '37', '1', '10');

-- ----------------------------
-- Table structure for sold_out
-- ----------------------------
DROP TABLE IF EXISTS `sold_out`;
CREATE TABLE `sold_out` (
  `id` bigint(100) NOT NULL AUTO_INCREMENT COMMENT '已售出id',
  `user_id` bigint(100) DEFAULT NULL COMMENT '销售人员id',
  `purchase_id` bigint(100) DEFAULT NULL COMMENT '采购id',
  `logistics_num` varchar(100) COLLATE utf8mb4_persian_ci DEFAULT NULL COMMENT '物流单号',
  `logistics_company` varchar(100) COLLATE utf8mb4_persian_ci DEFAULT NULL COMMENT '物流公司',
  `carriage_price` decimal(65,2) DEFAULT NULL COMMENT '物流价格',
  `sales_person` varchar(100) COLLATE utf8mb4_persian_ci DEFAULT NULL COMMENT '销售员',
  `time` date DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_persian_ci COMMENT='售出表';

-- ----------------------------
-- Records of sold_out
-- ----------------------------
INSERT INTO `sold_out` VALUES ('1', '1', '10', '', '', '100.00', 'hrx', '2019-01-12');
INSERT INTO `sold_out` VALUES ('2', '1', '1', '', '', '10000.00', 'hrx', '2019-01-13');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `studentId` bigint(8) NOT NULL AUTO_INCREMENT,
  `surName` varchar(10) NOT NULL,
  `givenName` varchar(10) NOT NULL,
  `email` varchar(25) NOT NULL,
  `userName` varchar(10) NOT NULL,
  `markerComments` varchar(200) DEFAULT '',
  `score` int(2) NOT NULL,
  `marker` varchar(255) NOT NULL,
  PRIMARY KEY (`studentId`)
) ENGINE=InnoDB AUTO_INCREMENT=997646 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 'a', 'a', '1450318612@qq.com', 'a', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('2', 'b', 'b', '9', 'b', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('3', 'c', 'c', '1191134106@qq.com', 'c', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('4', 'd', 'd', '11', 'd', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('5', 'e', 'e', '12', 'e', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('6', 'a', 'f', '13', 'f', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('7', 'b', 'g', '14', 'g', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('8', 'c', 'a', '15', 'a', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('9', 'd', 'b', '16', 'a', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('10', 'e', 'c', '17', 'b', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('11', 'a', 'd', '18', 'c', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('12', 'b', 'e', '19', 'd', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('13', 'c', 'f', '20', 'e', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('14', 'd', 'g', '21', 'f', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('15', 'e', 'a', '22', 'g', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('16', 'a', 'b', '23', 'a', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('17', 'b', 'c', '24', 'b', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('18', 'c', 'd', '25', 'c', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('19', 'd', 'e', '26', 'd', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('20', 'e', 'f', '27', 'e', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('21', 'a', 'g', '28', 'f', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('22', 'b', 'a', '29', 'g', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('23', 'c', 'b', '30', 'a', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('24', 'd', 'c', '31', 'a', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('25', 'e', 'd', '32', 'b', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('26', 'a', 'e', '33', 'c', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('27', 'b', 'f', '34', 'd', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('28', 'c', 'g', '35', 'e', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('29', 'd', 'a', '36', 'f', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('30', 'e', 'b', '37', 'g', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('31', 'a', 'c', '38', 'a', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('32', 'b', 'd', '39', 'b', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('33', 'c', 'e', '40', 'c', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('34', 'd', 'f', '41', 'd', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('35', 'e', 'g', '42', 'e', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('36', 'a', 'a', '43', 'f', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('444', 'qq', 'ww', '1212', '1', 'jaja', '4', 'marker1');
INSERT INTO `student` VALUES ('565', '88', '88', '88', '88', 'The student has no comments', '5', '88');
INSERT INTO `student` VALUES ('2322', '99', '99', '1450318612@qq.com', '99', '99', '8', '00');
INSERT INTO `student` VALUES ('111444', 'qq', 'ww', '1450318612@qq.com', '1', 'jaja', '4', 'user');
INSERT INTO `student` VALUES ('112322', '99', '99', '14503186121@qq.com', '99', '99', '8', 'user');
INSERT INTO `student` VALUES ('157689', 'a', 'a', '1', 'a', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('186527', 'b', 'b', '2', 'b', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('215366', 'c', 'c', '3', 'c', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('244204', 'd', 'd', '4', 'd', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('273042', 'e', 'e', '5', 'e', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('301881', 'f', 'f', '6', 'f', 'The student has no comments', '1', 'dd');
INSERT INTO `student` VALUES ('330719', 'g', 'g', '7', 'g', 'The student has no comments', '1', 'dd');

-- ----------------------------
-- Table structure for sys_organization
-- ----------------------------
DROP TABLE IF EXISTS `sys_organization`;
CREATE TABLE `sys_organization` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `available` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmeds2u6ae5usj0ko0bqj3k0eo` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_organization
-- ----------------------------

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `available` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `order_num` int(11) NOT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3fekum3ead5klp7y4lckn5ohi` (`parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=190 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES ('1', '\0', '\r\nTop column', '0', null, '0', null, '0');
INSERT INTO `sys_resource` VALUES ('2', '\0', '\r\nPermission', '2', '', '0', '', '1');
INSERT INTO `sys_resource` VALUES ('3', '\0', 'Role management', '3', '/role', '0', '/role', '2');
INSERT INTO `sys_resource` VALUES ('4', '\0', '\r\nPrivilege management', '1', '/resource', '0', '/resource', '2');
INSERT INTO `sys_resource` VALUES ('5', '\0', 'User management', '2', '/user', '0', '/user', '2');
INSERT INTO `sys_resource` VALUES ('6', '\0', 'edit', '0', '/role/editor-role', '1', '/role/editor-role', '3');
INSERT INTO `sys_resource` VALUES ('7', '\0', 'Adding permission nodes', '0', '/resource/add-permission', '1', '/resource/add-permission', '4');
INSERT INTO `sys_resource` VALUES ('8', '\0', 'Added Administrator', '0', '/user/add-user', '1', '/user/add-user', '5');
INSERT INTO `sys_resource` VALUES ('9', '\0', 'Add roles', '0', '/role/add-role', '1', '/role/add-role', '3');
INSERT INTO `sys_resource` VALUES ('10', '\0', 'delete roles', '0', '/role/delete', '1', '/role/delete', '3');
INSERT INTO `sys_resource` VALUES ('11', '\0', 'delete user\n\n', '0', '/user/delete-user', '1', '/user/delete-user', '5');
INSERT INTO `sys_resource` VALUES ('12', '\0', 'Delete permission', '0', '/resource/delete', '1', '/resource/delete', '4');
INSERT INTO `sys_resource` VALUES ('13', '\0', 'Enable', '0', '/user/available-user', '1', '/user/available-user', '3');
INSERT INTO `sys_resource` VALUES ('14', '\0', 'Modify Administrator Password', '0', '/user/modify-password', '1', '/user/modify-password', '5');
INSERT INTO `sys_resource` VALUES ('16', null, 'Permission editor', '0', '/resource/editor-permission', '1', '/resource/editor-permission', '4');
INSERT INTO `sys_resource` VALUES ('150', '\0', 'Editor Administrator Information', '0', '/user/edit-user', '1', '/user/edit-user', '5');
INSERT INTO `sys_resource` VALUES ('179', null, 'student', '1', '', '0', '', '1');
INSERT INTO `sys_resource` VALUES ('180', null, 'list', '1', '/student/list', '0', '/student/list', '179');
INSERT INTO `sys_resource` VALUES ('181', null, 'delete', '1', '/student/delete', '1', '/student/delete', '180');
INSERT INTO `sys_resource` VALUES ('182', null, 'markedStudent', '1', '', '0', '', '1');
INSERT INTO `sys_resource` VALUES ('183', null, 'studentList', '1', '/student/selflist', '0', '/student/selflist', '182');
INSERT INTO `sys_resource` VALUES ('184', null, 'uploadExcel', '1', '/resource/uploadExcel', '1', '/resource/uploadExcel', '183');
INSERT INTO `sys_resource` VALUES ('185', null, 'markerDeleteStudent', '2', '/student/delete', '1', '/student/delete', '183');
INSERT INTO `sys_resource` VALUES ('186', null, 'modify', '1', '/student/changeStu', '1', '/student/changeStu', '183');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `available` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', null, 'Admin', 'Admin');
INSERT INTO `sys_role` VALUES ('2', null, 'Test', 'Test');
INSERT INTO `sys_role` VALUES ('29', null, 'User', 'User');

-- ----------------------------
-- Table structure for sys_role_resources
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resources`;
CREATE TABLE `sys_role_resources` (
  `sys_role_id` bigint(20) NOT NULL,
  `resources_id` bigint(20) NOT NULL,
  KEY `FKog6jj4v6yh9e1ilxk2mwuk75a` (`resources_id`),
  KEY `FKsqkqfd2hpr5cc2kbrtgoced2w` (`sys_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_resources
-- ----------------------------
INSERT INTO `sys_role_resources` VALUES ('1', '2');
INSERT INTO `sys_role_resources` VALUES ('1', '3');
INSERT INTO `sys_role_resources` VALUES ('1', '6');
INSERT INTO `sys_role_resources` VALUES ('1', '9');
INSERT INTO `sys_role_resources` VALUES ('1', '10');
INSERT INTO `sys_role_resources` VALUES ('1', '13');
INSERT INTO `sys_role_resources` VALUES ('1', '4');
INSERT INTO `sys_role_resources` VALUES ('1', '7');
INSERT INTO `sys_role_resources` VALUES ('1', '12');
INSERT INTO `sys_role_resources` VALUES ('1', '16');
INSERT INTO `sys_role_resources` VALUES ('1', '5');
INSERT INTO `sys_role_resources` VALUES ('1', '8');
INSERT INTO `sys_role_resources` VALUES ('1', '11');
INSERT INTO `sys_role_resources` VALUES ('1', '14');
INSERT INTO `sys_role_resources` VALUES ('1', '150');
INSERT INTO `sys_role_resources` VALUES ('1', '178');
INSERT INTO `sys_role_resources` VALUES ('1', '179');
INSERT INTO `sys_role_resources` VALUES ('1', '180');
INSERT INTO `sys_role_resources` VALUES ('1', '181');
INSERT INTO `sys_role_resources` VALUES ('29', '182');
INSERT INTO `sys_role_resources` VALUES ('29', '183');
INSERT INTO `sys_role_resources` VALUES ('29', '184');
INSERT INTO `sys_role_resources` VALUES ('29', '185');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createtime` datetime DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `available` bit(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `sex_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '2017-07-11 17:42:18', '$2a$10$SIU57gfkh/TsIVYALXBNAeDnQzkm652FT9cg4h8wtEfC306uliyYa', '2019-01-11 07:34:38', 'admin', '', '1191134106@qq.com', '15030103078', '1');
INSERT INTO `sys_user` VALUES ('23', '2019-01-10 13:18:55', '$2a$10$Q74mtX6pmKerfSyEeJtP8etAEd2qDLGWUzpz5UGECtn09tumLNFWC', '2019-01-11 13:08:29', 'admin1', '\0', '', '', '0');
INSERT INTO `sys_user` VALUES ('24', '2019-01-19 02:05:14', '$2a$10$IOOxGqOFyFYfGzgztQ.1FOzHjrDVHGq.5VPL7dcwLVcy/N/iAenDe', '2019-01-19 02:05:14', 'user', '', '1450318612@qq.com', '139201211597', '1');
INSERT INTO `sys_user` VALUES ('26', '2019-01-19 12:18:33', '$2a$10$88KT7Qa3Xba1aNZ2VzpX8uFlRq.GPLZ5rjsCfXOUh6stVJIBvULhG', '2019-01-19 12:18:33', 'test', '\0', '', '', '1');

-- ----------------------------
-- Table structure for sys_user_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_roles`;
CREATE TABLE `sys_user_roles` (
  `sys_user_id` bigint(20) NOT NULL,
  `roles_id` bigint(20) NOT NULL,
  KEY `FKdpvc6d7xqpqr43dfuk1s27cqh` (`roles_id`),
  KEY `FKd0ut7sloes191bygyf7a3pk52` (`sys_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_roles
-- ----------------------------
INSERT INTO `sys_user_roles` VALUES ('1', '1');
INSERT INTO `sys_user_roles` VALUES ('23', '29');
INSERT INTO `sys_user_roles` VALUES ('24', '29');
