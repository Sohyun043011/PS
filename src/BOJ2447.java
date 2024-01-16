import java.util.*;
import java.io.*;
public class BOJ2447 {
    static int N;
    static String[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        cur(N,0,0);
        StringBuilder sb  = new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]==null) sb.append(" ");
                else sb.append("*");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    private static void cur(int n,int i, int j){
        if(n==1){
            map[i][j] = "*";
            return;
        }
        int newSize = n/3;
        cur(newSize,i,j);
        cur(newSize,i,j+newSize);
        cur(newSize,i,j+newSize*2);
        cur(newSize,i+newSize,j);
        cur(newSize,i+newSize,j+newSize*2);
        cur(newSize,i+newSize*2,j);
        cur(newSize,i+newSize*2,j+newSize);
        cur(newSize,i+newSize*2,j+newSize*2);


    }
}
