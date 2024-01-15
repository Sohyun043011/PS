import java.sql.SQLOutput;
import java.util.*;
import java.io.*;
public class BOJ25206 {
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        double sum = 0; //전공평점
        double gradeSum = 0;
        for(int i=0;i<20;i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            if(!grade.equals("P"))
                gradeSum+=score;

            switch (grade){
                case "A+":
                    sum+=score*4.5;
                    break;
                case "A0":
                    sum+=score*4.0;
                    break;
                case "B+":
                    sum+=score*3.5;
                    break;
                case "B0":
                    sum+=score*3.0;
                    break;
                case "C+":
                    sum+=score*2.5;
                    break;
                case "C0":
                    sum+=score*2.0;
                    break;
                case "D+":
                    sum+=score*1.5;
                    break;
                case "D0":
                    sum+=score*1.0;
                    break;
                case "F":
                    sum+=score*0.0;
                    break;
                default:
                    break;
            }
        }
        String result = String.format("%.6f",(sum/gradeSum));
        System.out.println(result);
    }
}
