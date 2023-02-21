import sys

n, m = map(int, sys.stdin.readline().split(" "))

temp = [[float('inf') for _ in range(n)]for _ in range(n)]
node = [[0 for _ in range(n)]for _ in range(n)]

for i in range(m):
    a, b, c = map(int, sys.stdin.readline().split(" "))
    temp[a - 1][b - 1] = c
    temp[b - 1][a - 1] = c
    node[a-1][b-1] = b
    node[b-1][a-1] = a

for k in range(n):
    for i in range(n):
        for j in range(n):
            if temp[i][j] > temp[i][k] + temp[k][j]:
                temp[i][j] = temp[i][k] + temp[k][j]
                node[i][j] = node[i][k]
                
for i in range(n):
    for j in range(n):
        if i == j:
            print("-", end=" ")
        else:
            print(node[i][j], end=" ")
    print()