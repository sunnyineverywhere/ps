import sys

input = sys.stdin.readline

x, y, w, s = map(int, input().split(' '))

c1 = (x + y) * w
c2 = 0
if (x+y) % 2 == 0: c2 = max(x, y) * s
else:  c2 = (max(x, y) -1) * s + w
c3 = (min(x, y) * s) + abs(x-y) * w
print(min(c1, c2, c3))