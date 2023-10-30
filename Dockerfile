FROM openjdk:17
FROM gradle:8.4.0-jdk17
COPY . /project
WORKDIR /project
EXPOSE 1111
RUN gradle run
CMD ["java", "ZodiacProjectApplication"]
