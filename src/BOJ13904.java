import java.util.*;
import java.io.*;
public class BOJ13904 {
    static class Task{
        int d;  //마감일
        int w;   //점수
        Task(int d, int w){
            this.d = d;
            this.w = w;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int N = Integer.parseInt(br.readLine());
        List<Task> taskList = new ArrayList<>();
        int maxDay = -1;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());   //과제 마감일
            int w = Integer.parseInt(st.nextToken());   // 과제 점수
            taskList.add(new Task(d,w));
            maxDay = Math.max(maxDay,d);
        }

        int sum = 0;
        for(int day=maxDay;day>=1;day--){
            Task todayTask = new Task(0,0);
            for(Task t: taskList){
                if(t.d>=day && t.w>=todayTask.w){
                    todayTask = t;
                }
            }
            sum+=todayTask.w;
            taskList.remove(todayTask);
        }
        System.out.println(sum);
    }
}
