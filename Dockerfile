FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/smokies-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 9090
RUN echo $(ls -1 /usr/src/app)

ENTRYPOINT ["java","-jar","app.jar"]