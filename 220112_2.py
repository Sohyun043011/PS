# https://www.acmicpc.net/problem/3190

N = int(input()) # 보드 크기 N
K = int(input()) # 사과 갯수 K
info = []
# 보드 초기화
board = [[0]*(N+1) for _ in range(N+1)]

#사과 있는 곳을 1로 표시, 나머지는 0으로 표시
for _ in range(K):
    a,b = map(int,input().split())
    board[a][b]=1


L = int(input())    #변환 횟수
for _ in range(L):
    x,c = input().split()
    info.append((int(x),c))

#처음에는 오른쪽을 보고 있으므로 (동,남,서,북)
dx = [0,1,0,-1]
dy = [1,0,-1,0]

def turn(direction,c):
    if c=="L":
        direction = (direction-1)%4
    else:
        direction = (direction+1)%4
    return direction

def simulate():
    x, y =1,1   #뱀의 머리 위치
    board[x][y]=2   #뱀이 존재하는 위치는 2로 표시
    direction = 0   #처음에는 동쪽을 보고 있음.
    time = 0    #시작한 뒤에 지난 '초 시간
    index = 0   #다음 회전할 정보
    q = [(x,y)] #뱀이 차지하고 있는 위치 정보(꼬리가 앞쪽)

    while True:
        nx = x+dx[direction]
        ny = y+dy[direction]
        # 맵 범위에 있고, 뱀의 몸통이 없는 위치라면
        if 1<=nx and nx<=N and 1<=ny and ny<=N and board[nx][ny]!=2:
            #사과가 없다면 이동 후에 꼬리 제거
            if board[nx][ny]==0:
                board[nx][ny]=2
                q.append((nx,ny))
                px,py = q.pop(0)    #꼬리가 앞쪽이므로 q.pop(0)
                board[px][py]=0
            #사과가 있다면 이동 후에 꼬리 그대로 두기
            if board[nx][ny]==1:
                board[nx][ny]=2
                q.append((nx,ny))
        #벽이나 몸통에 부딪혓다면
        else:
            time+=1
            break
        x,y = nx,ny #다음 위치로 머리를 이동
        time+=1
        if index<L and time == info[index][0] :  #회전할 시간인 경우 회전
            direction = turn(direction,info[index][1])
            index+=1
    return time

print(simulate())