import java.util.*;
import java.io.*;

public class BOJ20207 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] daily = new int[366];
        HashMap<Integer, int[]> todo = new HashMap();
        for(int i=0;i<N;i++){
            String[] str= br.readLine().split(" ");
            int S = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
            int days = E-S+1;
            int[] value = {S,E,days};
            todo.put(i,value);
        }
        ArrayList<Integer> keySet = new ArrayList<>(todo.keySet());
        Collections.sort(keySet, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int[] valueOne = todo.get(o1);
                int[] valueTwo = todo.get(o2);
                if(valueOne[0]==valueTwo[0]){
                    return valueTwo[2]-valueOne[2];
                }
                return valueOne[0]-valueTwo[0];
            }
        });

        ArrayList<ArrayList<Integer>> answerList = new ArrayList<>();
        for(Integer key: keySet){
            int[] nowValues = todo.get(key);
            if(answerList.size()==0){
                ArrayList<Integer> list = new ArrayList<>();
               for(int j=nowValues[0];j<=nowValues[1];j++){
                   list.add(j);
               }
               answerList.add(list);
            }
            else{
                boolean isContinue = false;
                for(int k=0;k<answerList.size();k++){
                    ArrayList<Integer> list = answerList.get(k);
                    if(list.get(list.size()-1)<nowValues[0]){
                        for(int j=nowValues[0];j<=nowValues[1];j++){
                            list.add(j);
                        }
                        isContinue = true;
                        break;
                    }
                    else continue;
                }
                if(!isContinue){
                    ArrayList<Integer> list = new ArrayList<>();
                    for(int j=nowValues[0];j<=nowValues[1];j++){
                        list.add(j);
                    }
                    answerList.add(list);
                }
            }
        }

        for(int i=0;i<answerList.size();i++){
            ArrayList list = answerList.get(i);
            for(int k=0;k<list.size();k++){
                int now = (int)list.get(k);
                daily[now]+=1;
            }
        }

        int answer =0;
        int maxVal = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        for(int j=1;j<366;j++){
            if(daily[j]!=0){
                if(maxVal==Integer.MIN_VALUE){
                    start = j;
                    end = j;
                }
                else{
                    end++;
                }
                maxVal = Math.max(maxVal,daily[j]);
            }
            else{
                if(maxVal!=Integer.MIN_VALUE){
                    answer+=(end-start+1)*maxVal;
                    maxVal = Integer.MIN_VALUE; //초기화
                }
            }
        }
        if(maxVal!=Integer.MIN_VALUE){
            answer+=(end-start+1)*maxVal;
        }
        System.out.println(answer);
    }
}
