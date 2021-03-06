# spring-boot-demo-actuator
Spring-Boot Actuator Example with 
* enabled [prometheus metrics](https://prometheus.io/)
* kibana APM agent, [Open Source Application Performance Monitoring](https://www.elastic.co/solutions/apm)

# Java
```
java -javaagent:elastic-apm-agent-1.2.0.jar -D"elastic.apm.service_name=hello-application" -D"elastic.apm.server_url=http://localhost:8200" -D"elastic.apm.application_packages=hello" -jar target/gs-spring-boot-0.1.0.jar 
```
# Docker without apm
```
docker image build -f Dockerfile -t marvino1/spring-boot-demo-actuator .
docker container run -d --name spring-8080 -p 8080:8080 marvino1/spring-boot-demo-actuator
docker container run -d --name spring-8081 -p 8081:8080 marvino1/spring-boot-demo-actuator
```

# Docker with apm
```
docker image build -f Dockerfile-with-apm -t marvino1/spring-boot-demo-actuator-apm .
docker container run -d --name spring-8080 -p 8080:8080 marvino1/spring-boot-demo-actuator-apm
docker container run -d --name spring-8081 -p 8081:8080 marvino1/spring-boot-demo-actuator-apm
```


# Spring native actuator endpoints
```
http://localhost:8080/actuator
http://localhost:8080/actuator/metrics
http://localhost:8080/actuator/metrics/{name-of-metrics}
```
# Prometheus actuator endpoints
```
http://localhost:8080/actuator/prometheus
```

# Elastic metrics
The metrics are pushed to local elastic instance when enabled. See application.properties for more details.

# Business endpoints 
```
http://localhost:8080/hello
  Show simple statistics
  
http://localhost:8080/properties
  Show properties of jvm
  
http://localhost:8080/wd
  Show some simple information about the durrent working directory
    
http://localhost:8080/hello/fast  
  Returns within a couple of milliseconds  

http://localhost:8080/hello/fast-berta
  Returns within a couple of milliseconds but throws and catches BertaException 
  
http://localhost:8080/hello/medium
  Returns within 5 seconds

http://localhost:8080/hello/slow
  Returns within 10 seconds
  
http://localhost:8080/hello/exception/runtime
  Throws a RuntimeException

http://localhost:8080/hello/exception/hossa
  Throws a HossaException
    
```


# Create load
## Unix
In bash shell execute
```
while [ true ] ; do time curl <endpoint-url> ; sleep 1 ; done
```
You can remove the sleep from this command to increase the load.

## Windows10
In Powershell execute 
```
for($i = 0; $i -lt 999999999; $i++)
{
  Invoke-RestMethod <endpoint-url>
  Start-Sleep -Seconds 1
}
```
You can remove the sleep from this command to increase the load.
