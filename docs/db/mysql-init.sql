-- 创建数据库
create database jpaency;

-- 使用数据库
use jpaency;

-- 创建表
CREATE TABLE USR
(
 id INT NOT NULL COMMENT '主键',
 name varchar(30) NOT NULL COMMENT '姓名',
 PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 插入数据
INSERT INTO USR(ID,NAME) VALUES(1,'刘备') ;
INSERT INTO USR(ID,NAME) VALUES(2,'关羽') ;
INSERT INTO USR(ID,NAME) VALUES(3,'张飞') ;