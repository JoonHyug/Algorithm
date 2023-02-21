from heapq import heappop, heappush
import sys
input = sys.stdin.readline
N, M = map(int, input().split(" "))
graph = [[]for _ in range(N+1)]
for _ in range(M):
    s, e, v = map(int, input().split(" "))
    graph[s].append((e, v))
    graph[e].append((s, v))

v1, v2 = map(int, input().split(" "))

def dijkstra(s):
    dist = [float('inf') for _ in range(N + 1)]
    heap = []
    heappush(heap, [0, s])
    dist[s] = 0
    while heap:
        distance, now = heappop(heap)
        for end, value in graph[now]:
            if distance + value < dist[end]:
                dist[end] = distance + value
                heappush(heap, ([distance + value, end]))
    return dist

a = dijkstra(1)
b = dijkstra(v1)
c = dijkstra(v2)

result = min(a[v1] + b[v2] + c[N], a[v2] + c[v1] + b[N])
if result == float('inf'):
    print(-1)
else:
    print(result)

