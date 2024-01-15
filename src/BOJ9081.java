import java.util.*;
import java.io.*;
public class BOJ9081 {
    static char[] strArr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++) {
            String str = br.readLine();
            strArr = str.toCharArray();
            int arrSize = strArr.length;

            StringBuilder sb = new StringBuilder();

            int idx1 = -1, idx2=0;
            //뒤에서부터 최초로 '감소'하는 애를 찾아
            //HELLO
            //L < O -> L
            //감소한다? 사전순이다
            //나 다음에 나올 애를 찾아야 하니까
            //idx1 을 찾아줌
            for(int j=arrSize-1;j>0;j--){
                if(strArr[j-1]<strArr[j]){
                    idx1 = j-1;
                    break;
                }
            }
            if(idx1==-1) {
                System.out.println(str);
            }
            else{
                //다시 뒤에서부터, L보다 큰애가 맨처음 나오는애를 찾아
                // O
                //큰 애랑 바꿔줘야 알파벳 오름차순 정렬했을 때 나보다 뒤에 있는 겨

                for(int j=arrSize-1;j>0;j--){
                    if(strArr[idx1]<strArr[j]){
                        idx2 = j;
                        break;
                    }
                }
                //둘이 swap

                //만약에 123 이었으면
                //최초로 감소하는애 idx = 2
                // 뒤에서부터나보다 큰애 3
                //둘이 swap
                char tmp = strArr[idx1];
                strArr[idx1] = strArr[idx2];
                strArr[idx2] = tmp;

                //둘이 swap 한다음, swap 한 뒤부터!! 오름차순 정렬 해줘

                Arrays.sort(strArr,idx1+1,arrSize);
                for(char c:strArr){
                    sb.append(c);
                }
                System.out.println(sb);
            }
        }

    }
}
