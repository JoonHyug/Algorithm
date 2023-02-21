N, M = map(int, input().split(" "))
temp = []
visited = [False] * N
def dfs(k):
    if len(temp) == M:
        print(' '.join(map(str, temp)))
        return
    for i in range(k, N):
        if visited[i]:
            continue
        visited[i] = True
        temp.append(i + 1)
        dfs(i)
        temp.pop()
        visited[i] = False
dfs(0)
