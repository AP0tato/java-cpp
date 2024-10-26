def encrypt_message():
    l1 = int(input("Enter chord 1: "))
    l2 = int(input("Enter chord 2: "))
    key = int(input("Enter key: "))
    enc_chords = l1 + key, l2 - key
    print("New encrypted chords are:", enc_chords)

def decrypt_message():
    i1 = int(input("Enter chord 1: "))
    i2 = int(input("Enter chord 2: "))
    key = int(input("Enter key: "))
    dyc_chords = i1 - key, i2 + key
    print "Decrypted chords are:", dyc_chords

decrypt_message()