FROM openjdk:8-alpine

WORKDIR .

COPY target/gs-spring-boot-0.1.0.jar gs-spring-boot-0.1.0.jar

CMD ["java", "-jar", "gs-spring-boot-0.1.0.jar", "--management.endpoints.web.exposure.include=*"]
