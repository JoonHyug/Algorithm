list1 = []
x, y, count = 0, 0, 0
for i in range(0, 4):
    temp = map(int, input().split(" "))
    list1 += list(temp)

for i in range(len(list1)):
    if i % 2 == 0:
        if list1[i] > x:
            x = list1[i]
    else:
        if list1[i] > y:
           y = list1[i]
            
list2 = [[0 for j in range(x)] for i in range(y)]
for i in range(4):
    for j in range(list1[0+4*i], list1[2+4*i]):
        for k in range(list1[1+4*i], list1[3+4*i]):
            list2[k][j] = 1
    
for i in range(x):
    for j in range(y):
        if list2[j][i] == 1:
            count += 1
print(count)