X = int(input())

temp = [0] * (X+1)
for i in range(2, X+1):
    a = []
    if i%3==0:
        a.append(temp[i // 3])
    if i%2 ==0:
        a.append(temp[i // 2])
    a.append(temp[i-1])
    temp[i] = min(a)+1

print(temp[X])