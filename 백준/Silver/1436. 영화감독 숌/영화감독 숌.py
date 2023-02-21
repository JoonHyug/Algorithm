N = int(input())
temp = [666]
i = 667
while len(temp) != N:
    if str(i).find("666") != -1:
        temp.append(i)
    i += 1
print(temp[N-1])