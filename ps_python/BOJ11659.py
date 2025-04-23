import sys

input = sys.stdin.readline

n, m = map(int, input().split())
arr = list(map(int, input().split()))

answer = []

sums = [0]
tmp = 0
for i in arr:
    tmp += i
    sums.append(tmp)

for i in range(m):
    start, end = map(int, input().split())
    answer.append(sums[end] - sums[start-1])

for item in answer:
    print(item)