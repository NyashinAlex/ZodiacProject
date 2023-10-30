FROM openjdk:17
FROM gradle:8.4.0-jdk17
COPY . /project
WORKDIR /project
EXPOSE 1111
RUN ./gradlew run
CMD ["java", "ZodiacProjectApplication"]
