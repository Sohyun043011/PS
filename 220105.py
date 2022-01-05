n = int(input())
data = list(map(int,input().split()))
data.sort()

result = 0  # 총 그룹의 수
count = 0   # 현재 그룹에 포함된 모험가의 수

for i in data:  # 공포도를 낮은 것 부터 하나씩 확인하여
  count+=1      # 현재 그룹에 해당 모험가를 포함시키기 
  if count>=i:
    result+=1
    count=0

print(result)