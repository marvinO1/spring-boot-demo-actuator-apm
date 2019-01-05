# spring-boot-demo-actuator
Spring-Boot Actuator Example with kibana APM agent
* [Open Source Application Performance Monitoring](https://www.elastic.co/solutions/apm)



# Docker
```
docker image build -t marvino1/spring-boot-demo-actuator-apm .
docker container run -d --name spring-8080 -p 8080:8080 marvino1/spring-boot-demo-actuator-apm
docker container run -d --name spring-8081 -p 8081:8080 marvino1/spring-boot-demo-actuator-apm
```
