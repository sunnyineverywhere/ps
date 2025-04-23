import heapq

minheap = []
answer = []
t = int(input())

for i in range(t):
    n = int(input())
    if n != 0:
        heapq.heappush(minheap, n)
    else:
        if len(minheap) == 0:
            answer.append(0)
        else: answer.append(heapq.heappop(minheap))


for n in answer:
    print(n)