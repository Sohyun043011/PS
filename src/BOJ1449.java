import java.nio.Buffer;
import java.util.*;
import java.io.*;
public class BOJ1449 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int cnt = 0;
        double max = -1;
        for(int i=0;i<arr.length;i++) {
            if (arr[i] <= max) continue;
            max = arr[i] + L - 0.5;
            cnt++;

        }
        System.out.println(cnt);
    }
}
