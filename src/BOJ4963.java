import java.util.*;
import java.io.*;
public class BOJ4963 {
    static int w,h;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0,1,1,-1,-1};
    static int[] dy = {0,0,-1,1,1,-1,1,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //1이 땅
        StringTokenizer st;
        while(true){
            String input = br.readLine();
            if(input.equals("0 0")) break;
                int answer = 0;
                st = new StringTokenizer(input);
                w = Integer.parseInt(st.nextToken());
                h = Integer.parseInt(st.nextToken());
                map = new int[h][w];
                visited = new boolean[h][w];
                for(int i=0;i<h;i++){
                    st = new StringTokenizer(br.readLine());
                    for(int j=0;j<w;j++) {
                        map[i][j] = Integer.parseInt(st.nextToken());
                    }
                }
                for(int i=0;i<h;i++){
                    for(int j=0;j<w;j++){
                        if(map[i][j]==1 && !visited[i][j]){
                            dfs(i,j);
                            answer++;
                        }
                    }
                }

            System.out.println(answer);
        }
    }
    private static void dfs(int i, int j){
        visited[i][j] = true;
        for(int m=0;m<8;m++){
            int nx = i+dx[m];
            int ny = j+dy[m];
            if(nx>=0 && nx<h && ny>=0 && ny<w){
                if(map[nx][ny]==1 && !visited[nx][ny]) dfs(nx,ny);
            }
        }
    }
}
