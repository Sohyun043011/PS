# https://www.acmicpc.net/problem/1931

import sys

N = int(input())
C =[]
stack = []
for i in range(N):
    C.append(list(map(int,sys.stdin.readline().split())))

C = sorted(C,key = lambda x: (x[1],x[0]))

#C 에서 key값이 같은 경우, 오름차순 정렬 하고 싶음
# for i in range(N-1):
#     for j in range(i+1,N):
#         if C[i][1]==C[j][1]:
#             #key값이 같을 경우 
#             if C[i][0]>=C[j][0]:
#                 #앞에 start time이 더 크면 swap
#                 C[i][0],C[j][0]=C[j][0],C[i][0]
#         else:
#             break

#print(C)

for i in range(N):
    if len(stack)==0:
        stack.append(C[i][1])
    elif len(stack)!=0 and stack[-1]<=C[i][0]:
        stack.append(C[i][1])


print(len(stack))

