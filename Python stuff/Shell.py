import os
num = int(input("Enter number: "))
os.system('for i in {1..' + str(num) + '}; do echo $i; done')