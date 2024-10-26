types = {
    'dictionaries': 'A way of storing data and keys',
    'print': 'A way to log info to console',
    'for loop': 'A way to loop'
}

type = ['dictionaries', 'lists', 'tuples', 'print', 'for loop']

for i in types:
    if i in type:
        print(str(i.title()) + ": " + str(types[i]))