import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i<progresses.length; i++){
            if((100-progresses[i]) % speeds[i] != 0){
                list.add(((100-progresses[i]) / speeds[i]) + 1);
            }
            else{
                list.add((100-progresses[i]) / speeds[i]);
            }
        }
        int cnt = 1;
        int prev = list.get(0);
        List<Integer> answer = new ArrayList<>();
        for(int i = 1; i<list.size(); i++){
            if(prev >= list.get(i)){
                cnt++;
            }
            else{
                answer.add(cnt);
                cnt = 1;
                prev = list.get(i);
            }
        }
        answer.add(cnt);
        
        int[] arr = new int[answer.size()];
        int n = 0;
        for(int a : answer){
            arr[n] = a;
            n++;
        }
        return arr;
    }
}