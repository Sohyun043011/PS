# 럭키 스트레이트
# 캐릭터 점수 N 자릿수를 기준으로 점수 N을 반으로 나누어,
# 왼쪽 부분의 각 자릿수의 합과 오른쪽 부분의 각 자릿수의 합을 더한 값이 동일한 상황을 의미.
# 점수 N의 자릿수는 항상 짝수형태이다. 
N = input()

sum1=0
sum2=0
for i in range(0,len(N)//2):
    sum1+=int(N[i])

for j in range(len(N)//2,len(N)):
    sum2+=int(N[j])

if sum1==sum2:
    print("LUCKY")
else:
    print("READY")