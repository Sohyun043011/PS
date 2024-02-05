import java.util.*;
import java.io.*;
public class BOJ1080 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][M];
        int[][] B = new int[N][M];
        for(int i=0;i<N;i++){
            String[] str = br.readLine().split("");
            for(int j=0;j<M;j++){
                A[i][j] = Integer.parseInt(str[j]);
            }
        }
        for(int i=0;i<N;i++){
            String[] str = br.readLine().split("");
            for(int j=0;j<M;j++){
                B[i][j] = Integer.parseInt(str[j]);
            }
        }
        int answer = 0 ;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(A[i][j]!=B[i][j]){
                    //다르면 뒤집기
                    if(i+3<=N && j+3<=M){
                        answer++;
                        for(int k=i;k<i+3;k++){
                            for(int m=j;m<j+3;m++){
                                if(A[k][m]==0) A[k][m] = 1;
                                else A[k][m] = 0;
                            }
                        }
                    }
                }
            }
        }
        boolean isSame = true;
        L:for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(A[i][j]!=B[i][j]){
                    isSame=false;
                    break L;
                }
            }
        }
        if(!isSame) System.out.println("-1");
        else System.out.println(answer);
    }
}
