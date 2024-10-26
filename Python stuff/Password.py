def __init__(self, password):
    self.password = password

def changePassword(self):
    a = input("Do you want to change the password? 0 = Yes, 1 = No\n")
    if a == "0":
        password = int(input("Enter new password:\n"))
        print("Your new password is " + password)