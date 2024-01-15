import java.util.*;
import java.io.*;
public class BOJ169536 {
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //정수 A를 B로 바꿔라
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        dfs(A,B,0);
        if(answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }
    private static void dfs(long curr, long B, int cnt){
        if(curr == B) {
            cnt++;
            answer = Math.min(answer,cnt);
            return;
        }
        if(curr>B) return;
        dfs(curr*2,B,cnt+1);
        // 1을 가장 오른쪽에 추가해라.
        dfs(curr*10+1,B,cnt+1);
    }
}
