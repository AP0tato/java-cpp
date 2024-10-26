from __future__ import print_function
import tkinter
import random

global board
global frame
global window

board = [["[ ]" for x in range(3)]for y in range(3)]
turn = random.randint(0, 1)

def create_board(frame):
    for i in range(3):
        for j in range(3):
            board[i][j] = tkinter.Button(frame, text="", width=5)
            board[i][j].grid(row=i, column=j)

def refresh_board(frame):
    for i in range(3):
        for j in range(3):
            board[i][j] = tkinter.Button(frame, text="", width=5)
            board[i][j].grid(row=i, column=j)
    frame.pack()

def canWin(b, c):
    return (
        (b[0][0]==c and b[0][1]==c and b[0][2]==c) or
        (b[1][0]==c and b[1][1]==c and b[1][2]==c) or
        (b[2][0]==c and b[2][1]==c and b[2][2]==c) or
        (b[0][0]==c and b[1][0]==c and b[2][0]==c) or
        (b[0][1]==c and b[1][1]==c and b[2][1]==c) or
        (b[0][2]==c and b[1][2]==c and b[2][2]==c) or
        (b[0][0]==c and b[1][1]==c and b[2][2]==c) or
        (b[0][2]==c and b[1][1]==c and b[2][0]==c)
    )

def isDraw():
    draw = True
    for i in board:
        if i.count('[ ]') > 0:
            draw = False
    return draw

def run():
    window = tkinter.Tk()
    frame = tkinter.Frame(window)
    window.title("Tic Tac Toe")
    window.geometry("210x100")
    create_board(frame)
    frame.pack()
    window.mainloop()

def AI():
    pass

run()