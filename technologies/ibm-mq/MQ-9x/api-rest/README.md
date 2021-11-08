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