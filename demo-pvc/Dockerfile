FROM openjdk:11

RUN mkdir app

EXPOSE 8080
COPY  ./app/build/libs/demo-pvc.jar /app
WORKDIR  /app

CMD java -jar demo-pvc.jar