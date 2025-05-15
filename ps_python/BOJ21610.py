import sys

input = sys.stdin.readline

dir8 = [(0, -1), (-1, -1), (-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1)]
diag4 = [(-1, -1), (-1, 1), (1, -1), (1, 1)]

def in_grid(x, y, N):
    return 0 <= x < N and 0 <= y < N

N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
commands = [tuple(map(int, input().split())) for _ in range(M)]

clouds = {(N - 1, 0), (N - 1, 1), (N - 2, 0), (N - 2, 1)}

for d, s in commands:
    d -= 1

    # 1) 구름 이동
    moved = set()
    for x, y in clouds:
        nx = (x + dir8[d][0] * s) % N
        ny = (y + dir8[d][1] * s) % N
        moved.add((nx, ny))

    # 2) 물 증가
    for x, y in moved:
        board[x][y] += 1

    # 4) 물복사버그
    for x, y in moved:
        cnt = 0
        for dx, dy in diag4:
            nx, ny = x + dx, y + dy
            if in_grid(nx, ny, N) and board[nx][ny] > 0:
                cnt += 1
        board[x][y] += cnt

    # 3) 구름 소멸
    prev_cloud_cells = moved
    clouds.clear()

    # 5) 새 구름 생성
    for i in range(N):
        for j in range(N):
            if (i, j) not in prev_cloud_cells and board[i][j] >= 2:
                clouds.add((i, j))
                board[i][j] -= 2

answer = sum(map(sum, board))
print(answer)
