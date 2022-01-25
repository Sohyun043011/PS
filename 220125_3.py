# 구현3
# https://www.acmicpc.net/problem/3048

n1,n2 = map(int,input().split())
#n1 : 1번 개미 수 n2 : 2번 개미 수

data1 =input()
data2 = input()

t = int(input()) #t초 후 시간 입력

# data1을 거꾸로 정렬 후, data1과 data2 이어붙이기
# for i in range(len(d1)//2):
#     temp = d1[len(d1)-1-i]  #끝에 자리
#     d1[i],d1[len(d1)-1-i] = d1[len(d1)-1-i],d1[i]

# 슬라이스로 data1 거꾸로 뒤집기
r_data1 = data1[::-1]


#data1 = "".join(d1)

data3 = []  #d1과 d2를 이어붙일 공간

answer = []

for i in range(n1):
    data3.append((0,r_data1[i])) #d1은 0으로 표시

for j in range(n2):
    data3.append((1,data2[j]))  #d2는 1로 표시



for i in range(t):

        k=0
        while k<len(data3)-1:
            if data3[k][0] != data3[k+1][0] and data3[k][0]==0:
                data3[k],data3[k+1] = data3[k+1],data3[k]
                k+=2
            else:
                k+=1     

for j in range(len(data3)):
    answer.append(data3[j][1])

ans = "".join(answer)
print(ans)

