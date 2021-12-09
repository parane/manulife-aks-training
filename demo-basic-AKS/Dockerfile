FROM openjdk:11

RUN mkdir app

EXPOSE 8080
COPY  ./app/build/libs/app.jar /app
WORKDIR  /app

CMD java -jar app.jar