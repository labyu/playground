#!/bin/bash


docker-compose exec mysql bash -c 'echo "GRANT SELECT, RELOAD, SHOW DATABASES, REPLICATION SLAVE, REPLICATION CLIENT ON *.* TO '"'"'debezium'"'"' IDENTIFIED BY '"'"'dbz'"'"';" > /tmp/grant.sql'
docker-compose exec mysql bash -c 'cat /tmp/grant.sql'
docker-compose exec mysql bash -c 'mysql -uroot -ppassword < /tmp/grant.sql'

SLEEP 5

curl -i -X POST -H "Accept:application/json" -H  "Content-Type:application/json" http://localhost:8083/connectors/ -d '{
    "name": "mysql-connector",
    "config": {
        "connector.class": "io.debezium.connector.mysql.MySqlConnector",
        "database.hostname": "mysql",
        "database.port": "3306",
        "database.user": "debezium",
        "database.password": "dbz",
        "database.server.id": "666",
        "database.serverTimezone": "Asia/Seoul",
        "database.server.name": "cdc-mysql",
        "database.allowPublicKeyRetrieval":"true",
        "database.history.kafka.bootstrap.servers": "kafka:9092",
        "database.history.kafka.topic": "schema-change.cdc-mysql",
        "include.schema.changes": "true",
        "table.whitelist": "springddd.users, springddd.posts"
    }
}'

SLEEP 5

curl http://localhost:8083/connectors/mysql-connector/status

