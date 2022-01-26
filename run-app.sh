#!/usr/bin/env bash
mvn clean package -DskipTests

docker build -t muratavci/todoapp .
docker run -p 8080:8080 -t muratavci/todoapp