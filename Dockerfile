FROM openjdk:23
LABEL authors="GermanAndres"
WORKDIR /app
COPY target/Curso-Microservice-0.0.1-SNAPSHOT.jar /app

ENTRYPOINT ["java", "-jar", "Curso-Microservice-0.0.1-SNAPSHOT.jar"]