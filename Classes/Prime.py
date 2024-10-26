def numbers_to_num(a):
    isPrime = []
    if a > 1:
        for i in range(2, a):
            for j in range(2, i):
                if i % j == 0:
                    break
                else:
                    isPrime.append(i)
                    break
    print(isPrime)
def prime_checker(b):
    if b > 1:
        for i in range(2, b):
            if b % i == 0:
                print(str(b) + " is not prime.")
                break
            else:
                print(str(b) + " is prime.")
                break
num = int(input("Enter number: "))
prime_checker(num)