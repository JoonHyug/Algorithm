from itertools import combinations


n = int(input())

nums = []
for i in range(1, 11):
    for comb in combinations(range(0, 10), i):
        comb = list(comb)
        comb.sort(reverse=True)
        nums.append(int(''.join(map(str, comb))))
nums.sort()

if len(nums) < n+1:
    print(-1)
else:
    print(nums[n])