#!/usr/bin/env bash
mvn package

docker build -t spt-server-healthrecord .