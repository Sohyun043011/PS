import java.util.*;
import java.io.*;
public class BOJ1283 {
    static StringBuilder sb = new StringBuilder();
    static boolean[] check;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        check = new boolean[26];
        for(int i=0;i<N;i++){
            String[] options = br.readLine().split(" ");
            //하나의 옵션에 대해서,...
            optionChecker(options);
        }
        System.out.println(sb.toString().trim());
    }
    private static void optionChecker(String[] options){
        //단어의 첫글자가 단축키에 있는지 확인해
        boolean findCheck = false;
        int optionNumber = -1;
        int indexInOption = -1;
        for(int k=0;k<options.length;k++){
            String str =options[k].toUpperCase();
            char first = str.charAt(0);
            if(!check[first-'A']){
                //안되어있으면 얘가 옵션이다.
                optionNumber = k;
                indexInOption = 0;
                findCheck = true;
                check[first-'A'] = true;
                break;
            }
        }

        //첫글자에서 찾은 경우
        if(findCheck){
            for(int k=0;k<options.length;k++){
                if(k==optionNumber){
                    String str = options[k];
                    for(int t=0;t<str.length();t++){
                        if(t==indexInOption){
                            sb.append("["+str.charAt(t)+"]");
                        }
                        else{
                            sb.append(str.charAt(t));
                        }
                    }
                    sb.append(" ");
                }
                else{
                    sb.append(options[k]+" ");
                }
            }
        }
        else{
            //첫글자에서 못찾으면?
            //왼쪽부터 알파벳 보면서 단축키로 지정안된 것이 있으면 지정해라.
            //findChcek가 아직 false
            L:for(int i=0;i<options.length;i++){
                String str = options[i].toUpperCase();
                for(int k=0;k<str.length();k++){
                    if(!check[str.charAt(k)-'A']){
                        findCheck = true;
                        optionNumber = i;
                        indexInOption = k;
                        check[str.charAt(k)-'A'] = true;
                        break L;
                    }
                }
            }
            if(findCheck){
                for(int k=0;k<options.length;k++){
                    if(k==optionNumber){
                        String str = options[k];
                        for(int t=0;t<str.length();t++){
                            if(t==indexInOption){
                                sb.append("["+str.charAt(t)+"]");
                            }
                            else{
                                sb.append(str.charAt(t));
                            }
                        }
                        sb.append(" ");
                    }
                    else{
                        sb.append(options[k]+" ");
                    }
                }
            }
            //여기서도 못찾았으면??
            else{
                for(int k=0;k<options.length;k++){
                    sb.append(options[k]+" ");
                }
            }
        }

        //

        //다음 옵션 검사 엔터침
        sb.append("\n");
    }
}
