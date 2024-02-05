
import java.util.*;
import java.io.*;
public class BOJ1120 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // A의 길이는 B보다 작거나 같다.
        // A의 길이가 B의 길이와 같아질 때
        // A의 앞에 아무 알파벳 추가 or 뒤에 추가

        // A와 B 길이가 같으면서 A와 B의 차이를 최소로 해라

        int cnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();
        //길이가 같은 경우 다른 글자만 세
        if(A.length()==B.length()){
            for(int i=0;i<A.length();i++){
                if(A.charAt(i)!=B.charAt(i)) cnt++;
            }
        }
        else{
            cnt = Integer.MAX_VALUE;
            int aLen = A.length();
            for(int i=0;i<=B.length()-aLen;i++){
                String temp = B.substring(i,i+aLen);
                int diff = 0;
                for(int j=0;j<temp.length();j++){
                    if(temp.charAt(j)!=A.charAt(j)) diff++;
                }
                cnt = Math.min(cnt,diff);
            }
        }
        System.out.println(cnt);
    }
}
