from heapq import heappop, heappush
import sys
T = 0

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

def dijkstra(n):
    heap = []
    heappush(heap, (temp[0][0], 0, 0))
    dist[0][0] = temp[0][0]
    while heap:
        distance, x, y = heappop(heap)
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < n:
                if distance + temp[ny][nx] < dist[ny][nx]:
                    dist[ny][nx] = distance + temp[ny][nx]
                    heappush(heap, (distance + temp[ny][nx], nx, ny))

while True:
    T += 1
    N = int(sys.stdin.readline())
    if N == 0:
        break
    dist = [[float('inf') for _ in range(N)] for _ in range(N)]
    temp = [[*map(int, sys.stdin.readline().split(" "))]for _ in range(N)]

    dijkstra(N)
    print("Problem %d: %d" % (T, dist[N-1][N-1]))