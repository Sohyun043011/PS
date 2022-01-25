# 구현 4
# https://www.acmicpc.net/problem/2980

N,L = map(int,input().split())
data = []
time = 0
for i in range(N):
    data.append(list(map(int,input().split())))

time=0

for j in range(N):
    if j==0:
        time+=data[j][0]
    else:
        time+=(data[j][0]-data[j-1][0])
    
    sin_sum = data[j][1]+data[j][2]
    temp = time%sin_sum
    if temp<data[j][1]:
        time+=(data[j][1]-temp)
    else:
        time+=0

time+=(L-data[-1][0])

print(time)