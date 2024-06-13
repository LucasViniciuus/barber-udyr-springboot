FROM openjdk:17-jdk-alpine
COPY target/udyrprojectv1-0.0.1-SNAPSHOT.jar udyrproject.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/udyrproject.jar"]
