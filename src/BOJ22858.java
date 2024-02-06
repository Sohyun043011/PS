import java.util.*;
import java.io.*;
public class BOJ22858 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] last = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            last[i] = Integer.parseInt(st.nextToken());
        }
        int[] dArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            dArr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<K;i++){
            int[] originArr = new int[N];
            for(int j=0;j<N;j++){
                originArr[dArr[j]-1] = last[j];
            }
            last = originArr.clone();
        }
        for(int i=0;i<N;i++){
            System.out.print(last[i]+" ");
        }
    }
}
