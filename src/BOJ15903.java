import java.util.*;
import java.io.*;
public class BOJ15903 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for(int i=0;i<M;i++){
            long first = arr[0];
            long sec = arr[1];
            long sum = first+sec;
            arr[0] = sum;
            arr[1] = sum;
            Arrays.sort(arr);
        }
        long answer = 0 ;
        for(long a:arr){
            answer+=a;
        }
        System.out.println(answer);
    }
}
