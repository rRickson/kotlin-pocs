FROM maven:3.9.4-amazoncorretto-20-al2023 as build

COPY . /home/maven/src
WORKDIR /home/maven/src
RUN mvn package

FROM amazoncorretto:20.0.2-alpine3.17
EXPOSE 8080:8080
RUN mkdir /app
COPY --from=build /home/maven/src/target/*-with-dependencies.jar /app/docker-sample.jar
ENTRYPOINT ["java","-jar","/app/docker-sample.jar"]