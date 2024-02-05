import java.util.*;
import java.io.*;
public class BOJ14889 {
    static int[] startTeam;
    static int[] linkTeam;
    static  int N;
    static boolean[] v;
    static int[][] arr;

    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        startTeam = new int[N/2];
        linkTeam = new int[N/2];
        v = new boolean[N];
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pick(new int[N/2],0,0);
        System.out.println(answer);

    }

    private static void pick(int[] p, int depth, int idx){
        if(depth==N/2){
            startTeam = p;
            v = new boolean[N];
            for(int i=0;i<N/2;i++){
                v[p[i]] = true;
            }
            int t = 0;
            for(int i=0;i<N;i++){
                if(!v[i]){
                    linkTeam[t] = i;
                    t++;
                }
            }
            int sSum = 0;
            int lSum = 0;
            for(int i=0;i<N/2;i++){
                for(int j=i+1;j<N/2;j++){
                    int ii = startTeam[i];
                    int jj = startTeam[j];
                    int li = linkTeam[i];
                    int lj = linkTeam[j];
                    sSum+=arr[ii][jj];
                    sSum+=arr[jj][ii];
                    lSum+=arr[li][lj];
                    lSum+=arr[lj][li];
                }
            }
            answer = Math.min(answer,Math.abs(lSum-sSum));
            return;
        }
        for(int i=idx;i<N;i++){
                p[depth] = i;
                pick(p,depth+1,i+1);
            }
        }
    }

