import sys
from collections import deque

input = sys.stdin.readline

# input
# test case
t = int(input())


def bfs():
    q = deque()
    q.append((xh, yh))

    while q:
        x, y = q.popleft()

        if abs(xp - x) + abs(yp - y) <= 1000:
            print("happy")
            return

        else:
            for i in range(len(stores)):
                if is_visited[i] == 0:
                    xs, ys = stores[i][0], stores[i][1]
                    if abs(xs - x) + abs(ys - y) <= 1000:
                        q.append((xs, ys))
                        is_visited[i] = 1

    print("sad")


for ___ in range(t):
    # input
    # 편의점 개수
    n = int(input())

    # 집
    xh, yh = map(int, input().split(' '))

    # 편의점
    stores = []
    is_visited = [0 for _ in range(n)]
    for _ in range(n):
        a, b = map(int, input().split(' '))
        stores.append((a, b))

    # 펜타포트
    xp, yp = map(int, input().split(' '))

    bfs()
