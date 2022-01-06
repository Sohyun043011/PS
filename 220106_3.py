#N개의 동전을 갖고 있다. N개의 동전을 이용하여 만들 수 없는 양의 정수 금액 중 최솟값을 구하는 프로그램을 작성하라
#N=5, 동전이 3,2,1,1,9원짜리이면

n = int(input())
data = list(map(int,input().split()))
data.sort()
# data=[1,1,2,3,9]
#금액 1을 만들 수 있는지 확인하기 위해 target=1 로 설정,
target=1
for x in data:
    if target<x:
        break
    target+=x
    # 1+1 = 2, target=2, 2+1=3, 3+2=5,5+3=8, 8<9 break,-> target=8

print(target)