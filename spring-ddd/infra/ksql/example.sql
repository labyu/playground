-- docker-compose exec ksql-cli ksql http://ksql-server:8088

-- 0
-- SET 'ksql.query.pull.table.scan.enabled' = 'true';
SET 'auto.offset.reset' = 'earliest';

--1
CREATE STREAM users_from_cdc (payload STRUCT<after STRUCT<user_id BIGINT, email VARCHAR, name VARCHAR, introduction VARCHAR>>) WITH (KAFKA_TOPIC='cdc-mysql.springddd.users', VALUE_FORMAT='json');
CREATE STREAM posts_from_cdc (payload STRUCT<after STRUCT<post_id BIGINT, author_user_id BIGINT, title VARCHAR, description VARCHAR, created_at VARCHAR>>) WITH (KAFKA_TOPIC='cdc-mysql.springddd.posts', VALUE_FORMAT='json');

-- 2
CREATE STREAM users_stream WITH (KAFKA_TOPIC='USERS_REPEAT', VALUE_FORMAT='json', PARTITIONS=1) AS SELECT payload->after->user_id AS user_id, payload->after->name AS name, payload->after->email AS email, payload->after->introduction AS introduction FROM users_from_cdc PARTITION BY payload->after->user_id;
CREATE STREAM posts_stream WITH (KAFKA_TOPIC='POSTS_REPEAT', VALUE_FORMAT='json', PARTITIONS=1) AS SELECT payload->after->post_id AS post_id, payload->after->author_user_id AS author_user_id, payload->after->title AS title, payload->after->description AS description, payload->after->created_at AS created_at FROM posts_from_cdc PARTITION BY payload->after->post_id;

-- 3
CREATE TABLE users (user_id BIGINT PRIMARY KEY, email VARCHAR, name VARCHAR, introduction VARCHAR) WITH (KAFKA_TOPIC='USERS_REPEAT', VALUE_FORMAT='json');

-- 4
CREATE STREAM feed_stream
WITH (KAFKA_TOPIC='FEED_STREAM', VALUE_FORMAT='json', PARTITIONS=1)
AS SELECT
    posts_stream.post_id AS post_id,
    posts_stream.title AS title,
    posts_stream.description AS description,
    posts_stream.created_at AS created_at,
    STRUCT(
        user_id := users.user_id,
        email := users.email,
        name := users.name,
        introduction := users.introduction
    ) AS author
FROM posts_stream JOIN users ON posts_stream.author_user_id = users.user_id
PARTITION BY post_id
EMIT CHANGES;
