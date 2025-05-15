# 17분

import sys

input = sys.stdin.readline


def solution(k, n, lan_wires):
    answer = 0

    lan_wires.sort()

    left = 1
    right = lan_wires[-1] + 1

    while left < right:
        mid = (left + right) // 2

        wire_cnt = 0

        for wire in lan_wires:
            wire_cnt += (wire // mid)

        if wire_cnt < n:
            right = mid

        else:
            left = mid + 1
            answer = mid


    return answer


k, n = map(int, input().split(" "))
lan_wires = []

for _ in range(k):
    lan_wire = int(input())
    lan_wires.append(lan_wire)

print(solution(k, n, lan_wires))
