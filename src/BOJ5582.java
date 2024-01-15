import java.util.*;
import java.io.*;
public class BOJ5582 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //두 문자열 모두 포함 된 부분 문자열 중 가장 긵 것?
        String str1 = br.readLine();
        String str2 =br.readLine();
        //짧은애가 기준
        String minStr = (str1.length()<str2.length()?str1:str2);
        String maxStr = (str1.length()<str2.length()?str2:str1);

        int[] dp = new int[maxStr.length()];

        int answer = 0;

        for(int i=0;i<minStr.length();i++){
            for(int j=0;j<maxStr.length();j++){
                if(minStr.charAt(i)==maxStr.charAt(j)){
                    int start = j;
                    int cnt = dp[j];
                    while(j+cnt<maxStr.length() && i+cnt<minStr.length()){
                        if(minStr.substring(i,i+cnt+1).equals(maxStr.substring(j,j+cnt+1))){
                            cnt++;
                        }
                        else break;
                    }
                    //
                    if(cnt>dp[j]){

                        for(int k=j;k<j+cnt;k++){
                            dp[k] = cnt--;
                        }
                        answer = Math.max(answer,dp[j]);
                    }
                }
            }
        }
        System.out.println(answer);

    }
}