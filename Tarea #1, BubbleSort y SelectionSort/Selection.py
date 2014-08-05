def ordenamientoSeleccion(lista):
   for ranuraLlena in range(len(lista)-1,0,-1):
       posicionValorMaximo=0
       for localizacion in range(1,ranuraLlena+1):
           if lista[localizacion]>lista[posicionValorMaximo]:
               posicionValorMaximo = localizacion
       temp = lista[ranuraLlena]
       lista[ranuraLlena] = lista[posicionValorMaximo]
       lista[posicionValorMaximo] = temp



alist = [54,26,93,17,77,31,44,55,20]
ordenamientoSeleccion(alist)
print(alist)
