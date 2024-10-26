#Question 1
def func():
    a = int(input())
    b = int(input())
    add1 = a + b
    sub = a - b
    mult = a * b
    div1 = float(a) / b
    return add1, sub, mult, div1
print(func())

#Question 2
def mean(a):
    total = 0
    for i in a:
        total += i
    return float(total) / len(a)
arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
print(mean(arr))

#Question 3
f = open("Test.txt", "w")
f.write("This That\nThis")
f.close()
f = open("Test.txt", "a")
f.write("\nThat\nThis")
f.close()
f = open("Test.txt", "r")
a = f.read()
b = a.split()
print(len(b))