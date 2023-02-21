import sys
from heapq import heappop, heappush
N = int(sys.stdin.readline())
heap = []
for _ in range(N):
    n = int(sys.stdin.readline())
    if n == 0:
        if len(heap) == 0:
            print(0)
        else:
            print(heappop(heap)[1])
    else:
        heappush(heap, (abs(n), n))
