# LastMinute_Test
[![Build Status](https://travis-ci.org/pcubero/LastMinute_Test.svg?branch=master)](https://travis-ci.org/pcubero/LastMinute_Test)

Herramientas

Eclipse Neon con Maven y la version 8 de java se.


Solucion

He desarrollado una clase Searcher con un método público que devuelve el listado de vuelos según los parámetros indicados en el enunciado del ejercicio. Para acceder a la información de los vuelos y las compañías, he construido un simple dao DaoFlights. La implementación que he escogido para este dao, ha sido una clase sencilla que cargue una única vez en un repositorio estático en memoria, todos los vuelos a través de un fichero csv situado en el mismo proyecto (DaoFlightsImpl).


Tests

Para construir las pruebas he utilizado las librerías: TestNg,Hamcrest y Mockito. Hago especial énfasis en mi elección por Mockito para aislar el dao, DaoFlights, de cualquier implementación o capa subyacente.
He dejado un suite TestNg xml en src/test/resources con las dos clases de pruebas por si se desea ejecutar

El proyecto ha sido testeado y desplegado con éxito por Travis CI


