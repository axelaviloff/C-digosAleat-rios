def testaMultiplo(n1, n2):
    if n1 >= n2:
        if n1 % n2 == 0:
            return 1
        else:
            return 0
    else:
        if n2 % n1 == 0:
            return 1
        else:
            return 0

print(testaMultiplo(100, 10))