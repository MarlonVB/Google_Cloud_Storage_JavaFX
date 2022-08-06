# Google_Cloud_Storage_JavaFX
Este proyecto es parte de la Guía Practica de la Unidad 2 de la materia de Tendencias Actuales de Programación. Aquí se evidencia como se puede subir archivos desde java, esto es posible gracias a las dependencias detalladas a continuación:

## ¿Qué realiza el sistema?

* Permite subir un archivo a un bucket en Google Cloud  a través de una interfaz gráfica sencilla e intuitiva realizada en JavaFX.
* Permite seleccionar archivo desde la misma UI desde un botón que abre un gestor de archivos de Windows donde podrá navegar por el ordenador y seleccionar un archivo.
* Una vez seleccionado un archivo se podrá quitar este archivo para poder seleccionar otro.
* Podremos poner el nombre con el que queramos que se visualice en el bucket el objeto(archivo) que subimos.
* Nos permite poner el nombre del bucket al que queramos que se suban los archivos. Este debe existir dentro de mi proyecto creado en Google Storage.

![](https://scontent.fcue8-1.fna.fbcdn.net/v/t1.15752-9/295673966_515246753693738_653577595096237800_n.jpg?_nc_cat=110&ccb=1-7&_nc_sid=ae9488&_nc_eui2=AeG5mzg2zilzc1RqjVCBhuuIK7jFyF6QNecruMXIXpA150oNVSIBnDPKR-7sUHvZKgOg6oLrW73yw0iQuNPLxTy4&_nc_ohc=67oPwkfGa7cAX_gKPz1&_nc_ht=scontent.fcue8-1.fna&oh=03_AVJj8YuQvQpWhcA0q9wIcq0OxtDpki9-xHsutNIaFiriyQ&oe=63125D1B)

# Cosas a tener en cuenta
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
## Cambiar el path de la imagen logo del sistema
El path que se utiliza para que el sistema cuente con un logo es un path adsoluto pero este al clonar el repositorio puede cambiar.
Por esto debemos cambiar el path con el que actual, luego de clonar el repositorio. Lo que debemos cambiar se encuentra dentro de la clase prinpial.
A continuacion pongo los pasos a seguir:

> Paso 1: Esto es lo que debemos cambiar.

[![path-1.png](https://i.postimg.cc/rpCqXftq/path-1.png)](https://postimg.cc/Tywznq9s)

> Paso 2: Borramos el path o URL.

[![path-2.png](https://i.postimg.cc/q7dp5Pqm/path-2.png)](https://postimg.cc/4YBCKFzt)

> Paso 3: Dentro de la carperta resources tenemos el icono. Una vez lo hayamos identificado damos clic derecho sobre el archivo.

[![path-3.png](https://i.postimg.cc/CLXhjBgp/path-3.png)](https://postimg.cc/zVwYNfvx)

> Paso 4: Luego le damos a Copy Path.

[![path-4.png](https://i.postimg.cc/htmSMDDz/path-4.png)](https://postimg.cc/9DW5QjqC)

> Paso 5: Luego le damos a copiar path adsoluto o Adsolute Path.

[![path-5.png](https://i.postimg.cc/260m33wJ/path-5.png)](https://postimg.cc/BLPRVSRc)

> Paso 6: Pegamos el path que acabamos de copiar donde antes borramos el path antiguo.

[![path-6.png](https://i.postimg.cc/Xqhbchtk/path-6.png)](https://postimg.cc/m1QJTdLP)

> Paso 7: Por ultimo ya tendremos el path actualizado.

[![path-7.png](https://i.postimg.cc/T1hxbGNP/path-7.png)](https://postimg.cc/JHwSVwLw)

# Observaciones
En este caso se usó Intellij como IDE de desarrollo, en caso de use algún otro como NetBeans o Eclipse, debe asegurarse de tener agregado en el module-info.java lo siguiente a parte de lo anterior:
```sh
requires google.cloud.storage;
```

#### Un error probable 
En este caso puede darte varios errores pero la mayoria yo lo solucione realizando todo lo anterior. Pero un error que puede saltarte es el de com.google.cloud.storage.StorageException: 401 Unauthorized  en este caso yo lo solucione ejecutando en el Google Cloud SDK Shell lo siguiente: 
```sh
gcloud auth application-default login
```
Este comando nos dara accesos para que podamos sobre realizar las transacciones desde el aplicativo.
Una vez realizado esto deberia abrirle una pestaña en su navegador donde debera ingresar a la cuenta con la que esta resgistrado en el Google Cloud.
Puede ver este post de StackoverFlow para conseguir mas info: https://stackoverflow.com/questions/49000925/com-google-cloud-storage-storageexception-401-unauthorized-from-local-machine


> **_Nota:_** _Se recomienda para que el sistema funcione de mejor manera, correrlo en IntelliJ IDEA._
