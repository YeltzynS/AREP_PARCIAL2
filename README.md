# Parcial2

aplicación para calcular los factores de un número y losnúmeros primos. 

El programa esta desplegado en dos instancias de EC2 en AWS, una para un proxy y dos para mathService.

---
### Prerrequisitos

* Maven
* Git
* Java -17
* AWS

---


## Instalación 

1.Clonamos el repositorio
```
https://github.com/YeltzynS/AREP_PARCIAL2.git
```
2.Nos movemos a la carpeta
```
cd Parcial2
```

## Ejecución

En una de las consolas vamos a ejecutar los siguientes comandos:

```
cd proxy
```
Y en para la otra consola seria:

```
cd mathservice
```

3.Construimos el proyecto en cada una de las carpetas
```
mvn package
```


2.Probamos nuestro proyecto ingresando con el siguiente link a nuestro browser, en donde podremos probar la funcionalidad de factores y primos:
```
http://localhost:8080
```


### Despliegue en AWS

Se crearon tres instancias en EC2
1. Proxy
2. MathService1

Como se observa en la siguiente imagen:
![](images/instancias.PNG)



### Construido con

* Maven
* Git
* GitHub
* Java -17
* JavaScript
* HTML
* Visual Studio Code
* AWS

