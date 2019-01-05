# spring-boot-demo-actuator
Spring-Boot Actuator Example with kibana APM agent
* [Open Source Application Performance Monitoring](https://www.elastic.co/solutions/apm)


# Java
```
java -javaagent:elastic-apm-agent-1.2.0.jar -D"elastic.apm.service_name=my-application" -D"elastic.apm.server_url=http://localhost:8200" -D"elastic.apm.application_packages=hello" -jar target/gs-spring-boot-0.1.0.jar
```
# Docker
```
docker image build -t marvino1/spring-boot-demo-actuator-apm .
docker container run -d --name spring-8080 -p 8080:8080 marvino1/spring-boot-demo-actuator-apm
docker container run -d --name spring-8081 -p 8081:8080 marvino1/spring-boot-demo-actuator-apm
```
