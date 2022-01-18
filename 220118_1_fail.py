# https://programmers.co.kr/learn/courses/30/lessons/60061
# 풀이 보기 전 실패한 풀이


# 입력받기
def solution(n, build_frame):

    # 꼭지점에 대한 정보를 적어놔야될거같은데
    # n*n의 전체 배열 초기화를 할까?
    data = [[0]*(n+1) for _ in range(n+1)]
    # 1.build_frame[x,y,a,b]
    # x,y,a,b 에 대한 정보를 저장해야 될까?
    # b = 1 이면 세우는 거니까, 그 때 data에서 세울 수 있으면 1로 표시해야 됨.
    # b= 0 이면 삭제하는 거니까 그 때 data에서 삭제할 수 있으면 0으로 변경해야 함.
    li = []
    for x in build_frame:
        i_x = x[0]
        i_y = x[1]
        i_a = x[2]
        i_b = x[3]
        if i_b==1:
        #설치하기
        #기둥이냐 보냐 먼저 파악?
        # 기둥이라면, 안되는 경우가 언제지 
        # 기둥은 바닥 위에 있거나, 보의 한쪽 끝 부분에 있거나, 또 다른 기둥 위에 있어야 함.(그럼, 그냥 꼭짓점 있는 곳이면 다 되는거같은데?
            if i_a==0:
            # 기둥이라면?
            # 안되는 경우는 무시해야 되니까, continue로 처리하면 될듯
            # 안되는 경우== continue
            # 되는 경우? == (y==0)일 때, 걍 됨
            # y!=0 일 때, data[x][y]==1 이면 됨 
            # 아니면 안됨
                if i_y==0:
                # y==0 인 경우,
                # n = 1 로 visit 표시
                    data[i_x][i_y]=1
                    data[i_x][i_y+1]=1
                    li.append([i_x,i_y,i_a])
                else:
                #y!=0 인 경우,
                    if data[i_x][i_y]==1:
                        data[i_x][i_y+1]=1
                        li.append([i_x,i_y,i_a])
                    else:
                        continue
            #             # 되는 경우? == (x,y+1) 좌표 찍어주기 (위로 +1 하면 되니까)
            else:
            # 보라면?
            # 안되는 경우 == continue
            # 되는 경우? 한쪽 끝부분이 기둥에 있거나? 양쪽 끝부분이 다른 보와 동시에 연결되어야 함.
            # 한 쪽 끝부분이 기둥에있거나? n[x][y]==1이고, n[x][y-1]==1 인지 확인
            # 양쪽 끝부분이 다른 보와 동시에 연결되어야 함? n[x][y]==1이고, n[x+1][y]==1 이면  가능
                if data[i_x][i_y-1]==1  or data[i_x+1][i_y]==1:
                    data[i_x][i_y]=1
                    data[i_x+1][i_y]=1
                    li.append([i_x,i_y,i_a])
                else:
                    continue
            # 되는 경우? == (x+1,y) 좌표 찍어주기.( 오른쪽으로 +1 하면 되니까 )
        else: 
        # 삭제하기
        # 기둥인경우
            if i_a==0:
            #기둥을 삭제하려면 ? (x,y)
                if (i_y==0 and data[i_x+1][i_y+1]==1) or (i_y!=0 and data[i_x][i_y+1]==0):
                    data[i_x][i_y]=0
                    li.remove([i_x,i_y,i_a])
                else:
                    continue
            else:
            #보를 삭제하려면?
                if data[i_x+1][i_y]==0 and data[i_x+2][i_y]==0:
                    data[i_x][i_y]=0
                    li.remove([i_x,i_y,i_a])
                else:
                    continue


# list의 정렬은?
    li = sorted(li,key = lambda x: (x[0],x[1],x[2]))
    return li


#n = int(input())

#bulid_frame = [[1,0,0,1],[1,1,1,1],[2,1,0,1],[2,2,1,1],[5,0,0,1],[5,1,0,1],[4,2,1,1],[3,2,1,1]]
#build_frame = [[0,0,0,1],[2,0,0,1],[4,0,0,1],[0,1,1,1],[1,1,1,1],[2,1,1,1],[3,1,1,1],[2,0,0,0],[1,1,1,0],[2,2,0,1]]
#data = [[0]*(n+1) for _ in range(n+1)]
#print(data)

# x 로 오름차순 정렬하고, y로 오름차순 정렬하고, 마지막으로 정렬.
