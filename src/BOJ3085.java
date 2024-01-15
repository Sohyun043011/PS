import java.util.*;
import java.io.*;
public class BOJ3085 {

    static int answer = Integer.MIN_VALUE;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N;
    static char[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                map[i][j] = str.charAt(j);
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                check(i,j);
            }
        }
        if(answer ==Integer.MIN_VALUE) System.out.println(0);
        else System.out.println(answer);
    }
    static void check(int i, int j){

        for(int m=0;m<4;m++){
            int nx = i+dx[m];
            int ny = j+dy[m];
            if(nx>=0 && nx<N && ny>=0 && ny<N){
                char origin = map[i][j];
                char next = map[nx][ny];
                map[i][j] = next;
                map[nx][ny] = origin;

                //행에대해
                int rowCnt = 1;
                int colCnt = 1;
                for(int l=0;l<N-1;l++){
                    // 연속 수 체크
                    for(int t=l+1;t<N;t++){
                        if(map[i][l]==map[i][t]){
                            rowCnt++;
                        }
                        else{
                            break;
                        }
                    }
                    for(int t=l+1;t<N;t++){
                        if(map[l][j]==map[t][j]){
                            colCnt++;
                        }
                        else{
                            break;
                        }
                    }

                    //달라서 나왔으면 비교
                    answer = Math.max(answer,Math.max(rowCnt,colCnt));
                    rowCnt = 1;
                    colCnt = 1;
                }

                //돌려놓기
                map[i][j] = origin;
                map[nx][ny] = next;
            }
        }
    }

}
