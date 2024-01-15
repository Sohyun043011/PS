import  java.util.*;
import java.io.*;

public class BOJ1182 {
    static int answer = 0;
    static int S;
    static int[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        // 크기가 양수인 부분수열 중 그 수열의 원소를 다 더한 값ㅇ이 S가 되는 경우의수
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //1~N까지 나눠서..
        for(int size=1;size<=N;size++)
        {
            int sum = 0;
            dfs(0,size,new boolean[N],0,0);
        }
        System.out.println(answer);
    }
    private static void dfs(int sum, int size,boolean[] visited, int depth,int start){
       if(depth==size){
           //그만큼 뽑았으면
           if(sum==S){
               answer++;
               return;
           }
       }
       for(int i=start;i<arr.length;i++){
           if(!visited[i]){
               visited[i] = true;
               dfs(sum+arr[i],size,visited,depth+1,i+1);
               visited[i] = false;
           }
       }

    }

}
