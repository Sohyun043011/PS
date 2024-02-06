import java.util.*;
import java.io.*;
public class BOJ1463 {
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        dp = new int[X+1];
        Arrays.fill(dp,1000001);
        dp[1] = 0;
        for(int i=1;i<X;i++){
            dp[i+1] = Math.min(dp[i+1],dp[i]+1);
            if(i*3<=X) dp[i*3] =Math.min(dp[i*3],dp[i]+1);
            if(i*2<=X) dp[i*2] = Math.min(dp[i*2],dp[i]+1);
        }

        System.out.println(dp[X]);
    }
    private static int recur(int n){
        if(n==1) return 0;
        if(dp[n]!=-1) return dp[n];

        int res = recur(n-1)+1;
        if(n%3==0) res = Math.min(res,recur(n/3)+1);
        if(n%2==0) res = Math.min(res,recur(n/2)+1);
        dp[n] = res;
        return res;
    }

}
