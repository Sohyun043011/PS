#Ch2. 구현 - 상하좌우 - 시뮬레이션 유형
N = int(input())
data = list(input().split())

x = 0
y = 0

for v in data:
    if v=='R':
        if (y+1)>=N:
            continue
        else:
          
            y+=1
    elif v=='L':
        if (y-1)<0:
            continue
        else:
         
            y-=1
    elif v=='U':
        if (x-1)<0:
            continue
        else:
            
            x-=1
    elif v=='D':
        if (x+1)>=N:
            continue
        else:
            
            x+=1

print(x+1,y+1)

