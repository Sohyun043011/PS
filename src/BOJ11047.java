import java.util.*;
import java.io.*;
public class BOJ11047 {
    public static void main(String[] args) throws Exception {
        // 동전 N종류, 합을 K로 만들것
        // 동전 개수의 최솟값을 구해라
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        // i>=2 인 경우, Ai는 Ai-1의 배수
        // 오름차순.
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int cnt = 0;
        for(int j=arr.length-1;j>0; j--){
            if(arr[j]<=K){
                int div = K/arr[j];
                cnt+=div;
                K=K%arr[j];
            }
        }
        System.out.println(cnt);
    }
}
