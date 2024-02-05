import java.util.*;
import java.io.*;
public class BOJ14891 {
    static int[][] tob;
    static int answer = 0;
    public static void main(String[] args) throws Exception{
        int[] one = new int[8];
        int[] tw = new int[8];
        int[] th = new int[8];
        int[] fo = new int[8];
        
        tob = new int[4][8];
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<4;i++){
            String[] str = br.readLine().split("");
            for(int j=0;j<8;j++){
                tob[i][j] = Integer.parseInt(str[j]);
            }
        }

        StringTokenizer st;
        int K=Integer.parseInt(br.readLine());
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int rot = Integer.parseInt(st.nextToken());
            rotate(num,rot);
        }
        calc();
        System.out.println(answer);
    }

    private static void calc() {
        if(tob[0][0]==1) answer+=1;
        if(tob[1][0]==1) answer+=2;
        if(tob[2][0]==1) answer+=4;
        if(tob[3][0]==1) answer+=8;
    }

    private static void rotate(int num, int rot){
        num-=1;
        int[] rotArr = new int[4];
        rotArr[num] = rot;
        if(num==0){
            if(tob[0][2]!=tob[1][6]){
                rotArr[1] = (-1)*rot;
            }
            if(tob[1][2]!=tob[2][6]){
                rotArr[2] = (-1)*(rotArr[1]);
            }
            if(tob[2][2]!=tob[3][6]){
                rotArr[3] = (-1)*(rotArr[2]);
            }

        }
        else if(num==1){
            if(tob[0][2]!=tob[1][6]){
                rotArr[0] = (-1)*rot;
            }
            if(tob[1][2]!=tob[2][6]){
                rotArr[2] = (-1)*(rotArr[1]);
            }
            if(tob[2][2]!=tob[3][6]){
                rotArr[3] = (-1)*(rotArr[2]);
            }
        }
        else if(num==2){
            if(tob[1][2]!=tob[2][6]){
                rotArr[1] = (-1)*(rot);
            }
            if(tob[0][2]!=tob[1][6]){
                rotArr[0] = (-1)*(rotArr[1]);
            }
            if(tob[2][2]!=tob[3][6]){
                rotArr[3] = (-1)*(rotArr[2]);
            }

        }
        else if(num==3){
            if(tob[2][2]!=tob[3][6]){
                rotArr[2] = (-1)*(rot);
            }
            if(tob[1][2]!=tob[2][6]){
                rotArr[1] = (-1)*(rotArr[2]);
            }
            if(tob[0][2]!=tob[1][6]){
                rotArr[0] = (-1)*(rotArr[1]);
            }
        }

        for(int i=0;i<rotArr.length;i++){
            if(rotArr[i]==1){
                int last = tob[i][7];
                for(int j=6;j>=0;j--){
                    tob[i][j+1] = tob[i][j];
                }
                tob[i][0] = last;
            }
            else if(rotArr[i]==-1){
                int first = tob[i][0];
                for(int j=1;j<8;j++){
                    tob[i][j-1] = tob[i][j];
                }
                tob[i][7] = first;
            }
        }
    }
}
