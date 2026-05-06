import random
import socket,time
from datetime import datetime

HOST = input("Enter ip")
PORT = 9999

s = socket.socket()
s.connect((HOST,PORT))

while True:
    local = time.time()+random.uniform(-5, 5)

    s.send(str(local).encode())

    diff = float(s.recv(1024).decode())

    new = local + diff

    print("OLD Time= ", datetime.fromtimestamp(local).strftime('%H:%M:%S'))
    print("New time is=", datetime.fromtimestamp(new).strftime('%H:%M:%S'))

    time.sleep(6)