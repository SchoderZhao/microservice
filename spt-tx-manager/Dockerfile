FROM openjdk:8u212-jre
MAINTAINER Schoder 

COPY ./target/spt-tx-manager-1.1-RELEASE.jar /spt/spt-tx-manager-1.1-RELEASE.jar
ADD agent/ /agent

ENTRYPOINT ["java", "-javaagent:/agent/skywalking-agent.jar", "-Dskywalking.agent.service_name=spt-tx-manager", "-Dskywalking.collector.backend_service=skywalkingIp:11800", "-jar", "/spt/spt-tx-manager-1.1-RELEASE.jar"]