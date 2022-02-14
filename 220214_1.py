# DFS/BFS 예제1
# N,M 공백으로 구분하여 입력받기


n,m = map(int,input().split())
#2차원 리스트의 맵 정보 입력받기
graph = []
for i in range(n):
    graph.append(list(map(int,input())))

#DFS 로 특정한 노드를 방문한 뒤에 연결된 모든 노드들도 방문
def dfs(x,y):
    #주어진 범위를 벗어나는 경우 False
    if x<=-1 or x>=n or y<=-1 or y>=m:
        return False
    #현재 노드를 아직 방문하지 않은 경우
    if graph[x][y]==0:
        #해당 노드 방문 처리
        graph[x][y]=1
        #상,하,좌,우 위치도 모두 재귀적으로 호출
        dfs(x-1,y)
        dfs(x+1,y)
        dfs(x,y-1)
        dfs(x,y+1)
        #어쨌든 현재 노드 하나는 방문한 것이 되므로 return True
        return True
    
    #현재 노드 이미 방문했을 경우는 False return
    return False

    
# 모든 노드에 대해 dfs 실시
result = 0
for i in range(n):
    for j in range(m):
        if dfs(i,j)==True:
            result+=1

print(result)        