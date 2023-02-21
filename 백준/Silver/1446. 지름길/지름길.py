from heapq import heappop, heappush
import sys
input = sys.stdin.readline

N, D = map(int, input().split(" "))
graph = [[]for _ in range(D+1)]
for i in range(D):
    graph[i].append((i+1, 1))
for _ in range(N):
    s, e, v = map(int, input().split(" "))
    if e > D:
        continue
    graph[s].append((e, v))
dist = [float('inf') for _ in range(D+1)]

def dijkstra(s):
    heap = []
    heappush(heap, (0, s))
    dist[s] = 0
    while heap:
        distance, now = heappop(heap)
        if dist[now] < distance:
            continue
        for end, value in graph[now]:
            if distance + value < dist[end]:
                dist[end] = distance + value
                heappush(heap, (distance + value, end))

dijkstra(0)
print(dist[D])