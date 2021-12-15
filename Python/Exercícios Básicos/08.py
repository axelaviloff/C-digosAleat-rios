from math import pi

def areaCirculo(raio):
    area = pi * raio * raio
    return area

def areaTriangulo(base, altura):
    area = (base * altura)/2
    return area

def areaRetangulo(base, lado):
    area = base * lado
    return area

print(areaCirculo(1))
print(areaTriangulo(3, 6))
print(areaRetangulo(10, 10))
