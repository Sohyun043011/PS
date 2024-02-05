import java.util.*;
import java.io.*;
public class BOJ12933 {
    static boolean[] visited;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] duck = {'q','u','a','c','k'};
        visited = new boolean[str.length()];
        int answer = 0;
        int d = 0;

        if(str.length()%5!=0 || str.charAt(0)!='q'){
            System.out.println("-1");
            return;
        }

        for(int i=0;i<str.length();i++){
            ArrayList<Character> list = new ArrayList<>();
            for(int j=i;j<str.length();j++){
                if(!visited[j] && str.charAt(j)==duck[d]){
                    list.add(str.charAt(j));
                    visited[j] = true;
                    d++;
                    if(d==5) d = 0;
                }
            }
            if(list.size()!=0){
                if(list.get(list.size()-1)!='k'){
                    System.out.println("-1");
                    return;
                }
                answer++;
            }
        }
        System.out.println(answer);
    }
}
