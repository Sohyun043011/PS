import java.util.*;
import java.io.*;
public class BOJ5052 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());    //전화번호 갯수 n
            boolean corresp = true;
            String[] numbers = new String[N];
            for(int j=0;j<N;j++){
                numbers[j] = br.readLine();
            }
            Arrays.sort(numbers);
            for(int j=0;j<N-1;j++){
                if(numbers[j+1].startsWith(numbers[j])){
                    corresp = false;
                    break;
                }
            }
            if(!corresp) System.out.println("NO");
            else System.out.println("YES");
        }
    }
}
