import java.util.*;
import java.io.*;
public class BOJ23733 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // n개의 서로 다른 양의 정수 수열
        // x가 주어졌을 때, ai+aj=x를 만족하는 ai,aj쌍의 수를 구해라
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int X = Integer.parseInt(br.readLine());
        //2개씩, X가 되면 count
        int count = 0;
        int sum = 0;
        int start = 0;
        int end = N-1;
        Arrays.sort(arr);
//        for(int start=0;start<N-1;start++){
//            int end = start+1;
//            while(end<N){
//                if(arr[start]+arr[end]==X) {count++; break;}
//                else if(arr[start]+arr[end]>X) break;
//                else end++;
//            }
//        }
        while(start<end){
            sum = arr[start]+arr[end];
            if(sum==X){
                count++;
                start++;
                end--;
            }
            else if(sum>X){
                //X보다 크면
                end--;
            }
            else {
                start++;
            }
        }
        System.out.println(count);
    }
}
