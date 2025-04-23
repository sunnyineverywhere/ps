import sys
from collections import deque

input = sys.stdin.readline

m, n = map(int, input().split())
tomato = [list(map(int, input().split())) for _ in range(n)]

dq = deque([])

for i in range(n):
    for j in range(m):
        if tomato[i][j] == 1: dq.append((i, j, 0))

answer = 0
dxy = [(1, 0), (0, 1), (0, -1), (-1, 0)]
while dq:
    x, y, day = dq.popleft()

    if day > answer:
        answer = day

    for d in dxy:
        nx = x + d[0]
        ny = y + d[1]
        if 0 <= nx < n and 0 <= ny < m and tomato[nx][ny] == 0:
            dq.append((nx, ny, day+1))
            tomato[nx][ny] = 1

for i in range(n):
    for j in range(m):
        if tomato[i][j] == 0:
            answer = -1
            break

print(answer)