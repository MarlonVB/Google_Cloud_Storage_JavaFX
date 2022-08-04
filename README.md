# Google_Cloud_Storage_JavaFX
Este proyecto es parte de la Guía Practica de la Unidad 2 de la materia de Tendencias Actuales de Programación. Aquí se evidencia como se puede subir archivos desde java, esto es posible gracias a las dependencias detalladas a continuación:
## Depencencias
```
<!--DEPENDECIAS DE GOOGLE-->
        <!-- https://mvnrepository.com/artifact/com.google.cloud/google-cloud-storage -->
        <dependency>
            <groupId>com.google.cloud</groupId>
            <artifactId>google-cloud-storage</artifactId>
            <version>2.10.0</version>
        </dependency>

        <dependency>
            <groupId>com.google.cloud</groupId>
            <artifactId>google-cloud-firestore</artifactId>
            <version>3.0.21</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/com.google.cloud/google-cloud-core -->
        <dependency>
            <groupId>com.google.cloud</groupId>
            <artifactId>google-cloud-core</artifactId>
            <version>2.8.6</version>
        </dependency>
```

## SDK GoogleCloud
Se debe tener instalado el SDK de Google Cloud para poder realizar esta practica puede hacerlo mediante este link: https://cloud.google.com/sdk/docs/install

## Agregar requires al module-info.java 
Una vez instado el SDK, creado el proyecto y agregado las dependencias, debemos agregar lo siguiente en el archivo module-info.java
```sh
requires google.cloud.storage;
requires google.cloud.core;
requires google.cloud.firestore;
requires com.google.auth;
requires com.google.auth.oauth2;
```

## Observaciones
En este caso se usó Intellij como IDE de desarrollo, en caso de use algún otro como NetBeans o Eclipse, debe asegurarse de tener agregado en el module-info.java lo siguiente a parte de lo anterior:
```sh
requires google.cloud.storage;
```

## Un error probable 
En este caso puede darte varios errores pero la mayoria yo lo solucione realizando la todo lo anterior. Pero un error que puede saltarte es el de com.google.cloud.storage.StorageException: 401 Unauthorized  en este caso yo lo solucione ejecutando en el Google Cloud SDK Shell lo siguiente: 
```sh
gcloud auth application-default login
```
Puede ver este post de StackoverFlow para conseguir mas info: https://stackoverflow.com/questions/49000925/com-google-cloud-storage-storageexception-401-unauthorized-from-local-machine
