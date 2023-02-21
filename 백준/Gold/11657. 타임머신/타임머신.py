N, M = map(int, input().split(" "))
graph = []
for _ in range(M):
    A, B, C = map(int, input().split(" "))
    graph.append((A-1, B-1, C))
dist = [float('inf') for _ in range(N)]
dist[0] = 0

def Bellman():
    for i in range(N):
        for a, b, c in graph:
            nw = dist[a] + c
            if dist[a] != float('inf') and dist[b] > nw:
                dist[b] = nw
                if i == N-1:
                    return False
    return True

check = Bellman()
for i in range(1, len(dist)):
    if check:
        if i != 0 and dist[i] != float('inf'):
            print(dist[i])
        else:
            print(-1)
    else:
        print(-1)
        break