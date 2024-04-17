FROM openjdk:21-oracle
RUN "./gradlew build"

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]