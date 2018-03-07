-- demo样例db语句
-- 功能说明：
/*
db库tcc_demo_db1与tcc_demo_db2
分布式事务流程如下：
在tcc_demo_db1库中tcc_t1与tcc_demo_db2中tcc_t2
中分别插入记录，t2中保留t1中的唯一号
 */

CREATE DATABASE `tcc_demo_db1`;
USE `tcc_demo_db1`;
CREATE TABLE tcc_t1 (
  `t1_id` INT PRIMARY KEY AUTO_INCREMENT,
  `uniq_no` CHAR(32) NOT NULL ,
  `status` TINYINT NOT NULL COMMENT '0:init ; 1:trying ; 2:confirm ; 3:cancel'
);

CREATE DATABASE `tcc_demo_db2`;
USE `tcc_demo_db2`;
CREATE TABLE tcc_t2 (
  `t2_id` INT PRIMARY KEY AUTO_INCREMENT,
  `uniq_no` CHAR(32) NOT NULL ,
  `status` TINYINT NOT NULL COMMENT '0:init ; 1:trying ; 2:confirm ; 3:cancel'
);