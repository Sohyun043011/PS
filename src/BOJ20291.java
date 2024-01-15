import java.util.*;
import java.io.*;
public class BOJ20291 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<N;i++){
            String[] arr = br.readLine().split("\\.");
            map.put(arr[1],map.getOrDefault(arr[1],0)+1);
        }
        ArrayList<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);
        for(String key:keySet){
            System.out.println(key+" "+map.get(key));
        }
    }
}
