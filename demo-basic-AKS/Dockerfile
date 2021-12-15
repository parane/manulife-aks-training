FROM gradle:6.9.1-jdk8 AS build

COPY --chown=gradle:gradle . /home/gradle/src

WORKDIR /home/gradle/src

RUN cd /home/gradle/src/app

RUN gradle build --no-daemon 

FROM openjdk:8-jre-slim

EXPOSE 8080

RUN mkdir /app

COPY --from=build /home/gradle/src/app/build/libs/*.jar /app/spring-boot-application.jar

COPY /app/applicationinsights-agent-3.2.3.jar /app/applicationinsights-agent-3.2.3.jar

COPY /app/applicationinsights.json /app/applicationinsights.json 

ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/spring-boot-application.jar", "-javaagent:app/applicationinsights-agent-3.2.3.jar"]