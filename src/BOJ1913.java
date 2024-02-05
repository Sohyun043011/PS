import java.util.*;
import java.io.*;
public class BOJ1913 {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int N = Integer.parseInt(br.readLine());
      int find = Integer.parseInt(br.readLine());
      int[][] map = new int[N][N];

      int dir = 0;
      int num = N*N;

      map[0][0] = num;
      int findX = 0, findY = 0;
      int nx = 0, ny=0;
      while(num>0){

          if(num==find){
              findX = nx;
              findY = ny;
          }
          if(num==1) break;
          if(dir==4) dir = 0;
          nx = nx+dx[dir];
          ny = ny+dy[dir];
          if((nx<0 || nx>=N || ny<0 || ny>=N) ||map[nx][ny]!=0){
              nx = nx-dx[dir];
              ny = ny-dy[dir];
              dir++;
              continue;
          }
          else{
              map[nx][ny] = --num;
          }
      }
      StringBuilder sb = new StringBuilder();
      for(int i=0;i<N;i++){
          for(int j=0;j<N;j++){
              sb.append(map[i][j]+" ");
          }
          sb.append("\n");
      }
      System.out.println(sb.toString().trim());
      System.out.println((findX+1)+" "+(findY+1));
    }
}
