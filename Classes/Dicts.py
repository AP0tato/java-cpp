#Question 1
rivers = {
    'Amazon': 'Brazil',
    'Mississippi': 'Gulf of Mexico',
    'Nile': 'Egypt'
}
for i in rivers:
    print("The " + i + " river is located in " + rivers.get(i))
print("")
for i in rivers:
    print(i)
print("")
for i in rivers:
    print(rivers.get(i))
print("")
#Question 2
favorite_languages = {
    'jen': 'python',
    'sarah': 'c',
    'edward': 'ruby',
    'phil': 'python',
}
people0 = ['ali', 'muhammad', 'rabbi', 'haashir', 'jen', 'edward']
for i in people0:
    if(favorite_languages.has_key(i)):
        print("Thank you for taking the poll " + i.title() + ".")
    else:
        n = int(input("Would you like to take the poll " + i.title() + "?\n[1] Yes\n[2] No\n"))
        if n == 1:
            temp = raw_input("What is your favorite programming language?\n")
            favorite_languages[i] = temp
print("")

#Question 3
person = {
    'first_name': 'ali',
    'last_name': 'abid',
    'age': 14,
    'city': 'toronto'
}

person1 = {
    'first_name': 'edward',
    'lsat_name': 'lee',
    'age': 15,
    'city': 'New York City'
}

person2 = {
    'first_name': 'phil',
    'last_name': 'armstrong',
    'age': 17,
    'city': 'montreal'
}
people = [person, person1, person2]

for i in people:
    for j in i:
        print(j.title() + ": " + str(i.get(j)).title())
    print("")

#Question 4
pet = {
    'owner': 'jen',
    'type': 'dog',
    'age': 2
}
pet1 = {
    'owner': 'edward',
    'type': 'parrot',
    'age': 10
}
pet2 = {
    'owner': 'sarah',
    'type': 'fish',
    'age': 3
}
pet3 = {
    'owner': 'phil',
    'type': 'lizzard',
    'age': 6
}
pet4 = {
    'owner': 'ali',
    'type': 'cat',
    'age': 5
}
pets = [pet, pet1, pet2, pet3, pet4]

for i in pets:
    for j in i:
        print(j.title() + ": " + str(i.get(j)).title())
    print("")

#Question 5
favorite_places = {
    'ali': ['toronto', 'orlando', 'vancouver'],
    'phil': ['new York', 'texas'],
    'edward': ['paris', 'belgium', 'spain']
}
for i in favorite_places:
    print(i.title() + ":")
    for j in favorite_places.get(i):
        print(" - " + j.title())
    print("")

#Question 6
fav_numbers = {}
running = True
while running:
    n = int(input("[1] Take The Poll\n[2] Quit\n"))
    print("")
    if(n == 1):
        a = raw_input("Enter Name: ")
        print("Enter favorite numbers, enter \"quit\" to quit: ")
        b = []
        c = ""
        while(c != "quit"):
            c = raw_input()
            b.append(c)
        print("")
        b.remove("quit")
        fav_numbers[a] = b
        b = []
    else:
        running = False

for i in fav_numbers:
    print(i.title() + ":")
    for j in fav_numbers.get(i):
        print(" - " + j)
    print("")

#Question 7
cities = {
    'toronto': 'Located in Canada, has an approximate population of 2.93 million, and is the capital of Ontario.',
    'New York': 'Located in America, has an approximate population of 8.419 million and is home to more people of Irish ancestry than Ireland\'s capital.',
    'london': 'Located in England, has an approximate population of 8.928, and is the capital of England.'
}

for i in cities:
    print(i.title() + ": " + cities.get(i))