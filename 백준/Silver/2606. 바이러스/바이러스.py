from collections import deque
N = int(input())
M = int(input())
graph = [[]for _ in range(N+1)]
visited = [False for _ in range(N+1)]
for _ in range(M):
    a, b = map(int, input().split(" "))
    graph[a].append(b)
    graph[b].append(a)

result = []

def dfs(s):
    q = deque()
    q.append(s)
    visited[s] = True
    while q:
        v = q.popleft()
        result.append(v)
        for i in graph[v]:
            if not visited[i]:
                q.append(i)
                visited[i] = True
dfs(1)
print(len(result)-1)
