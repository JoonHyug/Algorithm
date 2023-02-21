T = int(input())

def calc(X, n):
    if X == 0:
        a.append(n)
        return
    else:
        if X - 3 >= 0:
            calc(X - 3, n + 1)
        if X - 2 >= 0:
            calc(X - 2, n + 1)
        if X - 1 >= 0:
            calc(X - 1, n + 1)
result = []
for _ in range(T):
    num = int(input())
    a = []
    calc(num, 0)
    result.append(len(a))
for i in range(len(result)):
    print(result[i])