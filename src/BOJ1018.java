import java.util.*;
import java.io.*;
public class BOJ1018 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        String[] stringMap = new String[N];
        for(int i=0;i<N;i++){
            stringMap[i] = br.readLine();
            map[i] = stringMap[i].toCharArray();
        }
        //8*8만큼 자르기
        int minVal = Integer.MAX_VALUE;

        for(int i=0;i<=N-8;i++){
            // i: start
            for(int j=0;j<=M-8;j++){
                //BW 인 경우
                int cnt = 0;
                // map[i][j] ==i
                //1, 5
                // BW 하는 경우랑
                // WB 하는 경우랑 ...

                for(int start=i;start<i+8;start++){
                        char[] temp;
                        if((start-i)%2==0){
                            temp = "BWBWBWBW".toCharArray();
                        }
                        else{
                            temp = "WBWBWBWB".toCharArray();
                        }
                        for(int startj=j;startj<j+8;startj++){
                            if(map[start][startj]!=temp[startj-j]){
                                cnt++;
                            }
                        }
                }
                minVal = Math.min(minVal,cnt);
                cnt = 0;
                    for(int start=i;start<i+8;start++){
                        char[] temp;
                        if((start-i)%2==0){
                            temp = "WBWBWBWB".toCharArray();
                        }
                        else{
                            temp = "BWBWBWBW".toCharArray();
                        }
                        for(int startj=j;startj<j+8;startj++){
                            if(map[start][startj]!=temp[startj-j]){
                                cnt++;
                            }
                        }
                    }
                minVal = Math.min(minVal,cnt);

            }
        }
        System.out.println(minVal);

    }
}
