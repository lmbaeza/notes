# Demo Deploy

### Create SSH Key

```shell
ssh-keygen -t rsa -b 4096
```

### Run

```shell
# Create Volumen
docker volume create db-volumes-demo
# Build Images
docker-compose up
```

### Hosts

|         Name         | Ports             |  Links      |
|:--------------------:|-------------------|-------------|
| Microservice         | 8000 - 8001 - ... | http://localhost:8000/demo-microservice/faculty/all, http://localhost:8001/demo-microservice/faculty/all |
| Microservice Feign   | 8100 - 8101 - ... | http://localhost:8100/demo-feign-microservice/faculty/any/1 |
| Eureka Naming Server | 8761              | http://localhost:8761/ |
| ApiWategay           | 8765              | http://localhost:8765/demo-microservice/university/all, http://localhost:8765/demo-feign-microservice-new/faculty/any/1, http://localhost:8765/demo-feign-microservice/faculty/any/1, http://localhost:8765/demo-microservice/faculty/ping |


### PostgreSQL Shell

```shell
docker exec -it <CONTAINER-ID> psql -h <CONTAINER-NAME> -U <POSTGRES-USER> <DATABASE>
# Example
docker exec -it <CONTAINER-ID> psql -h postgresqldb -U postgres university
```

Insert Row

```sql
INSERT INTO university (name, create_at) VALUES ('Any University', CURRENT_TIMESTAMP);
INSERT INTO faculty (name, create_at, university_id) VALUES ('Any 1 Faculty', CURRENT_TIMESTAMP, 1);
INSERT INTO faculty (name, create_at, university_id) VALUES ('Any 2 Faculty', CURRENT_TIMESTAMP, 1);
```

Show Tables

```shell
\dt
```

### Build Images from Eclipse

```shell
# Run as / Maven Build
spring-boot:build-image -DskipTests
```