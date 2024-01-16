import java.util.*;
import java.io.*;
public class BOJ1074 {
    static int N,r,c;
    static int[][] map;
    static int cnt = 0;
    static int answer = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int N = (int)Math.pow(2,m);
        cur(N,0,0);

    }
    private static void cur(int n,int i, int j){
        //크기가 1이 되면
        if(n==1){
            System.out.println(answer);
            return;
        }
        int newSize = n/2;
        if(r<i+newSize && c<j+newSize){
            //1사분면
            cur(newSize,i,j);
        }
        //2사분면
        if(r<i+newSize && c>=j+newSize){
            answer+=(n*n)/4;
            cur(newSize,i,j+newSize);
        }
        //3사분면
        if(r>=i+newSize && c<j+newSize){
            answer+=((n*n)/4)*2;
            cur(newSize,i+newSize,j);
        }
        if(r>=i+newSize && c>=j+newSize){
            answer+=((n*n)/4)*3;
            cur(newSize,i+newSize,j+newSize);
        }
    }

}
