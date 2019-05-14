#!/bin/sh

docker-compose down
mvn clean package
docker-compose build
docker-compose up

