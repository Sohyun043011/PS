import java.util.*;
import java.io.*;
public class BOJ14562 {
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<C;i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            answer = Integer.MAX_VALUE;
            dfs(S,T,0);
            sb.append(answer+"\n");
        }
        System.out.println(sb.toString().trim());
    }
    private  static void dfs(int s, int t, int cnt){
        if(s>t) return;
        if(s==t){
            answer = Math.min(answer,cnt);
            return;
        }
        dfs(s+s,t+3,cnt+1);
        dfs(s+1,t,cnt+1);
    }
}
