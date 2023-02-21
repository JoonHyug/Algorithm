from collections import deque

N, M, V = map(int, input().split(" "))
graph = [[0 for _ in range(N + 1)] for _ in range(N + 1)]
visited_bfs = [0 for _ in range(N + 1)]
visited_dfs = [0 for _ in range(N + 1)]
for _ in range(M):
    a, b = map(int, input().split(" "))
    graph[a][b] = 1
    graph[b][a] = 1

def dfs(s):
    visited_dfs[s] = 1
    print(s, end=" ")
    for i in range(1, N+1):
        if graph[s][i] and not visited_dfs[i]:
            dfs(i)


def bfs(s):
    q = deque()
    q.append(s)
    visited_bfs[s] = 1
    while q:
        v = q.popleft()
        print(v, end=" ")
        for i in range(1, N+1):
            if not visited_bfs[i] and graph[v][i]:
                q.append(i)
                visited_bfs[i] = 1


dfs(V)
print()
bfs(V)
