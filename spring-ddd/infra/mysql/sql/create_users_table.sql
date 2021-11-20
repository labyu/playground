DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
                         `user_id` BIGINT NOT NULL AUTO_INCREMENT,
                         `email` VARCHAR(100) NOT NULL,
                         `name` VARCHAR(20) NOT NULL,
                         `introduction` VARCHAR(255),
                         PRIMARY KEY(`user_id`)
);

INSERT INTO `users` (user_id, email, name, introduction) VALUE
(1, 'test1@test.com', '이렐리아', '안녕하세요'),
(2, 'test2@test.com', '아칼리', '안녕하세요'),
(3, 'test3@test.com', '카밀', NULL),
(4, 'test4@test.com', '제이스', '안녕하세요'),
(5, 'test5@test.com', '말파이트', '안녕하세요');

