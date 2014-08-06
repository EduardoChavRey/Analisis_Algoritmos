import random
import time

#######################################################################################

def ordenamientoBurbuja(lista):
    largo = len(lista) - 1  # Operacion: Fijar (1) + Len (N) + Resta (1)
    sorted = False           # Operacion: Fijar (1)
    while not sorted:        # Operacion: Verificar (N)[
        sorted = True        # Operación: Fijar (1)
        for i in range(largo): #Operación: (N)
            if lista[i] > lista[i+1]: #Operación: Comparación (N)
                sorted = False        #Operación: (N)
                lista[i], lista[i+1] = lista[i+1], lista[i] #Operación: Index(4N) + Sumas (2N) + Fijar (2N)

# Burbuja(N)= (1+N+1) + (1) + (N)[(1)+(N)+(N)+(N)+(N)+(4N+2N+2N)]
#       O(N)= O((1+N+1) + (1) + (N)[(1)+(N)+(N)+(N)+(N)+(4N+2N+2N)])
#           => 12N^2 + 2N + 4
#           => 12N^2 + 2N
#           => 12N^2
#           => N^2

# Por lo tanto el O((1+N+1) + (1) + (N)[(1)+(N)+(N)+(N)+(N)+(4N+2N+2N)]) = O(N^2)

###########################################################################################

def ordenamientoSeleccion(lista):
   for ranuraLlena in range(len(lista)-1,0,-1): # Operación: Recorrido (N){
       posicionValorMaximo=0                    # Operación: Fijar (1) * 
       for localizacion in range(1,ranuraLlena+1): # Operación: Recorrido en Recorrido(N) {
           if lista[localizacion]>lista[posicionValorMaximo]: # Operación:  Index (2) + Comparación (1)
               posicionValorMaximo = localizacion # Operación: Fijar (1)
      #}
       temp = lista[ranuraLlena] # Operación: Fijar(1) + Index(1)
       lista[ranuraLlena] = lista[posicionValorMaximo] # Operación: Index(2) + Fijar (1)
       lista[posicionValorMaximo] = temp # Operación: Index(1) + Fijar (1)
   #}

# ordenamientoSeleccion(N)= (N)*[(1)+(N*[2+1+1])+(1)+(2)+(1)+(1+1)]
#       O(N)= O(N + N*(2N+N+N) + N + 2N + N + 2N)
#           => N + 2N^2 + N^2 + N^2 + 5N
#           => 4N^2 + 6N
#           => 4N^2
#           => N^2

# Por lo tanto el O(N + N*(2N+N+N) + N + 2N + N + 2N)
  # => O(N^2)


###########################################################################################


def calculateRunTime(funcion, *args):
    tiempoInicio = time.time()
    resultado = funcion(*args)
    return time.time() - tiempoInicio, resultado

###########################################################################################

                
def main(count=10, valorMinimo=0, valorMaximo=100, tamanio=1200):
    tiemposOrdenamientoSeleccion = []
    tiemposOrdenamientoBurbuja = []
    for i in range(count):
        x = [random.randint(valorMinimo,valorMaximo) for i in range(tamanio)]
        y = list(x)
        tiemposOrdenamientoSeleccion.append(calculateRunTime(ordenamientoBurbuja,x)[0])
        tiemposOrdenamientoBurbuja.append(calculateRunTime(ordenamientoSeleccion,y)[0])

    print("Tiempo promedio del ordenamiento burbuja: " + str(sum(tiemposOrdenamientoBurbuja)/len(tiemposOrdenamientoBurbuja)))
    print("Tiempo promedio del ordenamiento de seleccion: " + str(sum(tiemposOrdenamientoSeleccion)/len(tiemposOrdenamientoSeleccion)))

main()
