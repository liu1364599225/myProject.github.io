/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 50626
 Source Host           : localhost:3306
 Source Schema         : qqmail

 Target Server Type    : MySQL
 Target Server Version : 50626
 File Encoding         : 65001

 Date: 24/01/2020 01:25:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for event
-- ----------------------------
DROP TABLE IF EXISTS `event`;
CREATE TABLE `event`  (
  `eid` int(10) NOT NULL AUTO_INCREMENT COMMENT '事件的id',
  `title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '事件的标题',
  `start` date NULL DEFAULT NULL COMMENT '事件的开始时间',
  `end` date NULL DEFAULT NULL COMMENT '事件的结束时间',
  `master` int(11) NULL DEFAULT NULL COMMENT '拥有此事件的用户id',
  PRIMARY KEY (`eid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of event
-- ----------------------------
INSERT INTO `event` VALUES (1, 'jsdljdf', '2018-05-01', '2018-05-02', 1);
INSERT INTO `event` VALUES (2, '你好', '2018-05-10', '2018-05-11', 1);

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file`  (
  `fileId` int(11) NOT NULL AUTO_INCREMENT COMMENT '文件的id',
  `fileName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件的名字',
  `filePath` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件的jsp在服务器上的路径',
  `uploadDate` date NULL DEFAULT NULL COMMENT '文件上传的时间',
  `userId` int(11) NULL DEFAULT NULL COMMENT '用户的id',
  PRIMARY KEY (`fileId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of file
-- ----------------------------
INSERT INTO `file` VALUES (1, '??????', 'file/filejsp/1579790249443.jsp', '2020-01-23', 1);

-- ----------------------------
-- Table structure for linkman
-- ----------------------------
DROP TABLE IF EXISTS `linkman`;
CREATE TABLE `linkman`  (
  `linkman_id` int(11) NULL DEFAULT NULL COMMENT '联系人编号',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户账号',
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `job` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作',
  `group_id` int(11) NULL DEFAULT NULL COMMENT '组编号id'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of linkman
-- ----------------------------
INSERT INTO `linkman` VALUES (2, 1, '湖南省 长沙市 岳麓区', '2017-03-13', '学生', 2);
INSERT INTO `linkman` VALUES (3, 1, '湖南省 长沙市 岳麓区', '2018-05-21', '学生', 1);
INSERT INTO `linkman` VALUES (4, 1, '湖南省 长沙市 岳麓区', '2018-05-21', '学生', 1);
INSERT INTO `linkman` VALUES (5, 1, '湖南省 长沙市 岳麓区', '2018-05-21', '学生', 2);
INSERT INTO `linkman` VALUES (6, 2, '湖南省 长沙市 岳麓区', '2018-05-21', '学生', 1);
INSERT INTO `linkman` VALUES (2, 1, '', NULL, '', 1);

-- ----------------------------
-- Table structure for linkmangroup
-- ----------------------------
DROP TABLE IF EXISTS `linkmangroup`;
CREATE TABLE `linkmangroup`  (
  `group_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '通讯录组id',
  `group_name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通讯录组名',
  PRIMARY KEY (`group_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of linkmangroup
-- ----------------------------
INSERT INTO `linkmangroup` VALUES (1, '我的好友');
INSERT INTO `linkmangroup` VALUES (2, '我的朋友');
INSERT INTO `linkmangroup` VALUES (3, '我的家人');
INSERT INTO `linkmangroup` VALUES (4, '我的好友');

-- ----------------------------
-- Table structure for mail
-- ----------------------------
DROP TABLE IF EXISTS `mail`;
CREATE TABLE `mail`  (
  `mail_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '邮件编号',
  `motive` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主题',
  `main_body` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '正文',
  `status_id` int(11) NULL DEFAULT NULL COMMENT '邮件状态id',
  `send_mail_id` int(11) NULL DEFAULT NULL COMMENT '发件人id',
  `accept_mail_id` int(11) NULL DEFAULT NULL COMMENT '收件人id',
  `send_time` date NULL DEFAULT NULL COMMENT '发送邮件的时间',
  `notepaper_id` int(11) NULL DEFAULT NULL COMMENT '信纸id',
  PRIMARY KEY (`mail_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mail
-- ----------------------------
INSERT INTO `mail` VALUES (27, '刘波寄来的明信片', '\r\n							<img class=\"newImage\" src=\"/qqmail/img/postcardImg/test1527431830421.png\"><br>\r\n							<audio id=\"sendMusic\" src=\"/qqmail/mp3/444.mp3\" controls=\"controls\" autoplay=\"autoplay\"></audio>\r\n						', 142, 1, 2, '2018-05-27', NULL);
INSERT INTO `mail` VALUES (28, '刘波寄来的明信片', '\r\n							<img class=\"newImage\" src=\"/qqmail/img/postcardImg/test1527431830421.png\"><br>\r\n							<audio id=\"sendMusic\" src=\"/qqmail/mp3/444.mp3\" controls=\"controls\" autoplay=\"autoplay\"></audio>\r\n						', 142, 1, 5, '2018-05-27', NULL);
INSERT INTO `mail` VALUES (29, '????????', '\r\n							<img class=\"newImage\" src=\"/qqmail/img/postcardImg/test1579790165330.png\">\r\n							<audio id=\"sendMusic\" src=\"/qqmail/mp3/111.mp3\" controls=\"controls\" autoplay=\"autoplay\"></audio>\r\n						', 143, 1, 5, '2020-01-23', NULL);
INSERT INTO `mail` VALUES (30, '????????', '\r\n							<img class=\"newImage\" src=\"/qqmail/img/postcardImg/test1579790219783.png\">\r\n							<audio id=\"sendMusic\" src=\"/qqmail/mp3/111.mp3\" controls=\"controls\" autoplay=\"autoplay\"></audio>\r\n						', 144, 1, 2, '2020-01-23', NULL);
INSERT INTO `mail` VALUES (31, '????????', '\r\n							<img class=\"newImage\" src=\"/qqmail/img/postcardImg/test1579790219783.png\">\r\n							<audio id=\"sendMusic\" src=\"/qqmail/mp3/111.mp3\" controls=\"controls\" autoplay=\"autoplay\"></audio>\r\n						', 144, 1, 5, '2020-01-23', NULL);
INSERT INTO `mail` VALUES (32, '(???)', '<strong>46578<em>56465465151<img src=\"/qqmail/attached/image/20200123/20200123223912_56.gif\" alt=\"\" /></em></strong>', 145, 1, 2, '2020-01-23', NULL);
INSERT INTO `mail` VALUES (33, '545', '<img src=\"/qqmail/attached/image/20200123/20200123224107_714.gif\" alt=\"\" />', 146, 1, 5, '2020-01-23', NULL);

-- ----------------------------
-- Table structure for notepaper
-- ----------------------------
DROP TABLE IF EXISTS `notepaper`;
CREATE TABLE `notepaper`  (
  `notepaper_id` int(11) NOT NULL AUTO_INCREMENT,
  `notepaper_img` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`notepaper_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 94 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of notepaper
-- ----------------------------
INSERT INTO `notepaper` VALUES (1, '/img/notepaperImg/a_04.jpg');
INSERT INTO `notepaper` VALUES (2, '/img/notepaperImg/a_01.jpg');
INSERT INTO `notepaper` VALUES (3, '/img/notepaperImg/a_12.jpg');
INSERT INTO `notepaper` VALUES (4, '/img/notepaperImg/a_06.jpg');
INSERT INTO `notepaper` VALUES (5, '/img/notepaperImg/a_02.jpg');
INSERT INTO `notepaper` VALUES (6, '/img/notepaperImg/a_03.jpg');
INSERT INTO `notepaper` VALUES (89, '/img/notepaperImg/01-3.jpg');
INSERT INTO `notepaper` VALUES (90, '/img/notepaperImg/01-4.jpg');
INSERT INTO `notepaper` VALUES (91, '/img/notepaperImg/01-3.jpg');
INSERT INTO `notepaper` VALUES (92, '/img/notepaperImg/01-3.jpg');
INSERT INTO `notepaper` VALUES (93, '/img/notepaperImg/01-4.jpg');

-- ----------------------------
-- Table structure for now_linkman
-- ----------------------------
DROP TABLE IF EXISTS `now_linkman`;
CREATE TABLE `now_linkman`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '最近联系人的编号',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '联系人的id',
  `linkman_id` int(11) NULL DEFAULT NULL COMMENT '被联系人的id',
  `link_time` date NULL DEFAULT NULL COMMENT '联系时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of now_linkman
-- ----------------------------
INSERT INTO `now_linkman` VALUES (22, 1, 2, '2020-01-23');
INSERT INTO `now_linkman` VALUES (23, 1, 5, '2020-01-23');

-- ----------------------------
-- Table structure for status
-- ----------------------------
DROP TABLE IF EXISTS `status`;
CREATE TABLE `status`  (
  `mail_status_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '邮箱状态表的id',
  `inbox` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'false' COMMENT '收件箱状态',
  `bit_mail` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'false' COMMENT '星标邮件状态',
  `send` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'false' COMMENT '发件箱状态',
  `deletes` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'false' COMMENT '是否删除的状态',
  `garbage` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'false' COMMENT '垃圾状态',
  `draft` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'false' COMMENT '草稿箱的状态',
  `asend` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'false' COMMENT '已发送',
  `unsend` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'false' COMMENT '未发送',
  `afind` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'false' COMMENT '已查看',
  `unfind` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'false' COMMENT '未查看',
  `group_mail` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'false' COMMENT '群邮件',
  PRIMARY KEY (`mail_status_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 147 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of status
-- ----------------------------
INSERT INTO `status` VALUES (130, 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'true');
INSERT INTO `status` VALUES (131, 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'true');
INSERT INTO `status` VALUES (132, 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'true');
INSERT INTO `status` VALUES (133, 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'true');
INSERT INTO `status` VALUES (134, 'true', 'false', 'false', 'false', 'false', 'false', 'true', 'false', 'false', 'false', 'false');
INSERT INTO `status` VALUES (135, 'true', 'false', 'false', 'false', 'false', 'false', 'true', 'false', 'false', 'false', 'false');
INSERT INTO `status` VALUES (136, 'true', 'false', 'false', 'false', 'false', 'false', 'true', 'false', 'false', 'false', 'false');
INSERT INTO `status` VALUES (137, 'true', 'false', 'false', 'false', 'false', 'false', 'true', 'false', 'false', 'false', 'false');
INSERT INTO `status` VALUES (138, 'true', 'false', 'false', 'true', 'false', 'false', 'true', 'false', 'false', 'false', 'false');
INSERT INTO `status` VALUES (139, 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'true');
INSERT INTO `status` VALUES (140, 'true', 'false', 'false', 'false', 'false', 'false', 'true', 'false', 'false', 'false', 'false');
INSERT INTO `status` VALUES (141, 'true', 'false', 'false', 'false', 'false', 'false', 'true', 'false', 'false', 'false', 'false');
INSERT INTO `status` VALUES (142, 'true', 'false', 'false', 'false', 'false', 'false', 'true', 'false', 'false', 'false', 'false');
INSERT INTO `status` VALUES (143, 'true', 'false', 'false', 'false', 'false', 'false', 'true', 'false', 'false', 'false', 'false');
INSERT INTO `status` VALUES (144, 'true', 'false', 'false', 'false', 'false', 'false', 'true', 'false', 'true', 'false', 'false');
INSERT INTO `status` VALUES (145, 'true', 'false', 'false', 'false', 'false', 'false', 'true', 'false', 'false', 'false', 'false');
INSERT INTO `status` VALUES (146, 'true', 'false', 'false', 'false', 'false', 'false', 'true', 'false', 'false', 'false', 'false');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `nickname` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `user_account` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户账号',
  `user_password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `user_tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户电话',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '刘波', '1364599225@qq.com', '123456', '15074918448');
INSERT INTO `user` VALUES (2, '小明', '452849107@qq.com', '123456', '15074918448');
INSERT INTO `user` VALUES (3, '小红', '123456789@qq.com', '123456', '15074918448');
INSERT INTO `user` VALUES (4, '小王', '111111111@qq.com', '123456', '15074918448');
INSERT INTO `user` VALUES (5, '小刘', '222222222@qq.com', '123456', '15074918448');
INSERT INTO `user` VALUES (6, '小李', '333333333@qq.com', '123456', '15074918448');
INSERT INTO `user` VALUES (7, '小五', '444444444@qq.com', '123456', '15074918448');

SET FOREIGN_KEY_CHECKS = 1;
