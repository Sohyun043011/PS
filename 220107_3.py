# https://www.acmicpc.net/problem/10610
#양수 N,에 포함된 숫자들을 섞어 30의 ㅂ수가 되는 가장 큰 수를 만들고 싶다.
#N은 0으로 시작하지 않는 정수
# 마르코가 만들고 싶어하는 수가 존재한다면, 그 수룰 출력하라
# 존재하지 않으면 -1을 출력하라
# 30의 배수가 되는 가장 큰 수????
# 일단. 맨 뒤 글자가 0이 되어야 함.
# 그럼, 일단 내가 받은 수에 0이 없으면 -1
# 일단 내가 받은 수에 0이 있으면, 10으로 나눔
# 그리고 나서는 3의 배수인지를 보면 됨.
# 0 을 제외한 나머지 숫자들을 더한다음에 얘네를 3으로 나누고 나머지가 0인지 확인
# 아니라면 -1임.
# 맞다면 그냥 sort 하면됨

data = list(input())
# 각각 잘라서 list에 넣자 어케넣지??
sum=0

isZero = False
for x in data:
    num = int(x)
    sum+=num
    if num==0:
        isZero=True

if isZero==False:
    print(-1)
else:
    if(sum%3==0):
        data.sort(reverse=True)
        str ="".join(data)
        print(str)
    else:
        print(-1)
   