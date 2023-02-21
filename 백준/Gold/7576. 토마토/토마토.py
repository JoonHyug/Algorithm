from collections import deque
N, M = map(int, input().split(" "))
temp = [[*map(int, input().split(" "))] for _ in range(M)]

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

def bfs():
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < M and 0 <= ny < N and temp[nx][ny] == 0:
                temp[nx][ny] = temp[x][y] + 1
                q.append((nx, ny))
                
q = deque()
for i in range(N):
    for j in range(M):
        if temp[j][i] == 1:
            q.append((j, i))
            
            
bfs()


check = 0
result = 0
for i in range(N):
    for j in range(M):
        if temp[j][i] == 0:
            check = 1
        result = max(result, temp[j][i])
        
        
if check == 1:
    print(-1)
elif result == 1:
    print(0)
else:
    print(result-1)
