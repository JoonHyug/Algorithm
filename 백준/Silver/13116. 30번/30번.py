import sys
input = sys.stdin.readline
N = int(input())

def comp(A, B):
    for i in range(len(A)):
        for j in range(len(B)):
            if A[i] == B[j]:
                return A[i] * 10

result = []
for _ in range(N):
    a, b = map(int, input().split(" "))
    A = []
    B = []
    while a > 0 or b > 0:
        A.append(a)
        B.append(b)
        a //= 2
        b //= 2
    result.append(comp(A, B))
print(*result, sep="\n")