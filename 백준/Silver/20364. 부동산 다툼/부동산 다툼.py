import sys
input = sys.stdin.readline
N, M = map(int, input().split(" "))
visited = [False for _ in range(N+1)]
ori = [int(input()) for _ in range(M)]


for i in range(len(ori)):
    answer = 0
    check = ori[i]
    while check > 0:
        if visited[check]:
            answer = check
        check //= 2
    visited[ori[i]] = True
    print(answer)
    