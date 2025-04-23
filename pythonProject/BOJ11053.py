import sys
import bisect

input = sys.stdin.readline

n = int(input())
a = list(map(int, input().split()))

arr = []
for x in a:
    pos = bisect.bisect_left(arr, x)
    if pos == len(arr):
        arr.append(x)
    else:
        arr[pos] = x

print(len(arr))