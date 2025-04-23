import sys

input = sys.stdin.readline


def absolute_distantce(direction, x):
    if direction == 1:
        return x
    elif direction == 2:
        return 2 * n + m - x
    elif direction == 3:
        return 2 * n + 2 * m - x
    elif direction == 4:
        return n + x


# 블록의 가로, 세로
n, m = map(int, input().split())
total = 2 * (n + m)

# 상점의 개수
k = int(input())

# 상점 위치
# 1 북쪽, 2 남쪽, 3 서쪽, 4 동쪽
shops = []
for _ in range(k):
    direction, x = map(int, input().split())
    shops.append([direction, x])

start_direction, start_x = map(int, input().split())
start_position = absolute_distantce(start_direction, start_x)

answer = 0
for shop in shops:
    position = absolute_distantce(shop[0], shop[1])
    tmp = abs(position - start_position)
    if tmp > n + m:
        answer += total - tmp
    else:
        answer += tmp

print(answer)
