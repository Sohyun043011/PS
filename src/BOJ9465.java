import java.util.*;
import java.io.*;

public class BOJ9465 {
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[2][n+1];
            int[][] dp = new int[2][n+1];

            StringTokenizer st;

            for(int j=0;j<2;j++){
                st = new StringTokenizer(br.readLine());
                for(int m=0;m<n;m++){
                    map[j][m] = Integer.parseInt(st.nextToken());
                }
            }

            //dp[i]
            dp[0][0] = map[0][0];
            dp[1][0] = map[1][0];

            for(int k=1;k<n;k++){
                dp[0][k] = Math.max(dp[1][k-1]+map[0][k],dp[0][k-1]);
                dp[1][k] = Math.max(dp[0][k-1]+map[1][k],dp[1][k-1]);
            }

            System.out.println(Math.max(dp[0][n-1],dp[1][n-1]));
        }
    }
}
