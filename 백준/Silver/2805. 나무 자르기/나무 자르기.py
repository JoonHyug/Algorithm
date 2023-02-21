import sys
input = sys.stdin.readline
N, M = map(int, input().split(" "))
arr = [*map(int, input().split(" "))]
start = 1
end = max(arr)

while start <= end:
    mid = (start + end) // 2
    temp = 0
    for i in arr:
        if i > mid:
            temp += i - mid
    if temp >= M:
        # mid까지는 탐색했기 때문에 mid + 1부터 end 까지 탐색
        start = mid + 1
    elif temp < M:
        # mid부터 end까지는 탐색했기 때문에 start부터 mid - 1 까지 탐색
        end = mid - 1
print(end)