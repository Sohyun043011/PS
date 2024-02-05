import java.util.*;
import java.io.*;
public class BOJ5545 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());   //도우 가격
        int B = Integer.parseInt(st.nextToken());   //토핑 가격
        int C = Integer.parseInt(br.readLine());    //도우 열량
        int[] topping = new int[N];
        for(int i=0;i<N;i++){
            topping[i] = Integer.parseInt(br.readLine());   //토핑 열량
        }
        int answer =C/A;
        Arrays.sort(topping);
        int price = A;
        int cal = C;
        for(int i=topping.length-1;i>=0; i--){
            price+=B;
            cal+=topping[i];
            if(answer>(cal/price)) break;
            else answer = cal/price;
        }
        System.out.println(answer);

    }
}
