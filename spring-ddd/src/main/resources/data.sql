CREATE TABLE `users` (
    `user_id` BIGINT NOT NULL AUTO_INCREMENT,
    `email` VARCHAR(100) NOT NULL,
    `name` VARCHAR(20) NOT NULL,
    `introduction` VARCHAR(255) NOT NULL,
    PRIMARY KEY(`user_id`)
);