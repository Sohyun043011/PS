import java.util.*;
import java.io.*;
public class BOJ10448 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // T1 = 1*2/2 = 1
        //T2 = 2*3/2 = 3
        // 3<=K<=1000
        int[] tarr = new int[45];
        for(int i=0;i<45;i++){
            tarr[i] = i*(i+1)/2;
        }
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            int end = -1;
            for(int k=0;k<tarr.length;k++){
                if(tarr[k]>num){
                    end = k-1;
                    break;
                }
            }
            if(end==-1) end = tarr.length-1;
            boolean find = false;
            L:for(int k=1;k<=end;k++){
                int first = tarr[k];
                for(int m=k;m<=end;m++){
                    int sec = tarr[m];
                    for(int n=m;n<=end;n++){
                        int third = tarr[n];
                        if(first+sec+third==num){
                            System.out.println(1);
                            find = true;   //찾은 경우
                            break L;
                        }
                    }
                }
            }
            if(!find) System.out.println(0);
        }
    }
}
