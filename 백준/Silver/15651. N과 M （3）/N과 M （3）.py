N, M = map(int, input().split(" "))

temp = []

def dfs():
    if len(temp) == M:
        print(' '.join(map(str, temp)))
        return
    for i in range(1, N+1):
        temp.append(i)
        dfs()
        temp.pop()
dfs()