# 구현 1
# https://www.acmicpc.net/problem/10798
# 배열 초기화
data =[[""]*15 for _ in range(5)]
# 5줄 입력 받음
# 최대 값
m = 0
a=[]
for i in range(0,5):
    data[i] = list(map(str,input()))
    m = max(m,len(data[i]))

for i in range(0,m):
    for j in range(0,5):
        if len(data[j])-1<i:
            continue
        else: a.append(data[j][i])

al = "".join(a)
print(al)