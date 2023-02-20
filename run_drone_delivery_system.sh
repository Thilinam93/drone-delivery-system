#!/bin/bash
mvn clean install -DskipTests
cd target/ || exit
java -jar drone-delivery-system-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev
#java -jar drone-delivery-system-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod