/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.21-log : Database - myclub
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`myclub` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `myclub`;

/*Table structure for table `activities` */

DROP TABLE IF EXISTS `activities`;

CREATE TABLE `activities` (
  `activity_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `place_id` bigint(20) DEFAULT NULL,
  `club_id` bigint(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `place` varchar(20) DEFAULT NULL,
  `content` varchar(200) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatetime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`activity_id`),
  KEY `FK_Relationship_12` (`place_id`),
  KEY `FK_Relationship_9` (`club_id`),
  CONSTRAINT `FK_Relationship_12` FOREIGN KEY (`place_id`) REFERENCES `places` (`place_id`),
  CONSTRAINT `FK_Relationship_9` FOREIGN KEY (`club_id`) REFERENCES `clubs` (`club_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `activities` */

insert  into `activities`(`activity_id`,`place_id`,`club_id`,`name`,`time`,`place`,`content`,`createtime`,`updatetime`) values (1,4,1,'比赛','2020-03-04 17:43:51','创新创业活动中心','举行社内第二次比赛','2020-03-13 17:45:28','2020-05-20 13:02:40'),(2,1,5,'环校跑','2020-03-28 17:45:46','学校','绕学校跑2周','2020-03-13 17:45:32','2020-05-20 13:03:33'),(3,4,4,'骑行','2020-03-30 20:47:27','学校周边','在学校周边骑行','2020-03-30 20:47:02','2020-05-20 13:04:47'),(4,4,6,'歌唱比赛','2020-03-30 20:47:30','地点测试','举行社团第三届歌唱比赛','2020-03-30 20:47:27','2020-05-20 13:07:41'),(5,2,3,'轮滑','2020-04-21 00:00:00','地点备注','测试：编写活动内容','2020-04-21 16:37:03','2020-05-20 13:07:15'),(6,1,3,'例会','2020-04-25 16:37:24','地点备注','测试：编写活动内容','2020-04-21 16:37:47','2020-05-20 13:07:10'),(14,1,5,'测试','2020-05-24 11:28:41','地点测试','测试：社团活动内容','2020-05-13 11:29:30','2020-05-20 13:06:57');

/*Table structure for table `admins` */

DROP TABLE IF EXISTS `admins`;

CREATE TABLE `admins` (
  `admin_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `club_id` bigint(20) DEFAULT NULL,
  `admin_email` varchar(20) DEFAULT NULL,
  `admin_phone` varchar(20) DEFAULT NULL,
  `admin_password` varchar(50) DEFAULT NULL,
  `img` varchar(50) DEFAULT NULL,
  `real_name` varchar(10) DEFAULT NULL,
  `sex` varchar(1) DEFAULT NULL,
  `possition` varchar(10) DEFAULT NULL,
  `number` varchar(15) DEFAULT NULL,
  `college` varchar(10) DEFAULT NULL,
  `major` varchar(10) DEFAULT NULL,
  `admin_status` tinyint(1) DEFAULT NULL,
  `admin_type` tinyint(1) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatetime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`admin_id`),
  KEY `FK_Relationship_3` (`club_id`),
  CONSTRAINT `FK_Relationship_3` FOREIGN KEY (`club_id`) REFERENCES `clubs` (`club_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

/*Data for the table `admins` */

insert  into `admins`(`admin_id`,`club_id`,`admin_email`,`admin_phone`,`admin_password`,`img`,`real_name`,`sex`,`possition`,`number`,`college`,`major`,`admin_status`,`admin_type`,`createtime`,`updatetime`) values (1,2,'admin@qq.com','15958469852','123456',NULL,'社联','男','社联管理员','无','无','无',1,0,'2020-03-05 19:56:50','2020-06-02 18:58:16'),(2,3,'12345622777@qq.com','15958469855','123456',NULL,'王红','女','外联部长','201631063235','地球科学与技术学院','城市地下空间工程',1,1,'2020-03-06 11:43:39','2020-03-22 16:41:34'),(3,3,'123456737@qq.com','15895654556','123456',NULL,'貂蝉','女','组织部长','201631056449','地球科学与技术学院','地理信息科学',1,1,'2020-03-09 11:30:57','2020-05-14 22:25:58'),(4,1,'15455@qq.com','15898648759','123456',NULL,'刘备','男','社长','201956849785','地球科学与技术学院','城市地下空间工程',1,1,'2020-03-10 09:19:19','2020-03-12 17:04:38'),(7,3,'2452467985@qq.com','13550491186','123456',NULL,'测试','男','宣传部长','201956849765','石油与天然气工程学院','油气储运工程',0,1,'2020-03-10 09:19:51','2020-03-13 16:12:18'),(8,1,'245295585@qq.com','13995167359','123456',NULL,'张飞','男','外联部长','201894687594','石油与天然气工程学院','海洋油气工程',1,1,'2020-03-10 09:19:55','2020-03-12 17:24:25'),(20,3,'1234567167@qq.com','15958469855','123456',NULL,'王红','女','组织部长','201631063235','地球科学与技术学院','城市地下空间工程',1,1,'2020-03-12 16:51:37','2020-05-14 22:26:07'),(21,1,'1234567547@qq.com','15958469855','123456',NULL,'王红','女','组织部长','201631063235','地球科学与技术学院','城市地下空间工程',1,1,'2020-03-12 16:52:23','2020-05-14 22:26:10'),(22,3,'12345615177@qq.com','15958469855','123456',NULL,'王红','女','外联部长','201631063235','地球科学与技术学院','城市地下空间工程',1,1,'2020-03-12 16:57:50','2020-05-14 22:26:15'),(23,3,'2459874585@qq.com','13993794700','123456',NULL,'诸葛亮','男','外联部长','201364587954','地球科学与技术学院','地质学',1,1,'2020-03-12 17:27:38',NULL),(24,1,'14191516@qq.com','13848913578','123456',NULL,'测试3','男','副社长','201731053648','地球科学与技术学院','地理信息科学',1,1,'2020-05-20 08:33:49',NULL);

/*Table structure for table `club_applications` */

DROP TABLE IF EXISTS `club_applications`;

CREATE TABLE `club_applications` (
  `club_application_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `club_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `club_application_type` tinyint(1) DEFAULT NULL,
  `club_application_desc` varchar(100) DEFAULT NULL,
  `club_application_status` int(5) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatetime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`club_application_id`),
  KEY `FK_Relationship_13` (`user_id`),
  KEY `FK_Relationship_15` (`club_id`),
  CONSTRAINT `FK_Relationship_13` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FK_Relationship_15` FOREIGN KEY (`club_id`) REFERENCES `clubs` (`club_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `club_applications` */

insert  into `club_applications`(`club_application_id`,`club_id`,`user_id`,`club_application_type`,`club_application_desc`,`club_application_status`,`createtime`,`updatetime`) values (1,1,1,0,'我想打乒乓',2,'2020-04-10 16:36:38','2020-04-15 22:37:13'),(2,4,3,1,'器单车',2,'2020-04-10 16:37:08','2020-04-15 08:09:10'),(3,3,1,1,'我想学轮滑',0,'2020-04-10 16:37:31','2020-04-16 11:44:48'),(4,3,9,1,'测试加入',2,'2020-04-16 11:46:39',NULL);

/*Table structure for table `clubs` */

DROP TABLE IF EXISTS `clubs`;

CREATE TABLE `clubs` (
  `club_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `logo` varchar(30) DEFAULT NULL,
  `club_desc` varchar(100) DEFAULT NULL,
  `foundtime` datetime DEFAULT NULL,
  `founder` varchar(10) DEFAULT NULL,
  `star` int(5) DEFAULT NULL,
  `club_status` tinyint(1) DEFAULT NULL,
  `club_type` tinyint(1) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatetime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`club_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `clubs` */

insert  into `clubs`(`club_id`,`name`,`email`,`logo`,`club_desc`,`foundtime`,`founder`,`star`,`club_status`,`club_type`,`createtime`,`updatetime`) values (1,'乒乓球协会','1258498@qq.com',NULL,'一起打乒乓球','2020-03-05 19:41:29','王明明',1,1,1,'2020-03-05 19:42:39','2020-05-16 18:32:42'),(2,'社联管理员',NULL,NULL,NULL,NULL,NULL,NULL,1,0,'2020-03-05 19:57:42','2020-03-05 20:12:28'),(3,'轮滑协会','594948489@qq.com',NULL,'做轮滑场上的舞者','2020-02-05 00:00:00','测试1',4,1,1,'2020-03-10 14:53:32','2020-06-02 22:22:38'),(4,'自行车协会','98855455@qq.com',NULL,'一起骑单车','2020-03-12 00:00:00','测试2',2,1,1,'2020-03-13 12:41:12','2020-06-02 22:47:40'),(5,'跑步协会','4441616@qq.com',NULL,'一起跑步，一起运动','2020-03-12 00:00:00','测试3',3,1,1,'2020-03-13 13:37:20','2020-06-02 22:22:52'),(6,'音乐协会','586443876@qq.com',NULL,'音乐舒缓你的心情','2020-03-26 00:00:00','测试4',1,1,1,'2020-03-13 15:52:52','2020-06-02 22:22:58'),(7,'网球协会','123524678@qq.com',NULL,'来一起打网球吧','2020-03-10 00:00:00','测试5',1,0,1,'2020-03-13 15:53:09','2020-06-02 22:23:04');

/*Table structure for table `comments` */

DROP TABLE IF EXISTS `comments`;

CREATE TABLE `comments` (
  `comments_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `news_id` bigint(20) DEFAULT NULL,
  `comments` varchar(50) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatetime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`comments_id`),
  KEY `FK_Relationship_5` (`user_id`),
  KEY `FK_Relationship_6` (`news_id`),
  CONSTRAINT `FK_Relationship_5` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FK_Relationship_6` FOREIGN KEY (`news_id`) REFERENCES `news` (`news_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `comments` */

insert  into `comments`(`comments_id`,`user_id`,`news_id`,`comments`,`createtime`,`updatetime`) values (5,3,4,'进商场买东西','2020-03-15 11:25:04','2020-03-15 11:25:19'),(7,4,2,'轮滑场在哪儿呢','2020-03-15 11:26:37',NULL),(9,4,4,'商城的东西页太多了吧','2020-03-15 11:27:16',NULL);

/*Table structure for table `finance` */

DROP TABLE IF EXISTS `finance`;

CREATE TABLE `finance` (
  `finance_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `club_id` bigint(20) DEFAULT NULL,
  `finance_count` double DEFAULT NULL,
  `income` double DEFAULT NULL,
  `expend` double DEFAULT NULL,
  `finance_desc` varchar(100) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatetiem` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`finance_id`),
  KEY `FK_Relationship_7` (`club_id`),
  CONSTRAINT `FK_Relationship_7` FOREIGN KEY (`club_id`) REFERENCES `clubs` (`club_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `finance` */

insert  into `finance`(`finance_id`,`club_id`,`finance_count`,`income`,`expend`,`finance_desc`,`createtime`,`updatetiem`) values (2,1,1900,0,100,'买东西','2020-03-16 11:36:08',NULL),(3,3,2300,600,200,'拉赞助办活动','2020-03-16 11:37:24',NULL),(4,4,3000,0,500,'远行','2020-03-16 11:37:35','2020-03-16 11:37:54'),(5,3,NULL,0,200,'测试','2020-04-20 08:26:36',NULL),(7,3,NULL,100,50.02,'测试','2020-04-20 08:29:11',NULL),(9,3,NULL,451,658,'测试','2020-04-20 08:33:11',NULL),(11,3,NULL,1000,325,'测试','2020-04-20 08:40:23',NULL);

/*Table structure for table `group_applications` */

DROP TABLE IF EXISTS `group_applications`;

CREATE TABLE `group_applications` (
  `group_application_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity_id` bigint(20) DEFAULT NULL,
  `group_application_type` tinyint(1) DEFAULT NULL,
  `group_application_desc` varchar(100) DEFAULT NULL,
  `group_application_status` tinyint(1) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatetime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`group_application_id`),
  KEY `FK_Relationship_17` (`activity_id`),
  CONSTRAINT `FK_Relationship_17` FOREIGN KEY (`activity_id`) REFERENCES `activities` (`activity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `group_applications` */

insert  into `group_applications`(`group_application_id`,`activity_id`,`group_application_type`,`group_application_desc`,`group_application_status`,`createtime`,`updatetime`) values (1,1,0,'申请描述',0,'2020-03-13 17:55:24','2020-03-15 11:06:07'),(2,2,0,'申请描述',1,'2020-03-13 17:55:54','2020-03-14 22:41:39'),(3,5,0,'申请描述',2,'2020-04-21 16:41:05','2020-05-20 13:09:14'),(4,6,0,NULL,1,'2020-04-21 16:41:19','2020-05-21 08:43:14');

/*Table structure for table `news` */

DROP TABLE IF EXISTS `news`;

CREATE TABLE `news` (
  `news_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `club_id` bigint(20) DEFAULT NULL,
  `news_title` varchar(20) DEFAULT NULL,
  `news_content` text,
  `news_link` varchar(50) DEFAULT NULL,
  `news_status` tinyint(1) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatetime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`news_id`),
  KEY `FK_Relationship_4` (`club_id`),
  CONSTRAINT `FK_Relationship_4` FOREIGN KEY (`club_id`) REFERENCES `clubs` (`club_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `news` */

insert  into `news`(`news_id`,`club_id`,`news_title`,`news_content`,`news_link`,`news_status`,`createtime`,`updatetime`) values (2,3,'一起轮滑','一起轮滑吧',NULL,1,'2020-03-15 11:21:01','2020-05-17 22:15:25'),(4,6,'商城','商城',NULL,1,'2020-03-15 11:23:05','2020-05-17 22:15:26'),(5,3,'测试','新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻',NULL,1,'2020-03-30 21:18:26','2020-05-20 13:09:56'),(6,4,'测试','新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻',NULL,1,'2020-03-30 21:18:54','2020-05-20 13:09:49'),(7,4,'测试2','新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻',NULL,1,'2020-03-30 21:20:02','2020-05-20 13:09:40'),(8,3,'测试','<p>欢迎编写新闻，图片最多允许9张</p><p><br></p>',NULL,1,'2020-05-17 20:48:15','2020-05-18 21:56:46'),(10,3,'宇宙之美','<p>欢迎编写新闻，图片最多允许9张</p><p><img src=\"/static/upload/e01b5c4b-116c-421d-801c-3dfedffae9ec.png\" style=\"max-width:100%;\"><br></p>',NULL,1,'2020-05-18 06:46:35','2020-05-20 12:23:17'),(11,3,'新闻1','<p><span style=\"font-size: 1rem;\">有时候，你得停一下脚步，等一等心灵，让心情平和，想一想自己生活中拥有的所有美好的东西。</span></p><p><img src=\"/static/upload/953ccce9-2d31-4274-b1b0-b62ffe628c77.jpg\" style=\"max-width:100%;\"><span style=\"font-size: 1rem;\"><br></span></p><p>心情的颜色是活泼热烈的红色，是生机盎然的绿色，是尊贵华丽的黄色，好好地，用这种种颜色做心情，来书写生活，不要让它变得灰暗……&nbsp;&nbsp;<br></p><p>一个能从别人的观念来看事情，能了解别人心灵活动的人，永远不必为自己的前途担心。</p><p><img src=\"/static/upload/128a04e1-29a0-4809-8f6a-1c6a586af4af.jpg\" style=\"font-size: 1rem; max-width: 100%;\">&nbsp;&nbsp;<br></p><p>过一平衡的生活，是那么的不容易!容易的，不是平衡的生活;而是堕落!虽然社会不允许我们平衡，我们有何必要平衡呢?还不如堕落吗?呵呵不是的!我们因该更加自信的面对现实生活，更加努力去追求人生的路途;这样才会让自己现在的生活变得更好，更精彩，更美!&nbsp;&nbsp;<img src=\"/static/upload/6115b87f-f1db-41b8-9425-4f41a8a73df0.jpg\" style=\"font-size: 1rem; max-width: 100%;\"><br></p><p>善待自己，不被别人左右，也不去左右别人，自信优雅。如果做一粒尘埃，就用飞舞诠释生命的内涵;如果是一滴雨，就倾尽温柔滋润大地。人生多磨难，要为自己鼓掌，别让犹豫阻滞了脚步，别让忧伤苍白了心灵。&nbsp;&nbsp;<br></p>',NULL,1,'2020-05-20 18:59:49',NULL),(21,3,'新闻2','<p>倘若把生活比作河流，随波逐流的现代人，大部分生活在河流的表层。日子过得不错，看上去很美，其实似是而非，没有寻找生活深度的时间和耐心，不能从生活中为自己找到良性刺激。所以并不快乐，内心反倒空虚。&nbsp;&nbsp;<br></p><p><img src=\"/static/upload/d2fad4e0-afb7-4882-bb6e-da5b310fa1f9.jpg\" style=\"max-width:100%;\"><br></p><p>如果有人钟爱着一朵独一无二的、盛开在浩瀚星海里的花。那么，当他抬头仰望繁星时，便会心满意足。他会告诉自己：“我心爱的花在那里，在那颗遥远的星星上。”可是，如果羊把花吃掉了。那么，对他来说，所有的星光变会在刹那间暗淡无光!而你却认为这并不重要!&nbsp;&nbsp;<br></p><p><img src=\"/static/upload/63cf8561-e135-4a09-a535-6e56656b56a6.jpg\" style=\"max-width:100%;\"><br></p><p>小王子：我那时什么也不懂!我应该根据她的行为，而不是根据她的话来判断她。她香气四溢，让我的生活更加芬芳多彩，我真不该离开她的...我早该猜到，在她那可笑的伎俩后面是缱绻柔情啊。花朵是如此的天真无邪!可是，我毕竟是太年轻了，不知该如何去爱她。&nbsp;&nbsp;<br></p><p><br></p>',NULL,1,'2020-05-20 19:57:48',NULL),(22,3,'新闻3','<p>玫瑰花：哦，如果我想跟蝴蝶交朋友的话，当然就得忍耐两三只毛毛虫的拜访咯。我听说蝴蝶长的很漂亮。况且，如果没有蝴蝶，没有毛毛虫，还会有谁来看我呢?你离我那么远...至于大动物，我才不怕呢，我有我的力爪啊。&nbsp;&nbsp;<br></p><p><img src=\"/static/upload/a125bedf-6a6b-45ed-8481-f214f357635d.jpg\" style=\"max-width:100%;\"><br></p><p><br></p>',NULL,1,'2020-05-20 19:58:37',NULL),(23,3,'新闻4','<p>狐狸说：“对我而言，你只不过是个小男骇，就像其他千万个小男孩一样。我不需要你，你也同样用不着我。对你来说。我也只不过是只狐狸，就跟其他 千万只狐狸一样。然而，如果你驯养我。我们将会彼此需要，对我而言，你将是宇宙唯一的了，我对你来说，也是世界上唯一的了。&nbsp;&nbsp;<br></p><p><img src=\"/static/upload/8c04bed3-b046-45df-bce8-09e30ae90c38.jpg\" style=\"max-width:100%;\"><br></p><p>狐狸：如果你驯养我，那我的生命就充满阳光，你的脚步声会变得跟其他人的不一样。其他人的脚步声会让我迅速躲到地底下，而你的脚步声则会像音乐一样，把我召唤出洞穴。&nbsp;&nbsp;<br></p><p><img src=\"/static/upload/8f01c835-fee8-4b34-8c41-ac50bea029cd.jpg\" style=\"max-width:100%;\"><br></p><p>狐狸：你看，看到那边的麦田了吗?我不吃面包，麦子对我来说一点意义也没有，麦田无法让我产生联想，这实在可悲。但是，你有一头金发，如果你驯养我，那该有多么美好啊!金黄色的麦子会让我想起你，我也会喜欢听风在麦穗间吹拂的声音。&nbsp;&nbsp;<br></p><p><img src=\"/static/upload/1966e968-7277-46a5-99d8-7c0c45ac3874.jpg\" style=\"max-width:100%;\"><br></p><p>“你只能了解你驯养的东西。”狐狸说，“人类不再有时间去了解事情了，他们总是到商店里买现在的东西。但是，却没有一家商店贩卖友谊，所以人类没有真正的朋友，如果你不需要一个朋友，就驯养我吧!”&nbsp;&nbsp;<br></p><p><img src=\"/static/upload/63c0b27d-77be-4575-ac9a-5a9da17ca1eb.jpg\" style=\"max-width:100%;\"><br></p><p>好光阴应该是这样吧：一分一秒都过到了心里去，喜悦悦，暖洋洋，不嫌浪费，不嫌有悲有喜有惆怅，甚至喜欢那凡尘中小小的烦恼，喜欢那生活里必要的瑕疵。&nbsp;&nbsp;<br></p><p><img src=\"/static/upload/a71c4251-13cc-4434-9779-2dceac69ecaf.png\" style=\"max-width:100%;\"><br></p>',NULL,1,'2020-05-20 20:01:07',NULL);

/*Table structure for table `notices` */

DROP TABLE IF EXISTS `notices`;

CREATE TABLE `notices` (
  `notices_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `club_id` bigint(20) DEFAULT NULL,
  `notices_title` varchar(20) DEFAULT NULL,
  `notices_content` varchar(200) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatetime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`notices_id`),
  KEY `FK_Relationship_8` (`club_id`),
  CONSTRAINT `FK_Relationship_8` FOREIGN KEY (`club_id`) REFERENCES `clubs` (`club_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `notices` */

insert  into `notices`(`notices_id`,`club_id`,`notices_title`,`notices_content`,`createtime`,`updatetime`) values (1,1,'1','公告1','2020-04-20 08:49:36','2020-04-20 21:23:33'),(2,1,'1','公告2','2020-04-20 08:50:32','2020-04-20 21:23:35'),(3,3,'2','公告3','2020-04-20 08:50:43','2020-04-20 21:23:36'),(4,3,'27','公告4','2020-04-20 08:50:55','2020-04-20 21:23:38'),(5,3,'75','公告5','2020-04-20 08:51:10','2020-04-20 21:23:40'),(6,3,'757','公告6fefegefoeihguoergh','2020-04-20 08:51:23','2020-04-21 13:38:29'),(8,3,'5759','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试','2020-04-20 21:11:11','2020-04-20 21:23:47'),(9,3,'20200302活动','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试','2020-04-20 21:30:21',NULL);

/*Table structure for table `places` */

DROP TABLE IF EXISTS `places`;

CREATE TABLE `places` (
  `place_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `place_status` tinyint(1) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatetime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`place_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `places` */

insert  into `places`(`place_id`,`name`,`place_status`,`createtime`,`updatetime`) values (1,'明理楼A203',0,'2020-03-13 17:40:35',NULL),(2,'明德楼b103',0,'2020-03-13 17:40:57',NULL),(3,'思学楼C105',0,'2020-03-13 17:41:41',NULL),(4,'其它',0,'2020-03-13 17:43:14','2020-03-13 21:14:10');

/*Table structure for table `user_activity` */

DROP TABLE IF EXISTS `user_activity`;

CREATE TABLE `user_activity` (
  `user_id` bigint(20) NOT NULL,
  `activity_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`activity_id`),
  KEY `FK_Relationship_11` (`activity_id`),
  CONSTRAINT `FK_Relationship_10` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FK_Relationship_11` FOREIGN KEY (`activity_id`) REFERENCES `activities` (`activity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_activity` */

insert  into `user_activity`(`user_id`,`activity_id`) values (14,14);

/*Table structure for table `user_club` */

DROP TABLE IF EXISTS `user_club`;

CREATE TABLE `user_club` (
  `club_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`club_id`,`user_id`),
  KEY `FK_Relationship_2` (`user_id`),
  CONSTRAINT `FK_Relationship_1` FOREIGN KEY (`club_id`) REFERENCES `clubs` (`club_id`),
  CONSTRAINT `FK_Relationship_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_club` */

insert  into `user_club`(`club_id`,`user_id`) values (1,1),(3,1),(5,1),(1,2),(3,2),(1,3),(3,3),(4,3),(5,3),(3,4),(5,4),(3,5),(3,9),(3,11),(1,14),(3,14);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_email` varchar(20) DEFAULT NULL,
  `user_phone` varchar(20) DEFAULT NULL,
  `user_password` varchar(20) DEFAULT NULL,
  `user_name` varchar(10) DEFAULT NULL,
  `user_img` varchar(30) DEFAULT NULL,
  `real_name` varchar(10) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `number` varchar(15) DEFAULT NULL,
  `college` varchar(10) DEFAULT NULL,
  `major` varchar(10) DEFAULT NULL,
  `user_status` tinyint(1) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatetime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`user_id`,`user_email`,`user_phone`,`user_password`,`user_name`,`user_img`,`real_name`,`sex`,`number`,`college`,`major`,`user_status`,`createtime`,`updatetime`) values (1,'1514564@qq.com','15895684891','123456','测试',NULL,'测试','男','201653542658','石油与天然气工程学院','海洋油气工程',1,'2020-03-15 11:15:29','2020-04-10 15:14:34'),(2,'489455655@qq.com','13984759572','123456','测试',NULL,'测试','女','2016354895','测试','测试',1,'2020-03-15 11:16:56',NULL),(3,'5659165658@qq.com','15895485428','123456','测试',NULL,'测试','男','201635489','测试','测试',1,'2020-03-15 11:17:41','2020-04-10 16:31:52'),(4,'7949944@qq.com','13648859726','123456','测试',NULL,'测试','女','201764894598','地球科学与技术学院','资源勘查工程',1,'2020-03-15 11:18:17','2020-04-10 16:31:54'),(5,'ceshi@qq.com','13987548654','123456',NULL,NULL,'zhang','男','201658764851','地球科学与技术学院','地理信息科学',1,'2020-04-10 09:28:23',NULL),(9,'ceshi2@qq.com','13602565486','123456',NULL,NULL,'liu','男','201635621587','石油与天然气工程学院','石油工程',1,'2020-04-10 14:58:16','2020-04-10 16:31:59'),(10,'789456@qq.com','13984759572','123456','checl',NULL,'李四','男','201631063235','计算机科学学院','网络工程2016级',1,'2020-05-08 08:54:26',NULL),(11,'7894556@qq.com','13984759572','123456','0001',NULL,'测试','男','201956849785','计算机科学学院','网络工程',1,'2020-05-08 08:59:01',NULL),(12,'78946356@qq.com','13984759572','123456','123',NULL,'测试','男','201956849765','计算机科学学院','网络工程2016级',1,'2020-05-08 09:01:00',NULL),(13,'789459656@qq.com','13984759572','123456','0001',NULL,'李四','男','201631053235','计算机科学学院','网络工程2016级',1,'2020-05-08 09:03:14',NULL),(14,'78945693@qq.com','13984759572','1234567','测试修改昵称',NULL,'普通用户','女','201631053235','计算机科学学院','网络工程2016级',1,'2020-05-08 09:05:34','2020-06-02 19:08:37');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
