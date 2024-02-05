import java.util.*;
import java.io.*;
public class BOJ1138 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> arrList = new ArrayList<>();
        for(int j=arr.length-1;j>=0;j--){
                arrList.add(arr[j],j+1);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arrList.size();i++){
            sb.append(arrList.get(i)+" ");
        }
        System.out.println(sb.toString().trim());
    }
}
