text = list(input())
pattern = list(input())

table = [0 for _ in range(len(pattern))]
result = []

def pi(pattern):
    i = 0
    j = 1
    while j < len(pattern):
        while i > 0:
            if pattern[i] != pattern[j]:
                i = table[i-1]
            else:
                break
        # while i > 0 and text[i] != text[j]:
        #     i = table[i-1]
        if pattern[i] == pattern[j]:
            i += 1
            table[j] = i
        j += 1
        
def KMP(text, pattern):
    i=0
    j=0
    while j < len(text):
        while i > 0:
            if pattern[i] != text[j]:
                i = table[i-1]
            else:
                break
        if pattern[i] == text[j]:
            i += 1
            if i == len(pattern):
                result.append(j-i+2) #j=21, i=7 j-i+1로 하면 0번부터 시작하는 배열 기준 15번 정답은 1부터 시작하니까 +2해야함
                i = table[i-1] #뒤에 같은 패턴이 있을 수 있기 때문에
        j += 1
pi(pattern)
KMP(text, pattern)
print(len(result))
print(*result)