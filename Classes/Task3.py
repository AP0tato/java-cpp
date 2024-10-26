#Question 1
#Algorithms are a set of instructions to complete a specific task
#  1. Making a cake
#  2. A daily schedual

#Question 2
p = ["Ahad", "Zaman", "Khalid"]
a = raw_input("Enter name: ")
can = "Fail"
for i in p:
    if i == a:
        print "Pass"
        break
print(can)

#Question 3
x = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
a = int(input("Enter Number: "))
if(a<6):
    for i in range(len(x) / 2):
        if i == a:
            print(i)
            break
    
else:
    for i in range(len(x)/2, len(x)):
        if i == a:
            print(i)
            break

#Question 4
b = [8, 6, 0, 3]
c = [8, 6, 0, 3, 10, 100, 4, 56, 24]
def sort_array(arr):
    for i in range(len(arr) - 1):
        temp = arr[i]
        temp1 = arr[i + 1]
        if(temp > temp1):
            arr[i] = temp1
            arr[i + 1] = temp
    return arr

def sort(arr):
    for i in range(len(arr)):
        sort_array(arr)
    return arr
print(sort(b))