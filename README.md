# LastMinute_Test
[![Build Status](https://travis-ci.org/pcubero/LastMinute_Test.svg?branch=master)](https://travis-ci.org/pcubero/LastMinute_Test)

Herramientas

Eclipse Neon con Maven y la version 8 de java se.


Solucion

He desarrollado una clase Searcher con un m�todo p�blico que devuelve el listado de vuelos seg�n los par�metros indicados en el enunciado del ejercicio. Para acceder a la informaci�n de los vuelos y las compa��as, he construido un simple dao DaoFlights. La implementaci�n que he escogido para este dao, ha sido una clase sencilla que cargue una �nica vez en un repositorio est�tico en memoria, todos los vuelos a trav�s de un fichero csv situado en el mismo proyecto (DaoFlightsImpl).


Tests

Para construir las pruebas he utilizado las librer�as: TestNg,Hamcrest y Mockito. Hago especial �nfasis en mi elecci�n por Mockito para aislar el dao, DaoFlights, de cualquier implementaci�n o capa subyacente.
He dejado un suite TestNg xml en src/test/resources con las dos clases de pruebas por si se desea ejecutar

El proyecto ha sido testeado y desplegado con �xito por Travis CI


