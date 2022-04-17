FROM openjdk:11-jdk

EXPOSE 8080

ADD ./build/libs/*-1.0.jar app.jar

ENTRYPOINT ["java","-jar","-Dspring.profiles.active=docker","/app.jar"]