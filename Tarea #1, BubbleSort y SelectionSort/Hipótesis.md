####Hipótesis   
#####Algoritmo Burbuja:
Este algoritmo requiere de examinar cada valor de la lista, y verificar si el valor del elemento actual 
es menor al del elemento que le sigue. Por ende, ese deducible que el mejor caso para este algoritmo 
sea uno en el que todos los "N" elementos de la lista esten ordenados. Por lo que solo requerirá 
recorrer los "N" elementos de la lista una sola vez.
En caso contrario el peor de los escenarios sería en el que la lista esté ordenada de forma inversa, 
en este caso el algoritmo tendría que regresarse "N" veces por cada uno de los "N" elementos.
Lo que requeriría de un tiempo de ejecución de N * N.

#####Mejor caso 
En el algoritmo burbuja, el mejor caso correspondería a aquel en el la lista ingresada ya se encuentre ordenada, de forma que solo ocuparía recorrer la lista N veces (Sea N= Tamaño de la lista).

#####Caso medio
Una lista con valores al azar.

#####Peor caso
El peor caso del algoritmo burbuja, sería en el que se le ingrese una lista cuyos valores están ordenados de forma invertida. Puesto que para ordenarla, se ocuparía recorrer la lista N*N veces (Sea N=Tamaño de la ista).

#####Algoritmo de Selección:
Este algoritmo requiere de recorrer toda la lista de "N" elementos, y encontrar el elemento más grande. 
Esto, por lo tanto, requiere repetirse "N" veces por cada "N" elemento en la lista.
Por lo que me da la impresión que ya sea en el mejor de los escenario o el peor de los escenarios 
(por no decir en cualquier escenario), siempre ocupará un tiempo de ejecución de N*N.

#####Mejor caso   
En el algoritmo de selección, el mejor caso correspondería a aquel en el la lista ingresada ya se encuentre ordenada, de forma que solo ocuparía recorrer la lista N veces (Sea N= Tamaño de la lista).

#####Caso medio  
Una lista con valores al azar.

#####Peor caso  
El peor caso del algoritmo de selección, sería en el que se le ingrese una lista cuyos valores están ordenados de forma invertida. Puesto que para ordenarla, se ocuparía recorrer la lista N*N veces (Sea N=Tamaño de la ista).
