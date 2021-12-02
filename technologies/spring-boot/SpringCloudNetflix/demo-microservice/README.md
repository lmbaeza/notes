# Demo Microservice using Spring Boot + PostgreSQL + JPA + Docker

### Dependencies

* Spring Web
* Lombok
* Spring Data JPA
* PostgresSQL Driver

### SSH

```shell
ssh-keygen -t rsa -b 4096
git clone git@github.ibm.com:luismiguelbaez/demo-microservice.git
```

### Run

**Note:** run eureka-naming-server first

```shell
docker rmi demo-microservice -f
mvn clean install -DskipTests=true
docker-compose down
docker-compose up
# or
# docker-compose up -d
```

### PostgreSQL Shell

```shell
docker exec -it <CONTAINER-ID> psql -h <CONTAINER-NAME> -U <POSTGRES-USER> <DATABASE>
# Example
docker exec -it <CONTAINER-ID> psql -h postgresqldb -U postgres university
```

Insert Row

```sql
INSERT INTO university (name, create_at) VALUES ('Any University', CURRENT_TIMESTAMP);
INSERT INTO faculty (name, create_at, university_id) VALUES ('Any Faculty', CURRENT_TIMESTAMP, 1);
```

Show Tables

```shell
\dt
```

# Reference

[Youtube - Spring Boot con PostgreSQL y Docker Compose | Ejemplo de API de RESTful CRUD | Auditoría de Spring Data JPA](https://www.youtube.com/watch?v=hglfkhhBI14)