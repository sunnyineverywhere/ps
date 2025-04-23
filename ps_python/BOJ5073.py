import sys

input = sys.stdin.readline

while True:
    lines = list(map(int, input().split(" ")))
    lines.sort()
    a, b, c = lines[0], lines[1], lines[2]

    if a == b == c == 0:
        break

    if c >= a + b:
        print("Invalid")
    elif a == b and b == c:
        print("Equilateral")
    elif a != b and b != c and a != c:
        print("Scalene")
    else:
        print("Isosceles")
