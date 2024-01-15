import java.util.*;
import java.io.*;
public class BOJ2607 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String first = br.readLine();
        int answer = 0;

        for(int i=1;i<T;i++){
            String str = br.readLine();
            int cnt = 0;    //같은 단어 개수
            int[] tempAlpha = new int[26];
            for(int j=0;j<first.length();j++){
                tempAlpha[first.charAt(j)-'A']+=1;
            }
            for(int k=0;k<str.length();k++){
                if(tempAlpha[str.charAt(k)-'A']>0){
                    //같은애가 있구나!
                    cnt++;
                    //중복 방지
                    tempAlpha[str.charAt(k)-'A']--;
                }
            }
            //cnt 값들을 비교
            if(str.length()>first.length()+1 || first.length()>str.length()+1){
                //1 개 이상 차이나면 nono
                continue;
            }
            else if(str.length()==first.length()){
                //길이가 같으면 ! 한글자만 다른 경우 or 아예 같ㅇㄴ 경우
                if(first.length()==cnt || first.length()-1==cnt){
                    answer++;
                }
            }
            else if(str.length()>first.length()){
              // 쟤가 더 길면 ! 삭제 해서 되냐 이거지
                // DOG
                // DOGG
                if(first.length()==cnt) answer++;
            }
            else if(first.length()>str.length()){
                //비교 문자열이 짧은 경우
                // 더해서 되냐
                //DOGG
                //DOG
                if(str.length()==cnt) answer++;
            }
        }
        System.out.println(answer);
    }
}
