import java.util.*;
import java.io.*;
public class BOJ20164 {
    static int minVal  = Integer.MAX_VALUE;
    static int maxVal = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        if(number.length()==1){
            if(Integer.parseInt(number)%2==1){
                minVal = 1;
                maxVal = 1;
            }
            else{
                minVal = 0;
                maxVal = 0;
            }
        }
        else{
            recur(number,count(number));
        }
        System.out.println(minVal+" "+maxVal);
    }
    private static void recur(String str, int cnt){
        //수가 한자리면 종료.
        if(str.length()==1){
            minVal = Math.min(minVal,cnt);
            maxVal = Math.max(maxVal,cnt);
            return;
        }
        //수가 두자리면 2개로 나누고 합을 구해
        else if(str.length()==2){
            int newNumber = Integer.parseInt(str.substring(0,1))+Integer.parseInt(str.substring(1,2));
            recur(String.valueOf(newNumber),count(String.valueOf(newNumber))+cnt);
        }
        else if(str.length()>=3){
            //세자리 이상이면 각각 끊어서 3개의 수로 분할하고 걔네를 더해.
            for(int i=0;i<=str.length()-3;i++){
                for(int j=i+1;j<=str.length()-2;j++){
                    String one = str.substring(0,i+1);
                    String two = str.substring(i+1,j+1);
                    String three = str.substring(j+1,str.length());

                    int newNumber = Integer.parseInt(one)+Integer.parseInt(two)+Integer.parseInt(three);
                    recur(String.valueOf(newNumber),cnt+count(String.valueOf(newNumber)));
                }
            }
        }
    }

    private static int count(String str){

        int cnt = 0;
        String[] strArr = str.split("");
        for(String s: strArr){
            if(Integer.parseInt(s)%2==1) cnt++;
        }
        return cnt;
    }


}
