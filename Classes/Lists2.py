#Question 1
numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
reversed_numbers = numbers[::-1]
print(reversed_numbers)

#Question 2
squared = []
squared_2 = []
for i in numbers:
    squared.append(i * i)
    #Or
    squared_2.append(i ** 2)
print(squared)
print(squared_2)

#Question 3
list1 = [10, 20, [300, 400, [500, 600], 500], 30, 40]
list1[2][2].append(700)
print(list1)