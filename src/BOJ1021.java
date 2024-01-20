import java.util.*;
import java.io.*;
public class BOJ1021 {
    public static void main(String[] args) throws Exception{
        //큐에 처음에 포함되어 있던 수 N
        //뽑아ㅐ려고 하는 원소의 으ㅟ치
        // 2번,3번 연산의 최솟값
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=1;i<=N;i++){
            list.add(i);
        }
        int answer = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            // 3개 찾아줭
            int num = Integer.parseInt(st.nextToken());
            //num번쨰
            if(list.get(0)==num) list.removeFirst();
            else{
                int halfIdx;

                if(list.size()%2==0){
                    halfIdx = list.size()/2-1;
                }
                else{
                    halfIdx = list.size()/2;
                }
                int idx = list.indexOf(num);
                if(idx<=halfIdx){
                    //찾는애가 앞에 있으먄  2번
                    for(int j=0;j<idx;j++){
                        int temp = list.pollFirst();
                        list.offerLast(temp);
                        answer++;
                    }
                }
                else {
                    //뒤에 있으면 3번
                    for(int j=0;j<list.size()-idx;j++){
                        int temp = list.pollLast();
                        list.offerFirst(temp);
                        answer++;
                    }
                }
                list.pollFirst();
            }
        }
        System.out.println(answer);
    }
}
