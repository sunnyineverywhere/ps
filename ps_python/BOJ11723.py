import sys

input = sys.stdin.readline

m = int(input())
s = set()

for i in range(m):
    cmd = str(input())
    if 'all' in cmd:
        s = set([_ for _ in range(1, 21)])
    elif 'empty' in cmd:
        s = set()
    else:
        op, x = cmd.split(' ')
        x = int(x)
        if 'add' == op:
            s.add(x)
        elif 'remove' == op:
            s.discard(x)
        elif "check" == op:
            if x in s:
                print(1)
            else:
                print(0)
        elif "toggle" == op:
            if x in s:
                s.discard(x)
            else:
                s.add(x)
