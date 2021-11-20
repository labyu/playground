#!/bin/bash

docker-compose exec kafka /kafka/bin/kafka-topics.sh -zookeeper zookeeper:2181 -list

#docker-compose exec kafka /kafka/bin/kafka-console-consumer.sh \
#    --bootstrap-server kafka:9092 \
#    --from-beginning \
#    --property print.key=true \
#    --topic cdc-mysql.springddd.posts
