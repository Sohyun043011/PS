import java.util.*;
import java.io.*;
public class BOJ18310 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        if(N%2==0){
            System.out.println(arr[N/2-1]);
        }
        else{
            System.out.println(arr[N/2]);
        }
    }
}
