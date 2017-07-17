FROM openjdk:8-jre
LABEL maintainer brbingewar@gmail.com
RUN mkdir /app
COPY target/smaccit-0.0.1-SNAPSHOT.jar /app
WORKDIR /app
EXPOSE 8080
CMD [ "java","-jar","smaccit-0.0.1-SNAPSHOT.jar"]
