FROM hello-world

RUN mkdir app
COPY  demo-pvc/build/lib/demo-pvc.jar /app
WORKDIR  /app
RUN java -jar demo-pvc.jar