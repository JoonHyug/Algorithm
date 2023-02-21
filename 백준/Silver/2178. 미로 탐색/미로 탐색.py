from collections import deque
N, M  = map(int, input().split(" "))
temp = [list(map(int, input())) for _ in range(N)]

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

q = deque()
q.append((0, 0))
while q:
    qx, qy = q.popleft()
    for i in range(4):
        nx = qx + dx[i]
        ny = qy + dy[i]
        if 0 <= nx < M and 0 <= ny < N and temp[ny][nx] == 1:
                q.append((nx, ny))
                temp[ny][nx] = temp[qy][qx] + 1
                    

print(temp[N-1][M-1])