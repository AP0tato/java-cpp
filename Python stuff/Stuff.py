class Thing:
    def __init__(self):
        self
        
    def thing(self):
        n = int(input("Enter Length of the Pattern: "))
        c = raw_input("Enter character/string to be repeated: ")
        n += 1
        i = n
        c1 = ""
        while i > 0:
            for j in range(i):
                c1 += " "
                j += 1
            print(c1 + c * (n - i)) 
            c1 = c1.strip()
            i -= 1
              
    def thingy(self):
        n = int(input("Enter length of the Pattern: "))
        c = raw_input("Enter character/string to be repeated: ")
        n += 1
        i = 0
        while(i < n):
            print(c * i)
            i += 1
              
    def thing1(self):
        n = int(input("Enter length of the Pattern: "))
        c = raw_input("Enter character/string to be repeated: ")
        n += 1
        i = n
        j = 0
        c1 = " "
        while i > 0:
            print((c1 * j) + (c * i))
            i -= 1
            j += 1
            
    def thing2(self):
        n = int(input("Enter length of the pattern: "))
        c = raw_input("Enter character/string to be repeated: ")
        i = n+1
        while(i>0):
            print(c*i)
            i -= 1
            
Thing.thing(Thing())