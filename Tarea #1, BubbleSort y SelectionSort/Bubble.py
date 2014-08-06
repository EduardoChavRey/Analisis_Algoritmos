def burbuja(lista):
    length = len(lista) - 1  # Operación: Fijar (1) + Len (N) + Resta (1)
    sorted = False           # Operación: Fijar (1)
    while not sorted:        # Operación: Verificar (N)[
        sorted = True        # Operación: Fijar (1)
        for i in range(length): #Operación: Recorrido (N)
            if lista[i] > lista[i+1]: # Operación: Comparación (N)
                sorted = False        # Operación: (N)
                lista[i], lista[i+1] = lista[i+1], lista[i] #Operación: Index(4N) + Sumas (2N) + Fijar (2N)
    #]
    return (lista) # Operación : Return (1)


# Burbuja(N)= (1+N+1) + (1) + (N)[(1)+(N)+(N)+(N)+(N)+(4N+2N+2N)]
#       O(N)= O((1+N+1) + (1) + (N)[(1)+(N)+(N)+(N)+(N)+(4N+2N+2N)])
#           => 12N^2 + 2N + 4
#           => 12N^2 + 2N
#           => 12N^2
#           => N^2

# Por lo tanto el O((1+N+1) + (1) + (N)[(1)+(N)+(N)+(N)+(N)+(4N+2N+2N)])
  # => O(N^2)


alist = [54,26,93,17,77,31,44,55,20]
burbuja(alist)
print(alist)
