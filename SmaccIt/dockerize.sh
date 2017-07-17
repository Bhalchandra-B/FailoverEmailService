#!/bin/bash
mvn clean install
docker build -t smaccit .
echo to run just docker run -p 8080:8080 smaccit
