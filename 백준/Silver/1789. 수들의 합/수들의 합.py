S = int(input())
sum = 0
for N in range(1, 4294967295):
    sum += N
    if(sum > S):
        break
print(N - 1)