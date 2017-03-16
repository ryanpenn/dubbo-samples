-- create database
CREATE DATABASE db_shop;
USE db_shop;

-- drop table
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS tb_user;
DROP TABLE IF EXISTS tb_product;
DROP TABLE IF EXISTS tb_order;
DROP TABLE IF EXISTS tb_order_product;
DROP TABLE IF EXISTS tb_user_order;

-- create table
CREATE TABLE tb_user (
  id              INT          NOT NULL AUTO_INCREMENT,
  login_name      VARCHAR(100) NOT NULL,
  password        VARBINARY(128)        DEFAULT NULL,
  nickname        VARCHAR(50)           DEFAULT NULL,
  email           VARCHAR(100)          DEFAULT NULL,
  last_login_time TIMESTAMP             DEFAULT CURRENT_TIMESTAMP,
  register_date   TIMESTAMP             DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  UNIQUE KEY (login_name)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE tb_product (
  id              INT           NOT NULL AUTO_INCREMENT,
  name            VARCHAR(1000) NOT NULL,
  price           FLOAT                  DEFAULT 0.0,
  production_date DATE,
  factory         VARCHAR(1000)          DEFAULT NULL,
  stock           INT,
  creation_date   TIMESTAMP              DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE tb_order (
  id            INT NOT NULL  AUTO_INCREMENT,
  status        INT NOT NULL,
  buyerId       INT NOT NULL,
  orderTime     TIMESTAMP     DEFAULT CURRENT_TIMESTAMP,
  receiver      VARCHAR(1000) DEFAULT NULL,
  amount        DOUBLE        DEFAULT 0,
  creation_date TIMESTAMP     DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  KEY (buyerId)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE tb_order_product (
  order_id   INT NOT NULL,
  product_id INT NOT NULL,
  KEY (order_id),
  KEY (product_id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE tb_user_order (
  user_id  INT NOT NULL,
  order_id INT NOT NULL,
  KEY (user_id),
  KEY (order_id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- init data
-- MySQL一些常用的时间函数: https://my.oschina.net/sallency/blog/470370
INSERT INTO tb_user (login_name, password, nickname, email, last_login_time, register_date)
VALUES ('test01', '123', 'tom', 'tom@qq.com', now(), '2016/12/08 13:01:45'),
  ('test02', '123', '购物狂', 'buy@taobao.com', now(), current_timestamp()),
  ('test03', '123', '❤shopping', 'shopping@jd.com', now(), current_timestamp());

INSERT INTO tb_product (name, price, production_date, factory, stock, creation_date)
VALUES ('米家（MIJIA）【小米】小米米家电动滑板车 白色', 1979.0, '2016/01/28', '小米', 100, '2016/03/08 09:11:21'),
  ('智能电动剃须刀 全身水洗刮胡刀', 203.0, '2016/01/28', '飞利浦', 99, '2016/03/08 09:11:21'),
  ('华为 畅享5S 金色 移动联通电信4G手机 双卡双待', 899.0, curdate(), '华为', 99, '2016/03/08 09:11:21');

-- 待出库(1)/待发货(2)/已发货(3)/买家已收货(4)/已取消(5)
INSERT INTO tb_order (status, buyerId, orderTime, receiver, amount, creation_date)
VALUES (1, 1, current_timestamp(), '北京市海淀区苏州街20号院银丰大厦2号楼', 203.0 + 899.0, current_timestamp());

INSERT INTO tb_order_product (order_id, product_id) VALUES (1, 2), (1, 3);

INSERT INTO tb_user_order (user_id, order_id) VALUES (1, 1);

SET FOREIGN_KEY_CHECKS = 1;