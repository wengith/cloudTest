CREATE DATABASE IF NOT EXISTS robot_db default charset utf8 COLLATE utf8_bin;
use robot_db;

DROP TABLE IF EXISTS demo_robot_job;
DROP TABLE IF EXISTS demo_robot_main;

CREATE TABLE demo_robot_main (
  id bigint not null auto_increment ,
  robot_sn varchar(80) NOT NULL,
  robot_height decimal(6,2) NOT NULL,
  nickname varchar(80) DEFAULT NULL,
  recharge_count int NOT NULL,
  manufacture_name varchar(255) NOT NULL,
  manufacture_date date NOT NULL,
  com_code varchar(8) NOT NULL,
  version int NOT NULL,
  Insert_Time_For_His datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  Operate_Time_For_His datetime DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB;
CREATE TABLE demo_robot_job (
  id bigint not null auto_increment ,
  robot_id bigint NOT NULL,
  start_time datetime NOT NULL,
  end_time datetime NOT NULL,
  walk_count bigint DEFAULT NULL,
  consume_energy decimal(10,4) DEFAULT NULL,
  job_content text NOT NULL,
  job_image blob,
  com_code varchar(8) NOT NULL,
  version int NOT NULL,
  Insert_Time_For_His datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  Operate_Time_For_His datetime DEFAULT NULL,
  PRIMARY KEY (id),
  KEY fk_robot_id (robot_id) USING BTREE,
  CONSTRAINT demo_robot_job_ibfk_1 FOREIGN KEY (robot_id) REFERENCES demo_robot_main (id)
) ENGINE=InnoDB;