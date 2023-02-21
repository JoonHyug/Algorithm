N, M = map(int, input().split(" "))
temp = [input() for _ in range(N+M)]

visited = set()
result = {i for i in temp if i in visited or(visited.add(i) or False)}

result = list(result)
result.sort()
print(len(result))
print(*result, sep='\n')