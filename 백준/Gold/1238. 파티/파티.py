from heapq import heappop, heappush
import sys
N, M, X = map(int, input().split(" "))
dist = [[float('inf') for _ in range(N)]for _ in range(N)]
temp = [[]for _ in range(N)]
for _ in range(M):
    start, end, value = map(int, input().split(" "))
    temp[start - 1].append((end - 1, value))
    
def dijkstra(s):
    heap = []
    heappush(heap, (0, s))
    dist[s][s] = 0
    while heap:
        distance, now = heappop(heap)
        if dist[s][now] < distance:
            continue
        for end, value in temp[now]:
            if distance + value < dist[s][end]:
                dist[s][end] = distance + value
                heappush(heap, (distance + value, end))
for i in range(N):
    dijkstra(i)
result = []
for i in range(N):
    result.append(dist[i][X-1] + dist[X-1][i])
print(max(result))
