import java.util.*;
import java.io.*;
public class BOJ1058 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] friend = new boolean[N][N];
        boolean[][] visited;

        for(int i=0;i<N;i++){
            char[] str = br.readLine().toCharArray();
            for(int j=0;j<N;j++){
                if(str[j]=='Y'){
                    friend[i][j] = true;
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            int cnt = 0;
            visited = new boolean[N][N];
            visited[i][i] = true;
            for(int j=0;j<N;j++){
                if(friend[i][j]==true){
                    if(!visited[i][j])  cnt+=1;
                    visited[i][j] = true;
                    for(int k=0;k<N;k++){
                        if(friend[j][k] && !visited[i][k] ){
                            cnt++;
                            visited[i][k] = true;
                        }
                    }
                }
            }
            ans = Math.max(ans,cnt);
        }
        System.out.println(ans);
    }
}
