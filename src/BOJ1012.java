import java.util.*;
import java.io.*;
public class BOJ1012 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N,M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //0은 배추 x 1은 배추 o
        StringTokenizer st;
        //1로 탐색 가능 한 뭉텅이 찾기 : 최소의 배추흰지렁이 구해라

        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            //M,N
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());   //가로
            N = Integer.parseInt(st.nextToken());   //세로
            int K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visited = new boolean[N][M];
            int cnt = 0;

            for(int j=0;j<K;j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            //bfs
            for(int j=0;j<N;j++){
                for(int k=0;k<M;k++){
                    if(!visited[j][k] && map[j][k]==1){
//                        bfs(j,k);
                        dfs(j,k);
                        cnt++;

                    }
                }
            }
            System.out.println(cnt);
        }
    }
    private static void bfs(int x,int y){
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new int[]{x,y});

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            for(int i=0;i<4;i++){
                int nx = nowX+dx[i];
                int ny = nowY+dy[i];
                if(nx>=0 && nx<N && ny>=0 &&ny<M){
                    if(!visited[nx][ny] && map[nx][ny]==1){
                        queue.add(new int[]{nx,ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
    private static void dfs(int x, int y){
        visited[x][y] = true;
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny =y+dy[i];
            if(nx>=0 && nx<N && ny>=0 && ny<M){
                if(!visited[nx][ny] && map[nx][ny]==1){
                    dfs(nx,ny);
                }
            }
        }
    }
}
