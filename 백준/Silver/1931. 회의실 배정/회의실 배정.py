T = int(input())
temp = [[*map(int, input().split(" "))] for _ in range(T)]
count = 1

temp.sort(key=lambda x:(x[1], x[0]))

k=0
for m in range(1, T):
    if temp[m][0] >= temp[k][1]:
        
        k = m
        count += 1
print(count)