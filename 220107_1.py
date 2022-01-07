# https://www.acmicpc.net/problem/11047
n,k = map(int,input().split())
#n : 1<=N<=10(동전의 종류) #k : 동전을 이용한 합
data=[]
count =0
while n!=0:
    data.append(int(input()))
    n-=1

#print(data)
#K원을 만드는데 필요한 동전 개수의 최솟값을 출력한다.
data.sort(reverse=True)
#print(data)    
for x in data:
    if(k>0):
        if(x>k): continue
        else:
            count+=(k//x)
            k%=x    #나머지
    else:
        break

print(count)

