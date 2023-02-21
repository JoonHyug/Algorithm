from heapq import heappop, heappush
import sys
N = int(sys.stdin.readline())
M = int(sys.stdin.readline())
temp = [[]for _ in range(N)]
for _ in range(M):
    s, e, v = map(int, sys.stdin.readline().split(" "))
    temp[s - 1].append((e - 1, v))
dist = [float('inf') for _ in range(N)]

start, end = map(int, sys.stdin.readline().split(" "))

def dijkstra(s, e):
    heap = []
    heappush(heap, (0, s))
    dist[s] = 0
    while heap:
        distance, now = heappop(heap)
        if dist[e] < distance:
            continue
        for end, value in temp[now]:
            if distance + value < dist[end]:
                dist[end] = distance + value
                heappush(heap, (distance + value, end))
dijkstra(start - 1, end - 1)
print(dist[end -1])