def fatorial(n):
    fat = 1
    while n > 1:
        fat *= n
        n -= 1
    return fat


def combinacao(n, k):
    resultado = (fatorial(n))/(fatorial(n-k)*fatorial(k))
    return resultado

print(combinacao(5, 2))