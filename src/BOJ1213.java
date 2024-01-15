import java.util.*;
import java.io.*;
public class BOJ1213 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alphabet = new int[26]; //0~25

        String str = br.readLine();
        char[] strChar = str.toCharArray();
        int cnt =0;
        for(int i=0;i<strChar.length;i++){
            int alpha = strChar[i]-'A';
            alphabet[alpha]++;
        }

        String prevStr = "";
        for(int i=0;i<26;i++){
            if(alphabet[i]%2==0){
                //짝수면
                for(int j=0;j<(alphabet[i]/2);j++){
                    char nowChar = (char) (i+(int)'A');
                    prevStr+=nowChar;
                }
            }
            else{
                cnt++;
                alphabet[i]--;
                for(int j=0;j<(alphabet[i]/2);j++){
                    char nowChar = (char) (i+(int)'A');
                    prevStr+=nowChar;
                }
                alphabet[i]=1;
            }
        }
        if(cnt!=1 && cnt>0){
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        StringBuilder reverseSb = new StringBuilder(prevStr);
        reverseSb = reverseSb.reverse();

        for(int i=0;i<26;i++) {
            if (alphabet[i] == 1) {
                char nowChar = (char) (i + (int) 'A');
                prevStr += nowChar;
            }
        }
        prevStr+=reverseSb.toString();
        System.out.println(prevStr);
    }

}
