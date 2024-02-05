import java.util.*;
import java.io.*;
public class BOJ20125 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] map = new String[N][N];
        for(int i=0;i<N;i++){
            String[] s = br.readLine().split("");
            for(int j=0;j<N;j++){
                map[i][j] = s[j];
            }
        }
        int heartX = 0,heartY = 0;
        L:for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j].equals("*")){
                    heartX = i+1;
                    heartY = j;
                    break L;
                }
            }
        }
        int leftArm = 0, rightArm = 0;
        for(int k=heartY-1;k>=0;k--){
            if(map[heartX][k].equals("*")) leftArm++;
            else break;
        }
        for(int k=heartY+1;k<N;k++){
            if(map[heartX][k].equals("*")) rightArm++;
            else break;
        }
        int momX = 0, momY = 0;
        for(int k=heartX+1;k<N;k++){
            if(map[k][heartY].equals("*"))momX++;
            else break;
        }
        int leftLegX = heartX+momX+1;
        int leftLegY = 0;
        int rightLegX = heartX+momX+1;
        int rightLegY = 0;

        for(int i=leftLegX;i<N;i++){
            if(map[i][heartY-1].equals("*")) leftLegY++;
            else break;
        }
        for(int i=leftLegX;i<N;i++){
            if(map[i][heartY+1].equals("*")) rightLegY++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(heartX+1+" "+(heartY+1)+"\n");
        sb.append(leftArm+" "+rightArm+" "+momX+" "+leftLegY+" "+rightLegY);
        System.out.println(sb.toString());
    }
}
