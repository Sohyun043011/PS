import java.util.*;
import java.io.*;

public class BOJ1758 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int rank = 1;
        int sum = 0;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]-rank+1<0) break;
            sum+=arr[i]-rank+1;

            rank++;
        }
        System.out.println(sum);
    }


}
