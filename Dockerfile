FROM openjdk:22
LABEL maintainer="PedroJesuCrosPerez"
VOLUME /tmp
EXPOSE 8000
#ARG JAR_FILE=target/my-app-0.0.1-SNAPSHOT.jar
ARG JAR_FILE=target/project-0.0.1-SNAPSHOT.jar
#ARG JAR_FILE=$(ls target/*.jar | head -n 1)
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]