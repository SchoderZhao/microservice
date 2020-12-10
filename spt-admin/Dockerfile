FROM openjdk:8u212-jre
MAINTAINER Schoder

COPY ./target/spt-admin-1.1-RELEASE.jar /spt/spt-admin-1.1-RELEASE.jar
ADD agent/ /agent

ENTRYPOINT ["java", "-javaagent:/agent/skywalking-agent.jar", "-Dskywalking.agent.service_name=spt-admin", "-Dskywalking.collector.backend_service=skywalkingIp:11800", "-jar", "/spt/spt-admin-1.1-RELEASE.jar"]