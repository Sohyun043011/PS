import java.util.*;
import java.io.*;
public class BOJ1245 {
    public static void main(String[] args) throws Exception{
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        String origin = br.readLine();
        int answer = origin.length();

        //문자열에서 펠린드롬을 발견하면! 대칭이 되도록 왼쪽거를 오른쪽에 붙여주면 된다.
        for(int i=0;i<origin.length();i++){
            if(checkPelin(origin.substring(i)))
            {
                //pelin인 경우
                answer+=i;
                break;
            }
        }
        System.out.println(answer);
    }
    public static boolean checkPelin(String str){
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i)!=str.charAt(str.length()-1-i)) return false;
        }
        return true;
    }
}
