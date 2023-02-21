N = int(input())
cnt = int(input())
S = list(input())

result = []
temp = []
for i in range(cnt):
    if 0 <= i-N < cnt and 0 <= i+N < cnt:
        temp.append(S[i-N : i+N+1])
for i in range(len(temp)):
    check = False
    for j in range(len(temp[i])): 
        if j % 2 != 0:
            if temp[i][j] == "O":
                check = True
            else:
                check = False
        else:
            if temp[i][j] == "I":
                check = True
            else:
                check = False
        if check == False:
            break
    if check == True:
        result.append(temp[i])
print(len(result))