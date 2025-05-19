import sys

input = sys.stdin.readline

n = int(input())
m = int(input())
INF = 10 ** 9

graph = list([INF for _ in range(n + 1)] for __ in range(n + 1))

for i in range(1, n+1):
    graph[i][i] = 0

for i in range(m):
    a, b, c = map(int, input().split(" "))
    if c < graph[a][b]:
        graph[a][b] = c

for k in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            if graph[i][j] > graph[i][k] + graph[k][j]:
                graph[i][j] = graph[i][k] + graph[k][j]

for i in range(1, n+1):
    for j in range(1, n+1):
        if graph[i][j] == INF:
            print(0, end=" ")
        else:
            print(graph[i][j], end=" ")
    print()
