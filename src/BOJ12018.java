import java.util.*;
import java.io.*;
public class BOJ12018 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int ans = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int[] mileage = new int[p];
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<p;j++){
                mileage[j] = Integer.parseInt(st.nextToken());
            }
            if(p<l){
                queue.add(1);
            }
            else{
                Arrays.sort(mileage);
                queue.add(mileage[p-l]);
            }
        }

        while(!queue.isEmpty())
        {
                m-=queue.poll();
                if(m<0) break;
                ans++;
        }
        System.out.println(ans);
    }
}
