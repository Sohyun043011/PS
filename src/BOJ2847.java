import java.util.*;
import java.io.*;
public class BOJ2847 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr =new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int max = arr[N-1];
        int cnt = 0;
        for(int j=N-2;j>=0;j--){
            if(arr[j]>=max){
                cnt+=(arr[j]-(max-1));
                max--;
            }
            else max = arr[j];
        }
        System.out.println(cnt);
    }
}
