from collections import deque

T = int(input())
result = []
for _ in range(T):
    M, N, K = map(int, input().split(" "))
    dx = [-1, 0, 1, 0]
    dy = [0, -1, 0, 1]
    temp = [[0]*M for _ in range(N)]
    visited = [[0]*M for _ in range(N)]
    for i in range(K):
        x, y = map(int, input().split(" "))
        temp[y][x] = 1
    
    s = 0
    for yy in range(N):
        for xx in range(M):
            if temp[yy][xx] == 1 and not visited[yy][xx] == 1:
                visited[yy][xx] = 1
                q = deque()
                q.append((xx, yy))
                while q:
                    x, y = q.popleft()
                    for i in range(4):
                        nx = x + dx[i]
                        ny = y + dy[i]
                        if 0 <= nx < M and 0 <= ny < N and temp[ny][nx] and not visited[ny][nx]:
                            q.append((nx, ny))
                            visited[ny][nx] = 1
                s += 1
    result.append(s)
                    
for i in range(len(result)):
    print(result[i])