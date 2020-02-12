DROP DATABASE IF EXISTS albums;
CREATE DATABASE albums;

USE albums;

DROP TABLE IF EXISTS album_scheduler_task;

CREATE TABLE album_scheduler_task (
  started_at TIMESTAMP NULL DEFAULT NULL
);

INSERT INTO album_scheduler_task (started_at) VALUES (NULL);


DROP TABLE IF EXISTS album;

CREATE TABLE album (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  artist varchar(255) DEFAULT NULL,
  rating int NOT NULL,
  title varchar(255) DEFAULT NULL,
  year int NOT NULL,
  PRIMARY KEY (id)
) ENGINE = innodb DEFAULT CHARSET = UTF8MB4;
