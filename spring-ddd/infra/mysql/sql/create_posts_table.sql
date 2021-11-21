DROP TABLE IF EXISTS `posts`;
CREATE TABLE `posts` (
                         `post_id` BIGINT NOT NULL AUTO_INCREMENT,
                         `author_user_id` BIGINT NOT NULL,
                         `title` VARCHAR(100) NOT NULL,
                         `description` VARCHAR(2000) NOT NULL,
                         `created_at` DATETIME,
                         PRIMARY KEY(`post_id`)
);

INSERT INTO `posts` (post_id, author_user_id, title, description, created_at) VALUES
(1, 1, '테스트 제목1', '테스트 본문', '2021-11-21 10:00:00'),
(2, 3, '테스트 제목1', '테스트 본문', '2021-11-21 10:00:00'),
(3, 5, '테스트 제목1', '테스트 본문', '2021-11-21 10:00:00'),
(4, 4, '테스트 제목1', '테스트 본문', '2021-11-21 10:00:00'),
(5, 2, '테스트 제목1', '테스트 본문', '2021-11-21 10:00:00'),
(6, 3, '테스트 제목1', '테스트 본문', '2021-11-21 10:00:00'),
(7, 3, '테스트 제목1', '테스트 본문', '2021-11-21 10:00:00'),
(8, 1, '테스트 제목1', '테스트 본문', '2021-11-21 10:00:00'),
(9, 1, '테스트 제목1', '테스트 본문', '2021-11-21 10:00:00');

