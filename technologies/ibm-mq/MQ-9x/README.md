# IBM MQ 9.*


### Abrir entorno de ejecucion de comandos

`QMGR` Nombre de la Queue Manager

```bash
runmqsc QMGR
```

### Crear una Cola Local

```bash
DEFINE QLOCAL(QUEUE.REQ)
# Or
DEFINE QLOCAL(QUEUE.REQ) REPLACE
```

### Dar permisos a una Cola

```shell
# Dar todos los permisos +all usando el usuario app
setmqaut -m IBM_MQ1 -n SYSTEM.BROKER.AGGR.CONTROL -t queue -p app +all
```

# Api Rest de IBM MQ

### Crear un mensaje en una Cola

Usando `MQ_APP_PASSWORD=pass`

```bash
curl -i -k https://localhost:9443/ibmmq/rest/v1/messaging/qmgr/<QMGR>/queue/<QUEUE_NAME>/message -X POST -u app:pass -H "ibm-mq-rest-csrf-token: blank" -H "Content-Type: text/plain;charset=utf-8" -d "Este es un nuevo mensaje"
```

### Obtener un mensaje en una Cola

```bash
curl -i -k https://localhost:9443/ibmmq/rest/v1/messaging/qmgr/<QMGR>/queue/<QUEUE_NAME>/message -X GET -u app:pass -H "ibm-mq-rest-csrf-token: blank"
```

### Obtener y Eliminar un mensaje en una Cola

```bash
curl -i -k https://localhost:9443/ibmmq/rest/v1/messaging/qmgr/<QMGR>/queue/<QUEUE_NAME>/message -X DELETE -u app:pass -H "ibm-mq-rest-csrf-token: blank"
```

# MQ en Openshift

### Crear un contenedor de MQ en Openshift

```shell
oc new-app --env LICENSE=accept --env MQ_QMGR_NAME=QMGR --env MQ_ADMIN_PASSWORD=passw0rd --env MQ_APP_PASSWORD=pass --docker-image ibmcom/mq:latest --name ibm-mq 
```