import java.util.*;
import java.io.*;
public class BOJ1026 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];
        PriorityQueue<Integer> bQue= new PriorityQueue<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            bQue.offer(Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr,Collections.reverseOrder());
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i]*bQue.poll();
        }
        System.out.println(sum);
    }
}
