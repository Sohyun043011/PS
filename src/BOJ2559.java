import java.util.*;
import java.io.*;
public class BOJ2559 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //연속적인 며칠 동안의 온도의 합이 가장 큰 값
        //N:온도를 측정한 전체 날짜의 수
        //K: 합을 구하기 위한 연속적인 날짜의 수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //투포인터!
        //start, end가 필요
        int start = 0;
        int end = 0;
        int sum = 0;
        int max_sum = Integer.MIN_VALUE;
        while(start<=arr.length-K){
            //start 부터 end까지 더해
            // K = 2;
            //0 1
            //2 3
            if(end-start<K){
                sum+=arr[end];
                end++;
            }
            else{
                //K넘어가면?
                if(max_sum<sum) max_sum = sum;
                sum-=arr[start];
                start++;
            }
        }
        System.out.println(max_sum);
    }
}
