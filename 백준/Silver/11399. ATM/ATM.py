N = int(input())
P = list(map(int, input().split(" ")))
time = 0
temp = []
P.sort()
for i in P:
    time += i
    temp.append(time)
print(sum(temp))