CREATE DATABASE /*!32312 IF NOT EXISTS*/`test01` /*!40100 DEFAULT CHA
RACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENC
RYPTION='N' */;
USE `test01`;
/*Table structure for table `user` */
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `username` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
                        `address` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8
mb4_general_ci;
/*Data for the table `user` */
insert into `user`(`id`,`username`,`address`) values (1,'javaboy123
','www.javaboy.org'),(3,'javaboy','spring.javaboy.org'),(4,'张三','深 圳'),(5,'李四','广州'),(6,'王五','北京');