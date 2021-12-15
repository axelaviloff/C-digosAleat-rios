def numeroImpares(lista):
    listaImpar = []
    for numero in lista:
        if numero % 2 == 1:
            listaImpar.append(numero)
    return listaImpar


print(numeroImpares([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]))