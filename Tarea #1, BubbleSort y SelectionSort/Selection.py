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

 

alist = [54,26,93,17,77,31,44,55,20]
ordenamientoSeleccion(alist)
print(alist)
