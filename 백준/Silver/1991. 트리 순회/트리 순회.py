# class Node:
#     def __init__(self, data):
#         self.data = data
#         self.left = None
#         self.right = None
#     def insert_child(self, node):
#         node.parent = self
#         self.children.append(node)

N = int(input())
temp = {}
for _ in range(N):
    n, l, r = map(str, input().split(" "))
    if temp.get(n, None) == None:
        temp[n] = [l,r]

def PreOrder(C):
    if C != '.':
        print(C, end="")
        PreOrder(temp[C][0])
        PreOrder(temp[C][1])
def InOrder(C):
    if C != '.':
        InOrder(temp[C][0])
        print(C, end="")
        InOrder(temp[C][1])
def PostOrder(C):
    if C != '.':
        PostOrder(temp[C][0])
        PostOrder(temp[C][1])
        print(C, end="")

PreOrder('A')
print()
InOrder('A')
print()
PostOrder('A')