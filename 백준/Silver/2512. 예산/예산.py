N = int(input())
arr = list(map(int, input().split(" ")))
M = int(input())

start = 1
end = max(arr)

while start <= end:
    mid = (start + end) // 2
    temp = 0
    for i in arr:
        if i > mid:
            temp += mid
        else:
            temp += i
    # print(temp)
    if temp <= M:
        start = mid + 1
    else:
        end = mid - 1
# print(start)
# print(mid)
print(end)
    

