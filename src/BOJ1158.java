import java.util.*;
import java.io.*;
public class BOJ1158 {
    public static void main(String[] args) throws Exception{
        // 1~N, K가주어짐.
        // K번째 사람 제거.
        // 제거되면 남은사람들로 계속 ...
        //N명의 사람이 모두 제거될때까지
        // 순열을 구해라.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        LinkedList<Integer> list = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=N;i++){
            list.add(i);
            queue.offer(i);
        }
        //양의 정수 k 번째 사람을 제거
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int cnt = 0;
        while(!queue.isEmpty()){
            //
            if(cnt==K-1){
                sb.append(queue.poll());
                sb.append(", ");
                cnt = 0;
            }
            else{

                int num =  queue.poll();
                cnt++;
                queue.add(num);
            }
        }
        sb.delete(sb.length()-2,sb.length());
        sb.append(">");
        System.out.println(sb);
    }
}
