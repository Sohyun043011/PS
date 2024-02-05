import java.util.*;
import java.io.*;
public class BOJ2212 {
    public static void main(String[] args) throws Exception{
        // N개의 센서를 설치
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if(N<=K){
            System.out.println("0");
            System.exit(0);
        }
        Arrays.sort(arr);

        Integer[] diff = new Integer[N-1];
        // 차이 넣기
        for(int i=0;i<N-1;i++){
            diff[i] = arr[i+1]-arr[i];
        }
        //차이 오름차순 정리
        Arrays.sort(diff,Collections.reverseOrder());

        int sum = 0;
        for(int i=K-1;i<N-1;i++){
            sum+=diff[i];
        }
        System.out.println(sum);
    }
}
