CREATE DATABASE springmvc;

CREATE TABLE `user` (
  user_id int(11) NOT NULL AUTO_INCREMENT,
  user_name varchar(50) NOT NULL,
  user_password varchar(50) NOT NULL,
  PRIMARY KEY (user_id)
);

INSERT INTO `user` (user_id, user_name, user_password) VALUES (1, 'admin', 'admin@1234');
INSERT INTO `user` (user_id, user_name, user_password) VALUES (2, 'user123', 'user@123');
___________________________________________________________________________

USE springmvc;

DROP TABLE `user`;

CREATE TABLE `user` (
  user_id int(11) NOT NULL AUTO_INCREMENT,
  user_name varchar(50) NOT NULL,
  user_password varchar(50) NOT NULL,
  user_type varchar(50) NOT NULL,
  user_realname varchar(50) NOT NULL,
  PRIMARY KEY (user_id)
);

INSERT INTO `user` (user_id, user_name, user_password, user_type, user_realname) VALUES (1, 'a', 'a1', 'teacher', 'Enrique');
INSERT INTO `user` (user_id, user_name, user_password, user_type, user_realname) VALUES (2, 'u1', 'u1', 'student', 'Drew');
INSERT INTO `user` (user_id, user_name, user_password, user_type, user_realname) VALUES (3, 'u2', 'u2', 'student', 'Mary');
INSERT INTO `user` (user_id, user_name, user_password, user_type, user_realname) VALUES (4, 'u3', 'u3', 'student', 'Lauren');
INSERT INTO `user` (user_id, user_name, user_password, user_type, user_realname) VALUES (5, 'u4', 'u4', 'student', 'Jamie');
INSERT INTO `user` (user_id, user_name, user_password, user_type, user_realname) VALUES (6, 'u5', 'u5', 'student', 'Ben');
INSERT INTO `user` (user_id, user_name, user_password, user_type, user_realname) VALUES (7, 'u6', 'u6', 'student', 'Ganesh');
INSERT INTO `user` (user_id, user_name, user_password, user_type, user_realname) VALUES (8, 'u7', 'u7', 'student', 'Dan');
INSERT INTO `user` (user_id, user_name, user_password, user_type, user_realname) VALUES (9, 'u8', 'u8', 'student', 'Alyson');

SELECT * FROM `user`;
____________________________

USE springmvc;

DROP TABLE `exitTicket`;

CREATE TABLE `exitTicket` (
  ticket_id int(11) NOT NULL AUTO_INCREMENT,
  user_id int(11) NOT NULL,
  title varchar(50) NOT NULL,
  answer varchar(500) NOT NULL,
  PRIMARY KEY (ticket_id)
);

INSERT INTO `exitTicket` (ticket_id, user_id, title, answer) VALUES (1, 2, 'Class exti Ticket#1', '');
INSERT INTO `exitTicket` (ticket_id, user_id, title, answer) VALUES (2, 2, 'Class exti Ticket#2', '');
user
SELECT * FROM `exitTicket`;