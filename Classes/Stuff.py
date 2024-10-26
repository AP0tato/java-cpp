class Greeter:
    greeting = ""
    def __init__(self, message):
        self.greeting = message
    def greet(self):
        return "Hello, " + self.greeting

greeter = Greeter("world")
print(greeter.greet())