# 문자열 재정렬
# 알파벳 대문자와 숫자로만 구성된 문자열
# 이때 모든 알파벳을 오름차순으로 정렬하여 이어서 출력한 뒤, 그 뒤 모든 숫자를 더한 값을 이어서 출력한다.
# 첫째 줄에 하나의 문자열 S가 주어짐
# 정답을 출력
# print(ord('A')) #65
# print(ord('Z')) #90
# print(ord('0')) #48 
# print(ord('9')) #57

S = list(input())
sum = 0
alph = []
for x in S:
    #숫자라면 sum에 더함
    if ord(x)>=48 and ord(x)<=57:
        sum+=int(x)
    else:
        alph.append(x)

#알파벳인지 판별하는 isalpha()가 있었음
# for x in S:
#     if x.isalpha():
#         alph.append(x)
#     else:
#         sum+=int(x)


alph.sort()
al = "".join(alph)
print(al+str(sum))

##이렇게도 적을 수 있음
# if sum!=0:
#     alph.append(str(sum))
# print(''.join(alph))
