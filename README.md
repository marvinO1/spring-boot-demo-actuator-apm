# spring-boot-demo-actuator
Spring-Boot Actuator Example with 
* enabled [prometheus metrics](https://prometheus.io/)
* kibana APM agent, [Open Source Application Performance Monitoring](https://www.elastic.co/solutions/apm)

# Java
```
java -javaagent:elastic-apm-agent-1.2.0.jar -D"elastic.apm.service_name=hello-application" -D"elastic.apm.server_url=http://localhost:8200" -D"elastic.apm.application_packages=hello" -jar target/gs-spring-boot-0.1.0.jar --management.endpoints.web.exposure.include=*
```
# Docker
```
docker image build -t marvino1/spring-boot-demo-actuator-apm .
docker container run -d --name spring-8080 -p 8080:8080 marvino1/spring-boot-demo-actuator-apm
docker container run -d --name spring-8081 -p 8081:8080 marvino1/spring-boot-demo-actuator-apm
```

# Spring Nativ Actuator Endpoints
```
http://localhost:8080/actuator
http://localhost:8080/actuator/metrics
http://localhost:8080/actuator/metrics/{name-of-metrics}
http://localhost:8080/actuator/prometheus
```
# Prometheus Actuator Endpoint
```
http://localhost:8080/actuator/prometheus
```


# Business Endpoints
Show simple statistics 
```
http://localhost:8080
```

Returns within a couple of milliseconds
```
http://localhost:8080/fast
```

Returns within 5 seconds
```
http://localhost:8080/medium
```

Returns within 10 seconds
```
http://localhost:8080/slow
```

Throws a RuntimeException
```
http://localhost:8080/exception/runtime
```

Throws a HossaException
```
http://localhost:8080/exception/hossa
```


# Create Load
In bash shell execute following
```
while [ true ] ; do time curl <endpoint-url> ; sleep 1 ; done
```
You can remove the sleep from this command to increase the load.
