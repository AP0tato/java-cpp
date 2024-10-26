#Question 1
numbers = []
for i in range(21):
    numbers.append(i)
print(numbers[1::2])

#Question 2
multiples = []
for i in range(3, 31):
    if i % 3 == 0:
        multiples.append(i)
for i in multiples:
    print(i)

#Question 3
cubes = []
for i in range(11):
    cubes.append(i**3)
for i in cubes:
    print(i)