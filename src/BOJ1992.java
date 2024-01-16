import java.util.*;
import java.io.*;
public class BOJ1992 {
    static int[][] map;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            String[] arr = str.split("");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(arr[j]);
            }
        }
        sb = new StringBuilder();
        cur(N,0,0);
        System.out.println(sb);

    }
    private static void cur(int n,int i, int j){
        //같은수로만 이루어졌는지 확인
        boolean isFind = true;
        int start = map[i][j];
        L:for(int l=i;l<i+n;l++){
            for(int m=j;m<j+n;m++){
                if(start!=map[l][m]){
                    isFind = false;
                    break L;
                }
            }
        }
        if(!isFind){
            //왼위,오위,왼아,오아
            int newSize = n/2;
            sb.append("(");
            cur(newSize,i,j);
            cur(newSize,i,j+newSize);
            cur(newSize,i+newSize,j);
            cur(newSize,i+newSize,j+newSize);
            sb.append(")");
        }
        else{
            //같은거로만 이루어짐
            sb.append(start);
        }
    }
}
