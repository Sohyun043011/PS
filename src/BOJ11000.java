import java.util.*;
import java.io.*;
public class BOJ11000 {
    public static void main(String[] args) throws Exception{
        //Si 시작해서 Ti에 끝나야 됨.
        //최소의 강의실을 사용해서 모든 수업을 가능하게 해라
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,new Comparator<int[]>(){
                    @Override
                    public int compare(int[] o1, int[] o2){
                        if(o1[0]==o2[0]) return Integer.compare(o1[1],o2[1]);
                        return Integer.compare(o1[0],o2[0]);
                    }
        });

        // 비어있는 강의실 ...
        // 종료시간을 우선순위 큐에 넣으면, 종료시간이 작은 순으로 나오니까 우선순위 큐를
        // 쓰면된다.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(arr[0][1]);
        for(int i=1;i<N;i++){
            if(arr[i][0]>=pq.peek()){
                //시작시간이 pq.peek()
                // 강의 계속 진행
                pq.poll();
                pq.offer(arr[i][1]);
            }
            else{
                //새로운 강의실 배정.
                pq.offer(arr[i][1]);
            }
        }
        System.out.println(pq.size());
    }
}
