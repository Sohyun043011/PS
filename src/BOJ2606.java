import java.util.*;
import java.io.*;
public class BOJ2606 {
    static List[] pairList;
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수
        int com = Integer.parseInt(br.readLine());
        // 연결된 컴퓨터 쌍의 수
        int pair = Integer.parseInt(br.readLine());
        // 1 2 , 2 3 , 15
        //양방향 그래프 .. . . . . . .
        pairList = new List[com];    //컴퓨터 수만큼
        for(int i=0;i<com;i++){
            pairList[i] = new LinkedList<Integer>();
        }

        for(int i=0;i<pair;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            pairList[start].add(end);
            pairList[end].add(start);
        }
        //0번을 시작으로 순회
        answer = 0;
        visited = new boolean[com];
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(0);
//        visited[0] = true;
//        while(!queue.isEmpty()){
//            int now = queue.poll();
//            List list = pairList[now];
//            for(int i=0;i<list.size();i++){
//                int next = (int)list.get(i);
//                if(!visited[next]){
//                    queue.add(next);
//                    visited[next] = true;
//                    answer++;
//                }
//            }
//        }
//        System.out.println(answer);
        //dfs로 어케푸냐
        dfs(0);
        System.out.println(answer);
    }
    private static void dfs(int start){
        visited[start] =true;
        for(int i=0;i<pairList[start].size();i++){
            int next = (int)pairList[start].get(i);
            if(!visited[next]){
                answer++;
                dfs(next);
            }
        }
    }

}
