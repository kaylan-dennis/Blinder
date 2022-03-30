FROM debian:buster-slim

MAINTAINER tech-team <tech-team@wethinkcode.co.za>

RUN apt-get update
RUN apt-get install -y openjdk-11-jre curl

ADD blinder-server/target/blinder-server-1.0-SNAPSHOT.jar /srv/blinderserver.jar

WORKDIR /srv

EXPOSE 5000
ENTRYPOINT ["java", "-jar", "blinderserver.jar"]