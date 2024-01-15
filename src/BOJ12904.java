import java.util.*;
import java.io.*;
public class BOJ12904 {
    static class Item{
        String str;
        int aCnt;
        int bCnt;
        Item(String str, int cntA, int cntB){
            this.str = str;
            this.aCnt = cntA;
            this.bCnt = cntB;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        boolean answer = false;
        while(s.length()<t.length()){
               StringBuilder sb = new StringBuilder();
               if(t.endsWith("A")){
                   t=t.substring(0,t.length()-1);
               }else if(t.endsWith("B")){
                   t = t.substring(0,t.length()-1);
                   t = sb.append(t).reverse().toString();
               }
        }
        if(s.equals(t)){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }

    }
}
