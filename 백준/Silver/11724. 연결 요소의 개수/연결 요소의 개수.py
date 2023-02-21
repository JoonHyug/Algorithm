from collections import deque
import sys
N, M = map(int, sys.stdin.readline().split(" "))
graph = [[]for _ in range(N+1)]
for _ in range(M):
    a, b = map(int, sys.stdin.readline().split(" "))
    graph[a].append(b)
    graph[b].append(a)

visited = [False for _ in range(N+1)]
count = 0
def bfs(v):
    q = deque()
    q.append(v)
    visited[v] = True
    while q:
        a = q.popleft()
        for i in graph[a]:
            if not visited[i]:
                visited[i] = True
                q.append(i)
                

for i in range(1, N+1):
    if not visited[i]:
        bfs(i)
        count += 1
print(count)