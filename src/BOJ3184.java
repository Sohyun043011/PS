import java.util.*;
import java.io.*;
public class BOJ3184 {
    static char[][] map;
    static int R,C,wolf,sheep;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //' .' :빈 필드, '#' : d울타리, 'o':양, 'v':늑대
        // 영역 안의 양의 수가 늑대수보다 많으면 이긴다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());//행/
        C = Integer.parseInt(st.nextToken());//열

        wolf= 0;
        sheep=0;
        map = new char[R][C];
        visited = new boolean[R][C];

        for(int i=0;i<R;i++){
            char[] str = br.readLine().toCharArray();
            for(int j=0;j<C;j++){
                map[i][j] = str[j];
                if(map[i][j]=='o'){
                    sheep++;
                }else if(map[i][j]=='v'){
                    wolf++;
                }
            }
        }

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(!visited[i][j] && map[i][j]!='#'){
//                    bfs(i,j);
                    if(map[i][j]=='o'){
                        dfs(i,j,0,1);
                        }
                    else if(map[i][j]=='v'){
                        dfs(i,j,1,0);
                    }
                    else dfs(i,j,0,0);
                }

            }
        }
        System.out.println(sheep+" "+wolf);
    }
    private static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        int scnt =0,wcnt=0;
        if(map[x][y]=='o'){
            scnt++;
        }
        if(map[x][y]=='v'){
            wcnt++;
        }
        visited[x][y] = true;
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];
                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    if (!visited[nx][ny] && map[nx][ny] != '#') {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        if (map[nx][ny] == 'o') scnt++;
                        else if (map[nx][ny] == 'v') wcnt++;
                    }
                }
            }
        }
        if(scnt>0 && wcnt>0 ){
            if(scnt>wcnt) wolf-=wcnt;
            else sheep-=scnt;
        }
    }
    private static void dfs(int x, int y, int w, int s){
        visited[x][y] = true;
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && nx<R && ny>=0 && ny<C){
                if(!visited[nx][ny] && map[nx][ny]!='#'){
                    if(map[nx][ny]=='o'){
                        dfs(nx,ny,w,s+1);
                    }
                    else if(map[nx][ny]=='v'){
                        dfs(nx,ny,w+1,s);
                    }
                    else dfs(nx,ny,w,s);
                }
            }
        }
        if(w>0 && s>0){
            if(w>s) sheep-=s;
            else wolf-=w;
        }
    }
}
