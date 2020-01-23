/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 50626
 Source Host           : localhost:3306
 Source Schema         : house

 Target Server Type    : MySQL
 Target Server Version : 50626
 File Encoding         : 65001

 Date: 24/01/2020 01:25:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论编号',
  `comment_text` varchar(1000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '评论内容',
  `comment_createTime` datetime(0) NULL DEFAULT NULL COMMENT '评论时间',
  `user_id` int(11) NOT NULL COMMENT '用户编号',
  `housing_id` int(11) NOT NULL COMMENT '房源编号',
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, '房间很宽敞，看着舒适', '2019-04-16 17:44:23', 1, 2);
INSERT INTO `comment` VALUES (2, '房间整体一般', '2019-04-16 18:22:42', 5, 2);
INSERT INTO `comment` VALUES (12, '整体环境很棒', '2019-04-17 00:50:40', 1, 1);
INSERT INTO `comment` VALUES (13, 'v', '2019-04-25 14:02:33', 1, 2);
INSERT INTO `comment` VALUES (14, '房间很宽敞，位置也非常方便，离公交站很近', '2019-05-18 23:51:56', 5, 1);
INSERT INTO `comment` VALUES (15, '1231546', '2020-01-23 23:58:40', 1, 1);
INSERT INTO `comment` VALUES (16, '????', '2020-01-23 23:58:48', 1, 1);
INSERT INTO `comment` VALUES (17, 'gui', '2020-01-23 23:59:26', 1, 1);
INSERT INTO `comment` VALUES (18, '??', '2020-01-23 23:59:31', 1, 1);

-- ----------------------------
-- Table structure for housekeeper
-- ----------------------------
DROP TABLE IF EXISTS `housekeeper`;
CREATE TABLE `housekeeper`  (
  `houseKeeper_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '房管员编号',
  `houseKeeper_account` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '房管员账号',
  `houseKeeper_password` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '房管员密码',
  `houseKeeper_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '房管员姓名',
  `houseKeeper_avatar` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '房管员头像',
  `houseKeeper_sex` char(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '房管员性别',
  `houseKeeper_telNumber` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '电话号码',
  `houseKeeper_address` varchar(1000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '联系地址',
  PRIMARY KEY (`houseKeeper_id`) USING BTREE,
  UNIQUE INDEX `houseKeeper_account`(`houseKeeper_account`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of housekeeper
-- ----------------------------
INSERT INTO `housekeeper` VALUES (3, 'liu15484791548', '123456', '小王', 'img/avatar/222.jpg', '男', '15074918448', '湖南省长沙市岳麓区麓谷街道湖南涉外经济学院');
INSERT INTO `housekeeper` VALUES (4, '123456', '123456', '小明', 'img/avatar/222.jpg', '女', '15074918448', '湖南省长沙市岳麓区麓谷街道');

-- ----------------------------
-- Table structure for housemating
-- ----------------------------
DROP TABLE IF EXISTS `housemating`;
CREATE TABLE `housemating`  (
  `houseMating_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '房源配套编号',
  `houseMating_bed` char(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '床,0表示有，1表示没有',
  `houseMating_washer` char(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '洗衣机',
  `houseMating_airConditioner` char(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '空调',
  `houseMating_balcony` char(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '阳台',
  `houseMating_refrigerator` char(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '冰箱',
  `houseMating_toilet` char(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '卫生间',
  `houseMating_cookhouse` char(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '厨房',
  `houseMating_television` char(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '电视',
  `houseMating_waterHeater` char(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '热水器',
  `houseMating_closet` char(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '衣柜',
  `houseMating_wifi` char(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT 'wifi',
  `houseMating_sofa` char(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '沙发',
  `housing_id` int(11) NOT NULL COMMENT '房源编号',
  PRIMARY KEY (`houseMating_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of housemating
-- ----------------------------
INSERT INTO `housemating` VALUES (1, '0', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', 2);
INSERT INTO `housemating` VALUES (9, '0', '0', '0', '0', '0', '0', '0', NULL, '0', '0', NULL, '0', 1);

-- ----------------------------
-- Table structure for housetype
-- ----------------------------
DROP TABLE IF EXISTS `housetype`;
CREATE TABLE `housetype`  (
  `houseType_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '房源类型编号',
  `houseType_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '房源类型名',
  PRIMARY KEY (`houseType_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of housetype
-- ----------------------------
INSERT INTO `housetype` VALUES (1, '普通住宅');
INSERT INTO `housetype` VALUES (2, '公寓');
INSERT INTO `housetype` VALUES (3, '酒店');
INSERT INTO `housetype` VALUES (4, '别墅');
INSERT INTO `housetype` VALUES (5, '平房');

-- ----------------------------
-- Table structure for housing
-- ----------------------------
DROP TABLE IF EXISTS `housing`;
CREATE TABLE `housing`  (
  `housing_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '房源编号',
  `housing_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '房源标题',
  `housing_about` varchar(4000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '房源简介',
  `housing_image` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '房源图片,以;分隔',
  `housing_address` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '房源地址',
  `housing_detailsAddress` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '房源详细地址',
  `housing_price` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '房源价格',
  `housing_area` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '房源面积',
  `housing_houseType` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '房源户型',
  `housing_floor` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '房源楼层',
  `housing_createTime` datetime(0) NULL DEFAULT NULL COMMENT '房源发布时间',
  `housing_checkState` char(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '审核状态,0表示待审核，1表示未通过, 2表示已通过',
  `housing_leaseState` char(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '租赁状态,0表示未租出，1表示已租出',
  `houseType_id` int(11) NOT NULL COMMENT '房源类型编号',
  `houseKeeper_id` int(11) NOT NULL COMMENT '房管员编号',
  PRIMARY KEY (`housing_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of housing
-- ----------------------------
INSERT INTO `housing` VALUES (1, '沙湾公园地铁口半山壹号正规一室一厅 豪装带地暖 拎包入住', 'dddhfh', 'img/housing/housing1.jpg;img/housing/housing2.jpg;img/housing/housing3.jpg', '北京市 市辖区 西城区', '半山公馆 (雨花 体育新城)', '1200', '61', '2室1厅', '第9层', '2019-04-23 02:01:52', '2', '0', 2, 3);
INSERT INTO `housing` VALUES (2, '沙湾公园地铁口 半山壹号正规二室一厅 豪装带地暖 拎包入住', '欢迎您来到新环境房屋网，新环境白沙湾嘉园何帅欢迎您光顾我的网上店铺！有幸相识，真诚相待！专业的事情找专业的做！房子概况房子温馨舒适，家具齐全，户型周正。随时能看到房子，即租即可拎包可入住！小区概况绿化率达到40％;居住群体以高品质人士为主！安静，安全，人车分流！24*保安守护，更有利于老年人居住！交通概况项目在雨花区政府、喜盈门范城附近、圭塘河旁，占据城市主干道万家丽路与曲塘路双重便利，出门就是公交站。周边配套教育：砂子塘小学、广益中学，、长沙民政学院、山水幼儿园、丽景英蓝幼儿园。购物：家乐福超市、通程商场、华银旺和超市、喜盈门建材市场、家家乐超市；银行：中国建设银行、招商银行、中国工商银行、中国银行、中国农业银行、雨花区信用社。医院：长沙市中心医院、武警司法医院公园：沙湾公园、圭塘公园', 'img/housing/600x450c.jpg;img/housing/600x450c(1).jpg;img/housing/600x450c(2).jpg;img/housing/600x450c(3).jpg', '湖南省 长沙市 岳麓区', '半山公馆 (雨花 体育新城)', '2000', '80', '2室1厅', '第15层', '2019-04-15 13:47:26', '2', '0', 2, 3);
INSERT INTO `housing` VALUES (14, '新出市政府广泰锦苑 带天然气 温馨公寓 家电齐全 拎包入住', '1、小区物业管理规范，楼下便是步步高超市、便利店等，地下停车场很大，停车方便，绿化率高。\r\n\r\n2、视野开阔，周边环境优雅；房子前后均无遮挡，房子背面是小区的花园和小山公园，满足您散步需求。\r\n\r\n3、地理：紧邻市政府和岳麓区政府，东邻八方生态公园和著名的长郡中学，西侧紧邻西二环、规划中的市政公园。\r\n\r\n4、交通：出门便是公交车站，有115、168、903、301、6、302、303、916、907A .  116，规划中地铁2B线，公交车直达五一广场和汽车西站、王府井等商业中心。\r\n\r\n5、公园：谷山森林公园、八方生态公园。\r\n\r\n6、学校：长郡双语中学、博才小学、麓山国际实验小学、金色梯田幼儿园，公立北京御园三幼幼儿园\r\n\r\n7、医院：湘雅三医院、湖南省肿瘤医院\r\n\r\n8、银行：工商银行、建设银行、长沙银行、招商银行等\r\n\r\n9、商业：天恒超市 麦德龙超市、步步高超市、大型菜市场（锦园生鲜）', 'img/housing/housing3.jpg', '湖南省 长沙市 岳麓区', '岳麓 市政府', '1400', '41', '1室1厅', '第7层', '2019-04-22 22:00:13', '0', '1', 2, 3);

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager`  (
  `manager_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员编号',
  `manager_account` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '管理员账号',
  `manager_password` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '管理员密码',
  `manager_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '管理员姓名',
  PRIMARY KEY (`manager_id`) USING BTREE,
  UNIQUE INDEX `manager_account`(`manager_account`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES (1, '15074918448', '123456', '小王');

-- ----------------------------
-- Table structure for reservationrecord
-- ----------------------------
DROP TABLE IF EXISTS `reservationrecord`;
CREATE TABLE `reservationrecord`  (
  `reservationRecord_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '预约记录编号',
  `reservationRecord_state` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '预约状态',
  `reservationRecord_lookingTime` datetime(0) NULL DEFAULT NULL COMMENT '看房时间',
  `reservationRecord_createTime` datetime(0) NULL DEFAULT NULL COMMENT '表记录时间',
  `user_id` int(11) NOT NULL COMMENT '用户编号',
  `housing_id` int(11) NOT NULL COMMENT '房源编号',
  `houseKeeper_id` int(11) NOT NULL COMMENT '房管员编号',
  PRIMARY KEY (`reservationRecord_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of reservationrecord
-- ----------------------------
INSERT INTO `reservationrecord` VALUES (1, '???', '2019-04-26 00:00:00', '2019-04-23 17:22:36', 1, 2, 3);
INSERT INTO `reservationrecord` VALUES (2, '???', '2019-04-26 00:00:00', '2019-04-19 21:52:19', 5, 2, 3);
INSERT INTO `reservationrecord` VALUES (3, '???', '2019-04-17 00:00:00', '2019-04-17 15:46:46', 5, 1, 3);
INSERT INTO `reservationrecord` VALUES (4, '???', '2020-01-23 00:00:00', '2020-01-23 23:54:15', 1, 1, 3);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `user_account` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '用户账号',
  `user_password` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '用户密码',
  `user_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `user_avatar` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '用户头像',
  `user_sex` char(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '用户性别',
  `user_telNumber` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '电话号码',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `user_account`(`user_account`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '15074918448', '123456', '小明', 'img/avatar/111.png', '男', '15074918448');
INSERT INTO `user` VALUES (5, '452849107', '12345678', '小刘', 'img/avatar/222.jpg', '男', '15074918448');

SET FOREIGN_KEY_CHECKS = 1;
