#Method 1
list1 = [2, 3, 666, 212, 43]
count = 0
for i in list1:
    count += 1
print(count)

total = 0
"""
for i in list1:
    total += i
"""
for i in range(count):
    total += list1[i]
print(total)