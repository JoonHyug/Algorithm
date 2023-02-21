# InOrder형태로 값이 주어졌을 때 원래 트리를 출력하시오
# 빌딩의 번호는 1 ~ 2^N-1 까지의 값이다.(N가 3이라면 1~8)
# N은 트리의 높이이기도 하다.
import sys
input = sys.stdin.readline
N = int(input())
tree = list(map(int, input().split(" ")))
result = [[] for _ in range(N)]
# result = []

def undoInOrder(temp, n):
    if len(temp) == 0:
        return
    if len(temp) == 1:
        result[n].append(temp[0])
    else:    
        i = len(temp) // 2
        result[n].append(temp[i])
    i = len(temp) // 2
    n+=1
    undoInOrder(temp[0:i], n)
    undoInOrder(temp[i+1:len(temp)], n)

undoInOrder(tree, 0)

for i in range(N):
    print(*result[i], end=" ")
    print()
