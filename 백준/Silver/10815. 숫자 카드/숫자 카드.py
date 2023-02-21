N = int(input())
N_list = list(map(int, input().split(" ")))
M = int(input())
M_list = list(map(int, input().split(" ")))

N_list.sort()
result = [0 for _ in range(M)]


for i, v in enumerate(M_list):
    low = 0
    high = len(N_list)-1
    m = 0
    while low <= high:
        m = (high + low) // 2
        if v < N_list[m]:
            high = m-1
        elif v > N_list[m]:
            low = m+1
        else:
            result[i] = 1
            break
print(*result)