from collections import deque

N= int(input())
result = []
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]
temp = [[*map(int, input())] for _ in range(N)]
visited = [[0] * N for _ in range(N)]
for yy in range(N):
    for xx in range(N):
        if temp[yy][xx] == 1 and not visited[yy][xx] == 1:
            visited[yy][xx] = 1
            q = deque()
            q.append((xx, yy))
            count = 0
            while q:
                x, y = q.popleft()
                for i in range(4):
                    nx = x + dx[i]
                    ny = y + dy[i]
                    if 0 <= nx < N and 0 <= ny < N and temp[ny][nx] and not visited[ny][nx]:
                        q.append((nx, ny))
                        visited[ny][nx] = 1
                count += 1
            result.append(count)
print(len(result))
result.sort()
for i in range(len(result)):
    print(result[i])