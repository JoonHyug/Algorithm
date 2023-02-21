from collections import deque
N, K = map(int, input().split(" "))

visited = [0 for _ in range(100_001)]

def BFS(n):
    q = deque()
    q.append(n)
    while q:
        mq = q.popleft()
        move = [mq-1, mq+1, mq*2]
        if mq == K:
            return visited[mq]
        for i in range(3):
            m = move[i]
            if 0 <= m <= 100_000 and not visited[m]:
                visited[m] = visited[mq] + 1
                q.append(m)
print(BFS(N))
# print(visited[:20])