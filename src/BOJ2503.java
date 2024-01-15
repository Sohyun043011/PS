import java.util.*;
import java.io.*;
public class BOJ2503 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] arr = new int[889];
        int[][] strArr = new int[889][3];
        int answer = 0;

        for(int i=0;i<889;i++){
            arr[i] = 111+i;
            strArr[i][0] = arr[i]/100;
            strArr[i][1] = (arr[i]%100)/10;
            strArr[i][2] = (arr[i]%100)%10;
        }

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String minhyk = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            int[] temp = new int[3];
            for(int j=0;j<minhyk.length();j++){
                temp[j] = Integer.parseInt(String.valueOf(minhyk.charAt(j)));
            }
            int posCnt = strike+ball;

            for(int m=0;m<strArr.length;m++){
                int[] now = strArr[m];
                int cnt = 0;
                int strikeCnt = 0;
                for(int n=0;n<3;n++){
                    int tempR = temp[n];
                    for(int l=0;l<3;l++){
                        if(tempR==now[l]){
                            cnt++;
                        }
                    }
                }
                if(cnt!=posCnt){
                    arr[m]=0;
                }
                else{
                    for(int l=0;l<3;l++){
                        if(temp[l]==strArr[m][l]){
                            strikeCnt++;
                        }
                    }
                    if(strikeCnt!=strike) arr[m]=0;
                }
            }
        }
        for(int k=0;k<arr.length;k++){

            if(arr[k]!=0 && strArr[k][0]!=strArr[k][1] && strArr[k][1]!=strArr[k][2] &&strArr[k][0]!=strArr[k][2]) {
                if(strArr[k][0]!=0 && strArr[k][1]!=0 && strArr[k][2]!=0) {
//                    System.out.println("arr[k] = " + arr[k]);
                    answer++;
                }
            }
        }

        System.out.println(answer);

    }
}
