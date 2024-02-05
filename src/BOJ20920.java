import java.util.*;
import java.io.*;
public class BOJ20920 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<N;i++){
            String str = br.readLine();
            if(str.length()>=M) map.put(str,map.getOrDefault(str,0)+1);
        }
        ArrayList<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet,new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                if(map.get(o2)==map.get(o1)){
                    if(o2.length()==o1.length()){
                        return o1.compareTo(o2);
                    }
                    return o2.length()-o1.length();
                }
                return map.get(o2).compareTo(map.get(o1));
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String key: keySet){
            sb.append(key);
            sb.append("\n");
        }

        System.out.println(sb.toString().trim());

    }
}
