from collections import deque
N = int(input())
RGB = [list(map(str, input())) for _ in range(N)]

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]
visited = [[0] * N for _ in range(N)]
rgb_result = [0, 0, 0]
rb_result = [0, 0]

def bfs(x, y, c):
    visited[y][x] = 1
    q = deque()
    q.append((x, y))
    while q:
        qx, qy = q.popleft()
        for i in range(4):
            nx = qx + dx[i]
            ny = qy + dy[i]
            if 0 <= nx < N and 0 <= ny < N and RGB[ny][nx] == c and not visited[ny][nx]:
                q.append((nx, ny))
                visited[ny][nx] = 1


for y in range(N):
    for x in range(N):
        if RGB[y][x] == "R" and not visited[y][x] == 1:
            bfs(x, y, "R")
            rgb_result[0] += 1
        elif RGB[y][x] == "G" and not visited[y][x] == 1:
            bfs(x, y, "G")
            rgb_result[1] += 1
        elif RGB[y][x] == "B" and not visited[y][x] == 1:
            bfs(x, y, "B")
            rgb_result[2] += 1

RB = RGB
for i in range(N):
    for j in range(N):
        if RB[i][j] == "G":
            RB[i][j] = 'R'
visited = [[0] * N for _ in range(N)]
for y in range(N):
    for x in range(N):
        if RB[y][x] == "R" and not visited[y][x] == 1:
            bfs(x, y, "R")
            rb_result[0] += 1
rb_result[1] = rgb_result[2]
print("%d %d" % (sum(rgb_result),sum(rb_result)))