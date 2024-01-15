import java.util.*;
import java.io.*;
public class BOJ9536 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        
        while(T-->0){
            //첫줄
            Set<String> doggy = new HashSet<>();
            String str = br.readLine();
            //what does the fox say 나올 때 까지 while
            String input="";
            while(true){
                input = br.readLine();
                if(input.equals("what does the fox say?")) break;
                String[] token = input.split(" ");
                doggy.add(token[token.length-1]);   //다른 울음소리들 넣어두기
            }
            //str에 doggy안에 있는 울음소리들이 있으면 빼야 됨. . . .
            String[] arrayStr = str.split(" ");
            StringBuilder sb = new StringBuilder();
            for(String s: arrayStr){
                if(!doggy.contains(s)){
                    sb.append(s).append(" ");
                }
            }
            System.out.println(sb.toString().trim());
        }
    }
}
