import java.util.*;
import java.io.*;
public class BOJ1629 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());
        System.out.println(cur(A,B,C));
    }
    private static long cur(long a,long b,long c){
        if(b==1){
            return a%c;
        }
        long res = cur(a,b/2,c);
        if(b%2==1) return (res*res%c)*a%c;
        return res*res%c;
    }
}
