import sys

input = sys.stdin.readline

n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]
visit = []


def recursion(x, y, current):
    color = board[x][y]
    for i in range(x, x + current):
        for j in range(y, y + current):
            if color != board[i][j]:
                recursion(x, y, current // 2)
                recursion(x, y + current // 2, current // 2)
                recursion(x + current // 2, y, current // 2)
                recursion(x + current // 2, y + current // 2, current // 2)
                return
    if color == 0:
        visit.append(0)
    else:
        visit.append(1)


recursion(0, 0, n)
print(visit.count(0))
print(visit.count(1))

"""
탐색해야 하는 전체 변의 길이 = n/(n/현재값) => 현재값
8 => n/8 = 1


4 => n/4 = 2
- 0,0 ~ 3,3
- 0,4 ~ 3,7
- 4,0 ~ 7,3
- 4,4 ~ 7,7

2 => n/2 = 4
- 0,0 ~ 1,1
- 2,0 ~ 

[x,y]
[x, y+n/2]
[x+n/2, y]
[x+n/2, y+n/2]

"""
