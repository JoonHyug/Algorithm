N = int(input())
temp = []
for _ in range(N):
    temp.append(input())
temp = list(set(temp))
temp.sort()
temp.sort(key=lambda x : len(x))
print(*temp, sep="\n")