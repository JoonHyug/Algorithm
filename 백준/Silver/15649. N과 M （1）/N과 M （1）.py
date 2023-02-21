N, M = map(int, input().split(" "))
temp = []
visited = [False] * N
def dfs():
    if len(temp) == M:
        print(' '.join(map(str, temp)))
        return
    for i in range(N):
        if visited[i]:
            continue
        visited[i] = True
        temp.append(i + 1)
        dfs()
        temp.pop()
        visited[i] = False
dfs()
