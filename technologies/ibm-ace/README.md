# ACE

### Descargar Imagen productiva

* [Obtaining the IBM App Connect Enterprise server image from the IBM Cloud Container Registry ](https://www.ibm.com/docs/en/app-connect/containers_cd?topic=obtaining-app-connect-enterprise-server-image-from-cloud-container-registry)

### Errores Frecuentes

* **Trabajando con componentes Aggregate:**
    - Cuando se trabaja con los componentes Aggregate en Contenedores es necesario crear las siguientes colas

        ```
        SYSTEM.BROKER.AGGR.CONTROL
        SYSTEM.BROKER.AGGR.REPLY
        SYSTEM.BROKER.AGGR.REQUEST
        SYSTEM.BROKER.AGGR.UNKNOWN
        SYSTEM.BROKER.AGGR.TIMEOUT
        ```

        Ademas se tiene que agregar en el archivo `server.conf.yaml` el siguiente fragmento de codigo

        ```yaml
        remoteDefaultQueueManager: '{DefaultPolicies}:MQEndpoint_Servicio'
        # O segun sea el caso
        remoteDefaultQueueManager: '{MQ_POLICY}:MQ_POLICY'
        ```