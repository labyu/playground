#!/bin/bash

bin/zookeeper-server-start.sh -daemon config/zookeeper.properties
bin/kafka-server-start.sh -daemon ${KAFKA_BROKER_SERVER_PROPERTIES}
tail -f logs/server.log