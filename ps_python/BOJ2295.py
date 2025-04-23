import sys

input = sys.stdin.readline

n = int(input())
arr = []
for i in range(n):
    x = int(input())
    arr.append(x)
arr.sort()

arr_sum = set()

for x in arr:
    for y in arr:
        arr_sum.add(x + y)


def find():
    global answer
    for i in range(n - 1, -1, -1):
        for j in range(i + 1):
            if arr[i] - arr[j] in arr_sum:
                answer = arr[i]
                return


answer = 0
find()
print(answer)
