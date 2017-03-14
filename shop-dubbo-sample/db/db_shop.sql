
Create DATABASE db_shop;
USE db_shop;

DROP TABLE IF EXISTS tb_user;
CREATE TABLE tb_user (
  id char(32) NOT NULL,
  login_name varchar(30) DEFAULT NULL,
  password varchar(30) DEFAULT NULL,
  nickname varchar(30) DEFAULT NULL,
  email varchar(30) DEFAULT NULL,
  last_login_time TIMESTAMP DEFAULT NULL,
  register_date TIMESTAMP DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
