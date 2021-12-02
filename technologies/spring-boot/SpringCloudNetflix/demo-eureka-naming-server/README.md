# Eureka Naming Server - Demo

### Run

```shell
docker rmi eureka-naming-server -f
mvn clean install -DskipTests=true
docker-compose down
docker-compose up
# or
# docker-compose up -d
```

### Hosts


|         Name         | Ports             |  Links      |
|:--------------------:|-------------------|-------------|
| Microservice         | 8000 - 8001 - ... | http://localhost:8000/faculty/id/1, http://localhost:8001/faculty/id/1 |
| Microservice Feign   | 8100 - 8101 - ... | http://localhost:8100/faculty/any/1 |
| Eureka Naming Server | 8761              | http://localhost:8761/ |