FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 9091
ADD ./build/libs/catalogue-spring-boot-docker-0.1.0.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]