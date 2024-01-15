import java.util.*;
import java.io.*;
public class BOJ1013 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String regex = "(100+1+|01)+";
        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            if (str.matches(regex)) System.out.println("YES");
            else System.out.println("NO");

        }
    }
}
