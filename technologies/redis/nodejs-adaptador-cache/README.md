# nodejs-adaptador-cache

Adaptador Cache usando Redis

### Correr Contenedor Local

```shell
docker pull redis:latest
# docker build -t quay.io/luisbaez/nodejs-adaptador-cache:latest .
docker build -t nodejs-adaptador-cache:latest .

# oc import-image nodejs-adaptador-cache --from quay.io/luisbaez/nodejs-adaptador-cache:latest --confirm

docker-compose up
```


### Entrar al Contenedor de Redis

```shell
docker exec -it CONTAINER_ID_OR_NAME bash
# OR
docker exec -it CONTAINER_ID_OR_NAME redis-cli
redis-cli
KEYS '*'
HGETALL User:1
DUMP User:1
flushdb # Warning: Elimina toda la informacion de la base de datos
```