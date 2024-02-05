import java.util.*;
import java.io.*;
public class BOJ1459 {
    static long answer = Integer.MAX_VALUE;
    static long A,B;
    static long W,S;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());   //한 블록씩
        S = Integer.parseInt(st.nextToken());   // 대각선 이동.
        if(2*W<S){
            //한블록씩 가기
            answer = (A+B)*W;
        }
        else if(2*W>2*S){
            // 대각선 두번 왔다갔다
            if((A+B)%2==0){
                //짝수일때
                answer = (Math.max(A,B))*S;
            }
            else{
                //홀수 일 때
                answer = (Math.max(A,B)-1)*S;
                answer+=W;
            }
        }
        else{
            if(A==B){
                answer = A*S;
            }
            else{
                //대각선으로 이동하고, 한 블럭씩 움직이는거 둘다.
                answer = Math.min(A*S,B*S);
                answer+=Math.abs(A-B)*W;
            }
        }


        System.out.println(answer);
    }
}
