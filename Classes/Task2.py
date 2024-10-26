import math #Needed to prevent Recursion error

def _add():
    a = int(input())
    b = int(input())
    return a + b
#print(_add())

def _sub():
    a = int(input())
    b = int(input())
    return a - b
#print(_sub())

def _mult():
    a = int(input())
    b = int(input())
    return a * b
#print(_mult())

def _div():
    a = int(input())
    b = int(input())
    return a / float(b)
#print(_div())

def sqrt():
    x = int(input())
    if x == 0:
        return "Number cannot be zero"
    elif x < 0:
        return "The square root of a negative number can not be computed"
    else:
        return math.sqrt(x)

print(sqrt())