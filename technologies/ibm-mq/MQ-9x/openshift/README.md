# MQ en Openshift

### Crear un contenedor de MQ en Openshift

```shell
oc new-app --env LICENSE=accept --env MQ_QMGR_NAME=QMGR --env MQ_ADMIN_PASSWORD=passw0rd --env MQ_APP_PASSWORD=pass --docker-image ibmcom/mq:latest --name ibm-mq 
```