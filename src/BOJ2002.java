import java.util.*;
import java.io.*;
public class BOJ2002 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        int[] data = new int[N];

        for(int i=0;i<N;i++){
            String car = br.readLine();
            map.put(car,i);
        }

        for(int i=0;i<N;i++){
            String search = br.readLine();
            data[i] = map.get(search);
        }

        for(int i=0;i<N-1;i++){
            for(int j=i+1;j<N;j++){
                if(data[i]>data[j]){
                    answer+=1;
                    break;
                }
            }
        }
        System.out.println(answer);

    }
}
