N = int(input())
num = list(map(int, input().split(" ")))
M = max(num)+1
temp = [False] * M
temp[0] = True
temp[1] = True
m = int(M ** 0.5)
for i in range(2, m+1):
    if temp[i] == False:
        for j in range(i*i, M, i):
            temp[j] = True

count = 0
for i in range(len(temp)):
    if temp[i] == False and i in num:
        count += 1
print(count)

