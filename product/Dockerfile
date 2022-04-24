FROM openjdk:11-jdk

EXPOSE 8080

ARG PROJECT_DIRECTORY=/build

WORKDIR %PROJECT_DIRECTORY

ENTRYPOINT ["java","-jar","-Dspring.profiles.active=docker","/build/app.jar"]