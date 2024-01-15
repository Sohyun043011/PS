import java.util.*;
import java.io.*;
public class BOJ20922 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int [N];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //셀거야
        int[] numArr = new int[100001];
        int start =0;
        int end = 0;
        int count = 0;

        while(start<end){
            numArr[arr[end]]++;
            //걔가 ... 지금
            if(numArr[arr[end]]<=K){
                //K이하면!! 괜찮아.
                end++;
            }
            else{
                //K이상이면?! 안돼..

            }
        }

    }
}
