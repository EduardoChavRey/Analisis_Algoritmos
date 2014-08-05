def burbuja(lista):
    length = len(lista) - 1  # Operacion: Fijar (1) + Len (N) + Resta (1)
    sorted = False           # Operacion: Fijar (1)
    while not sorted:        # Operacion: Verificar (N)[
        sorted = True        # Operación: Fijar (1)
        for i in range(length): #Operación: (N)
            if lista[i] > lista[i+1]: #Operación: Comparación (N)
                sorted = False        #Operación: (N)
                lista[i], lista[i+1] = lista[i+1], lista[i] #Operación: Index(4N) + Sumas (2N) + Fijar (2N)
    #]
    return (lista) #Operación : Return (1)


# Burbuja(N)= (1+N+1) + (1) + (N)[(1)+(N)+(N)+(N)+(N)+(4N+2N+2N)]
#       O(N)= O((1+N+1) + (1) + (N)[(1)+(N)+(N)+(N)+(N)+(4N+2N+2N)])
#           => 12N^2 + 2N + 4
#           => 12N^2 + 2N
#           => 12N^2
#           => N^2

# Por lo tanto el O((1+N+1) + (1) + (N)[(1)+(N)+(N)+(N)+(N)+(4N+2N+2N)]) = O(N^2)
