import java.util.*;
import java.io.*;
public class BOJ11501 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            long sum = 0;
            int maxValue = arr[N-1];
            for(int j=N-1;j>=0;j--){
                if(maxValue<arr[j]){
                    maxValue = arr[j];
                }
                sum+=maxValue-arr[j];
            }
            System.out.println(sum);
        }
    }
}
