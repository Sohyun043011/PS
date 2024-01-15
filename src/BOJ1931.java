import java.util.*;
import java.io.*;
public class BOJ1931 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 각 회의 I에 대해 시작시간, 끝나는 시간이 주어져있고,
        // 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수
        // 2^31-1 보다 작거나 같은 자연수 또는 0이다
        int N = Integer.parseInt(br.readLine());
        //끝나는 시간 기준으로 오름차순 정렬
        // [1,4],[3,5]
        int[][] arr = new int[N][2];

        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    //같은 경우 처리?
                    return Integer.compare(o1[0],o2[0]);
                }
                return Integer.compare(o1[1],o2[1]);
            }
        });
        int cnt = 1;
        int start = arr[0][0];
        int end = arr[0][1];

        for(int idx=1;idx<N;idx++){
            if(end<=arr[idx][0]){
                cnt++;
                end = arr[idx][1];
            }
        }

        System.out.println(cnt);
    }
}
