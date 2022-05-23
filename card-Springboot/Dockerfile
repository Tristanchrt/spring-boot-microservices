FROM openjdk:11

EXPOSE 8081

COPY target/SPWebApp-0.0.1-SNAPSHOT.jar .

ARG JAR_FILE=target/SPWebApp-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} SPWebApp-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","./SPWebApp-0.0.1-SNAPSHOT.jar"]