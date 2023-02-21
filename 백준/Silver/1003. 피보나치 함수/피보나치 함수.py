def fibo(n):
    fibo_zero = [1, 0, 1]
    fibo_one = [0, 1, 1]
    for i in range(3, n+1):
        fibo_zero.append(fibo_zero[i-1]+fibo_zero[i-2])
        fibo_one.append(fibo_one[i-1]+fibo_one[i-2])
    print(fibo_zero[n], fibo_one[n])

num = int(input())
for i in range(num):
    fibo(int(input()))