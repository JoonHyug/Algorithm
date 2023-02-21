N, M = map(int, input().split(" "))
temp = [[float('inf') for _ in range(N)] for _ in range(N)]
for i in range(M):
    a, b = map(int, input().split(" "))
    temp[a - 1][b - 1] = 1
    temp[b - 1][a - 1] = 1

result = []

for k in range(N):
    for i in range(N):
        for j in range(N):
            if i != j:
                temp[i][j] = min(temp[i][k]+temp[k][j], temp[i][j])
            else:
                temp[i][j] = 0

for i in range(N):
    result.append(sum(temp[i]))
print(result.index(min(result))+1)