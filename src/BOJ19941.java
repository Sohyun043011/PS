import java.util.*;
import java.io.*;
public class BOJ19941 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String[] str = br.readLine().split("");
        boolean[] visited = new boolean[N];
        int answer = 0;
        for(int i=0;i<N;i++){
            if(str[i].equals("P")){
                boolean isFind = false;
                for(int j=i-K;j<=i-1;j++){
                    if(j>=0 && str[j].equals("H") && !visited[j]){
                        visited[j] = true;
                        isFind = true;
                        answer++;
                        break;
                    }
                }
                if(!isFind){
                    for(int j=i+1;j<=i+K;j++){
                        if(j<N && str[j].equals("H") && !visited[j]){
                            visited[j] = true;
                            isFind = true;
                            answer++;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
