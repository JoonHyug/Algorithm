n = int(input())
m = int(input())
bus = [list(map(int, input().split(' '))) for _ in range(m)]

temp = [[float('inf') for _ in range(n)]for _ in range(n)]

for i in range(m):
    if temp[bus[i][0]-1][bus[i][1]-1] > bus[i][2]:
        temp[bus[i][0]-1][bus[i][1]-1] = bus[i][2]
for i in range(n):
    temp[i][i] = 0
for k in range(n):
    for i in range(n):
        for j in range(n):
            temp[i][j] = min(temp[i][k]+temp[k][j], temp[i][j])
for i in range(n):
    for j in range(n):
        if temp[i][j] == float('inf'):
            print(0, end=" ")
        else:
            print(temp[i][j], end=" ")
    print()