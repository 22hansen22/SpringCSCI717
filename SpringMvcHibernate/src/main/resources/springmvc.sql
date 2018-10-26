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

DROP TABLE `exit_ticket`;

CREATE TABLE `exit_ticket` (
  ticket_id int(11) NOT NULL AUTO_INCREMENT,
  title varchar(50) NOT NULL,
  dateET date NOT NULL,
  PRIMARY KEY (ticket_id)
);

INSERT INTO `exit_ticket` (ticket_id, title, dateET) VALUES (1, 'Class exit Ticket#1','2018.10.26' );
INSERT INTO `exit_ticket` (ticket_id, title, dateET) VALUES (2, 'Class exit Ticket#2','2018.10.26');
SELECT * FROM `exit_ticket`;

________________________________

USE springmvc;

DROP TABLE `userET`;

CREATE TABLE `userET` (
  answerId int NOT NULL,
  user_id int NOT NULL,
  ticket_id int NOT NULL,
  answer varchar(50) NOT NULL,
  dateAnswer date,
  PRIMARY KEY (answerId), 
  FOREIGN KEY (user_id) REFERENCES user(user_id),
  FOREIGN KEY (ticket_id) REFERENCES exit_ticket(ticket_id)
);

INSERT INTO `userET` (answerId, user_id, ticket_id, answer, dateAnswer) VALUES (1,1,1, 'Answer to ticket 1 by user 1','2018.10.26' );
INSERT INTO `userET` (answerId, user_id, ticket_id, answer, dateAnswer) VALUES (2,1,2, 'Answer to ticket 2 by user 1','2018.10.26' );
INSERT INTO `userET` (answerId, user_id, ticket_id, answer, dateAnswer) VALUES (3,2,1, 'Answer to ticket 1 by user 2','2018.10.26' );
INSERT INTO `userET` (answerId, user_id, ticket_id, answer, dateAnswer) VALUES (4,2,2, 'Answer to ticket 2 by user 2','2018.10.26' );
INSERT INTO `userET` (answerId, user_id, ticket_id, answer, dateAnswer) VALUES (5,3,2, 'Answer to ticket 2 by user 2','2018.10.26' );
SELECT * FROM `userET`;