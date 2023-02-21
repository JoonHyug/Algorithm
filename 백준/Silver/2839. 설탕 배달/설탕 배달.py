num = int(input())
count = 0
while num > 0:
    if num % 5 == 0:
        num -= 5
        count += 1
    else:
        num -= 3
        count += 1
    if num < 0:
        count = -1 

print(count)        