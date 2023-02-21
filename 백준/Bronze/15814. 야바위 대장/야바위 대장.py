text = list(input())
T = int(input())
for i in range(T):
    A, B = map(int, input().split(" "))
    temp = text[A]
    text[A] = text[B]
    text[B] = temp
print(''.join(text))

