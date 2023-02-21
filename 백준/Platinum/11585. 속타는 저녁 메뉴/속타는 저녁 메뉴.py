N = int(input())
pattern = list(input().replace(" ", ""))
text = list(input().replace(" ", ""))

table = [0 for _ in range(len(pattern))]
result = []


def pi(pattern):
    i = 0
    j = 1
    while j < len(pattern):
        while i > 0 and pattern[i] != pattern[j]:
            i = table[i-1]
        if pattern[i] == pattern[j]:
            i += 1
            table[j] = i
        j += 1


def KMP(text, pattern):
    pi(pattern)
    i = 0
    j = 0
    while j < len(text):
        while i > 0 and pattern[i] != text[j]:
                i = table[i - 1]
        if pattern[i] == text[j]:
            i += 1
            if i == len(pattern):
                result.append(i)
                i = table[i - 1]
        j += 1


text += text[:len(text)-1]
KMP(text, pattern)
a = len(result)
print("%d/%d" % ((N%a)+1, N//a))