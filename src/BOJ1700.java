import java.util.*;
import java.io.*;
public class BOJ1700 {
    public static void main(String[] args) throws Exception{
        HashMap<Integer,LinkedList<Integer>> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[K];
        for(int i=0;i<K;i++){
            int key =Integer.parseInt(st.nextToken());
            arr[i] = key;
            LinkedList<Integer> idxQueue;
            if(map.containsKey(key)){
                idxQueue = map.get(key);
                idxQueue.offer(i);
                Collections.sort(idxQueue); //오름차순 정렬
                map.put(key,idxQueue);
            }
            else{
                idxQueue= new LinkedList<>();
                idxQueue.offer(i);
                map.put(key,idxQueue);
            }
        }
        //멀티탭 꽂을거
        LinkedList<Integer> multitab = new LinkedList<>();
        int ans = 0;
        for(int i=0;i<K;i++){
            if(multitab.contains(arr[i])) continue;
            if(multitab.size()==N){
                int[] delArr = new int[multitab.size()];       //i 인덱스 이후에 나오는 idx 넣기
                Arrays.fill(delArr,-1);
                boolean isFind= false;                          //i 인덱스 이후가 아예 없다면, 얘가 빠지면 됨 그래서 break
                int delIdx = -1;                                //얘가 빠져야 할 경우, idx 저장하려고 만든 변수
                for(int s=0;s<multitab.size();s++){
                    int idx = multitab.get(s);
                    LinkedList<Integer> idxList = map.get(idx);     //해당 제품이 등장하는 인덱스 리스트
                    int temp = -1;
                    for(int m=0;m<idxList.size();m++){
                        if(idxList.get(m)>i){
                            temp = idxList.get(m);                  // i 보다 큰 idx에서 해당 제품이 나오는 경우, 삭제 후보이므로 temp에 저장
                            break;
                        }
                    }
                    if(temp==-1){
                        delIdx = s;
                        isFind = true;
                        break;
                    }
                    else{
                        delArr[s] = temp;                      //삭제 후보 tempArr에 저장
                    }
                }
                if(isFind) {
                    // i 이후로 등장하지 않아서 바로 삭제하면 되는 경우
                    multitab.remove(delIdx);
                    multitab.offer(arr[i]);
                }
                else{
                    // 삭제 후보들 돌면서, 가장 큰 애를 찾으면 됨.(가장 나중에 나온다는 거기 때문에)
                    int maxVal = -1;
                    int maxIdx = -1;
                    for(int a=0;a<delArr.length;a++){
                        if(delArr[a]>maxVal) {
                            maxVal = delArr[a];
                            maxIdx = a;
                        }
                    }
                    //가장 나중에 나오는 애를 찾아서 지우고 해당 arr[i] 를 넣어주기
                    multitab.remove(maxIdx);
                    multitab.offer(arr[i]);
                }
                ans++;
            }
            else if(multitab.size()<N){
                multitab.offer(arr[i]);
            }
        }
        System.out.println(ans);
    }
}
