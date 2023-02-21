n = int(input())
temp = []
for i in range(n):
    num = int(input())
    if num:
        temp.append(num)
    else:
        temp.pop()
print(sum(temp))