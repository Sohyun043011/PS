import java.util.*;
import java.io.*;
public class BOJ12891 {
    static int aCnt=0,cCnt=0,gCnt=0,tCnt=0;
    static int[] cnt;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        cnt = new int[4];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<4;i++){
            cnt[i] = Integer.parseInt(st.nextToken());
        }

        //맨처음 cnt 세기
        for(int i=0;i<P;i++){
            checkDNA(str.charAt(i),true);
        }
        //a,c,g,t
        int answer = 0;
        if(checkPwd()){
            answer++;
        }
        //슬라이딩 윈도우
        for(int k=P;k<str.length();k++){
            //str[k] 는 더하고,
            //str[k-P] 는 빼고
            checkDNA(str.charAt(k),true);
            checkDNA(str.charAt(k-P),false);
            if(checkPwd()){
                answer++;
            }
        }
        System.out.println(answer);
    }
    private static boolean checkPwd(){
        if(aCnt>=cnt[0] && cCnt>=cnt[1] && gCnt>=cnt[2] && tCnt>=cnt[3]) return true;
        return false;
    }

    private static void checkDNA(char k, boolean next){
        if(k=='A'){
            if(next) aCnt++;
            else aCnt--;
        }else if(k=='C'){
            if(next) cCnt++;
            else cCnt--;
        }else if(k=='T'){
            if(next) tCnt++;
            else tCnt--;
        }else if(k=='G'){
            if(next) gCnt++;
            else gCnt--;
        }
    }
}
