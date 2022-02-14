# 백준 dfs/bfs 1
# https://www.acmicpc.net/problem/1260

from collections import deque
answer = []

def bfs(graph,start,visited):
    queue = deque([start])
    visited[start] = True
    while queue:
        v = queue.popleft()
        answer.append(v)
        # print(v,end=' ')
        for i in graph[v]:
                queue.append(i)
                visited[i]=True
    return answer

def dfs(graph,start,visited):

    
    if len(graph[start])!=0:
        visited[start] = True
        answer.append(start)
        # print(start, end=' ')
        for i in graph[start]:
            if not visited[i]:
                dfs(graph,i,visited)
    else:
        answer.append(start)
    return answer


#n은 정점의 개수.m은 간선의 개수
n,m,v = map(int,input().split())
# m개의 줄에 간선이 연결하는 두 번호
graph = [[] for _ in range(n+1)]
for _ in range(m):
    # m개 .. 입력 
    # 연결된 정보??
    x,y = map(int,input().split())
    graph[x].append(y)
    graph[y].append(x)

for i in range(n+1):
    graph[i].sort()

    

# 각 노드가 방문된 정보를 표현
visited = [False]*(n+1)
# print(graph)
# dfs 먼저 출력
result = dfs(graph,v,visited)
lst_new = [str(a) for a in result]
print(" " . join(lst_new))

visited = [False]*(n+1)
answer.clear()

result2 = bfs(graph,v,visited)
# bfs 출력
lst_new2 = [str(a) for a in result2]
print(" " . join(lst_new2))