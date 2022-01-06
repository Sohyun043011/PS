#A,B 가 볼링을 침. 서로 무게가 다른 볼링공을 고른다.총 N개가 있으며, 각 볼링공마다 무게가 적혀있음. 공의 번호는 1번부터 순서대로 부여
#같은 무게의 공이 여러개 있을 수 있지만 서로 다른 공이다.
#볼링공의 무게는 1~M까지.

# n,m=map(int,input().split())
# data = list(map(int,input().split()))

# count = 0
# for i in range(len(data)-1):
#     for j in range(i+1,len(data)):
#         if data[i]!=data[j]:
#             count+=1 

# print(count)    

#볼링공의 최대 무게가 M으로 주어짐. 볼링공의 무게는 1부터 10까지만 존재할 수 있다고 명시되어 있다.
# 따라서 리스트를 이용해서 각 무게별로 볼링공이 몇 개가 존재하는지 기록할 수 있다.
#예시, n=5, m=3 data=1,3,2,3,2

n,m = map(int,input().split())
data = list(map(int,input().split()))

#1부터 10까지 무게를 담을 수 있는 리스트
array = [0]*11

for x in data:
    #각 무게에 해당하는 볼링공의 개수 카운트
    #무게를 index로 이용
    array[x]+=1
    #array[1]=1, array[2]=2, array[3]=2

result = 0
#1부터 m까지의 각 무게에 대하여 처리
for i in range(1,m+1):
    #1부터 3까지 무게에 대해 처리.
    #n은 총 공의 갯수.
    n-=array[i]  #무게가 i인 볼링공의 개수(A가 선택할 수 있는 개수 ) 제외
    result+=array[i]*n  #B가 선택하는 경우의 수와 곱하기
# a가 array[1]을 선택한 경우, n=4, 따라서 1*4=4가 됨
# a가 array[2]을 선택한 경우, n=4-2=2, 따라서 2*2=4 가 됨
# a가 array[3] 을 선택한 경우, n=2-2=0, 따라서 0 이 됨.
# 즉 result = 4+4=8이 됨



print(result)