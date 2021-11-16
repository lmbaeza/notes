# Commandos de Kubernetes

### Comandos Basicos

```shell
# Set Namespace
kubectl config set-context --current --namespace NAMESPACE_NAME

# Crear un Deployment
kubectl create deployment hello-world-rest-api --image=in28min/hello-world-rest-api:0.0.1.RELEASE

# Crear un Balanceador de Carga
kubectl expose deployment hello-world-rest-api --type=LoadBalancer --port=8080

# Mostrar los pods corriendo
kubectl get pods

# Obtener informacion del pod
kubectl describe pod hello-world-rest-api-7ddff5dfc6-jb5ql

# Escalar un Deployment
kubectl scale deployment hello-world-rest-api --replicas=3

# Eliminar un pods
kubectl delete pod hello-world-rest-api-687d9c7bc7-444dd

# Auto Escalando un deployment
kubectl autoscale deployment hello-world-rest-api --max=10 --cpu-percent=70

# Actualizar una imagen
kubectl set image deployment hello-world-rest-api hello-world-rest-api=in28min/hllo-world-rest-api:0.0.2.RELEASE
```

### Cambiar de Version de la aplicacion

```shell
kubectl edit deployment
# Abajo de replicas: agregar la siguiente linea
# minReadySeconds: 45

kubectl set image deployment hello-world-rest-api hello-world-rest-api=in28min/hello-world-rest-api:0.0.2.RELEASE
# Cambiar de Version
```

```shell
# Optiene todos los servicios corriendo
kubectl get services
```
