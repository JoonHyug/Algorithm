import sys

N, M = map(int, sys.stdin.readline().split(" "))
temp = [[0 for _ in range(N)] for _ in range(N)]

for i in range(M):
    a, b = map(int, sys.stdin.readline().split(" "))
    temp[a - 1][b - 1] = 1

for k in range(N):
    for i in range(N):
        for j in range(N):
            if temp[i][j] == 1 or (temp[i][k] == 1 and temp[k][j] == 1):
                temp[i][j] = 1

result = 0
    
for i in range(N):
    count = 0
    for j in range(N):
        count += temp[i][j] + temp[j][i]
    if count == N-1:
        result += 1

print(result)