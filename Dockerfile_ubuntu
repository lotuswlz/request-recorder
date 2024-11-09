FROM registry.access.redhat.com/ubi8/openjdk-17
LABEL authors="wlz"

WORKDIR /application
COPY ./target/request-monitor-server-1.0.jar /application/app.jar

CMD ["java", "-jar", "/application/app.jar"]