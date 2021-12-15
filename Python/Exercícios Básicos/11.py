def ehPrimo(n):
    if n >= 2:
        for num in range(2, n):
            if n % num == 0:
                return False
    else:
        return False

    return True

def numerosPrimos(n):
    listaPrimos = []
    x = 1
    for i in range(n):
        while not ehPrimo(x):
            x += 1
        listaPrimos.append(x)
        x += 1
    return listaPrimos

print(numerosPrimos(10))


