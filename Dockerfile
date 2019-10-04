FROM openjdk:8
EXPOSE 8085
ADD target/Workshop-0.0.1-SNAPSHOT.war Workshop-0.0.1-SNAPSHOT.war
ENTRYPOINT["java","-war","Workshop-0.0.1-SNAPSHOT.war"]