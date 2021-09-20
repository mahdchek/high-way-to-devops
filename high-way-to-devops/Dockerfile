FROM ubuntu
MAINTAINER Mahdi CHEKINI <me.chekini@gmail.com>
RUN apt-get update && apt-get install openjdk-11-jdk vim curl -y
WORKDIR /opt
ADD target/high-way-to-devops-*.jar high-way-to-devops.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/high-way-to-devops.jar"]
