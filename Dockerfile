FROM openjdk:17
FROM gradle:8.4.0-jdk17
COPY . /project
WORKDIR /project
RUN ./gradlew run
CMD ["java", "ZodiacProjectApplication"]
