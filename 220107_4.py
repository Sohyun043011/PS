# https://www.acmicpc.net/problem/1783
N,M = map(int,input().split())
if N==1:
    count = 1
elif N==2:
    count = min(4,((M-1)//2)+1)
elif M<7:
    count = min(4,M)
else:
    count = M-2

print(count)