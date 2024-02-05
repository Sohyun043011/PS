import java.util.*;
import java.io.*;
public class BOJ5397 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            String str = br.readLine();
            char[] strArr = str.toCharArray();
            Deque<Character> origin = new ArrayDeque<>();
            Deque<Character> temp = new ArrayDeque<>();

            for(int j=0;j<strArr.length;j++){
                if(strArr[j]=='<'){
                    if(origin.size()!=0){
                        temp.offerLast(origin.pollLast());
                    }
                }
                else if(strArr[j]=='>'){
                    if(temp.size()!=0){
                        origin.offerLast(temp.pollLast());
                    }
                }
                else if(strArr[j]=='-'){
                    if(origin.size()!=0) origin.pollLast();
                }
                else{
                    origin.offerLast(strArr[j]);
                }
            }

            StringBuilder sb = new StringBuilder();
            while(!origin.isEmpty()){
               temp.offerLast(origin.pollLast());
            }
            while(!temp.isEmpty()){
                sb.append(temp.pollLast());
            }

            System.out.println(sb);
        }


    }
}
