import java.util.*;
import java.io.*;
public class BOJ1780 {
    static int zeroA = 0,oneA=0,minuA=0;
    static int N;
    static int[][] map;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cur(N,0,0);
        System.out.println(minuA);
        System.out.println(zeroA);
        System.out.println(oneA);

    }
    private static void cur(int k,int i, int j){
        //색이 다 같으면
        boolean isFind = true;
        int start = map[i][j];
        L:for(int l=i;l<i+k;l++){
            for(int m=j;m<j+k;m++){
                if(start!=map[l][m]){
                    isFind = false;
                    break L;
                }
            }
        }
        if(!isFind){
            //다 같지 않으면
            int newSize = k/3;
            //9개 recusive
            cur(newSize,i,j);
            cur(newSize,i,j+newSize);
            cur(newSize,i,j+newSize*2);
            cur(newSize,i+newSize,j);
            cur(newSize,i+newSize,j+newSize);
            cur(newSize,i+newSize,j+newSize*2);
            cur(newSize,i+newSize*2,j);
            cur(newSize,i+newSize*2,j+newSize);
            cur(newSize,i+newSize*2,j+newSize*2);
        }
        else{
            if(start==0) zeroA++;
            else if(start==1) oneA++;
            else minuA++;
        }


    }
}
