import java.util.*;
import java.io.*;
public class BOJ1706 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];
        Set<String> strSet = new HashSet<>();
        for(int i=0;i<R;i++){
            String str = br.readLine();
            String[] split =  str.split("#");
            for(int j=0;j<split.length;j++){
                if(split[j].length()>1){
                    strSet.add(split[j]);
                }
            }
            for(int j=0;j<C;j++){
                map[i][j] = str.charAt(j);
            }
        }

        //세로
        for(int i=0;i<C;i++){
            String str = "";
            for(int j=0;j<R;j++){
                str+=map[j][i];
            }
            String[] splt = str.split("#");
            for(int k=0;k<splt.length;k++){
                if(splt[k].length()>1){
                    strSet.add(splt[k]);
                }
            }
        }

        ArrayList<String> set = new ArrayList<>(strSet);
        Collections.sort(set);
        System.out.println(set.get(0));

    }
}
