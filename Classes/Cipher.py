#Question 1
chord1 = int(input("Enter first chord: "))
chord2 = int(input("Enter second chord: "))
key = int(input("Enter key: "))
enc_chords = chord1 - key, chord2 - key
print(enc_chords)

#Question 2
ch1 = int(input("Enter first chord: "))
ch2 = int(input("Enter second chord: "))
key1 = int(input("Enter key: "))
enc_chords1 = ch1 + key1, ch2 - key1
print(enc_chords1)

#Question 3
c1 = int(input("Enter first chord: "))
c2 = int(input("Enter second chord: "))
key2 = int(input("Enter key: "))
enc_chords2 = c1 * key2, c2 / key2
print(enc_chords2)

#Question 4
i1 = 89
i2 = 75
key3 = 42
real_chords = i1 - key3, i2 - key3
print(real_chords)

#Question 5
a1 = 115
a2 = 275
key4 = 5
real_chords1 = a1 / key4, a2 / key4
print(real_chords1)