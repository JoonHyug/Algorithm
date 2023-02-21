from heapq import heappush, heappop
V, E = map(int, input().split(" "))
K = int(input()) - 1
temp = [[]for _ in range(V)]
for i in range(E):
    u, v, w = map(int, input().split(" "))
    temp[u-1].append((v-1, w))
dist = [float('INF') for _ in range(V)]
heap = []
heappush(heap, [0, K])
dist[K] = 0
while heap:
    hdist, now = heappop(heap)
    for v, w in temp[now]:
        if hdist + w < dist[v]:
            dist[v] = hdist+w
            heappush(heap, (hdist+w, v))
# print(*temp, sep="\n")
for i in range(V):
    if dist[i] == float('inf'):
        print("INF")
    else:
        print(dist[i])