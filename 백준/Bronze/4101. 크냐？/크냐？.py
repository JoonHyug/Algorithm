while True:
    N, M = map(int, input().split(" "))
    if N and M:
        if N <= M:
            print("No")
        else:
            print("Yes")
    else:
        break