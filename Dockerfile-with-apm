FROM openjdk:8-alpine

WORKDIR .

COPY target/gs-spring-boot-0.1.0.jar gs-spring-boot-0.1.0.jar
COPY elastic-apm-agent-1.2.0.jar elastic-apm-agent-1.2.0.jar

CMD ["java", \
"-javaagent:elastic-apm-agent-1.2.0.jar", \
"-Delastic.apm.service_name=hello-application", \
"-Delastic.apm.server_url=http://localhost:8200", \
"-Delastic.apm.application_packages=hello", \
"-jar", "gs-spring-boot-0.1.0.jar", "--management.endpoints.web.exposure.include=*"]
