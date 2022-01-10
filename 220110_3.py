# CH2. 구현
# 왕실의 나이트

data = list(input())
col = data[0]
row = int(data[1])

col_data = ['a','b','c','d','e','f','g','h']
col_index = col_data.index(col)+1
## 이부분을 다르게 고칠 수 있다
col_index = int(ord(data[0]))-int(ord('a'))+1
#ord 함수 : 해당 문자의 유니코드 값을 반환
# a~z : 97~112에 해당함.

count = 0 
dx = [2,2,-2,-2,1,-1,1,-1]
dy = [-1,1,1,-1,-2,-2,2,2]
## 이부분도 다르게 고칠 수 있음 dx,dy -> steps 로 고치고 for문을 
# for step in steps : 로 하면 더 간결함

steps = [(2,-1),(2,1),(-2,1),(-2,-1),(1,-2),(-1,-2),(1,2),(-1,2)]

for i in range(0,8):
    
    m_x = col_index+dx[i]
    m_y = row + dy[i]  
    if 0<m_x<=8 and 0<m_y<=8:
        count+=1

print(count)