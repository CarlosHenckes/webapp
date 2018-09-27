FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8097
ARG JAR_FILE=target/webapp-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} webapp.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/webapp.jar"]