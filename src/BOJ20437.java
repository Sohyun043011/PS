import java.util.*;
import java.io.*;
public class BOJ20437 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int i=0;i<T;i++){
            String str = br.readLine();
            int K = Integer.parseInt(br.readLine());
            HashMap<Character,ArrayList> alpha = new HashMap<>();
            for(int j=0;j<str.length();j++){
                ArrayList<Integer> list;
                if(alpha.containsKey(str.charAt(j))){
                    list = alpha.get(str.charAt(j));
                }
                else{
                    list = new ArrayList<>();
                }
                list.add(j);
                
                alpha.put(str.charAt(j),list);
            }
            ArrayList<Character> alphabet = new ArrayList<>(alpha.keySet());
            ArrayList<Character> keys = new ArrayList<>();
            for(char c: alphabet){
                ArrayList arrayList = alpha.get(c);
                if(arrayList.size()>=K){
                    keys.add(c);
                }
            }
            if(keys.size()==0){
                System.out.println("-1");
            }
            else{
                //key 후보들 돌면서, 가장 짧은 문자열구하기
                int shortest = Integer.MAX_VALUE;
                int longest = Integer.MIN_VALUE;
                for(char key:keys){
                    ArrayList list = alpha.get(key);
                    for(int s=0;s<=list.size()-K;s++){
                        int index = (int)list.get(s);
                        int next = (int)list.get(s+K-1);
                        shortest = Math.min(shortest,(next-index)+1);
                        longest = Math.max(longest,(next-index)+1);
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append(shortest).append(" ").append(longest);
                System.out.println(sb);
            }
        }
    }
}
