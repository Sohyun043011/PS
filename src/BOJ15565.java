import java.util.*;
import java.io.*;
public class BOJ15565 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i]==1) list.add(i);
                //0 4 6 9
        }
        //K개 이상의 라이언 인형을 포함하는, 가장 작은 연속된 인형들의 집합 크기를 출력해라
        //K개 이상의 슬라이딩 윈도우..?

        int start = 0,end=K-1;
        int min = Integer.MAX_VALUE, cnt=0;
        if(list.size()<K){
            System.out.println(-1);
        }
        else{
            while(true){
                if(end==list.size()) break;
                cnt = list.get(end)-list.get(start)+1;
                min = Math.min(min,cnt);

                start++;
                end++;
            }
            System.out.println(min);
        }

    }
}
