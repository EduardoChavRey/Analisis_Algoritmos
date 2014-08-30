Tarea  
Análisis de algoritmos IC3002.40 2014  
Prof. Mauricio Rojas  


1) Asuma que cada una de las expresiones de abajo da el tiempo de procesamiento T(n) que toma un 
algoritmo para resolver un problema de tamaño n. 
Seleccione el termino dominante que tenga el mayor crecimiento en n y especifique la complejidad O 
mas baja para cada algoritmo.

![E1:](https://raw.githubusercontent.com/EduardoChavRey/Analisis_Algoritmos/master/Tarea%20%232/Imagenes/%231.png) 

2) Un algoritmo cuadrático tiene un tiempo de procesamiento T(n) = c * n ^2 y tarda T(Z) segundos 
para procesar Z elementos de datos. 
¿Cuanto tiempo tardaría en procesar n=5000 elementos de datos, asumiendo que Z=100 y que T(Z)=1ms?

![E1:](https://raw.githubusercontent.com/EduardoChavRey/Analisis_Algoritmos/master/Tarea%20%232/Imagenes/%232.png) 

3) Un algoritmo con una complejidad de tiempo O(f(n)) y un tiempo de procesamiento T(n) = c f(n) 
donde f(n) es una función conocida de n, tarda 10 segundos para procesar 1000 elementos de datos.  
¿Cuanto tiempo tomara procesar 100000 elementos de datos si f(n) = n y si f(n) = n^3?

![E1:](https://raw.githubusercontent.com/EduardoChavRey/Analisis_Algoritmos/master/Tarea%20%232/Imagenes/%233.png)

4) Se tienen dos paquetes de software A y B de complejidad O(n log n) y O(n) respectivamente. 

Y se tiene que  

![E1:](https://raw.githubusercontent.com/EduardoChavRey/Analisis_Algoritmos/master/Tarea%20%232/Imagenes/Imagen%20Enunciado%20%234.png) 

expresan el tiempo en milisegundos de cada paquete.  

Durante una prueba, el tiempo promedio de procesamiento de n=10^4 elementos de datos con los 
paquetes A y B es de 100ms y 500ms respectivamente.  
Establezca las condiciones en las cuales uno de los paquetes empieza a desempeñarse mejor que el 
otro y recomiendo la mejor opción si se van a procesar n=10^9.

![E1:](https://raw.githubusercontent.com/EduardoChavRey/Analisis_Algoritmos/master/Tarea%20%232/Imagenes/%234.png) 

![E1:](https://raw.githubusercontent.com/EduardoChavRey/Analisis_Algoritmos/master/Tarea%20%232/Imagenes/%234%202.png) 

5) Asuma que el arreglo a contiene n valores, que el método randomValue toma un numero constante c de 
pasos computacionales para producir cada valor de salida, y que el método goodSort toma n log n pasos 
computacionales para ordenar un arreglo. Determine la complejidad O para el siguiente fragmento de 
código:

![E1:](https://raw.githubusercontent.com/EduardoChavRey/Analisis_Algoritmos/master/Tarea%20%232/Imagenes/%235.png) 

6) Se le pide clasificar un archivo que contiene enteros entre 0 y 999999. No puede utilizar un millón 
de casillas, asi que en su lugar decide utilizar mil casillas numeradas desde 0 a 999 (recordar el 
ordenamiento por casillas o buckets comentado en clase). Comienza la clasificación colocando cada entero 
en la casillas correspondiente a sus tres primeras cifras. A continuación utiliza mil veces la 
ordenación por inserción para ordenar el contenido de cada casilla por separado.
Y por ultimo se vacían las casillas por orden para obtener una secuencia completamente ordenada.
Haga el pseudo código del algoritmo y realice el análisis del tiempo de ejecución. Compare con los 
tiempos esperados para ejecutar el ordenamiento solo usando el algoritmo de ordenamiento por inserción.

![E1:](https://raw.githubusercontent.com/EduardoChavRey/Analisis_Algoritmos/master/Tarea%20%232/Imagenes/%236.png) 

7) Cree una maquina de Turing que reemplaze su Nick por su nombre. 
(Puede utilizar solo las primeras 3 letras del Nick y las primeras 5 del nombre).

![E1:](https://raw.githubusercontent.com/EduardoChavRey/Analisis_Algoritmos/master/Tarea%20%232/Imagenes/%237.png) 

