import java.util.*;
import java.io.*;
public class BOJ20310 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        String[] str = s.split("");
        int zero = 0, one = 0;
        for(String st: str){
            if(st.equals("0")) zero++;
            else one++;
        }
        zero = zero/2;
        one = one/2;

        boolean[] del = new boolean[str.length];
        for(int i=0;i<del.length;i++){
            if(one==0) break;
            if(str[i].equals("1")){
                del[i] = true;
                one--;
            }
        }
        for(int j=del.length-1;j>=0;j--){
            if(zero==0) break;
            if(str[j].equals("0")){
                del[j] =true;
                zero--;
            }
        }
        for(int k=0;k<del.length;k++){
            if(!del[k]){
                sb.append(str[k]);
            }
        }
        System.out.println(sb);

    }
}
