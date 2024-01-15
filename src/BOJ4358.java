import java.util.*;
import java.io.*;
public class BOJ4358 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,Integer> map = new HashMap<>();
        String input = "";
        int total = 0;
        while(true){
            input = br.readLine();
            if(input==null||input.length()==0) break;
            total++;
            map.put(input,map.getOrDefault(input,0)+1);
        }

        //map정렬(알파벳 오름차 순)
        List<String> keySet = new ArrayList<>(map.keySet());

        //키값으로 오름차순 정렬
        Collections.sort(keySet);
        StringBuilder sb = new StringBuilder();

        for(String key: keySet){
            int cnt = map.get(key); //cnt 가져와
            //4자리 수까지 나타내야됨
            double avg = (double)(cnt*100.0)/total;
            sb.append(key+" "+String.format("%.4f",avg)+"\n");
        }
        System.out.println(sb.toString());
    }
}
