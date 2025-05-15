"""
GPT식 숫자비교

시뮬
'.' 쪼개서 단순 비교
아무것도 없을 때 -1을 넣는 아이디어
"""

import sys
input = sys.stdin.readline

n = int(input())
arr = []

for _ in range(n):
    num = input()

    x, y = '', ''
    
    if '.' not in num:
        x = int(num)
        y = -1
    else:
        x, y = str(num).split(".")
        x = int(x)
        y = int(y)

    arr.append([x, y])

arr.sort(key = lambda x : (x[0], x[1]))

for x in arr:
    if x[1] == -1:
        print(x[0])
    else:
        print(str(x[0]) + "." + str(x[1]))
