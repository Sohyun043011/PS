import java.util.*;
import  java.io.*;
public class BOJ2346 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<int[]> queue = new ArrayDeque<>();

        StringTokenizer st= new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            int num =  Integer.parseInt(st.nextToken());
            queue.offer(new int[]{num,i+1});
            arr[i] = num;
        }

        StringBuilder sb = new StringBuilder();
        int[] first = queue.poll();   //첫번째꺼 빼기
        sb.append(first[1]+" ");
        int cnt = first[0];
        while(!queue.isEmpty()){
            if(cnt>0){
                for(int k=1;k<cnt;k++){
                    queue.add(queue.poll());
                }
                int[] nxt = queue.poll();// 앞에꺼 빼기
                cnt= nxt[0];
                sb.append(nxt[1]+" ");
            }
            else{
                for(int k=1;k<-cnt;k++){
                    queue.addFirst(queue.pollLast());
                }
                //뒤에꺼 ㅂ빼기
                int[] nxt = queue.pollLast();
                cnt = nxt[0];
                sb.append(nxt[1]+" ");
            }
        }
        System.out.println(sb);

    }
}
