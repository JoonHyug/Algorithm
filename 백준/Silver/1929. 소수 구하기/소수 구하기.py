N, M = map(int, input().split(" "))
M += 1
temp = [False] * M
temp[1] = True
m = int(M ** 0.5)
for i in range(2, m+1):
    if temp[i] == 0:
        for j in range(i*i, M, i):
            temp[j] = True

for i in range(N, M):
    if temp[i] == False:
        print(i)