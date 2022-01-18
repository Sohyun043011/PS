# https://www.acmicpc.net/problem/15686
from itertools import combinations

N,M = map(int,input().split())
# N : N*N 행렬, M =최대갯수
# 도시 N*N 입력 받음

# 집(=1) 인 갯수 

house = []
chicken = []

for r in range(N):
    data = list(map(int,input().split()))
    for c in range(N):
        if data[c]==1:
            #입력 받은 수가 1이면 house에 추가
            house.append((r,c))
        elif data[c]==2:
            #입력 받은 수가 2이면 chicken에 추가
            chicken.append((r,c))

    
# 모든 치킨집 중에서 m개의 치킨집을 뽑는 조합 계산
candidates = list(combinations(chicken,M))

#치킨 거리의 합을 계산하는 함수
def get_sum(candidate):
    # 위에서 구한 candidate 중에서 하나씩 넣고 돌림.
    # 예시) candidate = {M개의 치킨집}
    result = 0
    #모든 집에 대하여
    for hx,hy in house:
        #가장 가까운 치킨집을 찾기
        temp = 1e9
        for cx,cy in candidate:
            temp = min(temp,abs(hx-cx)+abs(hy-cy))
        #가장 가까운 치킨집까지의 거리를 더하기
        result+=temp
    #치킨 거리의 합 반환
    return result

#치킨 거리의 합의 최소를 찾아 출력
result = 1e9
for candidate in candidates:
    result = min(result,get_sum(candidate))

print(result)