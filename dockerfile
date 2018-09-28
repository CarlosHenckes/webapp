FROM openjdk:8-jdk-alpine

#FROM openjdk:10-jre-slim
COPY ./target/webapp-0.0.1-SNAPSHOT.jar /usr/src/hola/
WORKDIR /usr/src/hola
EXPOSE 8097
CMD ["java", "-jar", "webapp-0.0.1-SNAPSHOT.jar"]

#VOLUME /tmp
#EXPOSE 8097
#ARG JAR_FILE=target/webapp-0.0.1-SNAPSHOT.jar
#COPY ${JAR_FILE} webapp.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/webapp.jar"]