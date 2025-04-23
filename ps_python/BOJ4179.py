import sys
from collections import deque

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]


def bfs(q):
    while q:
        x, y, s = q.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < r and 0 <= ny < c:
                if not check[nx][ny] and maze[nx][ny] == '.':
                    q.append((nx, ny, s))
                    check[nx][ny] = check[x][y] + 1
            else:
                if s == 'J':
                    return check[x][y]


r, c = map(int, input().split())
maze = [list(input()) for _ in range(r)]
check = [[0] * c for _ in range(r)]
q = deque()

for i in range(r):
    for j in range(c):
        if maze[i][j] == 'J':
            check[i][j] = 1
            q.append((i, j, 'J'))
        if maze[i][j] == 'F':
            check[i][j] = 1
            q.appendleft((i, j, 'F'))

ans = bfs(q)

if ans:
    print(ans)
else:
    print("IMPOSSIBLE")