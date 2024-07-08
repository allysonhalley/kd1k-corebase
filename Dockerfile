FROM maven:3.6.3-openjdk-17
LABEL authors="allysonhalley"

WORKDIR /api
COPY . .
RUN mvn clean package -Dmaven.test.skip

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/random","-jar", "/app.jar"]