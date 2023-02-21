N, X = map(int, input().split(" "))
temp = list(map(int, input().split(" ")))
for i in range(N):
    if temp[i] < X:
        print(temp[i], end=" ")