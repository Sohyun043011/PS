# https://www.acmicpc.net/problem/11000

#count가 되는 경우를 살펴보자

# n = int(input())
# data = []
# count =0 
# #초기 
# s,t = map(int,input().split())
# data.append(s)
# data.append(t)
# n-=1

# #이후로는 비교해주면서 넣기
# while n!=0:
#     s,t = map(int,input().split())
#     for i in range(0,len(data)):
#         if s>data[i]:
#             if i!=(len(data)-1):
#                 if t<=data[i+1]:
#                     data.append(s)
#                     data.append(t)
#                     data.sort()
#                 else:
#                     count+=1
#             elif i==len(data)-1:
#                 #마지막 원소인 경우
#                 data.append(s)
#                 data.append(t)
#                 data.sort()
#     n-=1
# print(count)

import heapq
import sys
#heapq : 리스트를 최소 힙처럼 다룰 수 있도록 도와주는 모듈
N=int(input())
C=[]
h=[]    #heapq에 이용할 리스트

#split() : 공백을 기준으로 input을 쪼개어 리스트 형태로 반환
#map() : split된 여러개의 input에 대하여 일괄적으로 형 변환
#sys.stdin.readline(): input과 사용방법 동일, 개행문자(\n)까지 함께 입력받는다

for i in range(N):
    C.append(list(map(int,sys.stdin.readline().split())))

C = sorted(C,key = lambda x:x[0])
# C를 정렬하는데, 첫번째 인자 기준으로 정렬
# [[1,3],[2,4],[3,5]]

for i in range(N):
    if len(h)!=0 and h[0]<=C[i][0]:
        #비어있지 않고,
        # 현재 heap에 있는 값이 지금 리스트의 start time보다 작으면
        # pop을 해준다 -> 같은 강의실에 배정된다는 뜻
        heapq.heappop(h)
    #그게 아닐 경우는 강의실을 하나 더 배정하는 경우이므로
    #C[i][1] end time을 heap에 넣어준다.
    heapq.heappush(h,C[i][1])
    #heapq에는 end time을 넣음.
print(len(h))