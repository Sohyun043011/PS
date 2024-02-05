import java.util.*;
import java.io.*;
public class BOJ4396 {
    static int[] dx = {-1,1,0,0,-1,1,-1,1};
    static int[] dy = {0,0,-1,1,-1,-1,1,1};
    static char[][] answer;
    static int n;
    static boolean[][] bomb;
    static char[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        bomb = new boolean[n][n];
        map = new char[n][n];
        answer = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(answer[i],'o');
        }

        for(int i=0;i<n;i++){
            String[] str = br.readLine().split("");
            for(int k=0;k<n;k++){
                if(str[k].equals("*")) bomb[i][k] = true;
            }
        }
        for(int i=0;i<n;i++)
        {
            map[i] = br.readLine().toCharArray();
        }
        L:for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(bomb[i][j]==true){
                    if(map[i][j]=='x'){
                        bombing();
                        break L;
                    }
                    else if(map[i][j]=='.'){
                        answer[i][j] = '.';
                    }
                }
                else{
                    if(map[i][j]=='.'){
                        answer[i][j]='.';
                    }
                    else if(map[i][j]=='x'){
                        int cnt= 0;
                        for(int k=0;k<8;k++){
                            int nx = i+dx[k];
                            int ny = j+dy[k];
                            if(nx>=0 && nx<n && ny>=0 && ny<n){
                                if(bomb[nx][ny]==true){
                                    cnt++;
                                }
                            }
                        }
                        answer[i][j] = (char)(cnt+'0');
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sb.append(answer[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString().trim());
    }
    static private void bombing(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(bomb[i][j]){
                    answer[i][j] = '*';
                }
                else{
                    if(answer[i][j]=='o') answer[i][j] = '.';
                }

            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j]=='x' && !bomb[i][j]){
                    int cnt= 0;
                    for(int k=0;k<8;k++){
                        int nx = i+dx[k];
                        int ny = j+dy[k];
                        if(nx>=0 && nx<n && ny>=0 && ny<n){
                            if(bomb[nx][ny]==true){
                                cnt++;
                            }
                        }
                    }
                    answer[i][j] = (char)(cnt+'0');
                }
            }
        }
    }
}
