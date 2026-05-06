import socket, time
from datetime import datetime

HOST, PORT = '', 9999

s = socket.socket()
print("Time Daemon Server Waiting...")
s.bind((HOST, PORT))

s.listen(1)

c, add = s.accept()
print("address is=",add)
while True:
    ct = float(c.recv(1024).decode())

    st = time.time()

    avg = (ct+st)/2

    print("Servertime is=", datetime.fromtimestamp(st).strftime('%H:%M:%S'))
    print("Client time=", datetime.fromtimestamp(ct).strftime('%H:%M:%S'))

    print("AVG=", datetime.fromtimestamp(avg).strftime('%H:%M:%S'))

    print()

    diff = avg-ct

    c.send(str(diff).encode())