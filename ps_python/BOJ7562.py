"41분"

import sys
from collections import deque

input = sys.stdin.readline


def solution(n, current, target):
    answer = 10 ** 9
    tx, ty = target[0], target[1]
    visited = list([0 for _ in range(n+1)] for __ in range(n+1))

    dxdy = [[-2, 1], [-1, 2], [1, 2], [2, 1], [2, -1], [1, -2], [-1, -2], [-2, -1]]

    dq = deque()

    dq.append([current[0], current[1], 0])

    while len(dq) > 0:

        cx, cy, cnt = dq.popleft()

        if cx == target[0] and cy == target[1]:
            if cnt <= answer:
                answer = cnt
                break

        for dx, dy in dxdy:
            nx, ny = cx + dx, cy + dy

            if 0 <= nx < n and 0 <= ny < n and visited[nx][ny] == 0:
                dq.append([nx, ny, cnt + 1])
                visited[nx][ny] = 1

    return answer


tc = int(input())

for _ in range(tc):
    n = int(input())
    current = list(map(int, input().split(" ")))
    target = list(map(int, input().split(" ")))
    print(solution(n, current, target))
