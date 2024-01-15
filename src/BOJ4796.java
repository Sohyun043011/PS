import java.util.*;
import java.io.*;
public class BOJ4796 {
    public static void main(String[] args)throws Exception {
        //연속하는 P일 중 L일 동안만 사용할 수 있다.
        //5 8 20 20/8 = 2 ... 4 2*5+4
        // 20일 동안,연속하는 8일중 5일동안만 사용할 수 있는 캠핑저ㅏㅇ
        // O O O O O X X X O O O O O X X X O O O O
        // 5 8 17 : 17/8 = 2....1 2*5+1
        // O O O O O X X X O O O O O X X X O
        //1  4  6 :  6/4 1...2  1*1+
        // 6-(4*1) = 2 /4 = 0...2
        // 2일 <Pd
        //4일 중 1루
        //OXXXOX
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int cnt = 0;
        while(true){
            cnt++;
            input = br.readLine();
            if(input.equals("0 0 0")) break;
            else{
                StringTokenizer st = new StringTokenizer(input);
                int L = Integer.parseInt(st.nextToken());
                int P = Integer.parseInt(st.nextToken());
                int V = Integer.parseInt(st.nextToken());
                int div = V/P;
                int nam = V%P;
                //2 4 6
                //OOXXOO
                if(nam>L) nam = L;
                int ans = div*L+nam;
                System.out.println("Case "+cnt+": "+ans);
            }
        }
    }
}
