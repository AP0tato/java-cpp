import random

def maxx(arr):
    max = 0
    for i in arr:
        if i > max:
            max = i
    return max

def randomm(a, b):
    if a == "":
        a = 0
    c = random.randint(a,b)
    return c
arr = [1, 03021, 39291, 0231, 3289]
print(randomm(10, 15))