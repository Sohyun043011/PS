# https://www.acmicpc.net/problem/2875
#여 2 + 남 1 한팀
#여 N명, 남 M명
# 참여하려는 학생 중 K명은 반드시 인턴쉽 프로그램에 가야함
# 인턴쉽에 참여하면 대회에 참여하지 못한다.
# N,M,K
# 만들 수 있는 팀의 최대 개수를 출력하라.
# (6,3,2) ->(5,2,)-> 2팀.
n,m,k = map(int,input().split())

result = 0

for x in range(0,k+1):
    result = max(result,min((n-x)//2,m-(k-x)))



print(result)


#(5,5,5)->(5,0)->0 (0,5)->0 , (4,1)->1팀 가능. (2,3)->1팀가능(3,2)->1팀 가능...전체수에서 K를 뺴면?