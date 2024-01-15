import java.util.*;
import java.io.*;
public class BOJ2992 {
    static String str;
    static int answer;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        arr = new int[str.length()];
        for(int i=0;i<str.length();i++){
            arr[i] = str.charAt(i)-'0';
        }
        answer = Integer.MAX_VALUE;
//        permu(new int[str.length()],new boolean[str.length()],str.length(),0);
        dfs("",new boolean[str.length()],str.length());
        if(answer==Integer.MAX_VALUE) answer = 0;
        System.out.println(answer);
    }

    private static void dfs(String temp, boolean[] visited,int size){
        if(temp.length()==size){
            if(Integer.parseInt(temp)>Integer.parseInt(str)){
                answer = Math.min(Integer.parseInt(temp),answer);

            }
            return;
        }
        for(int j=0;j<arr.length;j++){
            StringBuilder sb = new StringBuilder(temp);
            if(!visited[j]){
                sb.append(arr[j]);
                visited[j] = true;
                dfs(sb.toString(),visited,size);
                visited[j] = false;
                sb.deleteCharAt(sb.length()-1);
            }

        }
    }
    private static void permu(int[] temp, boolean[] visited,int size, int depth){
        if(depth==size){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<temp.length;i++){
                sb.append(temp[i]);
            }
            if(Integer.parseInt(sb.toString())>Integer.parseInt(str)){
                answer = Math.min(Integer.parseInt(sb.toString()),answer);
            }
            return;
        }
        for(int j=0;j<arr.length;j++){
            if(!visited[j]){
                visited[j] = true;
                temp[depth] = arr[j];
                permu(temp,visited,size,depth+1);
                visited[j] = false;
            }
        }
    }
    private static void dfs(String now,int idx){
        if(!now.equals("") && Integer.parseInt(now)>Integer.parseInt(str)){
            answer = Integer.parseInt(now);
            return;
        }
        for(int i=idx;i<arr.length;i++){
            System.out.println(now);
            StringBuilder sb = new StringBuilder(now);
            sb.append(String.valueOf(arr[i]));
            dfs(sb.toString(),i+1);
        }
    }
}
