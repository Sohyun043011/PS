#처음에 풀 때 숫자가 1인 경우를 생각 못함. 숫자가 1이나 0인 경우에는, 곱하기보다 더하는 것이 result값이 더 커짐.

data = input()

result = int(data[0])

for i in range(1,len(data)):
    num = int(data[i])
    if num<=1 or result<=1:
        result+=num
    else:
        result*=num

print(result)